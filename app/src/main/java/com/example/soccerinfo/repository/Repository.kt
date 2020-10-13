package com.example.soccerinfo.repository

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import com.example.soccerinfo.model.InfoResponse
import com.example.soccerinfo.model.LoginRequestModel
import com.example.soccerinfo.model.LoginResponse
import com.example.soccerinfo.network.ApiService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class Repository {

   @SuppressLint("CheckResult")
    fun requestForLogin(loginRequestModel:LoginRequestModel): Observable<LoginResponse>? {
        var data = MutableLiveData<LoginResponse>()
        val retrofit = Retrofit.Builder()
            .baseUrl("http://182.160.97.214:81/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        val apiService: ApiService = retrofit.create(ApiService::class.java)
        //without disposable
        /* apiService.getEmployeeData().subscribeOn(Schedulers.io()) .observeOn(AndroidSchedulers.mainThread())
             .subscribe{
                 Log.d("2",it.size.toString())
             }*/
        //with disposable
        return  apiService.requestForLogin(loginRequestModel).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())



    }

fun requestForInfo(): Observable<InfoResponse>? {
        var data = MutableLiveData<InfoResponse>()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://dhaka-static.zssbd.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        val apiService: ApiService = retrofit.create(ApiService::class.java)
        //without disposable
        /* apiService.getEmployeeData().subscribeOn(Schedulers.io()) .observeOn(AndroidSchedulers.mainThread())
             .subscribe{
                 Log.d("2",it.size.toString())
             }*/
        //with disposable
        return  apiService.requestForInfo().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())



    }


}