package com.xtensolutions.interfacesample.ui.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.xtensolutions.asiacup.databinding.ListItemAdBannerBinding
import com.xtensolutions.asiacup.domain.model.AdBannerModel
import com.xtensolutions.core.model.ListItem
import com.xtensolutions.asiacup.presentation.viewholder.AdBannerViewHolder
import com.xtensolutions.core.listener.ListItemListener
import com.xtensolutions.interfacesample.listener.ListSection
import java.util.LinkedList

/**
 * Adapter specifically for AdBanner rows. Extends the same adapter layering as other adapters
 * (extends GroupAdapter) so it can be composed in the same way.
 */
open class AdBannerAdapter(
    context: Context,
    objectsList: LinkedList<ListItemListener>
) : ListSectionAdapter(context, objectsList) {

    override fun getItemViewType(position: Int): Int {
        if (getItem(position) is AdBannerModel) return AD_BANNER_TYPE
        return super.getItemViewType(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == AD_BANNER_TYPE) {
            val binding = ListItemAdBannerBinding.inflate(inflater, parent, false)
            return AdBannerViewHolder(binding)
        } else return super.onCreateViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is AdBannerViewHolder && getItemViewType(position) == AD_BANNER_TYPE) {
            holder.bind(getItem(position) as AdBannerModel)
        } else super.onBindViewHolder(holder, position)
    }

    companion object {
        const val AD_BANNER_TYPE = 5000
    }
}
