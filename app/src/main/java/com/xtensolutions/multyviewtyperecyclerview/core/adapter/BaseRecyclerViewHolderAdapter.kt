package com.xtensolutions.multyviewtyperecyclerview.core.adapter

import android.content.Context
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.xtensolutions.multyviewtyperecyclerview.core.viewholder.BaseViewHolder

/**
 * Created by Vaghela Mithun R. on 14-08-2023 - 19:07.
 * Email : vaghela.mithun@gmail.com
 * Mob   : +919727206702
 **/
abstract class BaseRecyclerViewHolderAdapter<I, VH : ViewHolder>(
    protected val context: Context, protected var items: MutableList<I>
) : RecyclerView.Adapter<VH>() {
    protected val inflater: LayoutInflater = LayoutInflater.from(context)
    var viewHolderClickListener: BaseViewHolder.ViewHolderClickListener? = null

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getItemCount(): Int = items.size

    fun addItem(item: I) {
        items.add(item)
        notifyItemRangeChanged(0, items.size)
    }

    fun addItems(items: List<I>) {
        val startPosition = this.items.size
        this.items.addAll(items)
        notifyItemRangeInserted(startPosition, items.size)
    }

    fun addItemsAt(position: Int, items: List<I>) {
        this.items.addAll(position, items)
        notifyItemRangeInserted(position, items.size)
    }

    fun addItemAt(position: Int, item: I) {
        items.add(position, item)
        notifyItemInserted(position)
    }

    fun remove(position: Int) {
        items.removeAt(position)
        notifyItemRemoved(position)
    }

    fun remove(item: I) {
        remove(items.indexOf(item))
    }

    fun updateItems(newItems: MutableList<I>) {
        notifyItemRangeRemoved(0, itemCount)
        items.clear()
        items.addAll(newItems)
        notifyItemRangeInserted(0, items.size)
    }

    fun getItem(position: Int) = items.get(position)

    fun updateItemAt(position: Int, item: I) {
        items[position] = item
        notifyItemChanged(position)
    }

    fun getList(): List<I> = items;

    fun clear() {
        items.clear()
        notifyDataSetChanged()
//        notifyItemChanged(0, itemCount)
    }

}
