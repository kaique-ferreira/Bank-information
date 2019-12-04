package com.aruana.bankinformation.common

import android.widget.EditText
import com.aruana.bankinformation.R
import javax.inject.Inject

class ValidationViewHandlerImpl @Inject constructor() : ValidationViewHandler {

    override fun handleValidationCheckResult(isValid: Boolean, targetEditText: EditText) {
        if (isValid) {
            showValidSign(targetEditText)
        } else {
            showInvalidSign(targetEditText)
        }
    }

    private fun showInvalidSign(editText: EditText) {
        editText.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_clear_24dp, 0)
    }

    private fun showValidSign(editText: EditText) {
        editText.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_check_circle_24dp, 0)
    }
}

interface ValidationViewHandler {

    fun handleValidationCheckResult(isValid: Boolean, targetEditText: EditText)
}
