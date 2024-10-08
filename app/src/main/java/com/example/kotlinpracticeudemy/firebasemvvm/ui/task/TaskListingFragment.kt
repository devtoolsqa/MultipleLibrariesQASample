package com.example.kotlinpracticeudemy.firebasemvvm.ui.task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager


import com.example.kotlinpracticeudemy.databinding.FragmentTaskListingBinding
import com.example.kotlinpracticeudemy.firebasemvvm.utils.UiState
import com.example.kotlinpracticeudemy.firebasemvvm.utils.hide
import com.example.kotlinpracticeudemy.firebasemvvm.utils.show
import com.example.kotlinpracticeudemy.firebasemvvm.utils.toast
import com.example.kotlinpracticeudemy.firebasemvvm.data.model.Task

import com.example.kotlinpracticeudemy.firebasemvvm.ui.auth.AuthViewModel


import dagger.hilt.android.AndroidEntryPoint

private const val ARG_PARAM1 = "param1"

@AndroidEntryPoint
class TaskListingFragment : Fragment() {

    val TAG: String = "TaskListingFragment"
    private var param1: String? = null
    val viewModel: TaskViewModel by viewModels()
    val authViewModel: AuthViewModel by viewModels()
    lateinit var binding: FragmentTaskListingBinding
    var deleteItemPos = -1
    val adapter by lazy{
        TaskListingAdapter(
            onItemClicked = { pos, item -> onTaskClicked(item)},
            onDeleteClicked = { pos, item -> onDeleteClicked(pos,item) }
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        if (this::binding.isInitialized){
            return binding.root
        }else {
            binding = FragmentTaskListingBinding.inflate(layoutInflater)
            return binding.root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.addTaskButton.setOnClickListener {
            val createTaskFragmentSheet = CreateTaskFragment()
            createTaskFragmentSheet.setDismissListener {
                if (it) {
                    authViewModel.getSession {
                        viewModel.getTasks(it)
                    }
                }
            }
            createTaskFragmentSheet.show(childFragmentManager,"create_task")
        }

        binding.taskListing.layoutManager = LinearLayoutManager(requireContext())
        binding.taskListing.adapter = adapter

        authViewModel.getSession {
            viewModel.getTasks(it)
        }
        observer()
    }

    private fun observer(){
        viewModel.tasks.observe(viewLifecycleOwner) {
            when(it){
                is UiState.Loading -> {
                    binding.progressBar.show()
                }
                is UiState.Failure -> {
                    binding.progressBar.hide()
                    toast(it.error)
                }
                is UiState.Success -> {
                    binding.progressBar.hide()
                    adapter.updateList(it.data.toMutableList())
                }
            }
        }
        viewModel.deleteTask.observe(viewLifecycleOwner) {
            when(it){
                is UiState.Loading -> {
                    binding.progressBar.show()
                }
                is UiState.Failure -> {
                    binding.progressBar.hide()
                    toast(it.error)
                }
                is UiState.Success -> {
                    binding.progressBar.hide()
                    toast(it.data.second)
                    adapter.removeItem(deleteItemPos)
                }
            }
        }
    }

    private fun onTaskClicked(task: Task){
        val createTaskFragmentSheet = CreateTaskFragment(task)
        createTaskFragmentSheet.setDismissListener {
            if (it) {
                authViewModel.getSession {
                    viewModel.getTasks(it)
                }
            }
        }
        createTaskFragmentSheet.show(childFragmentManager,"create_task")
    }

    private fun onDeleteClicked(pos: Int, item: Task) {
        deleteItemPos = pos
        viewModel.deleteTask(item)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String) =
            TaskListingFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}
