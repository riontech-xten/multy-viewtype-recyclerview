package com.xtensolutions.asiacup.presentation.viewholder

import com.xtensolutions.asiacup.databinding.ListItemRowSectionBinding
import com.xtensolutions.core.viewholder.BaseViewHolder

/**
 * Created by Vaghela Mithun R. on 28-11-2025 - 17:54.
 * Email : vaghela.mithun@gmail.com
 * Mob   : +919727206702
 **/
/**
 * ViewHolder for the common header section.
 * This class binds the header section data to the view.
 *
 * @param binding The binding for the row item that contains the header section layout.
 */
class SectionViewHolder(
    private val binding: ListItemRowSectionBinding
) : BaseViewHolder(binding.root) {
    fun bind(headerSection: String) {
        binding.section = headerSection
    }
}
