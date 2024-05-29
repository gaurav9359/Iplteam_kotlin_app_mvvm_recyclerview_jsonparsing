package com.example.jsonparsing.ui.viewmodels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.jsonparsing.models.dataclasses.IplTeamModel
import com.example.jsonparsing.models.dataclasses.PlayerModel
import com.example.jsonparsing.models.repositories.IplTeamRepo
import org.json.JSONArray

class TeamViewModel : ViewModel() {
    var iplTeamRepo= IplTeamRepo()
    var iplTeams:LiveData<MutableList<IplTeamModel>> = iplTeamRepo.getTeamList()
    public lateinit var teamList:MutableList<IplTeamModel>

    fun parseJsonFromAssets(context: Context):MutableList<IplTeamModel> {
        val jsonString = readJsonFromAssets(context,"IplData.json")
        teamList = getDummyteams(jsonString)
        iplTeamRepo.setTeamList(teamList)
        return teamList
    }

    fun readJsonFromAssets(context: Context, fileName: String): String {
        return context.assets.open(fileName).bufferedReader().use { it.readText() }
    }





    public fun getDummyteams(jsonString:String):MutableList<IplTeamModel>{

        var jsonArray=JSONArray(jsonString)
        teamList= mutableListOf();

        for (i in 0 until jsonArray.length()) {
            val teamObject = jsonArray.getJSONObject(i)

            val id = teamObject.getInt("id")
            val teamname = teamObject.getString("teamname")
            val wins = teamObject.getInt("wins")
            val losses = teamObject.getInt("losses")
            val background= teamObject.getString("background")

            val playersArray = teamObject.getJSONArray("players")
            val playersList = mutableListOf<PlayerModel>()

            for (j in 0 until playersArray.length()) {
                val playerObject = playersArray.getJSONObject(j)
                val playerName = playerObject.getString("name")
                val speciality = playerObject.getString("speciality")
                val runs = playerObject.getInt("runs")
                val wickets = playerObject.getInt("wickets")


                val player = PlayerModel(playerName, speciality, runs, wickets)
                playersList.add(player)
            }

            val team = IplTeamModel(id, teamname, playersList, wins, losses,background)
            teamList.add(team)
        }


        return teamList

    }
}