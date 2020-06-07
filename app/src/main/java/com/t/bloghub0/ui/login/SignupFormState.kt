package com.t.bloghub0.ui.login

data class SignupFormState (

    val usernameError: Int? = null,
    val passwordError: Int? = null,
    val nameError: Int? = null,
    val isDataValid: Boolean = false
)