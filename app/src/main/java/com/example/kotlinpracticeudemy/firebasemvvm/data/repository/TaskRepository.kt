package com.example.kotlinpracticeudemy.firebasemvvm.data.repository



import com.example.kotlinpracticeudemy.firebasemvvm.utils.UiState
import com.example.kotlinpracticeudemy.firebasemvvm.data.model.Task
import com.example.kotlinpracticeudemy.firebasemvvm.data.model.User

interface TaskRepository {
    fun addTask(task: Task, result: (UiState<Pair<Task, String>>) -> Unit)
    fun updateTask(task: Task, result: (UiState<Pair<Task,String>>) -> Unit)
    fun deleteTask(task: Task, result: (UiState<Pair<Task,String>>) -> Unit)
    fun getTasks(user: User?, result: (UiState<List<Task>>) -> Unit)
}