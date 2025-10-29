package com.xtensolutions.multyviewtyperecyclerview.core.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView.ViewHolder

/**
 * Created by Vaghela Mithun R. on 14-08-2023 - 19:07.
 * Email : vaghela.mithun@gmail.com
 * Mob   : +919727206702
 **/
abstract class BaseRecyclerViewAdapter<I>(
    ctx: Context,
    lists: MutableList<I>
) : BaseRecyclerViewHolderAdapter<I, ViewHolder>(ctx, lists)
