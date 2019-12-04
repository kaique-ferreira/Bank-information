package com.aruana.bankinformation.ui.postcode

import com.aruana.bankinformation.common.ValidateApiResultCode
import com.aruana.bankinformation.networking.BankService
import javax.inject.Inject

class PostCodeRepositoryImpl @Inject constructor(private val bankService: BankService,
                                                 private val validateApiResultCode: ValidateApiResultCode) : PostCodeRepository {

    override fun validatePostCode(postCode: String, countryCode: String) = bankService.validatePostalCode(postCode, countryCode).map {
        validateApiResultCode.isInputValid(it.code)
    }

    override fun getSupportedCountriesList(): List<CountryModel> {
        return listOf(
                CountryModel(isoCode = "DE", name = "Germany"),
                CountryModel(isoCode = "BE", name = "Belgium"),
                CountryModel(isoCode = "AT", name = "Austria"),
                CountryModel(isoCode = "FR", name = "France"),
                CountryModel(isoCode = "IT", name = "Italy"),
                CountryModel(isoCode = "LU", name = "Luxembourg"),
                CountryModel(isoCode = "NL", name = "Netherlands"),
                CountryModel(isoCode = "PL", name = "Poland"))
    }
}