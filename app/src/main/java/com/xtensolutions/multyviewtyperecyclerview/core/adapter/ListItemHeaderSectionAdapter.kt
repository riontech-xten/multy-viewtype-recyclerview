package com.xtensolutions.multyviewtyperecyclerview.core.adapter

import android.content.Context
import com.xtensolutions.multyviewtyperecyclerview.core.listener.ListItemHeaderSection
import java.util.LinkedList

/**
 * Created by Vaghela Mithun R. on 24-11-2023 - 02:02.
 * Email : vaghela.mithun@gmail.com
 * Mob   : +919727206702
 */
abstract class ListItemHeaderSectionAdapter<I: ListItemHeaderSection>(context: Context, objectsList: LinkedList<I>) :
    BaseRecyclerViewAdapter<I>(context, objectsList) {

    override fun getItemViewType(position: Int): Int {
        return if(getItem(position).isHeader()) HEADER
        else super.getItemViewType(position)
    }

    companion object {
        const val HEADER = 1000
    }
}
