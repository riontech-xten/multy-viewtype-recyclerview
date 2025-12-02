package com.xtensolutions.interfacesample.room.entity

import android.os.Parcelable
import androidx.room.Entity
import com.xtensolutions.core.utils.ITEM_MATCH_TYPE
import kotlinx.parcelize.Parcelize

/**
 * Created by Vaghela Mithun R. on 10-10-2025 - 12:34.
 * Email : vaghela.mithun@gmail.com
 * Mob   : +919727206702
 **/
@Parcelize
@Entity
class MatchResult(
    val winnerTeamId: String,
    val winMargin: String,
    val teamAScore: String,
    val teamBScore: String,
    val tossWinnerTeamId: String,
    val teamAPlayedOvers: Double,
    val teamBPlayedOvers: Double,
    val superOver: Boolean = false,
    val teamAFlag: Int,
    val teamBFlag: Int,
    val groupName: String
) : Match(), Parcelable {
    override fun getItemType(): Int = ITEM_MATCH_TYPE
    fun getMatchVenue(): String = "Match $matchId , $groupName, $venue"
    fun getWinnerDetails(): String = "$winnerTeamId won by $winMargin"
}
