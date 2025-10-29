package com.xtensolutions.multyviewtyperecyclerview.core.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.xtensolutions.multyviewtyperecyclerview.core.listener.OnSingleClickListener


/**
 * Created by Vaghela Mithun R. on 30/10/20.
 * vaghela.mithun@gmail.com
 */
abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), OnSingleClickListener {
    private lateinit var viewHolderClickListener: ViewHolderClickListener
    open var allowInstantClick = false

    interface ViewHolderClickListener {
        fun onViewHolderViewClicked(view: View?, position: Int)
    }

    fun setViewClickListener(holderClickObserver: ViewHolderClickListener) {
        this.viewHolderClickListener = holderClickObserver
    }

    override fun onSingleClick(v: View) {
        if (allowInstantClick.not() && ::viewHolderClickListener.isInitialized) viewHolderClickListener.onViewHolderViewClicked(
            v, adapterPosition
        )
    }

    override fun instantClick(v: View) {
        if (allowInstantClick && ::viewHolderClickListener.isInitialized) viewHolderClickListener.onViewHolderViewClicked(
            v, adapterPosition
        )
    }
}
