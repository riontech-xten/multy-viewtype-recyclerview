package com.xtensolutions.sealedclass.ui.viewmodel

import com.xtensolutions.asiacup.domain.repository.MatchResultRepository
import com.xtensolutions.asiacup.domain.repository.TeamRepository
import com.xtensolutions.asiacup.presentation.viewmodel.ResultViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
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
            buildSealedClassSampleList(matches, teams)
        }
    )
}
