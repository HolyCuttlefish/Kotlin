package com.example.mytictaktoe

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var turn : Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun OnClick(view : View)
    {
        if(turn)
        {
            (view as Button).text = "X"
            (view as Button).isEnabled = false
            turn = !turn
        }
        else
        {
            (view as Button).text = "O"
            (view as Button).isEnabled = false
            turn = !turn
        }

        checkWin()

    }

    fun checkWin()
    {
        var intent : Intent

        if((ButFirst.text == "X") && (ButSecond.text == "X") && (ButThird.text == "X"))
        {
            intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("Name", "Победил X!")
            startActivity(intent)
        }
        else if((ButFour.text == "X") && (ButFive.text == "X") && (ButSix.text == "X"))
        {
            intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("Name", "Победил X!")
            startActivity(intent)
        }
        else if((ButSeven.text == "X") && (ButEight.text == "X") && (ButNine.text == "X"))
        {
            intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("Name", "Победил X!")
            startActivity(intent)
        }
        else if((ButFirst.text == "X") && (ButFour.text == "X") && (ButSeven.text == "X"))
        {
            intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("Name", "Победил X!")
            startActivity(intent)
        }
        else if((ButSecond.text == "X") && (ButFive.text == "X") && (ButEight.text == "X"))
        {
            intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("Name", "Победил X!")
            startActivity(intent)
        }
        else if((ButThird.text == "X") && (ButSix.text == "X") && (ButNine.text == "X"))
        {
            intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("Name", "Победил X!")
            startActivity(intent)
        }
        else if((ButFirst.text == "X") && (ButFive.text == "X") && (ButNine.text == "X"))
        {
            intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("Name", "Победил X!")
            startActivity(intent)
        }
        else if((ButThird.text == "X") && (ButFive.text == "X") && (ButSeven.text == "X"))
        {
            intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("Name", "Победил X!")
            startActivity(intent)
        }
        //Two
        else if((ButFirst.text == "O") && (ButSecond.text == "O") && (ButThird.text == "O"))
        {
            intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("Name", "Победил O!")
            startActivity(intent)
        }
        else if((ButFour.text == "O") && (ButFive.text == "O") && (ButSix.text == "O"))
        {
            intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("Name", "Победил O!")
            startActivity(intent)
        }
        else if((ButSeven.text == "O") && (ButEight.text == "O") && (ButNine.text == "O"))
        {
            intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("Name", "Победил O!")
            startActivity(intent)
        }
        else if((ButFirst.text == "O") && (ButFour.text == "O") && (ButSeven.text == "O"))
        {
            intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("Name", "Победил O!")
            startActivity(intent)
        }
        else if((ButSecond.text == "O") && (ButFive.text == "O") && (ButEight.text == "O"))
        {
            intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("Name", "Победил O!")
            startActivity(intent)
        }
        else if((ButThird.text == "O") && (ButSix.text == "O") && (ButNine.text == "O"))
        {
            intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("Name", "Победил O!")
            startActivity(intent)
        }
        else if((ButFirst.text == "O") && (ButFive.text == "O") && (ButNine.text == "O"))
        {
            intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("Name", "Победил O!")
            startActivity(intent)
        }
        else if((ButThird.text == "O") && (ButFive.text == "O") && (ButSeven.text == "O"))
        {
            intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("Name", "Победил O!")
            startActivity(intent)
        }
        //Three
        else if((!ButFirst.isEnabled) && (!ButSecond.isEnabled) && (!ButThird.isEnabled) && (!ButFour.isEnabled) && (!ButFive.isEnabled) && (!ButSix.isEnabled) && (!ButSeven.isEnabled) && (!ButEight.isEnabled) && (!ButNine.isEnabled))
        {
            intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("Name", "Нет победителя!")
            startActivity(intent)
        }
    }
}