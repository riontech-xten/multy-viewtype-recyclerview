package com.xtensolutions.multyviewtyperecyclerview.room.entity

import android.os.Parcelable
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
@Entity
data class GroupTeamPoints(
    @PrimaryKey
    val teamName: String,
    val teamFlagSmall: Int,
) : TeamPointTable(), Parcelable, ListItemHeaderSection {
    override fun isHeader(): Boolean = false
}
