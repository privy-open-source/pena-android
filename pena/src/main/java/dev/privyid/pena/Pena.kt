package dev.privyid.pena

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.webkit.WebView
import org.json.JSONObject

typealias HookFn = (message: Payload) -> Unit

@SuppressLint("SetJavaScriptEnabled")
class Pena : WebView {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    private var hook: HookFn? = null
    private val bridge: PenaAndroid = PenaAndroid(this::onMessage)

    fun openDoc(doc: PenaDocument) {
        this.openDoc(
            url = doc.url,
            privyId = doc.privyId,
            visibility = doc.visibility,
            debug = doc.debug,
            lang = doc.lang,
            signature = doc.signature,
            needScrollTo = doc.needScrollTo,
            onAfterAction = doc.onAfterAction,
        )
    }

    /**
     * Create signing document
     * @param url Document URL
     * @param privyId Recipient PrivyID
     * @param lang Language set, valid value: `en` | `id`, default: `id`
     * @param visibility Signature visibility, default: `true`
     * @param debug Enable debug mode, default: `false`
     * @param signature Signature placement position
     * @param onAfterAction After action (sign, review, etc) hook
     */
    fun openDoc(
        url: String,
        privyId: String? = null,
        visibility: Boolean? = null,
        debug: Boolean? = false,
        lang: String? = null,
        signature: Placement? = null,
        needScrollTo: Any? = null,
        onAfterAction: HookFn? = null,
    ) {
        if (onAfterAction != null)
            this.hook = onAfterAction

        this.settings.domStorageEnabled = true
        this.settings.javaScriptEnabled = true
        this.webViewClient = PenaWebClient()
        this.addJavascriptInterface(this.bridge, "PenaAndroid")

        this.loadUrl(
            createURL(
                url = url,
                lang = lang,
                privyId = privyId,
                signature = signature,
                visibility = visibility,
                needScrollTo = needScrollTo,
                debug = debug,
            )
        )
    }

    private fun onMessage(message: String) {
        val json = JSONObject(message)
        val payload = Payload(
            action = json.getString("action"),
            data = json.getJSONObject("data"),
        )

        this.hook?.invoke(payload)
    }
}