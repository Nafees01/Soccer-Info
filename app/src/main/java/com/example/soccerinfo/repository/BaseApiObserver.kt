package com.example.soccerinfo.repository

import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.example.soccerinfo.R
import com.example.soccerinfo.model.BaseResponse

import com.example.soccerinfo.model.LoginResponse
import io.reactivex.SingleObserver
import io.reactivex.observers.DisposableObserver

abstract class BaseApiObserver<T:BaseResponse> : DisposableObserver<T>() {

    abstract fun onSuccess(response: T)

    override fun onNext(response: T) {

       onSuccess(response)
    }

    override fun onError(e: Throwable) {

    }

    override fun onComplete() {}






}