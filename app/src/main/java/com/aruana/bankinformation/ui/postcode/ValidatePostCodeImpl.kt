package com.aruana.bankinformation.ui.postcode

import io.reactivex.Single
import javax.inject.Inject

class ValidatePostCodeImpl @Inject constructor(private val repository: PostCodeRepository) : ValidatePostCode() {

    override fun createSingleUseCase(params: Params): Single<Boolean> = repository.validatePostCode(params.postCode, params.countryCode)

}