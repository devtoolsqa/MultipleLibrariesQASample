package com.example.couritinespractice

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.kotlinpracticeudemy.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CoroutinesActivity : AppCompatActivity() {

          override fun onCreate(savedInstanceState: Bundle?) {

              super.onCreate(savedInstanceState)
                    enableEdgeToEdge()
                    setContentView(R.layout.activity_coroutines)
              var supendButton:Button = findViewById(R.id.suspend_coroutine_button)
              var singleButton:Button = findViewById(R.id.single_coroutine_button)
              var asyncButton:Button = findViewById(R.id.async_coroutine_button)
              var jobButton:Button = findViewById(R.id.job_coroutine_button)
              var parentChildButton:Button = findViewById(R.id.parent_child_coroutine_button)
                    ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                              val systemBars =
                                        insets.getInsets(WindowInsetsCompat.Type.systemBars())
                              v.setPadding(
                                        systemBars.left,
                                        systemBars.top,
                                        systemBars.right,
                                        systemBars.bottom
                              )
                              insets
                    }
/*
Example for suspend function
 */
                    supendButton.setOnClickListener {
                              lifecycleScope.launch(Dispatchers.Main){
                                    var name= getUsername()
                                        Toast.makeText(it.context,name,Toast.LENGTH_SHORT).show()
                              }
                    }
                    singleButton.setOnClickListener{

                              lifecycleScope.launch(Dispatchers.Main)
                              {
                                        getSingleValue()
                              }
                    }
                    /*
                    running two courotines parellel
                     */
                    asyncButton.setOnClickListener{

                                        val deferredOne=lifecycleScope.async {
                                                  var name= getUsername()
                                                  Toast.makeText(it.context,name+"1",Toast.LENGTH_SHORT).show()
                                        }
                                        val deferredTwo=lifecycleScope.async {
                                                  var name= getUsername()
                                                  Toast.makeText(it.context,name+"2",Toast.LENGTH_SHORT).show()
                                        }



                    }
                    jobButton.setOnClickListener{

                                        val printingJob=lifecycleScope.launch{
                                                  repeat(10){ number->delay(200)
                                                            println(number)
                                                  }
                                        }

                                      //  printingJob.cancel()
                                        println("I cancelled the printing job")

                    }

                    parentChildButton.setOnClickListener{

                                        val parentJob=lifecycleScope.launch{
                                                  repeat(10){ number->delay(200)
                                                            println("parent coroutine :"+number)
                                                            getUsername()
                                                  }
                                                  lifecycleScope.launch{
                                                            repeat(10){ number->delay(200)
                                                                      println("child coroutine :"+number)
                                                 getUsername()
                                                  }
                                        }

                                        println("I cancelled the printing job")
                              }

                                      //  parentJob.cancel()
                    }

          }
          /*
           It will supspend method for 10 sec and main method will run as usual whenever we got result this thread will die
                              */
          suspend fun getUsername(): String{
                    // Simulate a network delay
                    delay(10000)
                    return "sandeep"
          }
/*
If you want return only single value this couroutine will help
 */
          suspend fun getSingleValue(): String= withContext(Dispatchers.Main){
                    "Test"
          }
}