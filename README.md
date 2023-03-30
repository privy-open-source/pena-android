# Pena 💚 Android

> PrivyID's Official Client Integration Library for Android.

## Requirement
- Min SDK >= 30

## Installation

1. Add the JitPack repository to your `build.gradle` file.

```gradle
allprojects {
  repositories {
    maven { url 'https://jitpack.io' }
  }
}
```

2. Add the dependency
```gradle
dependencies {
  implementation 'dev.privyid:pena-android:0.2.0'
}
```

3. Add internet permission in your `AndroidManifest.xml`
```xml
<uses-permission android:name="android.permission.INTERNET" />
```

## Usage

1. Add Pena in your layout file

```xml
  <dev.privyid.pena.Pena
    android:id="@+id/pena"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
  />
```

2. And handle on your Activity

**Kotlin**

```kt
import dev.privyid.pena.Payload
import dev.privyid.pena.Pena
import dev.privyid.pena.Placement

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pena = findViewById<Pena>(R.id.pena)
        pena.openDoc(
            url = "https://sign.document.com/doc/xxx",
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
        if (payload.action == "sign")
            Toast.makeText(this, "Signed", Toast.LENGTH_SHORT).show()
    }
}
```

**Java**

```java
import dev.privyid.pena.Payload;
import dev.privyid.pena.Pena;
import dev.privyid.pena.PenaDocument;
import dev.privyid.pena.Placement;
import kotlin.Unit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Pena pena = findViewById(R.id.pena);
        pena.openDoc(
                new PenaDocument("https://sign.document.com/doc/xxx")
                        .setLang("en")
                        .setSignature(new Placement(100, 200, 1, true))
                        .setOnAfterAction(this::onAfterAction)
                        
        );
    }

    private Unit onAfterAction(Payload payload) {
        if (payload.getAction().equals("sign"))
            Toast.makeText(this, "Signed", Toast.LENGTH_SHORT).show();

        return null;
    }
}
```

## Options

| Options         | Type      | Default | Description                                                                                                  |
|-----------------|-----------|:-------:|--------------------------------------------------------------------------------------------------------------|
| `url`           | String    |    -    | **(Required)** Document's url                                                                                |
| `lang`          | String    |  `en`   | Set language, valid value is `en` or `id`                                                                    |
| `visibility`    | Boolean   | `true`  | Set signature visibility                                                                                     |
| `privyId`       | String    |    -    | Set recipient's privyId                                                                                      |
| `signature`     | Placement |    -    | Set signature placement<br/> <strong>(Deprecated)</strong> use API to set placement when upload the document |
| ├ `x`           | Number    |    -    | X Coordinate                                                                                                 |
| ├ `y`           | Number    |    -    | Y Coordinate                                                                                                 |
| ├ `page`        | Number    |    -    | Target page                                                                                                  |
| └ `fixed`       | Boolean   | `false` | Disabled signature for moving                                                                                |
| `debug`         | Boolean   | `false` | Enable debug mode                                                                                            |
| `onAfterAction` | Function  |    -    | After action hook                                                                                            |

## License

This project is licensed under the MIT License - see the [LICENSE](./LICENSE) file for details
