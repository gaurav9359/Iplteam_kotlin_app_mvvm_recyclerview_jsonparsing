package com.example.jsonparsing.models.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.jsonparsing.models.dataclasses.IplTeamModel

class IplTeamRepo {

        private var _teamList = MutableLiveData<MutableList<IplTeamModel>>(mutableListOf())
        private val teamList: LiveData<MutableList<IplTeamModel>> = _teamList

        fun getTeamList(): LiveData<MutableList<IplTeamModel>> {
            return this.teamList
        }

        fun setTeamList(newTeamList: MutableList<IplTeamModel>) {
            this._teamList.value = newTeamList
        }


}