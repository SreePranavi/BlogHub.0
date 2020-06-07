package com.t.bloghub0.ui.login


data class LoginResult(
    val success: LoggedInUserView? = null,
    val error: Int? = null
)
