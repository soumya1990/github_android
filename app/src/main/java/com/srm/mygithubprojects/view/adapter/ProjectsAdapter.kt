package com.srm.mygithubprojects.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.srm.mygithubprojects.R
import com.srm.mygithubprojects.model.Project
import com.srm.mygithubprojects.view.viewholder.ProjectsViewHolder

class ProjectsAdapter() : ListAdapter<Project,ProjectsViewHolder>(ProjectsDiffCallBack){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectsViewHolder {
        val view = LayoutInflater.from(parent.context). inflate(R.layout.project_row_item, parent, false)
        return ProjectsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProjectsViewHolder, position: Int) {
        val projectData = getItem(position)
        holder.heading.text = projectData.title
        holder.description.text = projectData.description
        //holder.avatar.background = projectData.image
    }

    object ProjectsDiffCallBack: DiffUtil.ItemCallback<Project>() {
        override fun areItemsTheSame(oldItem: Project, newItem: Project): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Project, newItem: Project): Boolean {
            return oldItem.title == newItem.title
        }

    }
}