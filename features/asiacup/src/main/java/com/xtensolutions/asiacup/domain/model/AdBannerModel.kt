package com.xtensolutions.asiacup.domain.model

import com.xtensolutions.core.listener.ListItemInterface
import com.xtensolutions.core.utils.ITEM_AD_BANNER_TYPE

/**
 * Simple model representing banner content for an ad row.
 */
data class AdBannerModel(
    val id: String,
    val title: String,
    val subtitle: String? = null,
    val imageUrl: String? = null
) : ListItemInterface {
    override fun getItemType(): Int = ITEM_AD_BANNER_TYPE
}
