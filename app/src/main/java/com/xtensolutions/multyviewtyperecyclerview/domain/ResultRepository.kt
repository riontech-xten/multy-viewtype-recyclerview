package com.xtensolutions.multyviewtyperecyclerview.domain

import com.xtensolutions.multyviewtyperecyclerview.room.dao.ResultDao
import javax.inject.Inject

/**
 * Created by Vaghela Mithun R. on 11-10-2025 - 12:34.
 * Email : vaghela.mithun@gmail.com
 * Mob   : +919727206702
 **/
class ResultRepository @Inject constructor(private val resultDao: ResultDao){
    suspend fun fetchAllResults() = resultDao.fetchAllResults()
}
