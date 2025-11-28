package com.xtensolutions.interfacesample.room.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.RoomWarnings
import com.xtensolutions.interfacesample.room.entity.MatchResult
import com.xtensolutions.interfacesample.room.entity.Result

/**
 * Created by Vaghela Mithun R. on 11-10-2025 - 12:10.
 * Email : vaghela.mithun@gmail.com
 * Mob   : +919727206702
 **/
@Dao
interface ResultDao : CoreDao<Result> {
//    @SuppressWarnings(RoomWarnings.QUERY_MISMATCH)
//    @Query("SELECT * FROM `match_result`")
//    suspend fun fetchAllResults(): List<Result>

    @Query(
        "SELECT R.matchId, R.winnerTeamId, R.winMargin, R.teamAScore, R.teamAPlayedOvers, R.teamBScore, "
                + "R.teamBPlayedOvers, R.tossWinnerTeamId,R.superOver, M.teamA, M.teamB, G.groupId, "
                + "(SELECT teamFlagLarge FROM team WHERE teamId = M.teamA) as teamAFlag, "
                + "(SELECT teamFlagLarge FROM team WHERE teamId = M.teamB) as teamBFlag, "
                + "M.matchType, M.matchDate, M.matchOvers, M.matchTime, M.matchStatus, "
                + "M.seriesName, M.isFinal, M.venue, G.groupName "
                + "FROM `match_result` R "
                + "LEFT JOIN `match` M ON M.matchId = R.matchId "
                + "LEFT JOIN `group` G ON G.groupId = M.groupId "
    )
    suspend fun fetchAllMatchResults(): List<MatchResult>

    @Query("DELETE FROM `match_result`")
    suspend fun clearTable()
}
