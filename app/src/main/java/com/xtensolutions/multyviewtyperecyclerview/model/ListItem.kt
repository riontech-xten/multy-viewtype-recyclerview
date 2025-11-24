package com.xtensolutions.multyviewtyperecyclerview.model

import com.xtensolutions.multyviewtyperecyclerview.core.listener.ListItemHeaderSection

/**
 * Generic sealed class representing different item types that can be shown in a single RecyclerView
 * with multiple view types.
 *
 * The base class is non-generic (data: Any?) so existing code that references `ListItem` without
 * type parameters continues to work. Subclasses remain generic and expose a typed `data`.
 */
sealed class ListItem(open val data: Any?) {

    /** A header/section item. Implements [ListItemHeaderSection] so adapters that rely on
     * that interface can detect headers easily. */
    data class Section<T>(override val data: T) : ListItem(data), ListItemHeaderSection {
        override fun isHeader(): Boolean = true
    }

    /** A match item (e.g. a match result). */
    data class Match<T>(override val data: T) : ListItem(data)

    /** A team item (e.g. team points row). */
    data class Team<T>(override val data: T) : ListItem(data)

    /** A group item (e.g. group header or descriptor). */
    data class Group<T>(override val data: T) : ListItem(data)

    /** An ad/banner item for promotional content. */
    data class AdBanner<T>(override val data: T) : ListItem(data)
}
