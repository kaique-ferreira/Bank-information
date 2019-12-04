package com.aruana.bankinformation.ui.biciban

import io.reactivex.Single
import javax.inject.Inject

class ValidateIbanImpl @Inject constructor(private val repository: IbanRepository) : ValidateIban() {

    override fun createSingleUseCase(params: Params): Single<Boolean> = repository.isIbanValid(params.iban)

}