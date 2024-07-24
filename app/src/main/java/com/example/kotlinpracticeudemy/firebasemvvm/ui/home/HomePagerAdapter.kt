package com.example.kotlinpracticeudemy.firebasemvvm.ui.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.shopathome.ui.note.NoteListingFragment

import com.example.kotlinpracticeudemy.firebasemvvm.ui.task.TaskListingFragment
import com.example.kotlinpracticeudemy.firebasemvvm.utils.HomeTabs


class HomePagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = HomeTabs.values().size

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            HomeTabs.NOTES.index -> NoteListingFragment.newInstance(HomeTabs.NOTES.name)
            HomeTabs.TASKS.index -> TaskListingFragment.newInstance(HomeTabs.TASKS.name)
            else -> throw IllegalStateException("Fragment not found")
        }
    }
}