package com.aruana.bankinformation.ui.postcode

import javax.inject.Inject

class GetAllSupportedCountriesImpl @Inject constructor(private val repository: PostCodeRepository) : GetAllSupportedCountries {

    override fun invoke() = repository.getSupportedCountriesList()
}