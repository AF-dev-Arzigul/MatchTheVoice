package uz.gita.placeimagegamenaj.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import uz.gita.placeimagegamenaj.LocalData

@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        LocalData.getInstance(this)
    }
}