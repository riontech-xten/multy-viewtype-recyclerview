package com.xtensolutions.multyviewtyperecyclerview.ui.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.xtensolutions.multyviewtyperecyclerview.core.listener.ListItemHeaderSection
import com.xtensolutions.multyviewtyperecyclerview.core.viewholder.BaseViewHolder
import com.xtensolutions.multyviewtyperecyclerview.databinding.ListItemRowMatchBinding
import com.xtensolutions.multyviewtyperecyclerview.room.entity.MatchResult
import java.util.LinkedList

/**
 * Created by Vaghela Mithun R. on 09-10-2025 - 19:53.
 * Email : vaghela.mithun@gmail.com
 * Mob   : +919727206702
 **/
open class MatchAdapter(
    context: Context,
    objectsList: LinkedList<ListItemHeaderSection>
) : GroupAdapter(context, objectsList) {

    override fun getItemViewType(position: Int): Int {
        if (getItem(position) is MatchResult && getItem(position).isHeader().not()) return MATCH_TYPE
        return super.getItemViewType(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == MATCH_TYPE) {
            val binding = ListItemRowMatchBinding.inflate(inflater, parent, false)
            return MatchViewHolder(binding)
        } else return super.onCreateViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is MatchViewHolder && getItem(position) is MatchResult) {
            holder.bind(getItem(position) as MatchResult)
        } else super.onBindViewHolder(holder, position)
    }

    companion object {
        const val MATCH_TYPE = 2000
    }
}

class MatchViewHolder(private val binding: ListItemRowMatchBinding) : BaseViewHolder(binding.root) {

    fun bind(match: MatchResult) {
        binding.match = match
    }
}
