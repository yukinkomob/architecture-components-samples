package com.android.example.github.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent
import com.android.example.github.R
import com.android.example.github.util.LoginHelper

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val customTabsIntent = CustomTabsIntent.Builder().apply {
            setShowTitle(true)
        }.build()

        customTabsIntent.launchUrl(this, LoginHelper.generateAuthorizationUrl())
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)

        intent?.let {
            LoginHelper.handleAuthRedirect(it)
        }
    }
}
