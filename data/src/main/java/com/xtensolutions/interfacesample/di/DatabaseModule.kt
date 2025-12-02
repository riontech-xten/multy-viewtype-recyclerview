package com.xtensolutions.interfacesample.di

import android.content.Context
import com.xtensolutions.interfacesample.room.T20ACDatabase
import com.xtensolutions.interfacesample.room.dao.GroupDao
import com.xtensolutions.interfacesample.room.dao.MatchDao
import com.xtensolutions.interfacesample.room.dao.ResultDao
import com.xtensolutions.interfacesample.room.dao.TeamDao
import com.xtensolutions.interfacesample.room.dao.TeamPointTableDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Vaghela Mithun R. on 11-10-2025 - 20:26.
 * Email : vaghela.mithun@gmail.com
 * Mob   : +919727206702
 **/
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideCatchDatabase(@ApplicationContext context: Context): T20ACDatabase =
        T20ACDatabase.buildDatabase(context)

    @Provides
    @Singleton
    fun provideResultDao(database: T20ACDatabase): ResultDao = database.resultDao()

    @Provides
    @Singleton
    fun provideMatchDao(database: T20ACDatabase): MatchDao = database.matchDao()

    @Provides
    @Singleton
    fun provideTeamDao(database: T20ACDatabase): TeamDao = database.teamDao()

    @Provides
    @Singleton
    fun provideGroupDao(database: T20ACDatabase): GroupDao = database.groupDao()

    @Provides
    @Singleton
    fun provideTeamPointsDao(database: T20ACDatabase): TeamPointTableDao = database.teamPointTableDao()
}
