package com.leading.navigationtest.jetpack

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.leading.navigationtest.R
import com.leading.navigationtest.jetpack.ui.start.StartFragment

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, StartFragment.newInstance())
                    .commitNow()
        }
    }

}
