package com.example.hulpjanrevive

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_drawer_layout)
        setSupportActionBar(findViewById<Toolbar>(R.id.toolbar))

        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer)
        val navController = findNavController(R.id.host_fragment)
        appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout) //TODO add menu items for each destination

        setupActionBarWithNavController(navController, appBarConfiguration)
        findViewById<NavigationView>(R.id.navigation_view).setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.host_fragment)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
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
}