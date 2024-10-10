package com.example.gravitocmpwebviewandroid
import android.content.Context
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity


class Home : AppCompatActivity() {


    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        webView = findViewById(R.id.webview)
        webView.webViewClient = WebViewClient() // Ensures links open within the WebView
        val webSettings: WebSettings = webView.settings
        webSettings.javaScriptEnabled = true // Enable JavaScript if needed
        webView.addJavascriptInterface(WebAppInterface(this), "Android")

        webView.loadUrl("https://gravitocdn.blob.core.windows.net/gravitocmpwebview/index.html?platform=android") // Replace with your URL
    }



    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}