package com.example.project1

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dev.privyid.pena.Payload
import dev.privyid.pena.Pena
import dev.privyid.pena.Placement

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pena = findViewById<Pena>(R.id.pena)
        pena.openDoc(
            url = "http://sign.document.com/doc/xxx",
            lang = "en",
            signature = Placement(
                x = 100,
                y = 200,
                page = 1,
                fixed = true,
            ),
            onAfterAction = this::onAfterAction,
        )
    }

    private fun onAfterAction(payload: Payload) {
        Toast.makeText(this, payload.action, Toast.LENGTH_SHORT).show()
    }
}
