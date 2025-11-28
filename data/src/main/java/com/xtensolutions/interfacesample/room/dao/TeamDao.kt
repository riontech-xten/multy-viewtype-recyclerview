package com.xtensolutions.interfacesample.room.dao

import androidx.room.Dao
import androidx.room.Query
import com.xtensolutions.interfacesample.room.entity.Team

/**
 * Created by Vaghela Mithun R. on 11-10-2025 - 12:10.
 * Email : vaghela.mithun@gmail.com
 * Mob   : +919727206702
 **/
@Dao
interface TeamDao : CoreDao<Team> {
    @Query("SELECT * FROM `Team`")
    suspend fun fetchAllTeam(): List<Team>

    @Query("DELETE FROM `Team`")
    suspend fun clearTable()
}
