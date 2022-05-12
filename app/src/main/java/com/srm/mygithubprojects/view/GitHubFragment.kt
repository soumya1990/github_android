package com.srm.mygithubprojects.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.srm.mygithubprojects.data.repository.GithubRepository
import com.srm.mygithubprojects.databinding.FragmentGithubBinding
import com.srm.mygithubprojects.model.Project
import com.srm.mygithubprojects.view.adapter.ProjectsAdapter
import com.srm.mygithubprojects.view.viewModel.ProjectViewModel
import com.srm.mygithubprojects.view.viewModel.ProjectsViewModelFactory

// TODO: Rename parameter arguments, choose names that match

class GitHubFragment : Fragment() {

    private var _binding: FragmentGithubBinding? = null

    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!

    private val projectViewModel by viewModels<ProjectViewModel> {
        ProjectsViewModelFactory()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGithubBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val linearLayoutManager = LinearLayoutManager(this.context)
        val projectAdapter = ProjectsAdapter()
        binding.projects.hasFixedSize()
        binding.projects.layoutManager = linearLayoutManager
        subscribeToProjectList(adapter = projectAdapter)
        binding.projects.adapter = projectAdapter
    }

    private fun subscribeToProjectList(adapter: ProjectsAdapter) {
        projectViewModel.getProjects().observe(this, { projects ->
            adapter.submitList(projects as MutableList<Project>)
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
