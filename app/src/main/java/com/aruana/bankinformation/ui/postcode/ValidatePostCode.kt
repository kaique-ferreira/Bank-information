package com.aruana.bankinformation.ui.postcode

import com.aruana.bankinformation.domain.SingleUseCase
import io.reactivex.disposables.Disposable

abstract class ValidatePostCode : SingleUseCase<Boolean, ValidatePostCode.Params> {

    override var disposable: Disposable? = null

    data class Params(val postCode: String, val countryCode: String)
}