package com.example.kotlinpracticeudemy.proguardbug

import android.app.Application
import androidx.window.embedding.RuleController
import com.example.kotlinpracticeudemy.R

/**
 * Initializer for activity embedding split rules.
 */
class SampleApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        RuleController.getInstance(this)
            .setRules(RuleController.parseRules(this, R.xml.main_split_config))
    }
}

