package `in`.democracy.app.io.networking.coroutineRequestAdapter

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ErrorModel {

    @SerializedName("status", alternate = ["success"])
    @Expose
    val status: String? = null

    @SerializedName("message", alternate = ["Message", "error"])
    @Expose
    val message: String? = null
}