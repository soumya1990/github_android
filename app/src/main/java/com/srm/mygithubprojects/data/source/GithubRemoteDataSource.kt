package com.srm.mygithubprojects.data.source

import com.srm.mygithubprojects.data.library.retrofit.RetrofitClient.githubService
import com.srm.mygithubprojects.model.Project
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GithubRemoteDataSource(
   // private val githubService: GithubService,
    //private val ioDispatchers: CoroutineDispatcher
) {
    suspend fun fetchGithubProjects() : List<Project>? = withContext(Dispatchers.IO) {
        githubService.getProjects("soumya1990").execute().body()
    }

}
