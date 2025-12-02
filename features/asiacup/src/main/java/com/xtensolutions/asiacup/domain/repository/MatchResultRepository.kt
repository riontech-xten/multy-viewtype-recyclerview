package com.xtensolutions.asiacup.domain.repository

import com.xtensolutions.interfacesample.room.dao.ResultDao
import javax.inject.Inject

/**
 * Created by Vaghela Mithun R. on 11-10-2025 - 12:33.
 * Email : vaghela.mithun@gmail.com
 * Mob   : +919727206702
 **/
class MatchResultRepository @Inject constructor(private val resultDao: ResultDao) {
    suspend fun fetchAllMatchResults() = resultDao.fetchAllMatchResults()
}
