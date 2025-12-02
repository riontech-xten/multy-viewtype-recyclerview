package com.xtensolutions.asiacup.data.model

import com.xtensolutions.interfacesample.room.T20ACDatabase
import com.xtensolutions.interfacesample.room.T20ACDatabase.Companion.MAX_DELAY
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Created by Vaghela Mithun R. on 27-11-2025 - 18:34.
 * Email : vaghela.mithun@gmail.com
 * Mob   : +919727206702
 **/
object DatabaseDataModel {
    private suspend fun clearAllTablesInTransaction(db: T20ACDatabase) {
        db.matchDao().clearTable()
        db.groupDao().clearTable()
        db.resultDao().clearTable()
        db.teamDao().clearTable()
        db.teamPointTableDao().clearTable()
        println("all records cleared")
    }

    fun insertSeedData(database: T20ACDatabase) {
        CoroutineScope(Dispatchers.IO).launch {
            // small delay to ensure getInstance() won't rebuild the DB recursively
            delay(MAX_DELAY)
            // Clear tables using raw SQL (defensive) then insert seed data via DAOs.
            // Use execSQL to clear in case DAOs don't have delete methods.
            clearAllTablesInTransaction(database)
            // Implement seed data insertion logic here if needed
            database.groupDao().insert(GroupDataModel.generateData())
            database.teamDao().insert(TeamDataModel.generateData())
            database.matchDao().insert(MatchDataModel.generateData())
            database.resultDao().insert(ResultDataModel.generateData())
            database.teamPointTableDao().insert(TeamPointDataModel.generateData())
            println("records inserted")
        }
    }
}
