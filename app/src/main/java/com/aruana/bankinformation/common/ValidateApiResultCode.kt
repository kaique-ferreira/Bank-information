package com.aruana.bankinformation.common

import javax.inject.Inject

class ValidateApiResultCodeImpl @Inject constructor() : ValidateApiResultCode {

    private val VALID_INPUT_CODE = "OK"

    override fun isInputValid(resultCode: String) = resultCode == VALID_INPUT_CODE
}

interface ValidateApiResultCode {
    fun isInputValid(resultCode: String): Boolean
}