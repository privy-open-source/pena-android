package dev.privyid.pena

import android.net.Uri

/**
 * Serialize boolean to string
 * @param value Value to convert
 */
fun b2s(value: Boolean): String {
    return if (value) "true" else "false"
}

/**
 * Signature placement
 * @param x X position
 * @param y Y position
 * @param page Page number
 * @param fixed Disabled signature to move, default: `false`
 */
data class Placement(
    val x: Number,
    val y: Number,
    val page: Number,
    val fixed: Boolean = false,
)

/**
 * Generate url from config
 * @param url Document URL
 * @param privyId Recipient PrivyID
 * @param lang Language set, valid value: `en` | `id`, default: `id`
 * @param visibility Signature visibility, default: `true`
 * @param debug Enable debug mode, default: `false`
 * @param signature Signature placement position
 */
fun createURL(
    url: String,
    privyId: String? = null,
    visibility: Boolean? = null,
    debug: Boolean? = null,
    lang: String? = null,
    signature: Placement? = null,
    needScrollTo: Any? = null
): String {
    val uri = Uri.parse(url).buildUpon()

    if (lang != null)
        uri.appendQueryParameter("lang", lang)

    if (debug != null)
        uri.appendQueryParameter("debug", b2s(debug))

    if (visibility != null)
        uri.appendQueryParameter("visibility", b2s(visibility))

    if (privyId != null)
        uri.appendQueryParameter("privyId", privyId)

    if (signature != null) {
        uri.appendQueryParameter("x", signature.x.toString())
        uri.appendQueryParameter("y", signature.y.toString())
        uri.appendQueryParameter("page", signature.page.toString())
        uri.appendQueryParameter("fixed", b2s(signature.fixed))
    }

    if (needScrollTo != null) {
        uri.appendQueryParameter("need_scrollto", needScrollTo.toString())
    }

    return uri.build().toString()
}

fun extractDomain(url: Uri): String? {
    val host = url.host
    val pattern = Regex("""(?:.*\.)?([^.]+\.[^.]+)$""")

    return host?.let { pattern.find(it)?.groupValues?.get(1) }
}

fun isSameDomain(a: Uri, b: Uri): Boolean {
    val domainA = extractDomain(a)
    val domainB = extractDomain(b)

    return domainA != null && domainB != null && domainA == domainB
}