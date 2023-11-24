package `in`.democracy.app.config

import android.content.Context
import `in`.democracy.app.utils.preference.SharedPreferenceUtils

const val PHONE = "PHONE"
const val EMAIL = "EMAIL"

object Config {
    private lateinit var preferences: SharedPreferenceUtils

    fun init(context: Context) {
        preferences = SharedPreferenceUtils(context)
    }

    var phone: String
        get() = preferences.get(PHONE, "")
        set(profile) = preferences.set(PHONE, profile)

    var email: String
        get() = preferences.get(EMAIL, "")
        set(profile) = preferences.set(EMAIL, profile)

    fun clearPreferences() {
        preferences.clearAll()
    }
}
