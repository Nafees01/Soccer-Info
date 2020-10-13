package com.example.soccerinfo.ui.ui.listShow

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.soccerinfo.model.InfoResponse
import com.example.soccerinfo.model.LoginRequestModel
import com.example.soccerinfo.model.LoginResponse
import com.example.soccerinfo.repository.BaseApiObserver
import com.example.soccerinfo.repository.Repository

class InfoViewModel : ViewModel() {
    var repository: Repository? = null
    var infoResponse = MutableLiveData<InfoResponse>()
    var errorResponse = MutableLiveData<String>()
    fun requestForInfo() {
        repository = Repository()
        repository.let {
            it?.requestForInfo()
                ?.subscribeWith(object: BaseApiObserver<InfoResponse>() {
                    override fun onSuccess(response: InfoResponse) {
                        infoResponse.value = response
                    }

                    override fun onError(e: Throwable) {
                        Log.d("error",e.message)
                        errorResponse.value=e.message

                    }
                })
        }
    }
}