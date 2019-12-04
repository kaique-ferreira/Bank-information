package com.aruana.bankinformation.ui.biciban

import io.reactivex.Single
import javax.inject.Inject

class ValidateBicImpl @Inject constructor(private val repository: BicRepository) : ValidateBic() {

    override fun createSingleUseCase(params: Params): Single<Boolean> = repository.isBicValid(params.bic)

}