package com.xtensolutions.multyviewtyperecyclerview.ui.viewmodel

import androidx.lifecycle.LiveData
import com.xtensolutions.multyviewtyperecyclerview.core.viewmodel.BaseViewModel
import com.xtensolutions.multyviewtyperecyclerview.domain.MatchResultRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.lifecycle.asLiveData
import com.xtensolutions.multyviewtyperecyclerview.core.listener.ListItemHeaderSection
import com.xtensolutions.multyviewtyperecyclerview.core.state.Result
import com.xtensolutions.multyviewtyperecyclerview.domain.TeamRepository
import com.xtensolutions.multyviewtyperecyclerview.model.ListSection
import com.xtensolutions.multyviewtyperecyclerview.room.entity.Group
import com.xtensolutions.multyviewtyperecyclerview.room.entity.Group.Companion.GroupType.GROUP_A
import com.xtensolutions.multyviewtyperecyclerview.room.entity.Group.Companion.GroupType.GROUP_B
import com.xtensolutions.multyviewtyperecyclerview.room.entity.Group.Companion.GroupType.SUPER_FOURS
import com.xtensolutions.multyviewtyperecyclerview.room.entity.GroupTeamPoints
import com.xtensolutions.multyviewtyperecyclerview.room.entity.MatchResult
import com.xtensolutions.multyviewtyperecyclerview.room.entity.Team
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
    ): LinkedList<ListItemHeaderSection> {
        return LinkedList<ListItemHeaderSection>().apply {
            add(ListSection("Matches"))
            addAll(matches)
            val groupSuperFour = teams.filter { it.groupId == SUPER_FOURS.id }
            val groupA = teams.filter { it.groupId == GROUP_A.id }
            val groupB = teams.filter { it.groupId == GROUP_B.id }
            add(ListSection("Groups"))
            add(Group(groupId = SUPER_FOURS.id, groupName = SUPER_FOURS.value))
            addAll(groupSuperFour)
            add(Group(groupId = GROUP_A.id, groupName = GROUP_A.value))
            addAll(groupA)
            add(Group(groupId = GROUP_A.id, groupName = GROUP_B.value))
            addAll(groupB)
        }
    }
}
