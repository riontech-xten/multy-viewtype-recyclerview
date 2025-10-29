package com.xtensolutions.multyviewtyperecyclerview.ui.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.xtensolutions.multyviewtyperecyclerview.core.listener.ListItemHeaderSection
import com.xtensolutions.multyviewtyperecyclerview.core.viewholder.BaseViewHolder
import com.xtensolutions.multyviewtyperecyclerview.databinding.ListItemRowGroupBinding
import com.xtensolutions.multyviewtyperecyclerview.room.entity.Group
import java.util.LinkedList

/**
 * Created by Vaghela Mithun R. on 09-10-2025 - 19:53.
 * Email : vaghela.mithun@gmail.com
 * Mob   : +919727206702
 **/
open class GroupAdapter(
    context: Context,
    objectsList: LinkedList<ListItemHeaderSection>
) : TeamAdapter(context, objectsList) {

    override fun getItemViewType(position: Int): Int {
        if (getItem(position) is Group && getItem(position).isHeader().not()) return GROUP_TYPE
        return super.getItemViewType(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == GROUP_TYPE) {
            val binding = ListItemRowGroupBinding.inflate(inflater, parent, false)
            return GroupViewHolder(binding)
        } else return super.onCreateViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is GroupViewHolder && getItem(position) is Group) {
            holder.bind(getItem(position) as Group)
        } else super.onBindViewHolder(holder, position)
    }

    companion object {
        const val GROUP_TYPE = 3000
    }
}

class GroupViewHolder(private val binding: ListItemRowGroupBinding) : BaseViewHolder(binding.root) {
    fun bind(group: Group) {
         binding.group = group
    }
}
