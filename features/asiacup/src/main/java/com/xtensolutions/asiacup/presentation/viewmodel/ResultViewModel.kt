package com.xtensolutions.asiacup.presentation.viewmodel

import androidx.lifecycle.asLiveData
import com.xtensolutions.asiacup.data.model.GroupType
import com.xtensolutions.asiacup.domain.model.AdBannerModel
import com.xtensolutions.core.model.ListItem
import com.xtensolutions.asiacup.domain.repository.MatchResultRepository
import com.xtensolutions.asiacup.domain.repository.TeamRepository
import com.xtensolutions.core.listener.ListItemListener
import com.xtensolutions.core.viewmodel.BaseViewModel
import com.xtensolutions.interfacesample.room.entity.Group
import com.xtensolutions.interfacesample.room.entity.GroupTeamPoints
import com.xtensolutions.interfacesample.room.entity.MatchResult
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.LinkedList
import javax.inject.Inject
import kotlin.collections.filter

/**
 * Created by Vaghela Mithun R. on 27-10-2025 - 18:21.
 * Email : vaghela.mithun@gmail.com
 * Mob   : +919727206702
 **/
open class ResultViewModel(
    private val matchResultRepository: MatchResultRepository,
    private val teamRepository: TeamRepository
) : BaseViewModel() {

    fun <T> fetchMatchResults(
        listBuilder: (List<MatchResult>, List<GroupTeamPoints>) -> LinkedList<T>
    ) = mappingLocalQuery(
        queryCallOne = { matchResultRepository.fetchAllMatchResults() },
        queryCallTwo = { teamRepository.getTeamPointTable() },
        mappingCall = { m, t -> listBuilder(m, t) }
    ).asLiveData()

    fun buildSealedClassSampleList(
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

            val groupSuperFour = teams.filter { it.groupId == GroupType.SUPER_FOURS.id }.map {
                ListItem.Team(it)
            }
            val groupA = teams.filter { it.groupId == GroupType.GROUP_A.id }.map {
                ListItem.Team(it)
            }
            val groupB = teams.filter { it.groupId == GroupType.GROUP_B.id }.map {
                ListItem.Team(it)
            }
            add(ListItem.Section("Groups"))
            add(
                ListItem.Group(
                    Group(
                        groupId = GroupType.SUPER_FOURS.id,
                        groupName = GroupType.SUPER_FOURS.value
                    )
                )
            )
            addAll(groupSuperFour)
            add(ListItem.Group(Group(groupId = GroupType.GROUP_A.id, groupName = GroupType.GROUP_A.value)))
            addAll(groupA)
            add(ListItem.Group(Group(groupId = GroupType.GROUP_A.id, groupName = GroupType.GROUP_B.value)))
            addAll(groupB)
        }
    }
}
