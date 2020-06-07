package com.t.bloghub0.data

import com.t.bloghub0.data.model.SignedUpUser
import com.t.bloghub0.data.Result.Success

class SignupRepository(val dataSource: SignupDataSource) {

        var user: SignedUpUser? = null
            private set

        val isSignedUp: Boolean
            get() = user != null

        init {
            user = null
        }


        public fun signUp(username: String, password: String, penname: String): Result<SignedUpUser> {

            val result = dataSource.signup(username, password, penname)

            if (result is Result.Success) {
                setSignedUpUser(result.data)
            }

            return result
        }

        private fun setSignedUpUser(SignedUpUser: SignedUpUser) {
            this.user = SignedUpUser

    }

}