package com.srm.mygithubprojects.view.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.srm.mygithubprojects.data.repository.GithubRepository
import com.srm.mygithubprojects.model.Project
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class ProjectViewModel(
    private val repo: GithubRepository
): ViewModel() {
    private var fetchJob: Job? = null
    private val projects: MutableLiveData<List<Project>> by lazy {
        MutableLiveData<List<Project>>().also {
            loadMyProject(it)
        }
    }

    fun getProjects(): LiveData<List<Project>> {
        return projects
    }

    private fun loadMyProject(mutableLiveData: MutableLiveData<List<Project>>) {
       // val projectList = mutableListOf<Project>()
        //mutableLiveData.value = projectList


        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
           mutableLiveData.value = repo.fetchGitHubProjects()
        }
        //populateDummyData(projectList)
    }
/*    private fun populateDummyData(projectList: MutableList<Project>) {

        val project1 = Project ("Title 1")
        project1.description = "This is a sample description f" +
                "or Title 1"
        val project2 = Project ("Title 2")
        project2.description = "This is a sample description f" +
                "or Title 2"
        val project3 = Project ("Title 3")
        project3.description = "This is a sample description f" +
                "or Title 3"
        var i = 0;

        while (i < 50) {
            i++
            val project = Project("Title $i")
            project.description = "Description of Title $i"
            projectList.add(project)
        }
    }*/
}