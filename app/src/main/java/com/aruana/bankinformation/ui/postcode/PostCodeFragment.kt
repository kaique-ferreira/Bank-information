package com.aruana.bankinformation.ui.postcode

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
import com.aruana.bankinformation.databinding.FragmentPostcodeBinding
import com.aruana.bankinformation.di.createPostCodeViewModel
import kotlinx.android.synthetic.main.fragment_postcode.*
import javax.inject.Inject

class PostCodeFragment : Fragment() {

    private lateinit var postCodeViewModel: PostCodeViewModel

    private lateinit var binding: FragmentPostcodeBinding

    @Inject
    lateinit var validationViewHandler: ValidationViewHandler

    @Inject
    lateinit var stateHandler: StateHandler

    override fun onAttach(context: Context) {
        super.onAttach(context)
        postCodeViewModel = createPostCodeViewModel()
        (requireActivity().application as MyApplication).appComponent.inject(this)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_postcode, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = postCodeViewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(postCodeViewModel) {
            state.observe(this@PostCodeFragment, Observer {
                stateHandler.handleState(it, progressBar)
            })

            isPostCodeValid.observe(this@PostCodeFragment, Observer {
                validationViewHandler.handleValidationCheckResult(it, editTextPostCode)
            })
        }
    }
}