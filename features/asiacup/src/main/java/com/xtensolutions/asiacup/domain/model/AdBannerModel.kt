package com.xtensolutions.asiacup.domain.model

import com.xtensolutions.core.listener.ListItemListener

/**
 * Simple model representing banner content for an ad row.
 */
data class AdBannerModel(
    val id: String,
    val title: String,
    val subtitle: String? = null,
    val imageUrl: String? = null
) : ListItemListener {
    override fun isHeader(): Boolean = false
}
