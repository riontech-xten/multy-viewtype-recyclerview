package com.xtensolutions.multyviewtyperecyclerview.room.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.xtensolutions.multyviewtyperecyclerview.annotations.IgnoreDetekt
import com.xtensolutions.multyviewtyperecyclerview.core.listener.ListItemHeaderSection
import kotlinx.parcelize.Parcelize
import java.text.SimpleDateFormat

/**
 * Created by Vaghela Mithun R. on 04-10-2025 - 16:31.
 * Email : vaghela.mithun@gmail.com
 * Mob   : +919727206702
 **/
@Parcelize
@Entity(tableName = "match")
open class Match(
    @PrimaryKey(autoGenerate = true)
    var matchId: Int = 0,
    var matchType: String = "T20",
    var seriesName: String = "Asia Cup 2025",
    var groupId: Int = 1,
    var teamA: String = "PAK",
    var teamB: String = "IND",
    var matchDate: String = "2025-09-09",
    var matchTime: String = "14:00",
    var matchOvers: Int = 20,
    var matchStatus: String = "Completed",
    var isFinal: Boolean = false,
    var venue: String = "Dubai International Cricket Stadium"
) : Parcelable, ListItemHeaderSection {
    override fun isHeader(): Boolean = false

    fun matchDateTime(): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd")
        val date = sdf.parse(matchDate)
        val outputSdf = SimpleDateFormat("EEE, dd MMM ''yy")
        return outputSdf.format(date!!)
    }

    companion object {
        @Suppress("detekt.LongMethod")
        fun generateData() = arrayListOf<Match>().apply {
            add(
                Match(
                    matchId = 1,
                    matchType = "T20",
                    seriesName = "Asia Cup 2025",
                    groupId = 2,
                    teamA = "AFG",
                    teamB = "HKG",
                    matchDate = "2025-09-09",
                    matchTime = "14:00",
                    matchOvers = 20,
                    matchStatus = "Completed",
                    venue = "Zayed Cricket Stadium, Abu Dhabi"
                )
            )
            add(
                Match(
                    matchId = 2,
                    matchType = "T20",
                    seriesName = "Asia Cup 2025",
                    groupId = 1,
                    teamA = "UAE",
                    teamB = "IND",
                    matchDate = "2025-09-10",
                    matchTime = "14:00",
                    matchOvers = 20,
                    matchStatus = "Completed",
                    venue = "Dubai International Cricket Stadium"
                )
            )
            add(
                Match(
                    matchId = 3,
                    matchType = "T20",
                    seriesName = "Asia Cup 2025",
                    groupId = 2,
                    teamA = "HKG",
                    teamB = "BAN",
                    matchDate = "2025-09-11",
                    matchTime = "14:00",
                    matchOvers = 20,
                    matchStatus = "Completed",
                    venue = "Zayed Cricket Stadium, Abu Dhabi"
                )
            )
            add(
                Match(
                    matchId = 4,
                    matchType = "T20",
                    seriesName = "Asia Cup 2025",
                    groupId = 1,
                    teamA = "PAK",
                    teamB = "OMA",
                    matchDate = "2025-09-12",
                    matchTime = "14:00",
                    matchOvers = 20,
                    matchStatus = "Completed",
                    venue = "Dubai International Cricket Stadium"
                )
            )
            add(
                Match(
                    matchId = 5,
                    matchType = "T20",
                    seriesName = "Asia Cup 2025",
                    groupId = 2,
                    teamA = "BAN",
                    teamB = "SL",
                    matchDate = "2025-09-13",
                    matchTime = "14:00",
                    matchOvers = 20,
                    matchStatus = "Completed",
                    venue = "Zayed Cricket Stadium, Abu Dhabi"
                )
            )
            add(
                Match(
                    matchId = 6,
                    matchType = "T20",
                    seriesName = "Asia Cup 2025",
                    groupId = 1,
                    teamA = "PAK",
                    teamB = "IND",
                    matchDate = "2025-09-14",
                    matchTime = "14:00",
                    matchOvers = 20,
                    matchStatus = "Completed",
                    venue = "Dubai International Cricket Stadium"
                )
            )
            add(
                Match(
                    matchId = 7,
                    matchType = "T20",
                    seriesName = "Asia Cup 2025",
                    groupId = 1,
                    teamA = "UAE",
                    teamB = "OMA",
                    matchDate = "2025-09-15",
                    matchTime = "14:00",
                    matchOvers = 20,
                    matchStatus = "Completed",
                    venue = "Zayed Cricket Stadium, Abu Dhabi"
                )
            )
            add(
                Match(
                    matchId = 8,
                    matchType = "T20",
                    seriesName = "Asia Cup 2025",
                    groupId = 2,
                    teamA = "HKG",
                    teamB = "SL",
                    matchDate = "2025-09-15",
                    matchTime = "14:00",
                    matchOvers = 20,
                    matchStatus = "Completed",
                    venue = "Dubai International Cricket Stadium"
                )
            )
            add(
                Match(
                    matchId = 9,
                    matchType = "T20",
                    seriesName = "Asia Cup 2025",
                    groupId = 2,
                    teamA = "BAN",
                    teamB = "AFG",
                    matchDate = "2025-09-16",
                    matchTime = "14:00",
                    matchOvers = 20,
                    matchStatus = "Completed",
                    venue = "Zayed Cricket Stadium, Abu Dhabi"
                )
            )
            add(
                Match(
                    matchId = 10,
                    matchType = "T20",
                    seriesName = "Asia Cup 2025",
                    groupId = 1,
                    teamA = "PAK",
                    teamB = "UAE",
                    matchDate = "2025-09-17",
                    matchTime = "14:00",
                    matchOvers = 20,
                    matchStatus = "Completed",
                    venue = "Dubai International Cricket Stadium"
                )
            )
            add(
                Match(
                    matchId = 11,
                    matchType = "T20",
                    seriesName = "Asia Cup 2025",
                    groupId = 2,
                    teamA = "AFG",
                    teamB = "SL",
                    matchDate = "2025-09-18",
                    matchTime = "14:00",
                    matchOvers = 20,
                    matchStatus = "Completed",
                    venue = "Zayed Cricket Stadium, Abu Dhabi"
                )
            )
            add(
                Match(
                    matchId = 12,
                    matchType = "T20",
                    seriesName = "Asia Cup 2025",
                    groupId = 1,
                    teamA = "IND",
                    teamB = "OMA",
                    matchDate = "2025-09-19",
                    matchTime = "14:00",
                    matchOvers = 20,
                    matchStatus = "Completed",
                    venue = "Zayed Cricket Stadium, Abu Dhabi"
                )
            )
            add(
                Match(
                    matchId = 13,
                    matchType = "T20",
                    seriesName = "Asia Cup 2025",
                    groupId = 3,
                    teamA = "SL",
                    teamB = "BAN",
                    matchDate = "2025-09-20",
                    matchTime = "14:00",
                    matchOvers = 20,
                    matchStatus = "Completed",
                    venue = "Dubai International Cricket Stadium"
                )
            )
            add(
                Match(
                    matchId = 14,
                    matchType = "T20",
                    seriesName = "Asia Cup 2025",
                    groupId = 3,
                    teamA = "PAK",
                    teamB = "IND",
                    matchDate = "2025-09-21",
                    matchTime = "14:00",
                    matchOvers = 20,
                    matchStatus = "Completed",
                    venue = "Dubai International Cricket Stadium"
                )
            )
            add(
                Match(
                    matchId = 15,
                    matchType = "T20",
                    seriesName = "Asia Cup 2025",
                    groupId = 3,
                    teamA = "SL",
                    teamB = "PAK",
                    matchDate = "2025-09-23",
                    matchTime = "14:00",
                    matchOvers = 20,
                    matchStatus = "Completed",
                    venue = "Zayed Cricket Stadium, Abu Dhabi"
                )
            )
            add(
                Match(
                    matchId = 16,
                    matchType = "T20",
                    seriesName = "Asia Cup 2025",
                    groupId = 3,
                    teamA = "IND",
                    teamB = "BAN",
                    matchDate = "2025-09-24",
                    matchTime = "14:00",
                    matchOvers = 20,
                    matchStatus = "Completed",
                    venue = "Dubai International Cricket Stadium"
                )
            )
            add(
                Match(
                    matchId = 17,
                    matchType = "T20",
                    seriesName = "Asia Cup 2025",
                    groupId = 3,
                    teamA = "PAK",
                    teamB = "BAN",
                    matchDate = "2025-09-25",
                    matchTime = "14:00",
                    matchOvers = 20,
                    matchStatus = "Completed",
                    venue = "Dubai International Cricket Stadium"
                )
            )
            add(
                Match(
                    matchId = 18,
                    matchType = "T20",
                    seriesName = "Asia Cup 2025",
                    groupId = 3,
                    teamA = "IND",
                    teamB = "SL",
                    matchDate = "2025-09-26",
                    matchTime = "14:00",
                    matchOvers = 20,
                    matchStatus = "Completed",
                    venue = "Dubai International Cricket Stadium"
                )
            )
            add(
                Match(
                    matchId = 19,
                    matchType = "T20",
                    seriesName = "Asia Cup 2025",
                    groupId = 3,
                    teamA = "PAK",
                    teamB = "IND",
                    matchDate = "2025-09-28",
                    matchTime = "14:00",
                    matchOvers = 20,
                    matchStatus = "Completed",
                    isFinal = true,
                    venue = "Dubai International Cricket Stadium"
                )
            )
        }
    }
}
