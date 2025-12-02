package com.xtensolutions.core.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.ajalt.timberkt.Timber
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import com.xtensolutions.core.state.Result

open class BaseViewModel(
    val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) : ViewModel() {
    private val loadingData = MutableLiveData<Boolean>()
    private val loadingPageData = MutableLiveData<Boolean>()

    @JvmField
    var loading: LiveData<Boolean> = loadingData

    @JvmField
    var loadingPage: LiveData<Boolean> = loadingPageData

    protected val failResult = MutableLiveData<String>()

    @JvmField
    var failDataResult: LiveData<String> = failResult

    protected val errorResult = MutableLiveData<Throwable>()

    @JvmField
    var errorDataResult: LiveData<Throwable> = errorResult

    var dataConnectionStatus = MutableLiveData(true)


    fun <L> executeLocalQuery(
        queryCall: suspend () -> L?
    ) = flow {
        val localData = queryCall.invoke()
        localData?.let { emit(Result.Success(localData, "")) } ?: run {
            emit(Result.Error<L>("No record found"))
        }
    }.onStart {
        emit(Result.Loading("Please wait..."))
    }.catch { e ->
        Timber.e(e) // Log the error
        emit(Result.Error(e.message ?: "Unknown error occurred"))
    }.flowOn(dispatcher)

    /**
     * Handle two queries at a time
     */
    fun <L, M, R> mappingLocalQuery(
        queryCallOne: suspend () -> L?,
        queryCallTwo: suspend () -> M?,
        mappingCall: (L, M) -> R?
    ) = flow {
        val localDataOne = queryCallOne.invoke()
        val localDataTwo = queryCallTwo.invoke()
        if (localDataOne != null && localDataTwo != null) {
            val result = mappingCall.invoke(localDataOne, localDataTwo)
            emit(Result.Success(result, ""))
        } else {
            emit(Result.Error<R>("No record found"))
        }
    }.onStart {
        emit(Result.Loading("Please wait..."))
    }.catch { e ->
        Timber.e(e) // Log the error
        emit(Result.Error(e.message ?: "Unknown error occurred"))
    }.flowOn(dispatcher)


    fun executeLocalInsertUpdateQuery(
        queryCall: () -> Boolean
    ) = flow {
        val status = queryCall.invoke()
        if (status) emit(Result.Success(true, ""))
        else emit(Result.Error("Failed"))
    }.onStart {
        emit(Result.Loading("Please wait..."))
    }.flowOn(dispatcher)


    /**
     * Handle response here in base with loading and error message
     *
     */
    fun <T> handleResponse(it: Result<T>, callback: (data: T) -> Unit) {
        println("handleResponse status ${it.status} ${it.message}")
        when (it.status) {
            Result.State.SUCCESS -> {
                loadingData.postValue(false)
                it.data?.let { data ->
                    callback(data)
                } ?: failResult.postValue(it.message ?: "")
            }

            else -> handleCommonStats(it)
        }
    }

    fun <T> allowNullDataResponse(it: Result<T>, callback: (data: T?) -> Unit) {
        println("allowNullDataResponse status ${it.status} ${it.message}")
        when (it.status) {
            Result.State.SUCCESS -> {
                loadingData.postValue(false)
                callback(it.data)
            }

            else -> handleCommonStats(it)
        }
    }

    private fun <T> handleCommonStats(it: Result<T>) {
        when (it.status) {
            Result.State.LOADING -> {
                loadingData.postValue(true)
            }

            Result.State.FAIL -> {
                loadingData.postValue(false)
                failResult.postValue(it.message ?: "")
            }

            Result.State.ERROR -> {
                println("ERROR ${it.message}")
                loadingData.postValue(false)
                errorResult.postValue(Throwable(it.message))
            }

            else -> {
                // do nothing
            }
        }
    }
}
