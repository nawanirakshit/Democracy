package `in`.democracy.app.config

import android.app.Activity
import android.content.Context
import `in`.democracy.app.utils.preference.SharedPreferenceUtils

const val FIRST_LAUNCH = "FIRST_LAUNCH"
const val IS_LOGGED_IN = "isLogin"
const val PROFILE = "PROFILE"
const val THEME = "THEME"
const val COOKIES = "COOKIES"
const val TEMP_COOKIES = "TEMP_COOKIES"
const val DOMAIN = "DOMAIN"
const val TOKEN = "TOKEN"
const val SESSION = "SESSION"
const val FIRST_USER_LAUNCH = "FIRST_USER_LAUNCH"

object Config {
    private lateinit var preferences: SharedPreferenceUtils

    fun init(context: Context) {
        preferences = SharedPreferenceUtils(context)
    }

    var profile: String
        get() = preferences.get(PROFILE, "")
        set(profile) = preferences.set(PROFILE, profile)

    var isLoggedIn: Boolean
        get() = preferences.get(IS_LOGGED_IN, false)
        set(isLoggedIn) = preferences.set(IS_LOGGED_IN, isLoggedIn)

    var theme: String
        get() = preferences.get(THEME, "")
        set(theme) = preferences.set(THEME, theme)

    var token: String
        get() = preferences.get(TOKEN, "")
        set(token) = preferences.set(TOKEN, token)

    var cookies: String
        get() = preferences.get(COOKIES, "")
        set(cookies) = preferences.set(COOKIES, cookies)

    var tempCookies: String
        get() = preferences.get(TEMP_COOKIES, "")
        set(tempCookies) = preferences.set(TEMP_COOKIES, tempCookies)

    var domain: String
        get() = preferences.get(DOMAIN, "")
        set(domain) = preferences.set(DOMAIN, domain)

    var session: String
        get() = preferences.get(SESSION, "")
        set(session) = preferences.set(SESSION, session)

    fun setFirstTimeLaunchUser(isFirstTime: String): Boolean {
        val set: MutableSet<String> = HashSet()
        if (isFirstLaunchUser() != null) {
            set.addAll(isFirstLaunchUser()!!)
        }
        set.add(isFirstTime)
        return preferences.mEditor.putStringSet(FIRST_USER_LAUNCH, set).commit()
    }

    fun isFirstLaunchUser(): Set<String>? {
        return preferences.mSharedPreferences.getStringSet(FIRST_USER_LAUNCH, null)
    }


    fun clearPreferences() {
        preferences.clearAll()
    }
}
