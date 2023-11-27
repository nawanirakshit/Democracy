package `in`.democracy.app.config

import android.content.Context
import `in`.democracy.app.utils.preference.SharedPreferenceUtils

const val PHONE = "PHONE"
const val EMAIL = "EMAIL"

const val USER_PHONE = "USER_PHONE"
const val USER_PASSWORD = "USER_PASSWORD"

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

    var userPhone: String
        get() = preferences.get(USER_PHONE, "")
        set(profile) = preferences.set(USER_PHONE, profile)

    var userPassword: String
        get() = preferences.get(USER_PASSWORD, "")
        set(profile) = preferences.set(USER_PASSWORD, profile)

    fun clearPreferences() {
        preferences.clearAll()
    }
}
