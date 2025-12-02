package com.xtensolutions.interfacesample.ui.viewmodel

import com.xtensolutions.asiacup.data.model.GroupType
import com.xtensolutions.asiacup.domain.model.AdBannerModel
import com.xtensolutions.asiacup.domain.repository.MatchResultRepository
import com.xtensolutions.asiacup.domain.repository.TeamRepository
import com.xtensolutions.asiacup.presentation.viewmodel.ResultViewModel
import com.xtensolutions.core.listener.ListItemInterface
import com.xtensolutions.interfacesample.listener.ListSection
import com.xtensolutions.interfacesample.room.entity.Group
import com.xtensolutions.interfacesample.room.entity.GroupTeamPoints
import com.xtensolutions.interfacesample.room.entity.MatchResult
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.LinkedList
import javax.inject.Inject

/**
 * Created by Vaghela Mithun R. on 28-11-2025 - 19:58.
 * Email : vaghela.mithun@gmail.com
 * Mob   : +919727206702
 **/
@HiltViewModel
class MatchResultViewModel @Inject constructor(
    matchResultRepository: MatchResultRepository,
    teamRepository: TeamRepository
) : ResultViewModel(matchResultRepository, teamRepository) {
    fun fetchMatchResults() = fetchMatchResults(
        { matches, teams ->
            buildInterfaceSampleList(matches, teams)
        }
    )


    fun buildInterfaceSampleList(
        matches: List<MatchResult>,
        teams: List<GroupTeamPoints>
    ): LinkedList<ListItemInterface> {
        return LinkedList<ListItemInterface>().apply {
            add(ListSection("Matches"))
            addAll(matches)

            // Insert a sample AdBanner row between Matches and Groups for demo purposes
            add(
                AdBannerModel(
                    id = "banner_1",
                    title = "Special Offer",
                    subtitle = "Get 20% off on tickets",
                    imageUrl = null
                )
            )

            val groupSuperFour = teams.filter { it.groupId == GroupType.SUPER_FOURS.id }
            val groupA = teams.filter { it.groupId == GroupType.GROUP_A.id }
            val groupB = teams.filter { it.groupId == GroupType.GROUP_B.id }
            add(ListSection("Groups"))
            add(Group(groupId = GroupType.SUPER_FOURS.id, groupName = GroupType.SUPER_FOURS.value))
            addAll(groupSuperFour)
            add(Group(groupId = GroupType.GROUP_A.id, groupName = GroupType.GROUP_A.value))
            addAll(groupA)
            add(Group(groupId = GroupType.GROUP_A.id, groupName = GroupType.GROUP_B.value))
            addAll(groupB)
        }
    }
}
