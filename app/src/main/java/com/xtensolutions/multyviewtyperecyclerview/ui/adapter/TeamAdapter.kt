package com.xtensolutions.multyviewtyperecyclerview.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.xtensolutions.multyviewtyperecyclerview.core.listener.ListItemHeaderSection
import com.xtensolutions.multyviewtyperecyclerview.core.viewholder.BaseViewHolder
import com.xtensolutions.multyviewtyperecyclerview.databinding.ListItemRowTeamBinding
import com.xtensolutions.multyviewtyperecyclerview.room.entity.GroupTeamPoints
import com.xtensolutions.multyviewtyperecyclerview.room.entity.Team
import java.util.LinkedList

/**
 * Created by Vaghela Mithun R. on 09-10-2025 - 19:28.
 * Email : vaghela.mithun@gmail.com
 * Mob   : +919727206702
 **/
open class TeamAdapter(
    context: android.content.Context,
    objectsList: LinkedList<ListItemHeaderSection>
) : ListSectionAdapter<ListItemHeaderSection>(context, objectsList) {

    override fun getItemViewType(position: Int): Int {
        if (getItem(position) is GroupTeamPoints && getItem(position).isHeader().not()) return TEAM_TYPE
        return super.getItemViewType(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TEAM_TYPE) {
            val binding = ListItemRowTeamBinding.inflate(inflater, parent, false)
            return TeamViewHolder(binding)
        } else return super.onCreateViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is TeamViewHolder && getItem(position) is GroupTeamPoints) {
            holder.bind(getItem(position) as GroupTeamPoints)
        } else super.onBindViewHolder(holder, position)
    }

    companion object {
        const val TEAM_TYPE = 4000
    }
}

class TeamViewHolder(private val binding: ListItemRowTeamBinding) : BaseViewHolder(binding.root) {

    fun bind(team: GroupTeamPoints) {
        binding.team = team
    }
}
