package com.aruana.bankinformation.ui.bank

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aruana.bankinformation.common.State
import com.aruana.bankinformation.common.State.FINISHED_LOADING
import com.aruana.bankinformation.common.State.LOADING
import javax.inject.Inject

class BankViewModel @Inject constructor(private val findBankByBlz: FindBankByBlz,
                                        val adapter: BanksAdapter) : ViewModel() {

    private val _state = MutableLiveData<State>()
    val state: LiveData<State> get() = _state

    override fun onCleared() {
        findBankByBlz.dispose()
    }

    fun findBankListByBlz(blz: String) {
        _state.value = LOADING
        findBankByBlz.invoke(
                onSuccess = {
                    adapter.submitList(it)
                    _state.value = FINISHED_LOADING
                },
                onError = {
                    adapter.submitList(emptyList())
                    _state.value = FINISHED_LOADING
                },
                onFinished = {
                    _state.value = FINISHED_LOADING
                },
                params = FindBankByBlz.Params(blz)
        )
    }
}

