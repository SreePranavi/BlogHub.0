package com.t.bloghub0.ui.login

import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Patterns
import androidx.core.content.ContextCompat.startActivity
import com.t.bloghub0.data.Result

import com.t.bloghub0.R
import com.t.bloghub0.ScrollingActivity
import com.t.bloghub0.data.SignupDataSource
import com.t.bloghub0.data.SignupRepository


class SignupViewModel(private val singupRepository: SignupRepository) : ViewModel() {

    private val _signupForm = MutableLiveData<SignupFormState>()
    val signupFormState: LiveData<SignupFormState> = _signupForm

    private val _signupResult = MutableLiveData<SignupResult>()
    val signupResult: LiveData<SignupResult> = _signupResult

    fun signup(username: String, password: String, penname: String) {
        val sresult = singupRepository.signUp(username, password, penname)

        if (sresult is Result.Success<*>) {
            _signupResult.value =
                SignupResult(success = SignedUpUserView(penName = penname))


        } else {
            _signupResult.value = SignupResult(error = R.string.signup_failed)
        }
    }


    fun signupDataChanged(username: String, password: String, penname: String) {
        if (!isUserNameValid(username)) {
            _signupForm.value = SignupFormState(usernameError = R.string.invalid_username)
        } else if (!isPasswordValid(password)) {
            _signupForm.value = SignupFormState(passwordError = R.string.invalid_password)
        } else if (!isnamevalid(penname)) {
            _signupForm.value = SignupFormState(nameError = R.string.invalid_name)
        } else {
            _signupForm.value = SignupFormState(isDataValid = true)
        }
    }

    private fun isUserNameValid(username: String): Boolean {
        return if (username.contains('@')) {
            Patterns.EMAIL_ADDRESS.matcher(username).matches()
        } else {
            return false
        }
    }

    private fun isPasswordValid(password: String): Boolean {
        return password.length > 7
    }


    private fun isnamevalid(penname : String): Boolean
    {
        return penname.length > 5
    }
}