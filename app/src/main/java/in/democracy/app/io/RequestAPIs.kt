package `in`.democracy.app.io

import `in`.democracy.app.config.APIEndPoints
import `in`.democracy.app.io.networking.coroutineRequestAdapter.GenericResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RequestAPIs {

    /**
     * https://uat.samsungbackstage.co.uk/auth/backstage/mobile_login.php?&username=rakshit.nawani%40iris-worldwide.com&password=Iris1234%21&service=dataart
     */
//    @GET(APIEndPoints.FUNCTION_LOGIN)
//    suspend fun getToken(
//        @Query("username") name: String,
//         @Query("password") password: String,
//         @Query("service") serviceName: String
//    ): GenericResponse<String>

}