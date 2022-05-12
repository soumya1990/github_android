package com.srm.mygithubprojects.data.library.retrofit

import com.srm.mygithubprojects.data.ProjectAPI
import com.srm.mygithubprojects.model.Project
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {

    @GET("users/{user}/repos")
    fun getProjects( @Path("user") user:String):Call<List<Project>>
}