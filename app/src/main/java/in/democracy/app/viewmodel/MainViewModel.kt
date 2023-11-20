package in.democracy.app.viewmodel

import androidx.lifecycle.viewModelScope
import `in`.democracy.app.io.RequestAPIs
import `in`.democracy.app.kotlin.viewmodel.KotlinBaseViewModel
import `in`.democracy.app.kotlin.viewmodel.VolatileLiveData

class MainViewModel(private val api: RequestAPIs) : KotlinBaseViewModel() {
    var successLogin = VolatileLiveData<Boolean>()
    var errorLogin = VolatileLiveData<String>()

    /**
     * API to check user credentials
     *
     * @param email entered password by user
     * @param password entered password by user
     */
    fun login(email: String, password: String) {
        viewModelScope.launchWithProgress {
//            val login = if (BuildConfig.APP_TYPE == "ONE") api.getSONEToken(
//                email, password, APIEndPoints.DAART
//            ) else api.getToken(email, password, APIEndPoints.DAART)
//
//            login.responseChecker<ResponseLogin> {
//                if (it.error != null && it.error.isNotEmpty()) {
//                    errorLogin.postValue(it.error)
//                } else {
//                    Config.theme = it.theme
//                    Config.token = it.wstoken
//
//                    val token = it.wstoken
//                    getProfileData(token)
//                }
//            }
        }
    }
}