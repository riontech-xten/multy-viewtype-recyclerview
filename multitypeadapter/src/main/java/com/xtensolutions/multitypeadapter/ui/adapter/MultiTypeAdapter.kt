package com.xtensolutions.multitypeadapter.ui.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.xtensolutions.asiacup.databinding.ListItemAdBannerBinding
import com.xtensolutions.asiacup.databinding.ListItemRowGroupBinding
import com.xtensolutions.asiacup.databinding.ListItemRowMatchBinding
import com.xtensolutions.asiacup.databinding.ListItemRowSectionBinding
import com.xtensolutions.asiacup.databinding.ListItemRowTeamBinding
import com.xtensolutions.asiacup.domain.model.AdBannerModel
import com.xtensolutions.core.model.ListItem
import com.xtensolutions.asiacup.presentation.viewholder.AdBannerViewHolder
import com.xtensolutions.asiacup.presentation.viewholder.GroupViewHolder
import com.xtensolutions.asiacup.presentation.viewholder.MatchViewHolder
import com.xtensolutions.asiacup.presentation.viewholder.SectionViewHolder
import com.xtensolutions.asiacup.presentation.viewholder.TeamViewHolder
import com.xtensolutions.core.adapter.BaseRecyclerViewAdapter
import com.xtensolutions.core.utils.ITEM_AD_BANNER_TYPE
import com.xtensolutions.core.utils.ITEM_GROUP_TYPE
import com.xtensolutions.core.utils.ITEM_MATCH_TYPE
import com.xtensolutions.core.utils.ITEM_SECTION_TYPE
import com.xtensolutions.core.utils.ITEM_TEAM_TYPE
import com.xtensolutions.interfacesample.room.entity.Group
import com.xtensolutions.interfacesample.room.entity.GroupTeamPoints
import com.xtensolutions.interfacesample.room.entity.MatchResult
import java.util.LinkedList

/**
 * Created by Vaghela Mithun R. on 28-11-2025 - 17:47.
 * Email : vaghela.mithun@gmail.com
 * Mob   : +919727206702
 **/
class MultiTypeAdapter(
    context: Context,
    items: LinkedList<ListItem>
) : BaseRecyclerViewAdapter<ListItem>(context, items) {

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return if (item is ListItem.Match<*>) ITEM_MATCH_TYPE
        else if (item is ListItem.Group<*>) ITEM_GROUP_TYPE
        else if (item is ListItem.Team<*>) ITEM_TEAM_TYPE
        else if (item is ListItem.AdBanner<*>) ITEM_AD_BANNER_TYPE
        else ITEM_SECTION_TYPE
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        return when (viewType) {
            ITEM_MATCH_TYPE -> {
                val binding = ListItemRowMatchBinding.inflate(inflater, parent, false)
                MatchViewHolder(binding)
            }

            ITEM_GROUP_TYPE -> {
                val binding = ListItemRowGroupBinding.inflate(inflater, parent, false)
                GroupViewHolder(binding)
            }

            ITEM_TEAM_TYPE -> {
                val binding = ListItemRowTeamBinding.inflate(inflater, parent, false)
                TeamViewHolder(binding)
            }

            ITEM_AD_BANNER_TYPE -> {
                val binding = ListItemAdBannerBinding.inflate(inflater, parent, false)
                AdBannerViewHolder(binding)
            }

            ITEM_SECTION_TYPE -> {
                val binding = ListItemRowSectionBinding.inflate(inflater, parent, false)
                SectionViewHolder(binding)
            }

            else -> {
                throw IllegalArgumentException("Invalid view type")
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        when (holder) {
            is MatchViewHolder if getItemViewType(position) == ITEM_MATCH_TYPE -> {
                holder.bind(item.data as MatchResult)
            }

            is GroupViewHolder if getItemViewType(position) == ITEM_GROUP_TYPE -> {
                holder.bind(item.data as Group)
            }

            is TeamViewHolder if getItemViewType(position) == ITEM_TEAM_TYPE -> {
                holder.bind(item.data as GroupTeamPoints)
            }

            is AdBannerViewHolder if getItemViewType(position) == ITEM_AD_BANNER_TYPE -> {
                holder.bind(item.data as AdBannerModel)
            }

            is SectionViewHolder if getItemViewType(position) == ITEM_SECTION_TYPE -> {
                holder.bind(item.data as String)
            }
        }
    }
}
