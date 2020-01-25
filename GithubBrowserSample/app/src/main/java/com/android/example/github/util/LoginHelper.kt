package com.android.example.github.util

import android.content.Intent
import android.net.Uri
import com.android.example.github.BuildConfig
import timber.log.Timber

object LoginHelper {
    fun generateAuthorizationUrl(): Uri =
            Uri.Builder().apply {
                scheme("https")
                authority("github.com")
                appendPath("login")
                appendPath("oauth")
                appendPath("authorize")
                appendQueryParameter("client_id", BuildConfig.GITHUB_CLIENT_ID)
            }.build()

    fun handleAuthRedirect(intent: Intent) {
        val uri = intent.data ?: return

        if (uri.toString().startsWith("dgbs://login")) {
            val tempCode = uri.getQueryParameter("code")
            Timber.i("code $tempCode")
        }
    }
}
