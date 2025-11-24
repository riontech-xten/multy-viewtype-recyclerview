package com.xtensolutions.multyviewtyperecyclerview.ui.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.ajalt.timberkt.Timber
import com.xtensolutions.multyviewtyperecyclerview.databinding.ActivityMainBinding
import com.xtensolutions.multyviewtyperecyclerview.ui.adapter.MatchAdapter
import com.xtensolutions.multyviewtyperecyclerview.ui.viewmodel.MatchResultViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.LinkedList

/**
 * Created by Vaghela Mithun R. on 25-10-2025 - 10:52.
 * Email : vaghela.mithun@gmail.com
 * Mob   : +919727206702
 **/
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MatchResultViewModel by viewModels()
    private lateinit var adapter: MatchAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        loadData()
    }

    private fun initRecyclerView() {
        adapter = MatchAdapter(this, LinkedList())
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
//        binding.recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        binding.recyclerView.adapter = adapter
    }

    private fun loadData() {
        viewModel.fetchAllMatchResults().observe(this) { matchResults ->
            // Update UI with matchResults
            viewModel.handleResponse(matchResults) {
                Timber.d { "matchResults =>${it.size}" }
                adapter.updateItems(it)
            }
        }
    }
}
