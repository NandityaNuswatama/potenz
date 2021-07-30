package com.nandits.potenz

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.nandits.potenz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityMainBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        val navView: BottomNavigationView = binding.navView
        
        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        navView.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.navigation_consult -> navView.isVisible = true
                R.id.navigation_home -> navView.isVisible = true
                R.id.navigation_course -> navView.isVisible = true
                R.id.navigation_insight -> navView.isVisible = true
                R.id.navigation_profile -> navView.isVisible = true
                else -> navView.isGone = true
            }
        }
    }
}