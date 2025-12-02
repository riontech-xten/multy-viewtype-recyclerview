package com.xtensolutions.asiacup.data.model

import com.xtensolutions.interfacesample.room.entity.Group

/**
 * Created by Vaghela Mithun R. on 25-11-2025 - 19:40.
 * Email : vaghela.mithun@gmail.com
 * Mob   : +919727206702
 **/
@Suppress("detekt.MagicNumber")
enum class GroupType(val id: Int, val value: String) {
    GROUP_A(1, "Group A"),
    GROUP_B(2, "Group B"),
    SUPER_FOURS(3, "Super Fours")
}

object GroupDataModel {
    fun generateData() = arrayListOf<Group>().apply {
        add(Group(groupId = GroupType.GROUP_A.id, groupName = GroupType.GROUP_A.value))
        add(Group(groupId = GroupType.GROUP_B.id, groupName = GroupType.GROUP_B.value))
        add(Group(groupId = GroupType.SUPER_FOURS.id, groupName = GroupType.SUPER_FOURS.value))
    }
}
