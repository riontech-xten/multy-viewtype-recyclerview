package com.xtensolutions.asiacup.domain.repository

import com.xtensolutions.interfacesample.room.dao.TeamPointTableDao
import javax.inject.Inject

/**
 * Created by Vaghela Mithun R. on 11-10-2025 - 12:34.
 * Email : vaghela.mithun@gmail.com
 * Mob   : +919727206702
 **/
class TeamRepository @Inject constructor(private val teamPointTableDao: TeamPointTableDao) {
    suspend fun getTeamPointTable() = teamPointTableDao.fetchTeamPointTable()
}
