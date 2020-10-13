package com.example.soccerinfo.model

open class LoginResponse : BaseResponse() {
    var action = ""
    var message = ""
    var dataArray = arrayListOf<UserModel>()
    var userid = 0
    var reason = ""
}

class UserModel {
    var userid = 0
    var email = ""
    var contact = ""
    var firstname = ""
    var surname = ""
    var companyname = ""

}
