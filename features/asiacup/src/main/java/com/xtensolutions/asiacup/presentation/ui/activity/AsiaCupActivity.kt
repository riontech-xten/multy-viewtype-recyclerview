package com.xtensolutions.asiacup.presentation.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.xtensolutions.asiacup.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Vaghela Mithun R. on 28-11-2025 - 20:17.
 * Email : vaghela.mithun@gmail.com
 * Mob   : +919727206702
 **/
@AndroidEntryPoint
abstract class AsiaCupActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        onViewInitialized()
    }

    abstract fun onViewInitialized()
}
