package com.xtensolutions.interfacesample.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.xtensolutions.interfacesample.room.dao.GroupDao
import com.xtensolutions.interfacesample.room.dao.MatchDao
import com.xtensolutions.interfacesample.room.dao.ResultDao
import com.xtensolutions.interfacesample.room.dao.TeamDao
import com.xtensolutions.interfacesample.room.dao.TeamPointTableDao
import com.xtensolutions.interfacesample.room.entity.Group
import com.xtensolutions.interfacesample.room.entity.Match
import com.xtensolutions.interfacesample.room.entity.Result
import com.xtensolutions.interfacesample.room.entity.Team
import com.xtensolutions.interfacesample.room.entity.TeamPointTable

/**
 * Created by Vaghela Mithun R. on 11-10-2025 - 12:16.
 * Email : vaghela.mithun@gmail.com
 * Mob   : +919727206702
 **/
@Database(
    entities = [
        Match::class, Group::class, Result::class, Team::class, TeamPointTable::class
    ], version = 1, exportSchema = false
)
abstract class T20ACDatabase : RoomDatabase() {
    abstract fun matchDao(): MatchDao
    abstract fun groupDao(): GroupDao
    abstract fun resultDao(): ResultDao
    abstract fun teamDao(): TeamDao
    abstract fun teamPointTableDao(): TeamPointTableDao

    companion object {
        const val DATABASE_NAME = "t20_ac_database"
        const val MAX_DELAY = 100L

        // Singleton instance
        @Volatile
        private var INSTANCE: T20ACDatabase? = null

        /**
         * Get the singleton database instance. If not created yet, build it and return.
         */
        fun getInstance(appContext: Context): T20ACDatabase {
            println("getInstance called")
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(appContext).also { INSTANCE = it }
            }
        }

        /**
         * Build the database with a callback that clears old records and inserts fresh seed data on create.
         */
        fun buildDatabase(appContext: Context): T20ACDatabase {
            println("buildDatabase called")
            return Room.databaseBuilder(appContext, T20ACDatabase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration(false)
                .build()
        }
    }
}
