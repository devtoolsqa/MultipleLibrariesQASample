package com.example.kotlinpracticeudemy.proguardbug

import android.content.Context
import androidx.startup.Initializer
import androidx.window.embedding.RuleController
import com.example.kotlinpracticeudemy.R

class SplitInitializer : Initializer<RuleController> {

  override fun create(context: Context): RuleController {
    return RuleController.getInstance(context).apply {
      setRules(RuleController.parseRules(context, R.xml.main_split_config))
    }
  }

  override fun dependencies(): List<Class<out Initializer<*>>> {
    return emptyList()
  }
}
