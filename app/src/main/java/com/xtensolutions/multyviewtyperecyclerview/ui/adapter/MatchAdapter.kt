package com.xtensolutions.multyviewtyperecyclerview.ui.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.xtensolutions.multyviewtyperecyclerview.core.viewholder.BaseViewHolder
import com.xtensolutions.multyviewtyperecyclerview.databinding.ListItemRowMatchBinding
import com.xtensolutions.multyviewtyperecyclerview.databinding.ListItemAdBannerBinding
import com.xtensolutions.multyviewtyperecyclerview.model.AdBannerModel
import com.xtensolutions.multyviewtyperecyclerview.model.ListItem
import com.xtensolutions.multyviewtyperecyclerview.room.entity.MatchResult
import java.util.LinkedList

/**
 * Created by Vaghela Mithun R. on 09-10-2025 - 19:53.
 * Email : vaghela.mithun@gmail.com
 * Mob   : +919727206702
 **/
open class MatchAdapter(
    context: Context,
    objectsList: LinkedList<ListItem>
) : GroupAdapter(context, objectsList) {

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        if (item is ListItem.AdBanner<*>) return AD_BANNER_TYPE
        if (item is ListItem.Match<*>) return MATCH_TYPE
        return super.getItemViewType(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == MATCH_TYPE) {
            val binding = ListItemRowMatchBinding.inflate(inflater, parent, false)
            return MatchViewHolder(binding)
        } else if (viewType == AD_BANNER_TYPE) {
            val binding = ListItemAdBannerBinding.inflate(inflater, parent, false)
            return AdBannerViewHolder(binding)
        } else return super.onCreateViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        if (holder is MatchViewHolder && getItemViewType(position) == MATCH_TYPE) {
            holder.bind(item.data as MatchResult)
        } else if (holder is AdBannerViewHolder && getItemViewType(position) == AD_BANNER_TYPE) {
            holder.bind(item.data as AdBannerModel)
        } else super.onBindViewHolder(holder, position)
    }

    companion object {
        const val MATCH_TYPE = 2000
        const val AD_BANNER_TYPE = 5000
    }
}

class MatchViewHolder(private val binding: ListItemRowMatchBinding) : BaseViewHolder(binding.root) {

    fun bind(match: MatchResult) {
        binding.match = match
    }
}

class AdBannerViewHolder(private val binding: ListItemAdBannerBinding) : BaseViewHolder(binding.root) {
    fun bind(banner: AdBannerModel) {
        binding.banner = banner
    }
}
