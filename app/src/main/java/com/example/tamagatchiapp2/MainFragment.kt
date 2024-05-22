package com.example.tamagatchiapp2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainFragment : Fragment() {
    private lateinit var statusBar: TextView
    private var hunger = 50
    private var happiness = 50
    private var cleanliness = 50

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        statusBar = view.findViewById(R.id.status_bar)
        updateStatus()

        val navHostFragment = childFragmentManager.findFragmentById(R.id.sub_fragment_container) as NavHostFragment
        val navController = navHostFragment.navController
        val bottomNavigationView: BottomNavigationView = view.findViewById(R.id.bottom_navigation)
        NavigationUI.setupWithNavController(bottomNavigationView, navController)

        return view
    }

    private fun updateStatus() {
        statusBar.text = "Duck Status: Hunger $hunger, Happiness $happiness, Cleanliness $cleanliness"
    }

    fun feedDuck() {
        hunger = (hunger + 10).coerceAtMost(100)
        updateStatus()
    }

    fun playWithDuck() {
        happiness = (happiness + 10).coerceAtMost(100)
        updateStatus()
    }

    fun cleanDuck() {
        cleanliness = (cleanliness + 10).coerceAtMost(100)
        updateStatus()
    }
}