package com.example.mynavigationdrawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.navigation.Navigation
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nav.setNavigationItemSelectedListener(this)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.emptyFragmentTwo -> {
                if (Navigation.findNavController(this, R.id.Frag).currentDestination?.label != "fragment_empty_two") {

                    Navigation.findNavController(this, R.id.Frag).navigate(R.id.action_emptyFragmentOne_to_emptyFragmentTwo)
                }
                return true
            }

            R.id.emptyFragmentOne -> {
                if (Navigation.findNavController(this, R.id.Frag).currentDestination?.label != "fragment_empty_one") {
                    Navigation.findNavController(this, R.id.Frag).navigate(R.id.action_emptyFragmentTwo_to_emptyFragmentOne)
                }
                return true
            }

            else -> {
                return super.onOptionsItemSelected(item)
            }

        }
    }
}