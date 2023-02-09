package dev.privyid.pena

import android.webkit.JavascriptInterface

typealias OnMessageHandler = (message: String) -> Unit

/**
 * Interface for bridging between Android and WebView
 */
class PenaAndroid(private val handler: OnMessageHandler) {
    @JavascriptInterface
    fun postMessage(message: String) {
        this.handler.invoke(message)
    }
}