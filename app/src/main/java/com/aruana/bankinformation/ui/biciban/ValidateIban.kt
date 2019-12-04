package com.aruana.bankinformation.ui.biciban

import com.aruana.bankinformation.domain.SingleUseCase
import io.reactivex.disposables.Disposable

abstract class ValidateIban : SingleUseCase<Boolean, ValidateIban.Params> {

    override var disposable: Disposable? = null

    data class Params(val iban: String)
}