package com.example.jsonparsing.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jsonparsing.databinding.IplTeamRecyclerviewBinding
import com.example.jsonparsing.models.dataclasses.IplTeamModel

public class TeamAdapter(var iplTeamList: MutableList<IplTeamModel>) :
    RecyclerView.Adapter<TeamAdapter.TaskViewHolder>(){

    inner class TaskViewHolder(val binding: IplTeamRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(team: IplTeamModel) {
            binding.iplteam = team
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = IplTeamRecyclerviewBinding.inflate(inflater, parent, false)
        return TaskViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.binding.apply {
            val iplTeams=iplTeamList[position]
            holder.bind(iplTeams)
            val subItemAdapter = PlayerAdapter(iplTeams.players)
            rv2.adapter = subItemAdapter
            rv2.layoutManager = LinearLayoutManager(root.context, LinearLayoutManager.HORIZONTAL, false)
        }
    }

    override fun getItemCount(): Int {
        return iplTeamList.size
    }
}