package `in`.democracy.app.viewmodel

import androidx.lifecycle.viewModelScope
import `in`.democracy.app.config.Config
import `in`.democracy.app.io.RequestAPIs
import `in`.democracy.app.io.model.ResponseInit
import `in`.democracy.app.io.model.ResponseWards
import `in`.democracy.app.kotlin.viewmodel.KotlinBaseViewModel
import `in`.democracy.app.kotlin.viewmodel.VolatileLiveData

class MainViewModel(private val api: RequestAPIs) : KotlinBaseViewModel() {
    var successInit = VolatileLiveData<Boolean>()
    var successStates = VolatileLiveData<List<ResponseWards>>()
    var successDistrict = VolatileLiveData<List<ResponseWards>>()
    var successBlock = VolatileLiveData<List<ResponseWards>>()
    var successWard = VolatileLiveData<List<ResponseWards>>()

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

    /**
     * API to fetch states
     */
    fun getStates() {
        viewModelScope.launchWithProgress {
            val states = api.getStates("India")

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
    fun getDistricts(state: String) {
        viewModelScope.launchWithProgress {
            val states = api.getDistricts("India", state)

            states.responseChecker<List<ResponseWards>> {
                if (it.isEmpty()) {
                    errorMessage.postValue("No districts available as of now, try again later.")
                } else successDistrict.postValue(it)
            }
        }
    }

    fun getBlock(state: String, district: String) {
        viewModelScope.launchWithProgress {
            val states = api.getBlocks("India", state, district)

            states.responseChecker<List<ResponseWards>> {
                if (it.isEmpty()) {
                    errorMessage.postValue("No blocks available as of now, try again later.")
                } else successBlock.postValue(it)
            }
        }
    }

    fun getWards(state: String, district: String, block: String) {
        viewModelScope.launchWithProgress {
            val states = api.getWards("India", state, district, block)

            states.responseChecker<List<ResponseWards>> {
                if (it.isEmpty()) {
                    errorMessage.postValue("No wards available as of now, try again later.")
                } else successWard.postValue(it)
            }
        }
    }

}