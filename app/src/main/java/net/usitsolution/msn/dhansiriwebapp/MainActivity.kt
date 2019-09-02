package net.usitsolution.msn.dhansiriwebapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.net.NetworkInfo
import android.content.Context.CONNECTIVITY_SERVICE
import android.content.Intent
import androidx.core.content.ContextCompat.getSystemService
import android.net.ConnectivityManager
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import android.icu.lang.UCharacter.GraphemeClusterBreak.T

class MainActivity : AppCompatActivity() {

    // init the webview
    var myWebView: WebView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // declare the webview element
        myWebView = findViewById(R.id.webview)

        // check network connection
        if(isNetworkAvailable()) {
            // add view and set url
            myWebView!!.webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                    view?.loadUrl(url)
                    return true
                }
            }

            // add settings
            myWebView!!.loadUrl("http://dhansiri.halaldish24.com/")
            myWebView!!.settings.javaScriptEnabled = true
        } else {
            var intent = Intent(this, ConnectionActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onBackPressed() {
        if (myWebView != null) {
            if (myWebView!!.canGoBack()) {
                myWebView!!.goBack()
            } else {
                super.onBackPressed()
            }
        } else {
            super.onBackPressed()
        }
    }

    private fun isNetworkAvailable(): Boolean {
        // Get Connectivity Manager class object from Systems Service
        val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        // Get Network Info from connectivity Manager
        val networkInfo = cm.activeNetworkInfo

        // if no network is available networkInfo will be null
        // otherwise check if we are connected
        return (networkInfo != null && networkInfo.isConnected)
    }


}
