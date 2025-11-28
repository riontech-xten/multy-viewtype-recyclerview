package com.xtensolutions.interfacesample.ui.activity

import androidx.activity.viewModels
import com.github.ajalt.timberkt.Timber
import com.xtensolutions.asiacup.presentation.ui.activity.AsiaCupActivity
import com.xtensolutions.interfacesample.ui.adapter.MatchAdapter
import com.xtensolutions.interfacesample.ui.viewmodel.MatchResultViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.LinkedList

/**
 * Created by Vaghela Mithun R. on 25-10-2025 - 10:52.
 * Email : vaghela.mithun@gmail.com
 * Mob   : +919727206702
 **/
@AndroidEntryPoint
class MainActivity : AsiaCupActivity() {
    private val viewModel: MatchResultViewModel by viewModels()
    private lateinit var adapter: MatchAdapter

    override fun onViewInitialized() {
        adapter = MatchAdapter(this, LinkedList())
        binding.recyclerView.adapter = adapter
        loadData()
    }

    private fun loadData() {
        viewModel.fetchMatchResults().observe(this) { matchResults ->
            // Update UI with matchResults
            viewModel.handleResponse(matchResults) {
                Timber.d { "matchResults =>${it.size}" }
                adapter.updateItems(it)
            }
        }
    }
}
