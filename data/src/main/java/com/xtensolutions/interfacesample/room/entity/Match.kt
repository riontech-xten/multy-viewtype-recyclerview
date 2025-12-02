package com.xtensolutions.interfacesample.room.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.xtensolutions.core.listener.ListItemInterface
import com.xtensolutions.core.utils.ITEM_MATCH_TYPE
import kotlinx.parcelize.Parcelize
import java.text.SimpleDateFormat
import java.util.Locale

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
) : Parcelable, ListItemInterface {
    override fun getItemType(): Int = ITEM_MATCH_TYPE

    fun matchDateTime(): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
        val date = sdf.parse(matchDate)
        val outputSdf = SimpleDateFormat("EEE, dd MMM ''yy", Locale.ENGLISH)
        return outputSdf.format(date!!)
    }
}
