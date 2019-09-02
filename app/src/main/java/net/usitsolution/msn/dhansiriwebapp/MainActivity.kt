package net.usitsolution.msn.dhansiriwebapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {

    // init the webview
    var myWebView: WebView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // declare the webview element
        myWebView = findViewById(R.id.webview)

        // add view and set url
        myWebView!!.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }
        }

        // add settings
        myWebView!!.loadUrl("https://www.prothomalo.com/")
        myWebView!!.settings.javaScriptEnabled = true
    }

    override fun onBackPressed() {
        if (myWebView != null) {
            if (myWebView!!.canGoBack()) {
                myWebView!!.goBack()
            } else {
                super.onBackPressed()
            }
        }
    }
}
