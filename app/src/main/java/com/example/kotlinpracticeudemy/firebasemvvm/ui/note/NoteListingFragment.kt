package com.example.shopathome.ui.note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.kotlinpracticeudemy.R
import com.example.kotlinpracticeudemy.databinding.FragmentNoteListingBinding
import com.example.kotlinpracticeudemy.firebasemvvm.utils.UiState
import com.example.kotlinpracticeudemy.firebasemvvm.utils.hide
import com.example.kotlinpracticeudemy.firebasemvvm.utils.show
import com.example.kotlinpracticeudemy.firebasemvvm.utils.toast


import com.example.kotlinpracticeudemy.firebasemvvm.ui.auth.AuthViewModel


import dagger.hilt.android.AndroidEntryPoint


private const val ARG_PARAM1 = "param1"

@AndroidEntryPoint
class NoteListingFragment : Fragment() {

    val TAG: String = "NoteListingFragment"
    var param1: String? = null
    lateinit var binding: FragmentNoteListingBinding
    val viewModel: NoteViewModel by viewModels()
    val authViewModel: AuthViewModel by viewModels()
    val adapter by lazy {
        NoteListingAdapter(
            onItemClicked = { pos, item ->
                findNavController().navigate(R.id.action_noteListingFragment_to_noteDetailFragment,Bundle().apply {
                    putParcelable("note",item)
                })
            }
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
            binding = FragmentNoteListingBinding.inflate(layoutInflater)
            return binding.root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        oberver()
        val staggeredGridLayoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        binding.recyclerView.layoutManager = staggeredGridLayoutManager
        binding.recyclerView.adapter = adapter
        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_noteListingFragment_to_noteDetailFragment)
        }

        authViewModel.getSession {
            viewModel.getNotes(it)
        }
    }

    private fun oberver(){
        viewModel.note.observe(viewLifecycleOwner) {
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
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String) =
            NoteListingFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}