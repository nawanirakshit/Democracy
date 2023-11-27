package `in`.democracy.app.viewmodel

import androidx.lifecycle.viewModelScope
import `in`.democracy.app.config.Config
import `in`.democracy.app.io.RequestAPIs
import `in`.democracy.app.io.model.ResponseInit
import `in`.democracy.app.io.model.ResponseLogin
import `in`.democracy.app.io.model.ResponseWards
import `in`.democracy.app.io.model.User
import `in`.democracy.app.kotlin.viewmodel.KotlinBaseViewModel
import `in`.democracy.app.kotlin.viewmodel.VolatileLiveData

class MainViewModel(private val api: RequestAPIs) : KotlinBaseViewModel() {
    var successInit = VolatileLiveData<Boolean>()
    var successStates = VolatileLiveData<List<ResponseWards>>()
    var successDistrict = VolatileLiveData<List<ResponseWards>>()
    var successBlock = VolatileLiveData<List<ResponseWards>>()
    var successWard = VolatileLiveData<List<ResponseWards>>()
    var successLogin = VolatileLiveData<User>()
    var successAttendance = VolatileLiveData<Boolean>()

    var errorMessage = VolatileLiveData<String>()

    fun init() {
        viewModelScope.launchWithProgress {
            val init = api.init()

            init.responseChecker<ResponseInit> {
                val email = it.support_email
                val phone = it.support_phone

                Config.phone = phone
                Config.email = email
                successInit.postValue(true)

            }
        }
    }


    fun getCountries() {
        viewModelScope.launchWithProgress {
            val states = api.getCountries()

            states.responseChecker<List<ResponseWards>> {
                if (it.isEmpty()) {
                    errorMessage.postValue("No states available as of now, try again later.")
                } else successStates.postValue(it)
            }
        }
    }

    /**
     * API to fetch states
     */
    fun getStates(country: String) {
        viewModelScope.launchWithProgress {
            val states = api.getStates(country)

            states.responseChecker<List<ResponseWards>> {
                if (it.isEmpty()) {
                    errorMessage.postValue("No states available as of now, try again later.")
                } else successStates.postValue(it)
            }
        }
    }

    /**
     * API to fetch states
     */
    fun getDistricts(country: String, state: String) {
        viewModelScope.launchWithProgress {
            val states = api.getDistricts(country, state)

            states.responseChecker<List<ResponseWards>> {
                if (it.isEmpty()) {
                    errorMessage.postValue("No districts available as of now, try again later.")
                } else successDistrict.postValue(it)
            }
        }
    }

    fun getBlock(country: String, state: String, district: String) {
        viewModelScope.launchWithProgress {
            val states = api.getBlocks(country, state, district)

            states.responseChecker<List<ResponseWards>> {
                if (it.isEmpty()) {
                    errorMessage.postValue("No blocks available as of now, try again later.")
                } else successBlock.postValue(it)
            }
        }
    }

    fun getWards(country: String, state: String, district: String, block: String) {
        viewModelScope.launchWithProgress {
            val states = api.getWards(country, state, district, block)

            states.responseChecker<List<ResponseWards>> {
                if (it.isEmpty()) {
                    errorMessage.postValue("No wards available as of now, try again later.")
                } else successWard.postValue(it)
            }
        }
    }

    fun getAttendees(
        country: String, state: String, district: String, block: String, ward: String
    ) {
        viewModelScope.launchWithProgress {
            val states = api.getAttendees(country, state, district, block, ward)

            states.responseChecker<List<ResponseWards>> {
                if (it.isEmpty()) {
                    errorMessage.postValue("No attendees available as of now, try again later.")
                } else successWard.postValue(it)
            }
        }
    }

    fun checkLogin(mobile: String, password: String) {
        viewModelScope.launchWithProgress {
            val states = api.login(mobile, password)

            states.responseChecker<ResponseLogin> {

                if (it.code == 1) {
                    successLogin.postValue(it.user)
                } else {
                    errorMessage.postValue(it.msg)
                }
            }
        }
    }

    fun markAttendance(attendee_id: String, status: String) {
        viewModelScope.launchWithProgress {
            val states =
                api.markAttendance(Config.userPhone, Config.userPassword, attendee_id, status)

            states.responseChecker<ResponseLogin> {

                errorMessage.postValue(it.msg)
                if (it.code == 1) {
                    successAttendance.postValue(true)
                } else successAttendance.postValue(false)
            }
        }

    }

}