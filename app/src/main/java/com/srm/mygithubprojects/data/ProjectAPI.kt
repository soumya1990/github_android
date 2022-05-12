package com.srm.mygithubprojects.data

import com.google.gson.annotations.SerializedName

data class ProjectAPI(
    @SerializedName("html_url")
    var html_url:String,
    var description: String
)
