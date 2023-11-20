package `in`.democracy.app.config

import android.os.Build
import java.util.*

object Constants {
    const val COURSES = "courses"
}

fun getDeviceID(): String {
    return UUID.randomUUID().toString()
}

fun getDeviceModel(): String {
    return Build.MANUFACTURER + " - " + Build.MODEL
}

fun getVersion(): String {
    return Build.VERSION.SDK_INT.toString()
}