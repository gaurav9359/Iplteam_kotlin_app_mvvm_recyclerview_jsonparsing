package com.example.jsonparsing.models.dataclasses

data class PlayerModel(var name:String, var speciality:String, var runs:Int, var wickets:Int){
    val runsString: String
        get() = runs.toString()

    val wicketsString: String
        get() = wickets.toString()
}
