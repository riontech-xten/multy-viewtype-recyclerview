package com.xtensolutions.interfacesample.room.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.xtensolutions.core.listener.ListItemInterface
import com.xtensolutions.core.utils.ITEM_TEAM_TYPE
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
) : Parcelable, ListItemInterface {
    override fun getItemType(): Int = ITEM_TEAM_TYPE
}
