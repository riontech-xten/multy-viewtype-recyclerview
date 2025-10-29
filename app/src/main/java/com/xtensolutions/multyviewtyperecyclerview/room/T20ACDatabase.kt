package com.xtensolutions.multyviewtyperecyclerview.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.xtensolutions.multyviewtyperecyclerview.room.dao.GroupDao
import com.xtensolutions.multyviewtyperecyclerview.room.dao.MatchDao
import com.xtensolutions.multyviewtyperecyclerview.room.dao.ResultDao
import com.xtensolutions.multyviewtyperecyclerview.room.dao.TeamDao
import com.xtensolutions.multyviewtyperecyclerview.room.dao.TeamPointTableDao
import com.xtensolutions.multyviewtyperecyclerview.room.entity.Group
import com.xtensolutions.multyviewtyperecyclerview.room.entity.Match
import com.xtensolutions.multyviewtyperecyclerview.room.entity.Result
import com.xtensolutions.multyviewtyperecyclerview.room.entity.Team
import com.xtensolutions.multyviewtyperecyclerview.room.entity.TeamPointTable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

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
                .addCallback(object : Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        println("Database onCreate called")
                        // Schedule seeding after the database instance is available.
                        // Room invokes this callback while build() is running, so INSTANCE may still be null.
                        // We delay briefly and then call getInstance(appContext) which will return the created instance
                        // because getInstance assigns INSTANCE after build() returns.
                        CoroutineScope(Dispatchers.IO).launch {
                            // small delay to ensure getInstance() won't rebuild the DB recursively
                            delay(100)
                            // Clear tables using raw SQL (defensive) then insert seed data via DAOs.
                            // Use execSQL to clear in case DAOs don't have delete methods.
                            clearAllTablesInTransaction(db)

                            try {
                                getInstance(appContext).also { database ->
                                    insertSeedData(database)
                                }
                            } catch (e: Exception) {
                                e.printStackTrace()
                            }
                        }
                    }
                })
                .build()
        }

        private suspend fun clearAllTablesInTransaction(db: SupportSQLiteDatabase) {
            db.execSQL("DELETE FROM `match`")
            db.execSQL("DELETE FROM `group`")
            db.execSQL("DELETE FROM `match_result`")
            db.execSQL("DELETE FROM `team`")
            db.execSQL("DELETE FROM `team_point_table`")
            println("all records cleared")
        }

        private suspend fun insertSeedData(database: T20ACDatabase) {
            // Implement seed data insertion logic here if needed
            database.groupDao().insert(Group.generateData())
            database.teamDao().insert(Team.generateData())
            database.matchDao().insert(Match.generateData())
            database.resultDao().insert(Result.generateData())
            database.teamPointTableDao().insert(TeamPointTable.generateData())
            println("records inserted")
        }
    }
}
