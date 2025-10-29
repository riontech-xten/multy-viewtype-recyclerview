package com.xtensolutions.multyviewtyperecyclerview.core.listener

/**
 * Created by Vaghela Mithun R. on 29-03-2024 - 17:28.
 * Email : vaghela.mithun@gmail.com
 * Mob   : +919727206702
 **/
interface ListItemHeaderSection {
    fun isHeader(): Boolean
    fun isFooter(): Boolean {
        return false
    }
}
