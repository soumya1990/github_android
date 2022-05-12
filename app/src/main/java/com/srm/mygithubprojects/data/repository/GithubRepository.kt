package com.srm.mygithubprojects.data.repository

import com.srm.mygithubprojects.data.source.GithubRemoteDataSource
import com.srm.mygithubprojects.model.Project

class GithubRepository(
    private val remoteDataSource: GithubRemoteDataSource
)
{
    suspend fun fetchGitHubProjects() : List<Project>? {
        return remoteDataSource.fetchGithubProjects()
    }
}