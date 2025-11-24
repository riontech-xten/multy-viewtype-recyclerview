package com.xtensolutions.multyviewtyperecyclerview.model

/**
 * Simple model representing banner content for an ad row.
 */
data class AdBannerModel(
    val id: String,
    val title: String,
    val subtitle: String? = null,
    val imageUrl: String? = null
)
