package com.xtensolutions.asiacup.presentation.viewholder

import com.xtensolutions.asiacup.databinding.ListItemAdBannerBinding
import com.xtensolutions.asiacup.domain.model.AdBannerModel
import com.xtensolutions.core.viewholder.BaseViewHolder

/**
 * Created by Vaghela Mithun R. on 28-11-2025 - 17:53.
 * Email : vaghela.mithun@gmail.com
 * Mob   : +919727206702
 **/
class AdBannerViewHolder(private val binding: ListItemAdBannerBinding) : BaseViewHolder(binding.root) {
    fun bind(banner: AdBannerModel) {
        binding.banner = banner
    }
}
