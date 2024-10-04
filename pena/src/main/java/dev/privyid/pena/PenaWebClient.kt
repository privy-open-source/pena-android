package dev.privyid.pena

import android.net.Uri
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient

class PenaWebClient(url: String) : WebViewClient() {
    private var url: Uri = Uri.parse(url)

    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        if (request != null) {
            if (isSameDomain(this.url, request.url))
                return false
        }

        return true
    }
}