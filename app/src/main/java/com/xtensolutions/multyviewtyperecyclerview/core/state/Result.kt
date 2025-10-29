package com.xtensolutions.multyviewtyperecyclerview.core.state


sealed class Result<out T>(val status: State, val data: T?, var message: String?) {
    fun isSuccess(): Boolean = this.status == State.SUCCESS

    fun isError(): Boolean = this.status == State.ERROR

    fun isFail(): Boolean = this.status == State.FAIL

    fun isLoading(): Boolean = this.status == State.LOADING

//    fun isPaging(): Boolean = this.status == State.PAGING

    class Success<T>(result: T?, message: String?) : Result<T>(State.SUCCESS, result, message)
    class Fail<T>(message: String?) : Result<T>(State.FAIL, null, message)
    class Error<T>(message: String?) : Result<T>(State.ERROR, null, message)
    class Loading<T>(message: String?) : Result<T>(State.LOADING, null, message)
//    class Paging<T>(message: String?) : Result<T>(State.PAGING, null, message)

    enum class State {
        SUCCESS,
        FAIL,
        ERROR,
        LOADING,
//        PAGING
    }
}
