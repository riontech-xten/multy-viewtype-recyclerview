package com.xtensolutions.asiacup.data.model

import com.xtensolutions.interfacesample.room.entity.TeamPointTable

/**
 * Created by Vaghela Mithun R. on 27-11-2025 - 18:51.
 * Email : vaghela.mithun@gmail.com
 * Mob   : +919727206702
 **/
object TeamPointDataModel {
    @Suppress("detekt.LongMethod")
    fun generateData() = arrayListOf<TeamPointTable>().apply {
        // Group A Teams
        add(
            TeamPointTable(
                teamId = "IND",
                groupId = 1,
                playedMatches = 3,
                wonMatches = 3,
                lostMatches = 0,
                tiedMatches = 0,
                points = 6,
                netRunRate = 3.547
            )
        )
        add(
            TeamPointTable(
                teamId = "PAK",
                groupId = 1,
                playedMatches = 3,
                wonMatches = 2,
                lostMatches = 1,
                tiedMatches = 0,
                points = 4,
                netRunRate = 1.790
            )
        )
        add(
            TeamPointTable(
                teamId = "UAE",
                groupId = 1,
                playedMatches = 3,
                wonMatches = 1,
                lostMatches = 2,
                tiedMatches = 0,
                points = 2,
                netRunRate = -1.984
            )
        )
        add(
            TeamPointTable(
                teamId = "OMA",
                groupId = 1,
                playedMatches = 3,
                wonMatches = 0,
                lostMatches = 3,
                tiedMatches = 0,
                points = 0,
                netRunRate = -2.600
            )
        )
        // Group B Teams
        add(
            TeamPointTable(
                teamId = "SL",
                groupId = 2,
                playedMatches = 3,
                wonMatches = 3,
                lostMatches = 0,
                tiedMatches = 0,
                points = 6,
                netRunRate = 1.278
            )
        )
        add(
            TeamPointTable(
                teamId = "BAN",
                groupId = 2,
                playedMatches = 3,
                wonMatches = 2,
                lostMatches = 1,
                tiedMatches = 0,
                points = 4,
                netRunRate = -0.270
            )
        )
        add(
            TeamPointTable(
                teamId = "AFG",
                groupId = 2,
                playedMatches = 3,
                wonMatches = 1,
                lostMatches = 2,
                tiedMatches = 0,
                points = 2,
                netRunRate = 1.241
            )
        )
        add(
            TeamPointTable(
                teamId = "HKG",
                groupId = 2,
                playedMatches = 3,
                wonMatches = 0,
                lostMatches = 3,
                tiedMatches = 0,
                points = 0,
                netRunRate = -2.151
            )
        )
        // Super Fours Teams
        add(
            TeamPointTable(
                teamId = "IND",
                groupId = 3,
                playedMatches = 3,
                wonMatches = 3,
                lostMatches = 0,
                tiedMatches = 0,
                points = 6,
                netRunRate = 0.913
            )
        )
        add(
            TeamPointTable(
                teamId = "PAK",
                groupId = 3,
                playedMatches = 3,
                wonMatches = 2,
                lostMatches = 1,
                tiedMatches = 0,
                points = 4,
                netRunRate = 0.329
            )
        )
        add(
            TeamPointTable(
                teamId = "BAN",
                groupId = 3,
                playedMatches = 3,
                wonMatches = 1,
                lostMatches = 2,
                tiedMatches = 0,
                points = 2,
                netRunRate = -0.831
            )
        )
        add(
            TeamPointTable(
                teamId = "SL",
                groupId = 3,
                playedMatches = 3,
                wonMatches = 0,
                lostMatches = 3,
                tiedMatches = 0,
                points = 0,
                netRunRate = -0.418
            )
        )
    }
}
