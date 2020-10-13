package com.example.soccerinfo.model

class InfoResponse : BaseResponse() {
    var results = ResourceModel()
}

class ResourceModel {
    var resources = arrayListOf<InfoModel>()

}

class InfoModel {
    var event = EventModel()
    var owner = OwnerModel()
    var caption = ""
    var video = ""
    var photo = ""
    var uploaded = ""

}

class OwnerModel {
    var fullname = ""
    var username = ""
    var primary_team = ""
    var avatar = ""
}

class EventModel {
    var title = ""
    var start_event = ""
    var end_event = ""


}
