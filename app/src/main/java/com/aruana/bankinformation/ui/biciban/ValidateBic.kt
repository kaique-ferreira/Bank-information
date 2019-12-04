package com.aruana.bankinformation.ui.biciban

import com.aruana.bankinformation.domain.SingleUseCase
import io.reactivex.disposables.Disposable

abstract class ValidateBic : SingleUseCase<Boolean, ValidateBic.Params> {

    override var disposable: Disposable? = null

    data class Params(val bic: String)
}