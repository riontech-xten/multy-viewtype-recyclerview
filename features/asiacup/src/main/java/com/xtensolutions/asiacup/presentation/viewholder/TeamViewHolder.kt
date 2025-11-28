package com.xtensolutions.asiacup.presentation.viewholder

import com.xtensolutions.asiacup.databinding.ListItemRowTeamBinding
import com.xtensolutions.core.viewholder.BaseViewHolder
import com.xtensolutions.interfacesample.room.entity.GroupTeamPoints

/**
 * Created by Vaghela Mithun R. on 28-11-2025 - 17:52.
 * Email : vaghela.mithun@gmail.com
 * Mob   : +919727206702
 **/
class TeamViewHolder(private val binding: ListItemRowTeamBinding) : BaseViewHolder(binding.root) {

    fun bind(team: GroupTeamPoints) {
        binding.team = team
    }
}
