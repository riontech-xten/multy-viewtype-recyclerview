package com.xtensolutions.sealedclass.ui.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.xtensolutions.asiacup.databinding.ListItemRowTeamBinding
import com.xtensolutions.interfacesample.room.entity.GroupTeamPoints
import com.xtensolutions.core.model.ListItem
import com.xtensolutions.asiacup.presentation.viewholder.TeamViewHolder
import java.util.LinkedList

/**
 * Created by Vaghela Mithun R. on 09-10-2025 - 19:28.
 * Email : vaghela.mithun@gmail.com
 * Mob   : +919727206702
 **/
open class TeamAdapter(
    context: Context,
    objectsList: LinkedList<ListItem>
) : AdBannerAdapter(context, objectsList) {

    override fun getItemViewType(position: Int): Int {
        if (getItem(position) is ListItem.Team<*>) return TEAM_TYPE
        return super.getItemViewType(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TEAM_TYPE) {
            val binding = ListItemRowTeamBinding.inflate(inflater, parent, false)
            return TeamViewHolder(binding)
        } else return super.onCreateViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is TeamViewHolder && getItem(position) is ListItem.Team<*>) {
            holder.bind(getItem(position).data as GroupTeamPoints)
        } else super.onBindViewHolder(holder, position)
    }

    companion object {
        const val TEAM_TYPE = 4000
    }
}
