package com.xtensolutions.interfacesample.ui.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.xtensolutions.asiacup.databinding.ListItemRowTeamBinding
import com.xtensolutions.asiacup.presentation.viewholder.TeamViewHolder
import com.xtensolutions.core.listener.ListItemListener
import com.xtensolutions.interfacesample.room.entity.GroupTeamPoints
import java.util.LinkedList

/**
 * Created by Vaghela Mithun R. on 09-10-2025 - 19:28.
 * Email : vaghela.mithun@gmail.com
 * Mob   : +919727206702
 **/
open class TeamAdapter(
    context: Context,
    objectsList: LinkedList<ListItemListener>
) : AdBannerAdapter(context, objectsList) {

    override fun getItemViewType(position: Int): Int {
        if (getItem(position) is GroupTeamPoints) return TEAM_TYPE
        return super.getItemViewType(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TEAM_TYPE) {
            val binding = ListItemRowTeamBinding.inflate(inflater, parent, false)
            return TeamViewHolder(binding)
        } else return super.onCreateViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is TeamViewHolder && getItemViewType(position) == TEAM_TYPE) {
            holder.bind(getItem(position) as GroupTeamPoints)
        } else super.onBindViewHolder(holder, position)
    }

    companion object {
        const val TEAM_TYPE = 4000
    }
}
