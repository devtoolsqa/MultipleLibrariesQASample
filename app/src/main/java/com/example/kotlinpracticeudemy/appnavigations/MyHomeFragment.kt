package com.example.kotlinpracticeudemy.appnavigations

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.net.toUri
import androidx.navigation.fragment.findNavController
import com.example.kotlinpracticeudemy.R
import com.navigation.component.sample.data.MyParcelableDataArgs

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MyHomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MyHomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var button:Button
    lateinit var deeplinkButton: Button

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
        return inflater.inflate(R.layout.fragment_my_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button=view.findViewById(R.id.button_start)
        deeplinkButton=view.findViewById(R.id.deep_link)
        button.setOnClickListener{
            val arg1 = 2
            val arg3 = "Screen 2"
            val data1=1
            val arg2= MyParcelableDataArgs(data1)
            arg2.data2=2
            arg2.data3="Welcome to Screen 2(wow)"
            arg2.data4=1
            val directions=MyHomeFragmentDirections.actionMyHomeFragmentToMySecondFragment(arg2,arg3,arg1)
//val directions=MyHomeFragmentDirections.actionMyHomeFragmentToMySecondFragment(arg1,arg2,arg3)

           findNavController().navigate(directions)

        }
        deeplinkButton.setOnClickListener{
            val deepLink = InternalDeepLink.SECOND.toUri()
            findNavController().navigate(deepLink)
        }
    }


}