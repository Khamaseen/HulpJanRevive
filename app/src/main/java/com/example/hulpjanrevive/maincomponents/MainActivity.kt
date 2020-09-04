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
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.hulpjanrevive.R
import com.example.hulpjanrevive.ui.HomeFragmentDirections
import com.google.android.material.navigation.NavigationView
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

    //TODO add menu items for each destination
    private fun setUpHome() {
        shouldSeeOnboarding = false
        navController.graph.startDestination = R.id.homeFragment
        appBarConfiguration = AppBarConfiguration(
            navController.graph,
            drawerLayout
        )
    }

    fun setBar() {
        setupActionBarWithNavController(navController, appBarConfiguration)
        setUpActionBarNavigation()
        this.supportActionBar?.show()
    }

    private fun setUpActionBarNavigation() {
        findViewById<NavigationView>(R.id.navigation_view).setupWithNavController(navController)
        navigation_view.setNavigationItemSelectedListener { item ->
            closeDrawer()
            navigateTo(item)
            true
        }
    }

    private fun navigateTo(item: MenuItem) {
        when (item.itemId) {
            R.id.personFragment -> {
                val action =
                    HomeFragmentDirections.actionMainFragmentToPersonFragment(
                        0
                    )
                findNavController(R.id.host_fragment).navigate(action)
            }
        }
    }

    private fun closeDrawer() {
        layout_drawer_main.closeDrawer(GravityCompat.START)
    }

    private fun unlockDrawer() {
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
    }

    private fun lockDrawerHideActionBar() {
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        supportActionBar?.hide()
    }

    private fun createDestinationChangeListener(): NavController.OnDestinationChangedListener {
        return NavController.OnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.onboardingFragment) {
                lockDrawerHideActionBar()
            } else {
                unlockDrawer()
                setUpHome()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.host_fragment)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
//            R.id.nav_item_one -> TODO
        }
        return super.onOptionsItemSelected(item)
    }

    fun processDatePickerResult(year: Int, month: Int, day: Int) {
        val monthString = (month + 1).toString()
        val dayString = day.toString()
        val yearString = year.toString()
        val dateMessage = monthString +
                "/" + dayString + "/" + yearString
        Toast.makeText(
            this, "Date: $dateMessage",
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