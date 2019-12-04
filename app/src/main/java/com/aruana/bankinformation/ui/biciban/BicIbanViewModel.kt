package com.aruana.bankinformation.ui.biciban

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aruana.bankinformation.common.State
import com.aruana.bankinformation.common.State.FINISHED_LOADING
import com.aruana.bankinformation.common.State.LOADING
import javax.inject.Inject

class BicIbanViewModel @Inject constructor(private val validateBic: ValidateBic,
                                           private val validateIban: ValidateIban) : ViewModel() {

    private val _state = MutableLiveData<State>()
    val state: LiveData<State> get() = _state

    private val _isBicValid = MutableLiveData<Boolean>()
    val isBicValid: LiveData<Boolean> get() = _isBicValid

    private val _isIbanValid = MutableLiveData<Boolean>()
    val isIbanValid: LiveData<Boolean> get() = _isIbanValid

    override fun onCleared() {
        validateBic.dispose()
        validateIban.dispose()
    }

    fun validateIban(iban: String) {
        _state.value = LOADING
        validateIban.invoke(
                onSuccess = {
                    _isIbanValid.value = it
                    _state.value = FINISHED_LOADING
                },
                onError = {
                    _state.value = FINISHED_LOADING
                },
                onFinished = {
                    _state.value = FINISHED_LOADING
                },
                params = ValidateIban.Params(iban)
        )
    }

    fun validateBic(bic: String) {
        _state.value = LOADING
        validateBic.invoke(
                onSuccess = {
                    _isBicValid.value = it
                    _state.value = FINISHED_LOADING
                },
                onError = {
                    _state.value = FINISHED_LOADING
                },
                onFinished = {
                    _state.value = FINISHED_LOADING
                },
                params = ValidateBic.Params(bic)
        )
    }
}