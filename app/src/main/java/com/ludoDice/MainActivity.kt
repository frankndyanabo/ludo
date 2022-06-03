package com.ludoDice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.ludo.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //finding button in layout
        val rollbutton:Button=findViewById(R.id.button)
        //set a click listener to a button
        rollbutton.setOnClickListener { rolldice() }
        //do a dice roll when app starts
        rolldice()}
        //roll dice and update the screen with result
        private fun rolldice(){
            //new dice with 6sides
            val dice=Dice(6)
            val diceroll=dice.roll()
            //find image view in the layout
            val diceimage:ImageView=findViewById(R.id.imageViewdice1)
            //determine which drawable side to use
            val drawableresource=when(diceroll){
                1->R.drawable.dice_1
                2->R.drawable.dice_2
                3->R.drawable.dice_3
                4->R.drawable.dice_4
                5->R.drawable.dice_5
                else->R.drawable.dice_6

            }
            //update the imageview thye correct drawable resource
            diceimage.setImageResource(drawableresource)

            //update the content description
            diceimage.contentDescription=diceroll.toString()
        }
    //dice with afixed number of dides
    class Dice(private val numsides:Int){
        fun roll():Int{

            return (1..numsides).random()
        }

    }
}