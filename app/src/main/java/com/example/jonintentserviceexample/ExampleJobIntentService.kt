package com.example.jonintentserviceexample

import android.content.Context
import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import android.util.Log
import android.widget.Toast
import androidx.core.app.JobIntentService

class ExampleJobIntentService : JobIntentService() {
    var TAG = "ExampleJobIntentService"

    companion object {
        var isServiceRunning = false
        fun enqueueWork(context: Context, work: Intent) {
            enqueueWork(context, ExampleJobIntentService::class.java, 123, work)
        }
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "on Destroy")

    }

    override fun onStopCurrentWork(): Boolean {
        //default true
        //true will start the work again after stop by memory pressure
        Log.d(TAG, "On stop Current work")
        return super.onStopCurrentWork()


    }

    override fun onHandleWork(intent: Intent) {
        Log.d(TAG, "on Handle")

        var intnetText = intent.getStringExtra("inputString")
        for (x in 1..3) {

            Handler(Looper.getMainLooper()).post {
            Toast.makeText(this,"$intnetText $x $isStopped",Toast.LENGTH_SHORT).show()
            }
            isServiceRunning = isStopped
            if (isStopped) {
                return
            }
            Log.d(TAG, "$intnetText $x")
            SystemClock.sleep(3000)

        }
    }
}