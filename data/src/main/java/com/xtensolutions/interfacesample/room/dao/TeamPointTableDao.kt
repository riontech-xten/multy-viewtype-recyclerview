package com.xtensolutions.interfacesample.room.dao

import androidx.room.Dao
import androidx.room.Query
import com.xtensolutions.interfacesample.room.entity.GroupTeamPoints
import com.xtensolutions.interfacesample.room.entity.TeamPointTable

/**
 * Created by Vaghela Mithun R. on 11-10-2025 - 12:10.
 * Email : vaghela.mithun@gmail.com
 * Mob   : +919727206702
 **/
@Dao
interface TeamPointTableDao : CoreDao<TeamPointTable> {
//    @Query("SELECT * FROM `team_point_table`")
//    suspend fun fetchAllTeam(): List<TeamPointTable>

    @Query(
        "SELECT PT.pointTableId, PT.teamId, T.teamName, T.teamFlagSmall, PT.groupId, PT.playedMatches, PT.wonMatches, "
                + "PT.lostMatches, PT.tiedMatches, PT.points, PT.netRunRate FROM `team_point_table` PT "
                + "LEFT JOIN `team` T ON T.teamId = PT.teamId "
    )
    suspend fun fetchTeamPointTable(): List<GroupTeamPoints>

    @Query("DELETE FROM `team_point_table`")
    suspend fun clearTable()
}
