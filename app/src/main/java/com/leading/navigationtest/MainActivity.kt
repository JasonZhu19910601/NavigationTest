package com.leading.navigationtest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        val navHostFragment: NavHostFragment = supportFragmentManager.findFragmentById(R.id.my_nav_host_fragment) as NavHostFragment
        NavigationUI.setupActionBarWithNavController(this, navHostFragment.navController)
        // 动态加载 NavGraph
        val navGraph = navHostFragment.navController.navInflater.inflate(R.navigation.navi)
        val firstFragNavDestination = navGraph.findNode(R.id.nav_first_frag)
        val firstFragmentArgs = FirstFragmentArgs.Builder("data for first frag").build()
        firstFragNavDestination?.setDefaultArguments(firstFragmentArgs.toBundle())
        navHostFragment.navController.graph = navGraph
    }

    override fun onSupportNavigateUp(): Boolean {
        return Navigation.findNavController(this, R.id.my_nav_host_fragment).navigateUp()
    }
}
