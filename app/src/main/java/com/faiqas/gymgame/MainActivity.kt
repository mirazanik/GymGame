package com.faiqas.gymgame


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //setSupportActionBar(toolbar)
//https://sites.google.com/site/mirazanik/project/gym-game-ai
        fab.setOnClickListener { view ->
            /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()*/

            val url = "https://sites.google.com/site/mirazanik/project/gym-game-ai"
            val uri: Uri = Uri.parse(url)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            // Verify that the intent will resolve to an activity
            // Verify that the intent will resolve to an activity
            if (intent.resolveActivity(packageManager) != null) {
                // Here we use an intent without a Chooser unlike the next example
                startActivity(intent)
            }

        }

        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
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

    private var back_pressed: Long = 0

    override fun onBackPressed() {
        // your code.
        if (back_pressed + 2000 > System.currentTimeMillis()){
            super.onBackPressed();

            finish();
        }
        else{
            Toast.makeText(getBaseContext(), "Press once again to exit",
                Toast.LENGTH_SHORT).show();
            back_pressed = System.currentTimeMillis();
        }

    }
}
