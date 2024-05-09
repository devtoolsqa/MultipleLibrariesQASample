package com.example.kotlinpracticeudemy.workmanager


import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.kotlinpracticeudemy.R
import java.io.ByteArrayOutputStream


class BlurWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    override fun doWork(): Result {
        try {

            // Load the bitmap
            val bitmap = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.ic_download)

// Compress the bitmap with a quality of 50%
            val compressedBitmap = compressBitmap(bitmap, 50)

            // If there were no errors, return SUCCESS
            return Result.success()
        } catch (throwable: Throwable) {
            // Technically WorkManager will return Result.failure()
            // but it's best to be explicit about it.
            // Thus if there were errors, we're return FAILURE

            Log.e("TAG", "Error applying blur", throwable)
            return Result.failure()
        }

    }
    fun compressBitmap(bitmap: Bitmap, quality:Int): ByteArray {
        // Initialize a byte array output stream
        val outputStream = ByteArrayOutputStream()

        // Compress the bitmap using the provided quality
        bitmap.compress(Bitmap.CompressFormat.JPEG, quality, outputStream)

        // Return the compressed bitmap as a byte array
        return outputStream.toByteArray()
    }
}