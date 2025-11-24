package com.xtensolutions.multyviewtyperecyclerview.ui.viewmodel

import androidx.lifecycle.asLiveData
import com.xtensolutions.multyviewtyperecyclerview.core.viewmodel.BaseViewModel
import com.xtensolutions.multyviewtyperecyclerview.domain.MatchResultRepository
import com.xtensolutions.multyviewtyperecyclerview.domain.TeamRepository
import com.xtensolutions.multyviewtyperecyclerview.model.AdBannerModel
import com.xtensolutions.multyviewtyperecyclerview.model.ListItem
import com.xtensolutions.multyviewtyperecyclerview.room.entity.Group
import com.xtensolutions.multyviewtyperecyclerview.room.entity.Group.Companion.GroupType.GROUP_A
import com.xtensolutions.multyviewtyperecyclerview.room.entity.Group.Companion.GroupType.GROUP_B
import com.xtensolutions.multyviewtyperecyclerview.room.entity.Group.Companion.GroupType.SUPER_FOURS
import com.xtensolutions.multyviewtyperecyclerview.room.entity.GroupTeamPoints
import com.xtensolutions.multyviewtyperecyclerview.room.entity.MatchResult
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.LinkedList
import javax.inject.Inject

/**
 * Created by Vaghela Mithun R. on 27-10-2025 - 18:21.
 * Email : vaghela.mithun@gmail.com
 * Mob   : +919727206702
 **/
@HiltViewModel
class MatchResultViewModel @Inject constructor(
    private val matchResultRepository: MatchResultRepository,
    private val teamRepository: TeamRepository
) : BaseViewModel() {
    fun fetchAllMatchResults() = mappingLocalQuery(
        queryCallOne = { matchResultRepository.fetchAllMatchResults() },
        queryCallTwo = { teamRepository.getTeamPointTable() },
        mappingCall = { m, t -> mappingMatchResultWithGroupTeam(m, t) }
    ).asLiveData()

    fun mappingMatchResultWithGroupTeam(
        matches: List<MatchResult>,
        teams: List<GroupTeamPoints>
    ): LinkedList<ListItem> {
        return LinkedList<ListItem>().apply {
            add(ListItem.Section("Matches"))
            addAll(matches.map { ListItem.Match(it) })

            // Insert a sample AdBanner row between Matches and Groups for demo purposes
            add(
                ListItem.AdBanner(
                    AdBannerModel(
                        id = "banner_1",
                        title = "Special Offer",
                        subtitle = "Get 20% off on tickets",
                        imageUrl = null
                    )
                )
            )

            val groupSuperFour = teams.filter { it.groupId == SUPER_FOURS.id }.map {
                ListItem.Team(it)
            }
            val groupA = teams.filter { it.groupId == GROUP_A.id }.map {
                ListItem.Team(it)
            }
            val groupB = teams.filter { it.groupId == GROUP_B.id }.map {
                ListItem.Team(it)
            }
            add(ListItem.Section("Groups"))
            add(ListItem.Group(Group(groupId = SUPER_FOURS.id, groupName = SUPER_FOURS.value)))
            addAll(groupSuperFour)
            add(ListItem.Group(Group(groupId = GROUP_A.id, groupName = GROUP_A.value)))
            addAll(groupA)
            add(ListItem.Group(Group(groupId = GROUP_A.id, groupName = GROUP_B.value)))
            addAll(groupB)
        }
    }
}
