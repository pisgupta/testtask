package com.csquare.codingtask.model

data class UserListModel(
    var page: Int,
    var per_page: Int,
    var total: Int,
    var total_pages: Int,
    var data: ArrayList<DataModel>?
) {

}