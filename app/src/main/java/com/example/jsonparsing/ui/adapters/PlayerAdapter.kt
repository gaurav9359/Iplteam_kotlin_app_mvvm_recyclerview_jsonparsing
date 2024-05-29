package com.example.jsonparsing.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jsonparsing.databinding.IplTeamRecyclerviewBinding
import com.example.jsonparsing.databinding.PlayerRecyclerviewBinding
import com.example.jsonparsing.models.dataclasses.IplTeamModel
import com.example.jsonparsing.models.dataclasses.PlayerModel

class PlayerAdapter (var teamPlayerList: MutableList<PlayerModel>) :
        RecyclerView.Adapter<PlayerAdapter.TaskViewHolder>(){

        inner class TaskViewHolder(val binding: PlayerRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {

            fun bind(players: PlayerModel) {
                binding.player = players
                binding.executePendingBindings()
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = PlayerRecyclerviewBinding.inflate(inflater, parent, false)
            return TaskViewHolder(binding)
        }

        override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
            holder.bind(teamPlayerList[position])

        }

        override fun getItemCount(): Int {
            return teamPlayerList.size
        }


    }
