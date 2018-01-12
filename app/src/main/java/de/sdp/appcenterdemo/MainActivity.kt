package de.sdp.appcenterdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    val logic = BusinessLogic()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        AppCenter.start(application, "21a01265-a855-4075-a33f-2cb8152c4133", Analytics::class.java, Crashes::class.java)

        fab.setOnClickListener {
            val text : String = if (logic.complicatedFunction() == 42) "Yes that's the thing." else "Oh Nooooees!"
            label.text = text
            Analytics.trackEvent("Fab tapped!")
        }

        label.setOnClickListener {
            Analytics.trackEvent("Label tapped!")
        }

        label.setOnLongClickListener {
            Crashes.generateTestCrash()
            true
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
