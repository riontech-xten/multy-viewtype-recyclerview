package com.xtensolutions.interfacesample.ui.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.xtensolutions.asiacup.databinding.ListItemRowGroupBinding
import com.xtensolutions.interfacesample.room.entity.Group
import com.xtensolutions.core.model.ListItem
import com.xtensolutions.asiacup.presentation.viewholder.GroupViewHolder
import com.xtensolutions.core.listener.ListItemListener
import java.util.LinkedList

/**
 * Created by Vaghela Mithun R. on 09-10-2025 - 19:53.
 * Email : vaghela.mithun@gmail.com
 * Mob   : +919727206702
 **/
open class GroupAdapter(
    context: Context,
    objectsList: LinkedList<ListItemListener>
) : TeamAdapter(context, objectsList) {

    override fun getItemViewType(position: Int): Int {
        if (getItem(position) is Group) return GROUP_TYPE
        return super.getItemViewType(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == GROUP_TYPE) {
            val binding = ListItemRowGroupBinding.inflate(inflater, parent, false)
            return GroupViewHolder(binding)
        } else return super.onCreateViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is GroupViewHolder && getItemViewType(position) == GROUP_TYPE) {
            holder.bind(getItem(position) as Group)
        } else super.onBindViewHolder(holder, position)
    }

    companion object {
        const val GROUP_TYPE = 3000
    }
}
