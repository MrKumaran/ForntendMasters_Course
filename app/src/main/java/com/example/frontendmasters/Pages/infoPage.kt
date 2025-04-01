package com.example.frontendmasters.Pages

import android.text.Editable.Factory
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun MyWebView() {
    var url = "https://kumaran-profiles.vercel.app/index.html"
    AndroidView(
        factory = {
            WebView(it)
                .apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
                webViewClient = WebViewClient()
                loadUrl(url)
            }

        },
        update = {
            it.loadUrl(url)
        }
    )
}

@Composable
fun InfoPage(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
    ){
        MyWebView()
    }
}