package com.xtensolutions.multyviewtyperecyclerview.room.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.xtensolutions.multyviewtyperecyclerview.core.listener.ListItemHeaderSection
import kotlinx.parcelize.Parcelize

/**
 * Created by Vaghela Mithun R. on 08-10-2025 - 11:03.
 * Email : vaghela.mithun@gmail.com
 * Mob   : +919727206702
 **/
@Parcelize
@Entity(tableName = "match_result")
data class Result(
    @PrimaryKey(autoGenerate = true)
    val resultId: Int,
    val matchId: Int,
    val winnerTeamId: String,
    val winMargin: String,
    val teamAScore: String,
    val teamBScore: String,
    val tossWinnerTeamId: String,
    val teamAPlayedOvers: Double,
    val teamBPlayedOvers: Double,
    val superOver: Boolean = false
) : Parcelable, ListItemHeaderSection {
    override fun isHeader(): Boolean = false

    companion object {
        fun generateData() = arrayListOf<Result>().apply {
            add(
                Result(
                    resultId = 1,
                    matchId = 1,
                    winnerTeamId = "AFG",
                    winMargin = "94 runs",
                    teamAScore = "188/6",
                    teamBScore = "94/9",
                    tossWinnerTeamId = "AFG",
                    teamAPlayedOvers = 20.0,
                    teamBPlayedOvers = 20.0
                )
            )
            add(
                Result(
                    resultId = 2,
                    matchId = 2,
                    winnerTeamId = "IND",
                    winMargin = "9 wickets",
                    teamAScore = "57/10",
                    teamBScore = "60/1",
                    tossWinnerTeamId = "IND",
                    teamAPlayedOvers = 13.1,
                    teamBPlayedOvers = 4.3
                )
            )
            add(
                Result(
                    resultId = 3,
                    matchId = 3,
                    winnerTeamId = "BAN",
                    winMargin = "7 wickets",
                    teamAScore = "143/7",
                    teamBScore = "144/3",
                    tossWinnerTeamId = "BAN",
                    teamAPlayedOvers = 20.0,
                    teamBPlayedOvers = 17.4
                )
            )
            add(
                Result(
                    resultId = 4,
                    matchId = 4,
                    winnerTeamId = "PAK",
                    winMargin = "93 runs",
                    teamAScore = "160/7",
                    teamBScore = "67/10",
                    tossWinnerTeamId = "PAK",
                    teamAPlayedOvers = 20.0,
                    teamBPlayedOvers = 16.4
                )
            )
            add(
                Result(
                    resultId = 5,
                    matchId = 5,
                    winnerTeamId = "SL",
                    winMargin = "6 wickets",
                    teamAScore = "139/5",
                    teamBScore = "140/4",
                    tossWinnerTeamId = "SL",
                    teamAPlayedOvers = 20.0,
                    teamBPlayedOvers = 14.4
                )
            )
            add(
                Result(
                    resultId = 6,
                    matchId = 6,
                    winnerTeamId = "IND",
                    winMargin = "7 wickets",
                    teamAScore = "127/9",
                    teamBScore = "131/3",
                    tossWinnerTeamId = "PAK",
                    teamAPlayedOvers = 20.0,
                    teamBPlayedOvers = 15.5
                )
            )
            add(
                Result(
                    resultId = 7,
                    matchId = 7,
                    winnerTeamId = "UAE",
                    winMargin = "42 runs",
                    teamAScore = "172/5",
                    teamBScore = "130/10",
                    tossWinnerTeamId = "OMN",
                    teamAPlayedOvers = 20.0,
                    teamBPlayedOvers = 18.4
                )
            )
            add(
                Result(
                    resultId = 8,
                    matchId = 8,
                    winnerTeamId = "SL",
                    winMargin = "4 wickets",
                    teamAScore = "149/4",
                    teamBScore = "153/6",
                    tossWinnerTeamId = "SL",
                    teamAPlayedOvers = 20.0,
                    teamBPlayedOvers = 18.5
                )
            )
            add(
                Result(
                    resultId = 9,
                    matchId = 9,
                    winnerTeamId = "BAN",
                    winMargin = "8 runs",
                    teamAScore = "154/5",
                    teamBScore = "146/10",
                    tossWinnerTeamId = "BAN",
                    teamAPlayedOvers = 20.0,
                    teamBPlayedOvers = 20.0
                )
            )
            add(
                Result(
                    resultId = 10,
                    matchId = 10,
                    winnerTeamId = "PAK",
                    winMargin = "6 wickets",
                    teamAScore = "146/9",
                    teamBScore = "105/10",
                    tossWinnerTeamId = "UAE",
                    teamAPlayedOvers = 20.0,
                    teamBPlayedOvers = 17.4
                )
            )
            add(
                Result(
                    resultId = 11,
                    matchId = 11,
                    winnerTeamId = "SL",
                    winMargin = "6 wickets",
                    teamAScore = "169/9",
                    teamBScore = "171/4",
                    tossWinnerTeamId = "AFG",
                    teamAPlayedOvers = 20.0,
                    teamBPlayedOvers = 18.4
                )
            )
            add(
                Result(
                    resultId = 12,
                    matchId = 12,
                    winnerTeamId = "IND",
                    winMargin = "21 runs",
                    teamAScore = "188/8",
                    teamBScore = "167/4",
                    tossWinnerTeamId = "IND",
                    teamAPlayedOvers = 20.0,
                    teamBPlayedOvers = 20.0
                )
            )
            add(
                Result(
                    resultId = 13,
                    matchId = 13,
                    winnerTeamId = "BAN",
                    winMargin = "4 wickets",
                    teamAScore = "168/7",
                    teamBScore = "169/6",
                    tossWinnerTeamId = "BAN",
                    teamAPlayedOvers = 20.0,
                    teamBPlayedOvers = 19.5
                )
            )
            add(
                Result(
                    resultId = 14,
                    matchId = 14,
                    winnerTeamId = "IND",
                    winMargin = "6 wickets",
                    teamAScore = "171/5",
                    teamBScore = "174/4",
                    tossWinnerTeamId = "IND",
                    teamAPlayedOvers = 20.0,
                    teamBPlayedOvers = 18.5
                )
            )
            add(
                Result(
                    resultId = 15,
                    matchId = 15,
                    winnerTeamId = "PAK",
                    winMargin = "5 wickets",
                    teamAScore = "133/8",
                    teamBScore = "138/5",
                    tossWinnerTeamId = "PAK",
                    teamAPlayedOvers = 20.0,
                    teamBPlayedOvers = 18.0
                )
            )
            add(
                Result(
                    resultId = 16,
                    matchId = 16,
                    winnerTeamId = "IND",
                    winMargin = "41 runs",
                    teamAScore = "168/6",
                    teamBScore = "127/10",
                    tossWinnerTeamId = "BAN",
                    teamAPlayedOvers = 20.0,
                    teamBPlayedOvers = 19.3
                )
            )
            add(
                Result(
                    resultId = 17,
                    matchId = 17,
                    winnerTeamId = "PAK",
                    winMargin = "10 runs",
                    teamAScore = "135/8",
                    teamBScore = "124/9",
                    tossWinnerTeamId = "BAN",
                    teamAPlayedOvers = 20.0,
                    teamBPlayedOvers = 20.0
                )
            )
            add(
                Result(
                    resultId = 18,
                    matchId = 18,
                    winnerTeamId = "IND",
                    winMargin = "Super Over by 2 wickets",
                    teamAScore = "202/5",
                    teamBScore = "202/5",
                    tossWinnerTeamId = "SL",
                    teamAPlayedOvers = 20.0,
                    teamBPlayedOvers = 20.0,
                    superOver = true
                )
            )
            add(
                Result(
                    resultId = 19,
                    matchId = 19,
                    winnerTeamId = "IND",
                    winMargin = "5 wickets",
                    teamAScore = "146/10",
                    teamBScore = "150/5",
                    tossWinnerTeamId = "IND",
                    teamAPlayedOvers = 19.1,
                    teamBPlayedOvers = 19.4
                )
            )
        }
    }
}
