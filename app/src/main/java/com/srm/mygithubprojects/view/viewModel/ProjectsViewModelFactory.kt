package com.srm.mygithubprojects.view.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.srm.mygithubprojects.data.library.retrofit.GithubService
import com.srm.mygithubprojects.data.repository.GithubRepository
import com.srm.mygithubprojects.data.source.GithubRemoteDataSource

class ProjectsViewModelFactory: ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val remoteDS = GithubRemoteDataSource()
        val repository = GithubRepository(remoteDS)
        return  ProjectViewModel(repository) as T
    }
}