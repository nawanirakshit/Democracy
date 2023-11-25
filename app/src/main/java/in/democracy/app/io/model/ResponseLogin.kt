package `in`.democracy.app.io.model

data class ResponseLogin(
    val code: Int,
    val msg: String,
    val user: User
)