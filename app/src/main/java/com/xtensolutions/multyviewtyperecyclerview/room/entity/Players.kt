package com.xtensolutions.multyviewtyperecyclerview.room.entity

import androidx.room.Entity

/**
 * Created by Vaghela Mithun R. on 04-10-2025 - 16:52.
 * Email : vaghela.mithun@gmail.com
 * Mob   : +919727206702
 **/
@Entity(tableName = "players")
data class Players(
    val playerId: String,
    val playerName: String,
    val playerRole: String,
    val teamId: String,
    val battingStyle: String,
    val bowlingStyle: String,
    val dateOfBirth: String,
)
