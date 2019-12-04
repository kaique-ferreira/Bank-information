package com.aruana.bankinformation.ui.biciban

import com.aruana.bankinformation.common.ValidateApiResultCode
import com.aruana.bankinformation.networking.BankService
import javax.inject.Inject

class IbanRepositoryImpl @Inject constructor(private val bankService: BankService,
                                             private val validateApiResultCode: ValidateApiResultCode) : IbanRepository {

    override fun isIbanValid(iban: String) = bankService.validateIban(iban).map { validateApiResultCode.isInputValid(it.code) }
}