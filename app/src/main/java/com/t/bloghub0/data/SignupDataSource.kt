package com.t.bloghub0.data

import com.t.bloghub0.data.model.SignedUpUser
import java.io.IOException
import java.util.*

class SignupDataSource{

fun signup(username: String, password: String, penname: String): Result<SignedUpUser> {
    try {
        val fake = SignedUpUser(UUID.randomUUID().toString(), "Jane Doe")
        return Result.Success(fake)
    } catch (e: Throwable) {
        return Result.Error(IOException("Error  signing up", e))
    }
}

}
