package com.example.project1;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import dev.privyid.pena.Payload;
import dev.privyid.pena.Pena;
import dev.privyid.pena.PenaDocument;
import dev.privyid.pena.Placement;
import kotlin.Unit;

public class BlankActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blank);

        Pena pena = findViewById(R.id.pena);
        pena.openDoc(
                new PenaDocument("http://192.168.1.13:5173")
                        .setDebug(true)
                        .setPrivyId("UAT001")
                        .setLang("en")
                        .setSignature(new Placement(100, 200, 1, false))
                        .setOnAfterAction(this::onAfterAction)

        );
    }

    private Unit onAfterAction(Payload payload) {
        if (payload.getAction().equals("sign"))
            Toast.makeText(this, payload.getAction(), Toast.LENGTH_SHORT).show();

        return null;
    }
}