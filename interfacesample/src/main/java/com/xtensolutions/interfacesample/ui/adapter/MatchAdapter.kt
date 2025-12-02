package com.xtensolutions.interfacesample.ui.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.xtensolutions.asiacup.databinding.ListItemRowMatchBinding
import com.xtensolutions.interfacesample.room.entity.MatchResult
import com.xtensolutions.asiacup.presentation.viewholder.MatchViewHolder
import com.xtensolutions.core.listener.ListItemInterface
import com.xtensolutions.core.utils.ITEM_MATCH_TYPE
import java.util.LinkedList

/**
 * Created by Vaghela Mithun R. on 09-10-2025 - 19:53.
 * Email : vaghela.mithun@gmail.com
 * Mob   : +919727206702
 **/
open class MatchAdapter(
    context: Context,
    objectsList: LinkedList<ListItemInterface>
) : GroupAdapter(context, objectsList) {

    override fun getItemViewType(position: Int): Int {
        return getItem(position).getItemType()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == ITEM_MATCH_TYPE) {
            val binding = ListItemRowMatchBinding.inflate(inflater, parent, false)
            return MatchViewHolder(binding)
        } else return super.onCreateViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        if (holder is MatchViewHolder && getItemViewType(position) == ITEM_MATCH_TYPE) {
            holder.bind(item as MatchResult)
        } else super.onBindViewHolder(holder, position)
    }
}
