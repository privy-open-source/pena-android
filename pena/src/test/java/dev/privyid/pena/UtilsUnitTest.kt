package dev.privyid.pena

import android.net.Uri
import org.junit.Test
import org.junit.Assert.*
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class UtilsUnitTest {
    @Test
    fun createURL_basic() {
        val result = createURL(url = "http://coba.com")

        assertEquals(result, "http://coba.com")
    }

    @Test
    fun createURL_lang() {
        val result = createURL(url = "http://coba.com", lang = "id")

        assertEquals(result, "http://coba.com?lang=id")
    }

    @Test
    fun createURL_debug() {
        val result = createURL(url = "http://coba.com", debug = true)

        assertEquals(result, "http://coba.com?debug=true")
    }

    @Test
    fun createURL_visibility() {
        val result = createURL(url = "http://coba.com", visibility = false)

        assertEquals(result, "http://coba.com?visibility=false")
    }

    @Test
    fun createURL_needScrollTo_number() {
        val result = createURL(url = "http://coba.com", needScrollTo = 5)

        assertEquals(result, "http://coba.com?need_scrollto=5")
    }

    @Test
    fun createURL_needScrollTo_string() {
        val result = createURL(url = "http://coba.com", needScrollTo = "last")

        assertEquals(result, "http://coba.com?need_scrollto=last")
    }
}