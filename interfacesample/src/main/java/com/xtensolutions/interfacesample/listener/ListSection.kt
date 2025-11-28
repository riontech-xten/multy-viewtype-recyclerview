package com.xtensolutions.interfacesample.listener

import com.xtensolutions.core.listener.ListItemListener

/**
 * Created by Vaghela Mithun R. on 09-10-2025 - 19:50.
 * Email : vaghela.mithun@gmail.com
 * Mob   : +919727206702
 **/
data class ListSection(
    val section: String
) : ListItemListener {
    override fun isHeader(): Boolean = true
}
