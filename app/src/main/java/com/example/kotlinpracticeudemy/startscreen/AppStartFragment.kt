package com.example.kotlinpracticeudemy.startscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.kotlinpracticeudemy.R
import com.example.kotlinpracticeudemy.appnavigations.MyHomeFragmentDirections

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AppStartFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AppStartFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var buttonWorkManager:Button
    lateinit var buttonCoroutines:Button
    lateinit var buttonAppNavigations:Button
    lateinit var buttonmvvm:Button
    lateinit var buttonRoom:Button
    lateinit var buttonProguard:Button
    lateinit var buttonFirebase:Button

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
        return inflater.inflate(R.layout.fragment_app_start, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonAppNavigations=view.findViewById(R.id.app_navigations)
        buttonWorkManager=view.findViewById(R.id.work_manager_sample)
        buttonCoroutines=view.findViewById(R.id.coroutines_sample)
        buttonmvvm=view.findViewById(R.id.mvvm_sample)
        buttonRoom=view.findViewById(R.id.room_db_sample)
        buttonProguard=view.findViewById(R.id.proguard_sample)
        buttonFirebase=view.findViewById(R.id.firebase_sample)

        buttonCoroutines.setOnClickListener {
            val directions=AppStartFragmentDirections.actionAppStartFragmentToCoroutinesActivity()
            findNavController().navigate(directions)
        }
        buttonAppNavigations.setOnClickListener {
            val directions=AppStartFragmentDirections.actionAppStartFragmentToNavigationActivity()
            findNavController().navigate(directions)

        }
        buttonWorkManager.setOnClickListener {
            val directions=AppStartFragmentDirections.actionAppStartFragmentToWorkManagerActivity()
            findNavController().navigate(directions)
        }
        buttonmvvm.setOnClickListener {
            val directions=AppStartFragmentDirections.actionAppStartFragmentToMvvmActivity()
            findNavController().navigate(directions)
        }
        buttonRoom.setOnClickListener {
            val directions=AppStartFragmentDirections.actionAppStartFragmentToRoomActivity()
            findNavController().navigate(directions)
        }
        buttonProguard.setOnClickListener{
            val directions=AppStartFragmentDirections.actionAppStartFragmentToProguardActivity()
            findNavController().navigate(directions)
        }
        buttonFirebase.setOnClickListener{
            val directions=AppStartFragmentDirections.actionAppStartFragmentToFirebaseActivity()
            findNavController().navigate(directions)
        }
    }


}