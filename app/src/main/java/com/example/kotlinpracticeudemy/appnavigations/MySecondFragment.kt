package com.example.kotlinpracticeudemy.appnavigations

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.kotlinpracticeudemy.R
import com.navigation.component.sample.data.MyParcelableDataArgs

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MySecondFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MySecondFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val safeArgs: MySecondFragmentArgs by navArgs()
        val arg1 = safeArgs.arg1
        val arg2 = safeArgs.arg2
        val arg3 = safeArgs.arg3 as MyParcelableDataArgs
        val data1=arg3.data1
        val data2=arg3.data2
        val data3=arg3.data3
        val tvLabel=view.findViewById<TextView>(R.id.tv_label)
        tvLabel.text=data3
        button=view.findViewById(R.id.button_next)
        button.setOnClickListener{
            findNavController().navigate(R.id.action_mySecondFragment_to_myThirdFragment)
        }
    }


}