package com.xtensolutions.multyviewtyperecyclerview

import android.app.Application
import com.github.ajalt.timberkt.Timber
import dagger.hilt.android.HiltAndroidApp

/**
 * Created by Vaghela Mithun R. on 11-10-2025 - 12:44.
 * Email : vaghela.mithun@gmail.com
 * Mob   : +919727206702
 **/
@HiltAndroidApp
class T20AsiaCupApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}
