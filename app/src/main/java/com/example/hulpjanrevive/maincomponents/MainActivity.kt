package com.example.hulpjanrevive.maincomponents

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.hulpjanrevive.R
import com.example.hulpjanrevive.ui.HomeFragmentDirections
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.main_drawer_layout.*

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var listener: NavController.OnDestinationChangedListener

    private var shouldSeeOnboarding: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_drawer_layout)
        setSupportActionBar(findViewById<Toolbar>(R.id.toolbar))
        supportActionBar?.hide()
        drawerLayout = findViewById<DrawerLayout>(R.id.layout_drawer_main)
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        navController = findNavController(R.id.host_fragment)

        if (shouldSeeOnboarding) {
            setUpOnboarding()
        } else {
            setUpHome()
        }

        listener = createDestinationChangeListener()
    }

    private fun setUpOnboarding() {
        navController.graph.startDestination = R.id.onboardingFragment
    }

    private fun setUpHome() {
        navController.graph.startDestination = R.id.homeFragment
        appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout) //TODO add menu items for each destination
    }

    fun setBar() {
        setupActionBarWithNavController(navController, appBarConfiguration)
        setUpActionBarNavigation()
    }

    private fun setUpActionBarNavigation() {
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

    private fun openDrawerAndSuch() {
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
        closeDrawer()
        this.supportActionBar?.show()
    }

    private fun closeDrawerAndSuch() {
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        this.supportActionBar?.hide()
    }

    private fun createDestinationChangeListener(): NavController.OnDestinationChangedListener {
        return NavController.OnDestinationChangedListener { controller, destination, arguments ->
            if (destination.label == "fragment_onboarding") {
                Toast.makeText(baseContext, "Onboarding Fragment", Toast.LENGTH_SHORT).show()
                closeDrawerAndSuch()
            } else {
                Toast.makeText(baseContext, destination.label, Toast.LENGTH_SHORT).show()
                openDrawerAndSuch()
                setUpHome()
            }
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
            closeDrawer()
        } else {
            super.onBackPressed()
        }
    }

    override fun onResume() {
        super.onResume()
        navController.addOnDestinationChangedListener(listener)
    }

    override fun onPause() {
        navController.removeOnDestinationChangedListener(listener)
        super.onPause()
    }
}