package team.sesh.teamsesh

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.iid.FirebaseInstanceId
import java.util.*


class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

//    private lateinit var viewPagerAdapter: ViewPagerAdapter
//
//    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
//        when (item.itemId) {
//            R.id.navigation_home -> {
//                viewPagerAdapter.currentItem = 0
//                return@OnNavigationItemSelectedListener true
//            }
//            R.id.navigation_tab_2 -> {
//                main_view_pager.currentItem = 1
//                return@OnNavigationItemSelectedListener true
//            }
//        }
//        false
//    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.performClick()
        navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        //   val appBarConfiguration = AppBarConfiguration(
        val toolbar = findViewById<Toolbar>(R.id.toolbar_main)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(true)

        //setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Create channel to show notifications.
            val channelId = getString(R.string.default_notification_channel_id)
            val channelName = getString(R.string.default_notification_channel_name)
            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager?.createNotificationChannel(
                NotificationChannel(channelId,
                channelName, NotificationManager.IMPORTANCE_LOW)
            )
        }

        //fun noInternetConnection(view: View) {
        //    Toast.makeText(this,"No Internet connection", Toast.LENGTH_LONG).show()
     //   }

        FirebaseInstanceId.getInstance().instanceId
               .addOnCompleteListener(OnCompleteListener { task ->
                   if (!task.isSuccessful) {
                       Log.w(TAG, "getInstanceId failed", task.exception)
                       return@OnCompleteListener
                   }

                   // Get new Instance ID token
                   val token = task.result?.token

                   // Log and toast
                   val msg = getString(R.string.msg_token_fmt, token)
                   Log.d(TAG, msg)
                   Toast.makeText(baseContext, msg, Toast.LENGTH_SHORT)
               })

       /* FirebaseMessaging.getInstance().subscribeToTopic("SESH")
            .addOnCompleteListener { task ->
                var msg = getString(R.string.msg_subscribed)
                if (!task.isSuccessful) {
                    msg = getString(R.string.msg_subscribe_failed)
                }
                Log.d(TAG, msg)
              //  Toast.makeText(baseContext, msg, Toast.LENGTH_SHORT).show()
            }*/


    }



    fun openBrowser (view: View) {//Get url from tag
        val link = view.tag as String

        this.startActivity(
            Intent().apply {
                action = Intent.ACTION_VIEW
                data = Uri.parse(link)
            }
        )


    }
    private val cache = Hashtable<String, Typeface>()
    fun get(c: Context, name:String): Typeface? {
        synchronized (cache) {
            if (!cache.containsKey(name))
            {
                val path = "fonts/" + name
                try
                {
                    val t = Typeface.createFromAsset(c.getAssets(), path)
                    cache.put(name, t)
                }
                catch (e:Exception) {
                    e.printStackTrace()
                }
            }
            return cache.get(name)
        }
    }
    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount < 2)
            super.onBackPressed()
        else
            navController.popBackStack()
    }
    companion object {
        private const val TAG = "MainActivity"
    }
}
