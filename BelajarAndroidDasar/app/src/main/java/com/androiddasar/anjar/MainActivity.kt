package com.androiddasar.anjar

import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var sayHelloButton: Button
    private lateinit var sayHelloTextView: TextView

    private fun initComponents() {
        nameEditText = findViewById(R.id.nameEditText)
        sayHelloButton = findViewById(R.id.sayHelloButton)
        sayHelloTextView = findViewById(R.id.sayHelloTextView)
    }

    // fungsi aktifkan fingger print
    private fun checkFingerPrint() {
        if (packageManager.hasSystemFeature(PackageManager.FEATURE_FINGERPRINT)) {
            Log.i("FEATURE", "Feature finggerprint Mode ON")
        } else {
            Log.w("FEATURE", "Feature finggerprint Mode OF")
        }
    }



    private fun checkPlatformversion(){
        Log.i("SDK", Build.VERSION.SDK_INT.toString())
        if ( Build.VERSION.SDK_INT < Build.VERSION_CODES.S){
            Log.i("SDK", "Desabled Feature, Because Version SDK is Lower Than 31")
        }

    }


    private fun printHello(name: String){
        Log.i("Debug", name)
    }


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hello_world)

        initComponents()
//        val nameEditText: EditText = findViewById(R.id.nameEditText)
//        val sayHelloButton: Button = findViewById(R.id.sayHelloButton)
//        val sayHelloTextView: TextView = findViewById(R.id.sayHelloTextView)

        sayHelloTextView.text = resources.getString(R.string.app_name)
        sayHelloButton.setOnClickListener {

            val firstName = "Anjar"
            printHello(firstName)
            checkFingerPrint()
            checkPlatformversion()

            val sample = resources.openRawResource(R.raw.sample)
                .bufferedReader()
                .use { it.readText() }

            // memanggil folder assets
            val json = assets.open("sample.json")
                .bufferedReader()
                .use { it.readText() }
            Log.i("Assets", json)

            // memanggil raw resources

            Log.i("RAW", sample)

            Log.d("JAY", "This Is Debug Log")
            Log.i("JAY", "This Is Info Log")
            Log.w("JAY", "This Is Warning Log")
            Log.e("JAY", "This Is error Log")

            Log.i("ValueResources", resources.getInteger(R.integer.nextPage).toString())
            Log.i("ValueResources", resources.getBoolean(R.bool.isProductName).toString())
            Log.i("ValueResources", resources.getIntArray(R.array.numbers).joinToString(","))
            Log.i("ValueResources", resources.getColor(R.color.background, theme).toString())

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                sayHelloButton.setBackgroundColor(resources.getColor(R.color.background, theme))
            }

            val name = nameEditText.text.toString()
            sayHelloTextView.text = resources.getString(R.string.sayHelloTextView, name)

            resources.getStringArray(R.array.names).forEach {
                Log.i("JAY", it)
            }
        }
    }
}