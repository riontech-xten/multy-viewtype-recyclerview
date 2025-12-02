package com.xtensolutions.asiacup.data.model

import com.xtensolutions.asiacup.R
import com.xtensolutions.interfacesample.room.entity.Team

/**
 * Created by Vaghela Mithun R. on 25-11-2025 - 19:48.
 * Email : vaghela.mithun@gmail.com
 * Mob   : +919727206702
 **/
object TeamDataModel {
    @Suppress("detekt.LongMethod")
    fun generateData() = arrayListOf<Team>().apply {
        // Group A Teams
        add(
            Team(
                teamId = "IND",
                teamName = "India",
                teamFlagLarge = R.drawable.flag_ind,
                teamFlagSmall = R.drawable.flag_ind_40,
            )
        )
        add(
            Team(
                teamId = "PAK",
                teamName = "Pakistan",
                teamFlagSmall = R.drawable.flag_pak_40,
                teamFlagLarge = R.drawable.flag_pak,
            )
        )
        add(
            Team(
                teamId = "UAE",
                teamName = "United Arab Emirates",
                teamFlagSmall = R.drawable.flag_uae_40,
                teamFlagLarge = R.drawable.flag_uae,
            )
        )
        add(
            Team(
                teamId = "OMA",
                teamName = "United Arab Emirates",
                teamFlagSmall = R.drawable.flag_oma_40,
                teamFlagLarge = R.drawable.flag_oma,
            )
        )
        // Group B Teams
        add(
            Team(
                teamId = "SL",
                teamName = "Sri Lanka",
                teamFlagSmall = R.drawable.flag_sl_40,
                teamFlagLarge = R.drawable.flag_sl,
            )
        )
        add(
            Team(
                teamId = "BAN",
                teamName = "Bangladesh",
                teamFlagSmall = R.drawable.flag_ban_40,
                teamFlagLarge = R.drawable.flag_ban,
            )
        )
        add(
            Team(
                teamId = "AFG",
                teamName = "Afghanistan",
                teamFlagSmall = R.drawable.flag_afg_40,
                teamFlagLarge = R.drawable.flag_afg,
            )
        )
        add(
            Team(
                teamId = "HKG",
                teamName = "Hong Kong",
                teamFlagSmall = R.drawable.flag_hkg_40,
                teamFlagLarge = R.drawable.flag_hkg,
            )
        )
    }
}
