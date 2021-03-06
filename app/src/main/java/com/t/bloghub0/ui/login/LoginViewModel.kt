package com.t.bloghub0.ui.login

import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Patterns
import androidx.core.content.ContextCompat.startActivity
import com.t.bloghub0.data.LoginRepository
import com.t.bloghub0.data.Result

import com.t.bloghub0.R
import com.t.bloghub0.ScrollingActivity

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {

    private val _loginForm = MutableLiveData<LoginFormState>()
    val loginFormState: LiveData<LoginFormState> = _loginForm

    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult

    fun login(username: String, password: String) {
        val result = loginRepository.login(username, password)

        if (result is Result.Success) {
            _loginResult.value =
                LoginResult(success = LoggedInUserView(displayName = username))


        } else {
            _loginResult.value = LoginResult(error = R.string.login_failed)
        }
    }


    fun loginDataChanged(username: String, password: String) {
        if (!isUserNameValid(username)) {
            _loginForm.value = LoginFormState(usernameError = R.string.invalid_username)
        } else if (!isPasswordValid(password)) {
            _loginForm.value = LoginFormState(passwordError = R.string.invalid_password)
        } else {
            _loginForm.value = LoginFormState(isDataValid = true)
        }
    }

    private fun isUserNameValid(username: String): Boolean {
        return if (username.contains('@')  ) {
            Patterns.EMAIL_ADDRESS.matcher(username).matches()
        } else {
            //username.isNotBlank()
            return false
        }
    }

    private fun isPasswordValid(password: String): Boolean {
        return password.length > 7
    }
}
