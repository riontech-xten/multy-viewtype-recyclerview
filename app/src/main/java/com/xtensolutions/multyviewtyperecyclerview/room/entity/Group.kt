package com.xtensolutions.multyviewtyperecyclerview.room.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.xtensolutions.multyviewtyperecyclerview.core.listener.ListItemHeaderSection
import kotlinx.parcelize.Parcelize

/**
 * Created by Vaghela Mithun R. on 04-10-2025 - 16:55.
 * Email : vaghela.mithun@gmail.com
 * Mob   : +919727206702
 **/
@Parcelize
@Entity(tableName = "group")
data class Group(
    @PrimaryKey(autoGenerate = true)
    val groupId: Int,
    val groupName: String
) : Parcelable, ListItemHeaderSection {

    override fun isHeader(): Boolean = false

    companion object {
        fun generateData() = arrayListOf<Group>().apply {
            add(Group(groupId = 1, groupName = "Group A"))
            add(Group(groupId = 2, groupName = "Group B"))
            add(Group(groupId = 3, groupName = "Super Fours"))
        }
    }
}
