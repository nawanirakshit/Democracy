package `in`.democracy.app.kotlin.viewmodel.common

enum class ErrorType {
    TOAST,
    CENTER_TOAST
}

data class CommonError(val msg: String?, val errorType: ErrorType = ErrorType.TOAST)