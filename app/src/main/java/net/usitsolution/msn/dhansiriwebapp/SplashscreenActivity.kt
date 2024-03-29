package net.usitsolution.msn.dhansiriwebapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashscreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        // override the "Thread Object"
        val background = object: Thread() {
            override fun run() {
                try {
                    // add sleep for 5 sec
                    Thread.sleep(3000)

                    // add destination activity
                    val intent = Intent(baseContext, MainActivity::class.java)
                    startActivity(intent)
                } catch(e: Exception) {
                    e.printStackTrace()
                }
            }
        }

        // call the object
        background.start()
    }
}
