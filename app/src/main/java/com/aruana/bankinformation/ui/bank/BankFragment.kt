package com.aruana.bankinformation.ui.bank

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.aruana.bankinformation.MyApplication
import com.aruana.bankinformation.R
import com.aruana.bankinformation.common.StateHandler
import com.aruana.bankinformation.databinding.FragmentBankBinding
import com.aruana.bankinformation.di.createBankViewModel
import com.jakewharton.rxbinding3.widget.textChanges
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.fragment_bank.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

const val TIME_TO_WAIT_FOR_TEXT_INPUT = 900L

class BankFragment : Fragment() {

    private lateinit var bankViewModel: BankViewModel
    private lateinit var binding: FragmentBankBinding
    private var disposableEditTextSeachBank: Disposable? = null

    @Inject
    lateinit var stateHandler: StateHandler

    override fun onAttach(context: Context) {
        super.onAttach(context)
        bankViewModel = createBankViewModel()
        (requireActivity().application as MyApplication).appComponent.inject(this)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_bank, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = bankViewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        disposableEditTextSeachBank = editTextSearchBank
                .textChanges()
                .skip(1)
                .debounce(TIME_TO_WAIT_FOR_TEXT_INPUT, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .map { it.toString() }
                .subscribe({
                    bankViewModel.findBankListByBlz(it)
                }, {})

        bankViewModel.state.observe(this, Observer {
            stateHandler.handleState(it, progressBar)
        })
    }

    override fun onDestroyView() {
        disposableEditTextSeachBank?.dispose()
        super.onDestroyView()
    }
}