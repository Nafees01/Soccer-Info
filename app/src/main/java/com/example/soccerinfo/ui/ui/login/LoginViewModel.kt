package com.example.soccerinfo.ui.ui.login

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.soccerinfo.model.LoginRequestModel
import com.example.soccerinfo.model.LoginResponse
import com.example.soccerinfo.repository.BaseApiObserver
import com.example.soccerinfo.repository.Repository
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class LoginViewModel : ViewModel() {
    var repository: Repository? = null
    var loginResponse = MutableLiveData<LoginResponse>()
    var errorResponse = MutableLiveData<String>()
    fun requestForLogin(loginRequestModel: LoginRequestModel) {
        repository = Repository()
        repository.let {
            it?.requestForLogin(loginRequestModel)
            ?.subscribeWith(object: BaseApiObserver<LoginResponse>() {
                override fun onSuccess(response: LoginResponse) {
                    loginResponse.value = response
                }

                override fun onError(e: Throwable) {
                   Log.d("error",e.message)
                    errorResponse.value=e.message

                }
            })
        }
    }
}


