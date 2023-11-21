package `in`.democracy.app

import android.app.Application
import `in`.democracy.app.config.Config
import `in`.democracy.app.di.apiModule
import `in`.democracy.app.di.networkModule
import `in`.democracy.app.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ApplicationClass : Application() {

    companion object {
        const val notificationChannelID = "Democracy App Channel"

        private lateinit var instance: ApplicationClass

        @JvmStatic
        fun getApp() = instance
    }

    override fun onCreate() {
        super.onCreate()

        Config.init(this@ApplicationClass)

        startKoin {
            androidContext(this@ApplicationClass)
            modules(
                listOf(
                    networkModule, apiModule, viewModelModule
                )
            )
        }

    }
}