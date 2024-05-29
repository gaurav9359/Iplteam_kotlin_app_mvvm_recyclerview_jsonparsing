package com.example.jsonparsing.models.dataclasses

import android.graphics.Color
import androidx.annotation.ColorInt

data class IplTeamModel(val id:Int, var teamname:String, var players:MutableList<PlayerModel>, var wins:Int, var losses:Int,var background:String){

    val winsString: String
        get() = wins.toString()

    val lossesString: String
        get() = losses.toString()

    @get:ColorInt
    val backgroundInt: Int // Computed property to get the color integer value
        get() = Color.parseColor(background)

}
