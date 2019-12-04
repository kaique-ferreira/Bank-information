package com.aruana.bankinformation.ui.biciban

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
import com.aruana.bankinformation.common.ValidationViewHandler
import com.aruana.bankinformation.databinding.FragmentBicibanBinding
import com.aruana.bankinformation.di.createBicIbanViewModel
import kotlinx.android.synthetic.main.fragment_biciban.*
import javax.inject.Inject

class BicIbanFragment : Fragment() {

    private lateinit var bicIbanViewModel: BicIbanViewModel

    private lateinit var binding: FragmentBicibanBinding

    @Inject
    lateinit var validationViewHandler: ValidationViewHandler

    @Inject
    lateinit var stateHandler: StateHandler

    override fun onAttach(context: Context) {
        super.onAttach(context)
        bicIbanViewModel = createBicIbanViewModel()
        (requireActivity().application as MyApplication).appComponent.inject(this)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_biciban, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = bicIbanViewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(bicIbanViewModel) {
            isBicValid.observe(this@BicIbanFragment, Observer { isValid ->
                validationViewHandler.handleValidationCheckResult(isValid, editTextBic)
            })

            isIbanValid.observe(this@BicIbanFragment, Observer { isValid ->
                validationViewHandler.handleValidationCheckResult(isValid, editTextIban)
            })

            state.observe(this@BicIbanFragment, Observer {
                stateHandler.handleState(it, progressBar)
            })
        }
    }
}