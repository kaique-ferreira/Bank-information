package com.aruana.bankinformation.ui.bank

import com.aruana.bankinformation.domain.SingleUseCase
import io.reactivex.disposables.Disposable

abstract class FindBankByBlz : SingleUseCase<List<BankModel>, FindBankByBlz.Params> {

    override var disposable: Disposable? = null

    data class Params(val blz: String)
}