package com.xtensolutions.interfacesample.ui.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.xtensolutions.asiacup.databinding.ListItemRowSectionBinding
import com.xtensolutions.core.model.ListItem
import com.xtensolutions.asiacup.presentation.viewholder.SectionViewHolder
import com.xtensolutions.core.adapter.BaseRecyclerViewAdapter
import com.xtensolutions.core.listener.ListItemListener
import com.xtensolutions.interfacesample.listener.ListSection
import java.util.LinkedList

/**
 * Created by Vaghela Mithun R. on 03-06-2025 - 11:55.
 * Email : vaghela.mithun@gmail.com
 * Mob   : +919727206702
 **/

/** Adapter for displaying common header sections in a RecyclerView.
 * This adapter extends [BaseRecyclerViewAdapter]
 * to handle common header sections.
 * @param context The context in which the adapter is created.
 * @param objectsList The list of items to be displayed, which should include instances of [ListSectionAdapter].
 */
open class ListSectionAdapter(
    context: Context, objectsList: LinkedList<ListItemListener>
) : BaseRecyclerViewAdapter<ListItemListener>(context, objectsList) {

    override fun getItemViewType(position: Int): Int {
        return if (getItem(position) is ListSection) HEADER
        else super.getItemViewType(position)
    }

    /**
     * Creates a new view holder for the common header section.
     * This method is called by the RecyclerView to create a new view holder for the header section.
     *
     * @param parent The parent view group into which the new view will be added.
     * @param viewType The type of view to create, which is expected to be HEADER for this adapter.
     * @return A new instance of [com.xtensolutions.asiacup.presentation.viewholder.SectionViewHolder] with the inflated binding.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == HEADER) {
            val binding = ListItemRowSectionBinding.inflate(inflater, parent, false)
            SectionViewHolder(binding)
        } else super.createViewHolder(parent, viewType)
    }

    /**
     * Binds the data to the view holder.
     * This method is called by the RecyclerView to bind data to the view holder at the specified position.
     *
     * @param holder The view holder to bind data to.
     * @param position The position of the item in the adapter.
     */
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is SectionViewHolder && getItemViewType(position) == HEADER) {
            // use component1() (data class generated accessor) instead of .data to avoid unresolved reference
            val section = (getItem(position) as ListSection).section
            holder.bind(section)
        } else {
            super.bindViewHolder(holder, position)
        }
    }

    companion object {
        const val HEADER = 1000
    }
}
