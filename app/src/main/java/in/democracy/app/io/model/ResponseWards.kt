package `in`.democracy.app.io.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResponseWards(
    val block: String,
    val country: String,
    val district: String,
    val id: String,
    val state: String,
    val ward: String,
    val block_id: String,
    val ward_id: String,
    val name: String,
    val mobile: String,
    val status: String
) : Parcelable