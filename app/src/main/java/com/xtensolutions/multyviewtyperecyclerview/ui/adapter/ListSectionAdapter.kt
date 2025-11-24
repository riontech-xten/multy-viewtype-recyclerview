package com.xtensolutions.multyviewtyperecyclerview.ui.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.xtensolutions.multyviewtyperecyclerview.core.adapter.ListItemHeaderSectionAdapter
import com.xtensolutions.multyviewtyperecyclerview.core.viewholder.BaseViewHolder
import com.xtensolutions.multyviewtyperecyclerview.databinding.ListItemRowSectionBinding
import com.xtensolutions.multyviewtyperecyclerview.model.ListItem
import java.util.LinkedList

/**
 * Created by Vaghela Mithun R. on 03-06-2025 - 11:55.
 * Email : vaghela.mithun@gmail.com
 * Mob   : +919727206702
 **/

/** Adapter for displaying common header sections in a RecyclerView.
 * This adapter extends [com.xtensolutions.multyviewtyperecyclerview.core.adapter.ListItemHeaderSectionAdapter]
 * to handle common header sections.
 * @param context The context in which the adapter is created.
 * @param objectsList The list of items to be displayed, which should include instances of [ListSectionAdapter].
 */
open class ListSectionAdapter(
    context: Context, objectsList: LinkedList<ListItem>
) : ListItemHeaderSectionAdapter<ListItem>(context, objectsList) {
    /**
     * Creates a new view holder for the common header section.
     * This method is called by the RecyclerView to create a new view holder for the header section.
     *
     * @param parent The parent view group into which the new view will be added.
     * @param viewType The type of view to create, which is expected to be HEADER for this adapter.
     * @return A new instance of [SectionViewHolder] with the inflated binding.
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
        if (holder is SectionViewHolder && getItemViewType(position) == HEADER && getItem(position) is ListItem.Section<*>) {
            val headerSection = getItem(position) as ListItem.Section<*>
            // use component1() (data class generated accessor) instead of .data to avoid unresolved reference
            holder.bind(headerSection.component1() as String)
        } else {
            super.bindViewHolder(holder, position)
        }
    }
}

/**
 * ViewHolder for the common header section.
 * This class binds the header section data to the view.
 *
 * @param binding The binding for the row item that contains the header section layout.
 */
class SectionViewHolder(
    private val binding: ListItemRowSectionBinding
) : BaseViewHolder(binding.root) {
    fun bind(headerSection: String) {
        binding.section = headerSection
    }
}
