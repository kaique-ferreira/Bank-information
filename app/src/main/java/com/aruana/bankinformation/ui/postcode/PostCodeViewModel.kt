package com.aruana.bankinformation.ui.postcode

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aruana.bankinformation.common.State
import com.aruana.bankinformation.common.State.FINISHED_LOADING
import com.aruana.bankinformation.common.State.LOADING
import javax.inject.Inject

class PostCodeViewModel @Inject constructor(private val getAllSupportedCountries: GetAllSupportedCountries,
                                            private val validatePostCode: ValidatePostCode) : ViewModel() {

    private val _state = MutableLiveData<State>()
    val state: LiveData<State> get() = _state

    private val _isPostCodeValid = MutableLiveData<Boolean>()
    val isPostCodeValid: LiveData<Boolean> get() = _isPostCodeValid

    val spinnerItems = getAllSupportedCountries.invoke().map { it.name }

    override fun onCleared() {
        validatePostCode.dispose()
    }

    fun validatePostCode(postCode: String, countryName: String) {
        if (countryName.isEmpty()) {
            return
        }

        _state.value = LOADING
        val countryCode = getAllSupportedCountries.invoke().find { it.name == countryName }!!.isoCode

        validatePostCode.invoke(
                onSuccess = {
                    _isPostCodeValid.value = it
                    _state.value = FINISHED_LOADING
                },
                onError = {
                    _state.value = FINISHED_LOADING
                },
                onFinished = {
                    _state.value = FINISHED_LOADING
                },
                params = ValidatePostCode.Params(postCode, countryCode)
        )
    }
}