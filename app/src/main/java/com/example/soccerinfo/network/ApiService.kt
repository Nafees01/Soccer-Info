package com.example.soccerinfo.network

import com.example.soccerinfo.model.InfoResponse
import com.example.soccerinfo.model.LoginRequestModel
import com.example.soccerinfo.model.LoginResponse
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @POST("api/v1/user")
    fun requestForLogin(@Body loginRequest : LoginRequestModel): Observable<LoginResponse>
    @GET("RecruitmentTest.json")
    fun requestForInfo(): Observable<InfoResponse>

}