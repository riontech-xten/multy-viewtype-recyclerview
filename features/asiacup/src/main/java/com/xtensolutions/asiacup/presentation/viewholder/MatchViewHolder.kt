package com.xtensolutions.asiacup.presentation.viewholder

import com.xtensolutions.asiacup.databinding.ListItemRowMatchBinding
import com.xtensolutions.core.viewholder.BaseViewHolder
import com.xtensolutions.interfacesample.room.entity.MatchResult

/**
 * Created by Vaghela Mithun R. on 28-11-2025 - 17:51.
 * Email : vaghela.mithun@gmail.com
 * Mob   : +919727206702
 **/
class MatchViewHolder(private val binding: ListItemRowMatchBinding) : BaseViewHolder(binding.root) {

    fun bind(match: MatchResult) {
        binding.match = match
    }
}
