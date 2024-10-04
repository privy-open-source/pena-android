package dev.privyid.pena

import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient

class PenaWebClient() : WebViewClient() {
    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        return request == null || (request.url.scheme != "http" && request.url.scheme != "https")
    }
}