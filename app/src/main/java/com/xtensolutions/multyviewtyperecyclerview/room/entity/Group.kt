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
        @Suppress("detekt.MagicNumber")
        enum class GroupType(val id: Int, val value: String) {
            GROUP_A(1, "Group A"),
            GROUP_B(2, "Group B"),
            SUPER_FOURS(3, "Super Fours")
        }

        fun generateData() = arrayListOf<Group>().apply {
            add(Group(groupId = GroupType.GROUP_A.id, groupName = GroupType.GROUP_A.value))
            add(Group(groupId = GroupType.GROUP_B.id, groupName = GroupType.GROUP_B.value))
            add(Group(groupId = GroupType.SUPER_FOURS.id, groupName = GroupType.SUPER_FOURS.value))
        }
    }
}
