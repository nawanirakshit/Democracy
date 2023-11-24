package `in`.democracy.app.config

object IntentKey {
    const val PERM_KEY = "perm_key"
    const val PERM_STATE = "state"
    const val PERM_DISTRICT = "district"
    const val PERM_BLOCK = "block"
    const val PERM_WARD = "ward"
}

object APIEndPoints {
    const val APP_ID = "appid=com.`in`.democracy.app"
    const val INIT = "init"
    const val COUNTRIES = "get-countries"
    const val STATES = "get-states"
    const val DISTRICTS = "get-districts"
    const val BLOCKS = "get-blocks"
    const val WARDS = "get-wards"
}

object FragmentResult {
    const val LOCATION_PERMISSION = "locationPermission"
    const val NOTIFICATION_PERMISSION = "notificationPermission"
    const val STORAGE_PERMISSION = "storagePermission"
    const val COUNTER_DETAILS = "counter_details"
}