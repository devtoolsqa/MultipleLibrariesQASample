package com.example.kotlinpracticeudemy.workmanager

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.example.kotlinpracticeudemy.R

class WorkManagerActivity : AppCompatActivity() {
lateinit var button:Button
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_work_manager)
        button=findViewById(R.id.button)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        button.setOnClickListener {

            val workRequest = OneTimeWorkRequest.Builder(MyWorker::class.java).build()
            WorkManager.getInstance(this).enqueue(workRequest)
        }
    }
}