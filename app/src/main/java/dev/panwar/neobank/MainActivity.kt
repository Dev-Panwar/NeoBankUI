package dev.panwar.neobank

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.panwar.neobank.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var drawerLayout:DrawerLayout
    private lateinit var navView:NavigationView
    private lateinit var toolBarMain:Toolbar
    private lateinit var recentTransactionList:ArrayList<recent>
    private lateinit var recTranRecyclerView: RecyclerView
    private lateinit var recTransactionAdapter:RecentTransactionAdapter

    private lateinit var pendingTransactionList:ArrayList<pending>
    private lateinit var penTranRecyclerView: RecyclerView
    private lateinit var penTransactionAdapter:PendingTransactionAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toolBarMain=binding.appBarMain.toolbar
        drawerLayout = binding.drawerLayout
        navView= binding.navView
        navView.setNavigationItemSelectedListener(this)
        setupActionBar()

        addDataToRecentList()
        addDataToPendingList()
        val layoutManager= LinearLayoutManager(this)
        recTranRecyclerView = findViewById(R.id.rv_recent)
        recTranRecyclerView.layoutManager=layoutManager
        recTranRecyclerView.setHasFixedSize(true)
        recTransactionAdapter= RecentTransactionAdapter(recentTransactionList)
        recTranRecyclerView.adapter=recTransactionAdapter

        val penLayoutManager = LinearLayoutManager(this)
        penTranRecyclerView = findViewById(R.id.rv_pending)
        penTranRecyclerView.layoutManager=penLayoutManager
        penTranRecyclerView.setHasFixedSize(true)
        penTransactionAdapter= PendingTransactionAdapter(pendingTransactionList)
        penTranRecyclerView.adapter=penTransactionAdapter


    }

    private fun setupActionBar(){
        setSupportActionBar(toolBarMain)
        toolBarMain.setNavigationIcon(R.drawable.baseline_dehaze_24)
        toolBarMain.setNavigationOnClickListener {
    //            whenever we click on Navigation burger icon on toolbar
            toggleDrawer()
        }
    }

    private fun toggleDrawer() {
//        if drawer open then we close drawer else we open the drawer
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        }
        else{
            drawerLayout.openDrawer(GravityCompat.START)
        }
    }

//    inflating menu items to toolBar
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.toolbar_main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.notification -> {

            }
            R.id.help -> {

            }

        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.ProfileSettings -> {

            }
            R.id.tapToPay -> {

            }
            R.id.link_CC->{

            }
            R.id.UPI_andPayment->{

            }
            R.id.getLoan->{

            }
            R.id.getLoan->{

            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }


    private fun addDataToRecentList() {
        recentTransactionList = arrayListOf<recent>()
        recentTransactionList.add(recent(name = "Dev Panwar", profile_pic = R.drawable.profile_image ))
        recentTransactionList.add(recent(name = "Rahul Barve", profile_pic = R.drawable.profile_image ))
        recentTransactionList.add(recent(name = "Atharv Vibhute", profile_pic = R.drawable.profile_image ))
        recentTransactionList.add(recent(name = "Harsh Rai", profile_pic = R.drawable.profile_image ))
        recentTransactionList.add(recent(name = "Sarthak Patel", profile_pic = R.drawable.profile_image ))
        recentTransactionList.add(recent(name = "Dhananjay Sarathe", profile_pic = R.drawable.profile_image ))
        recentTransactionList.add(recent(name = "Akshat Agrawal", profile_pic = R.drawable.profile_image ))

    }

    private fun addDataToPendingList(){
        pendingTransactionList = arrayListOf<pending>()
        pendingTransactionList.add(pending(name = "Dev Panwar", profile_pic = R.drawable.profile_image ))
        pendingTransactionList.add(pending(name = "Rahul Barve", profile_pic = R.drawable.profile_image ))
        pendingTransactionList.add(pending(name = "Atharv Vibhute", profile_pic = R.drawable.profile_image ))
        pendingTransactionList.add(pending(name = "Harsh Rai", profile_pic = R.drawable.profile_image ))
        pendingTransactionList.add(pending(name = "Sarthak Patel", profile_pic = R.drawable.profile_image ))
        pendingTransactionList.add(pending(name = "Dhananjay Sarathe", profile_pic = R.drawable.profile_image ))
        pendingTransactionList.add(pending(name = "Akshat Agrawal", profile_pic = R.drawable.profile_image ))

    }





}