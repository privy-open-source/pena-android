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
//            url = "https://fe-public-sdk-sign.carstensz.privydev.id/magic-link/f25e2ec651028ac7e828a8a30c84c883",
            url = "https://sdk-sign-web.dev.privydev.id/doc/fca0f79911bf506c5c2228b95a67e316758a6ed3b97c7d3d82be3c1bdcabf3b6",
//            url = "https://sdk-sign-web.dev.privydev.id/doc/sign/62353330613961363533303262653239326135313439323566643132326633346532623137643365626633366138323334346263643734316635323938343662-b2c7aa3f4663cc3a753ca75a56bf80c2e702fd4474aa7c3e673d568d6ac2a8a7-1",
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