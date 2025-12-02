package com.xtensolutions.asiacup

import android.app.Application
import com.github.ajalt.timberkt.Timber
import com.xtensolutions.asiacup.data.model.DatabaseDataModel
import com.xtensolutions.interfacesample.room.T20ACDatabase
import javax.inject.Inject

/**
 * Created by Vaghela Mithun R. on 27-11-2025 - 18:29.
 * Email : vaghela.mithun@gmail.com
 * Mob   : +919727206702
 **/
abstract class T20AsiaCupApp : Application() {
    @Inject
    lateinit var database: T20ACDatabase

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())

        DatabaseDataModel.insertSeedData(database)
    }
}
