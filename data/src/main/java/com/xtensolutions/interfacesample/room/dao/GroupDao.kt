package com.xtensolutions.interfacesample.room.dao

import androidx.room.Dao
import androidx.room.Query
import com.xtensolutions.interfacesample.room.entity.Group

/**
 * Created by Vaghela Mithun R. on 11-10-2025 - 12:10.
 * Email : vaghela.mithun@gmail.com
 * Mob   : +919727206702
 **/
@Dao
interface GroupDao : CoreDao<Group> {
    @Query("SELECT * FROM `Group`")
    suspend fun fetchAllGroup(): List<Group>

    @Query("DELETE FROM `Group`")
    suspend fun clearTable()
}
