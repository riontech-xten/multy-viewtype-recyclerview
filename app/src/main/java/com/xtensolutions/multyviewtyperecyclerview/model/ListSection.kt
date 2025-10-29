package com.xtensolutions.multyviewtyperecyclerview.model

import com.xtensolutions.multyviewtyperecyclerview.core.listener.ListItemHeaderSection

/**
 * Created by Vaghela Mithun R. on 09-10-2025 - 19:50.
 * Email : vaghela.mithun@gmail.com
 * Mob   : +919727206702
 **/
data class ListSection(
    val section: String
) : ListItemHeaderSection {
    override fun isHeader(): Boolean = true
}
