package com.leading.navigationtest.bottomnavigation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.leading.navigationtest.R
import kotlinx.android.synthetic.main.activity_bottom_navigation.*

class BottomNavigationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)

        val navHostFragment: NavHostFragment = frag_bottom_nav_host as NavHostFragment
        NavigationUI.setupWithNavController(navigation, navHostFragment.navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return Navigation.findNavController(this,R.id.frag_bottom_nav_host).navigateUp()
    }
}
