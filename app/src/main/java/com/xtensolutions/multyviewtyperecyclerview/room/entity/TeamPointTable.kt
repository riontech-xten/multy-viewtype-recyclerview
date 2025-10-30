package com.xtensolutions.multyviewtyperecyclerview.room.entity

import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.xtensolutions.multyviewtyperecyclerview.R
import com.xtensolutions.multyviewtyperecyclerview.core.listener.ListItemHeaderSection
import kotlinx.parcelize.Parcelize

/**
 * Created by Vaghela Mithun R. on 04-10-2025 - 16:49.
 * Email : vaghela.mithun@gmail.com
 * Mob   : +919727206702
 **/
@Parcelize
@Entity(tableName = "team_point_table")
open class TeamPointTable(
    @PrimaryKey(autoGenerate = true)
    var pointTableId: Int = 0,
    var teamId: String = "",
    var groupId: Int = 0,
    var playedMatches: Int = 0,
    var wonMatches: Int = 0,
    var lostMatches: Int = 0,
    var tiedMatches: Int = 0,
    var points: Int = 0,
    var netRunRate: Double = 0.0
) : Parcelable, ListItemHeaderSection {
    override fun isHeader(): Boolean = false

    companion object {
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
}
