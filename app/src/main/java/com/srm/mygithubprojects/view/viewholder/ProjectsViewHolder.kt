package com.srm.mygithubprojects.view.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.srm.mygithubprojects.R

class ProjectsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val heading: TextView = itemView.findViewById(R.id.heading)
    val description: TextView = itemView.findViewById(R.id.description)
    val avatar: ImageView = itemView.findViewById(R.id.imageView)
}