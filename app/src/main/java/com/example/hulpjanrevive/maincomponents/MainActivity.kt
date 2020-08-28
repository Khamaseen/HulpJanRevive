package com.example.hulpjanrevive.maincomponents

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.hulpjanrevive.R
import com.example.hulpjanrevive.ui.HomeFragmentDirections
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.main_drawer_layout.*

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_drawer_layout)
        setSupportActionBar(findViewById<Toolbar>(R.id.toolbar))

        val drawerLayout = findViewById<DrawerLayout>(R.id.layout_drawer_main)
        val navController = findNavController(R.id.host_fragment)
        appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout) //TODO add menu items for each destination

        setupActionBarWithNavController(navController, appBarConfiguration)

        findViewById<NavigationView>(R.id.navigation_view).setupWithNavController(navController)
        navigation_view.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.personFragment -> {
                    val action =
                        HomeFragmentDirections.actionMainFragmentToPersonFragment(
                            0
                        )
                    findNavController(R.id.host_fragment).navigate(action)
                    closeDrawer()
                }
            }

            true
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.host_fragment)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    private fun closeDrawer() {
        layout_drawer_main.closeDrawer(GravityCompat.START)
    }


    //
//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        menuInflater.inflate(R.menu.navigation_view, menu)
//        return true
//    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
//            R.id.nav_item_one -> TODO()
//            R.id.nav_item_two -> TODO()
//            R.id.nav_item_three -> TODO()
        }
        return super.onOptionsItemSelected(item)
    }

    fun processDatePickerResult(year: Int, month: Int, day: Int) {
        val month_string = Integer.toString(month + 1)
        val day_string = Integer.toString(day)
        val year_string = Integer.toString(year)
        val dateMessage = month_string +
                "/" + day_string + "/" + year_string
        Toast.makeText(
            this, "Date: " + dateMessage,
            Toast.LENGTH_SHORT
        ).show();
    }

    override fun onBackPressed() {
        if (layout_drawer_main.isOpen) {
            layout_drawer_main.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}