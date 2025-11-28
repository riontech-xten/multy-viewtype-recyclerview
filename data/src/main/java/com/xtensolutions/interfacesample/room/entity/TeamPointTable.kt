package com.xtensolutions.interfacesample.room.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.xtensolutions.core.listener.ListItemListener
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
) : Parcelable, ListItemListener {
    override fun isHeader(): Boolean = false
}
