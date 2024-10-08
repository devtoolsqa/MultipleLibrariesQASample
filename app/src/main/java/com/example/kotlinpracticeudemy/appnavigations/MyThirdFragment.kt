package com.example.kotlinpracticeudemy.appnavigations

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.kotlinpracticeudemy.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MyThirdFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MyThirdFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var buttonPrev:Button
    lateinit var buttonHome:Button

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
        return inflater.inflate(R.layout.fragment_my_third, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonHome=view.findViewById(R.id.btnNavigateToHome)
        buttonPrev=view.findViewById(R.id.btnNavigateToPrev)
        buttonHome.setOnClickListener{
            findNavController().navigate(R.id.action_myThirdFragment_to_myHomeFragment3)
        }
        buttonPrev.setOnClickListener{
            findNavController().popBackStack()
        }

    }


}