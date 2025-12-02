package com.xtensolutions.interfacesample.listener

import com.xtensolutions.core.listener.ListItemInterface
import com.xtensolutions.core.utils.ITEM_SECTION_TYPE

/**
 * Created by Vaghela Mithun R. on 09-10-2025 - 19:50.
 * Email : vaghela.mithun@gmail.com
 * Mob   : +919727206702
 **/
data class ListSection(
    val section: String
) : ListItemInterface {
    override fun getItemType(): Int = ITEM_SECTION_TYPE
}
