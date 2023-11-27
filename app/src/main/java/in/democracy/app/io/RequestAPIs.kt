package `in`.democracy.app.io

import `in`.democracy.app.config.APIEndPoints
import `in`.democracy.app.io.model.ResponseInit
import `in`.democracy.app.io.model.ResponseLogin
import `in`.democracy.app.io.model.ResponseWards
import `in`.democracy.app.io.networking.coroutineRequestAdapter.GenericResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RequestAPIs {

    @GET(APIEndPoints.INIT)
    suspend fun init(): GenericResponse<ResponseInit>

    @GET(APIEndPoints.COUNTRIES)
    suspend fun getCountries(): GenericResponse<List<ResponseWards>>

    @GET(APIEndPoints.STATES)
    suspend fun getStates(
        @Query("country") country: String
    ): GenericResponse<List<ResponseWards>>

    @GET(APIEndPoints.DISTRICTS)
    suspend fun getDistricts(
        @Query("country") country: String,
        @Query("state") state: String
    ): GenericResponse<List<ResponseWards>>

    @GET(APIEndPoints.BLOCKS)
    suspend fun getBlocks(
        @Query("country") country: String,
        @Query("state") state: String,
        @Query("district") district: String
    ): GenericResponse<List<ResponseWards>>

    @GET(APIEndPoints.WARDS)
    suspend fun getWards(
        @Query("country") country: String,
        @Query("state") state: String,
        @Query("district") district: String,
        @Query("block") block: String
    ): GenericResponse<List<ResponseWards>>

    @GET(APIEndPoints.ATTENDEES)
    suspend fun getAttendees(
        @Query("country") country: String,
        @Query("state") state: String,
        @Query("district") district: String,
        @Query("block_id") block: String,
        @Query("ward_id") ward: String
    ): GenericResponse<List<ResponseWards>>

    @GET(APIEndPoints.LOGIN)
    suspend fun login(
        @Query("mobile") country: String,
        @Query("password") state: String
    ): GenericResponse<ResponseLogin>

    @GET(APIEndPoints.ATTENDANCE)
    suspend fun markAttendance(
        @Query("user_mobile") user_mobile: String,
        @Query("user_password") user_password: String,
        @Query("attendee_id") attendee_id: String,
        @Query("status") status: String
    ): GenericResponse<ResponseLogin>

}