package `in`.democracy.app.config

object IntentKey {
    const val PERM_KEY = "perm_key"
    const val PERM_COUNTRY = "country"
    const val PERM_STATE = "state"
    const val PERM_DISTRICT = "district"
    const val PERM_BLOCK = "block"
    const val PERM_WARD = "ward"
    const val PERM_WARD_BUNDLE = "ward_bundle"
    const val PERM_BLOCK_ID = "block_id"
    const val PERM_WARD_ID = "ward_id"
    const val PERM_ATTENDEE_STATUS = "attendee_status"
    const val PERM_ATTENDEE_ID = "attendee_id"
    const val PERM_FROM_LOGIN = "from_login"
}

object APIEndPoints {
    const val APP_ID = "appid=com.`in`.democracy.app"
    const val INIT = "init"
    const val COUNTRIES = "get-countries"
    const val STATES = "get-states"
    const val DISTRICTS = "get-districts"
    const val BLOCKS = "get-blocks"
    const val WARDS = "get-wards"
    const val ATTENDEES = "get-attendees"
    const val LOGIN = "login"
    const val ATTENDANCE = "attendance"

}

object FragmentResult {
    const val LOCATION_PERMISSION = "locationPermission"
    const val NOTIFICATION_PERMISSION = "notificationPermission"
    const val STORAGE_PERMISSION = "storagePermission"
    const val COUNTER_DETAILS = "counter_details"
}