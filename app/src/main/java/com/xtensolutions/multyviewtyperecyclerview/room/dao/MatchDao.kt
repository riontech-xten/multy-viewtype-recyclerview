package com.xtensolutions.multyviewtyperecyclerview.room.dao

import androidx.room.Dao
import androidx.room.Query
import com.xtensolutions.multyviewtyperecyclerview.room.entity.Match
import com.xtensolutions.multyviewtyperecyclerview.room.entity.Result

/**
 * Created by Vaghela Mithun R. on 11-10-2025 - 12:10.
 * Email : vaghela.mithun@gmail.com
 * Mob   : +919727206702
 **/
@Dao
interface MatchDao : CoreDao<Match> {
    @Query("SELECT * FROM `match`")
    suspend fun fetchAllMatches(): List<Match>
}
