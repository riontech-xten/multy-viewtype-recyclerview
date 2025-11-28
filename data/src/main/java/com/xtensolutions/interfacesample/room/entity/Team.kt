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
@Entity(tableName = "team")
data class Team(
    @PrimaryKey
    val teamId: String,
    val teamName: String,
    val teamFlagLarge: Int,
    val teamFlagSmall: Int,
) : Parcelable, ListItemListener {
    override fun isHeader(): Boolean = false
}
