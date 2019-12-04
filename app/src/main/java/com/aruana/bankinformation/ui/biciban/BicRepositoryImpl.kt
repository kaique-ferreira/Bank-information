package com.aruana.bankinformation.ui.biciban

import com.aruana.bankinformation.common.ValidateApiResultCode
import com.aruana.bankinformation.networking.BankService
import javax.inject.Inject

class BicRepositoryImpl @Inject constructor(private val bankService: BankService,
                                            private val validateApiResultCode: ValidateApiResultCode) : BicRepository {

    override fun isBicValid(bic: String) = bankService.validateBic(bic).map { validateApiResultCode.isInputValid(it.code) }
}