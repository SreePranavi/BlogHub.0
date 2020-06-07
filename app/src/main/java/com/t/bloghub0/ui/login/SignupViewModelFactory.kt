package com.t.bloghub0.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.t.bloghub0.data.SignupDataSource
import com.t.bloghub0.data.SignupRepository

class SignupViewModelFactory : ViewModelProvider.Factory{

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(SignupViewModel::class.java)) {
                return SignupViewModel(SignupRepository(
                        dataSource = SignupDataSource()
                    )
                ) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
