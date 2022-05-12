package com.srm.mygithubprojects.model

import android.graphics.drawable.Drawable
import com.google.gson.annotations.SerializedName

data class Project(
    @SerializedName("html_url")
     var title: String,
    var description: String?
)
