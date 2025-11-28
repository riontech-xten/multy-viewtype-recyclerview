package com.xtensolutions.asiacup.presentation.viewholder

import com.xtensolutions.asiacup.databinding.ListItemRowGroupBinding
import com.xtensolutions.core.viewholder.BaseViewHolder
import com.xtensolutions.interfacesample.room.entity.Group

/**
 * Created by Vaghela Mithun R. on 28-11-2025 - 17:50.
 * Email : vaghela.mithun@gmail.com
 * Mob   : +919727206702
 **/
class GroupViewHolder(private val binding: ListItemRowGroupBinding) : BaseViewHolder(binding.root) {
    fun bind(group: Group) {
        binding.group = group
    }
}
