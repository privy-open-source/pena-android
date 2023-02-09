package dev.privyid.pena

import org.json.JSONObject

data class Payload(
    val action: String,
    val data: JSONObject,
)