package com.example.kotlinpracticeudemy.firebasemvvm.data.repository



import com.example.kotlinpracticeudemy.firebasemvvm.utils.FireDatabase
import com.example.kotlinpracticeudemy.firebasemvvm.utils.UiState
import com.example.kotlinpracticeudemy.firebasemvvm.data.model.Task
import com.example.kotlinpracticeudemy.firebasemvvm.data.model.User

import com.google.firebase.database.FirebaseDatabase

class TaskRepositoryImp(
    val database: FirebaseDatabase
) : TaskRepository {

    override fun addTask(task: Task, result: (UiState<Pair<Task, String>>) -> Unit) {
        val reference = database.reference.child(FireDatabase.TASK).push()
        val uniqueKey = reference.key ?: "invalid"
        task.id = uniqueKey
        reference
            .setValue(task)
            .addOnSuccessListener {
                result.invoke(
                    UiState.Success(Pair(task,"Task has been created successfully"))
                )
            }
            .addOnFailureListener {
                result.invoke(
                    UiState.Failure(
                        it.localizedMessage
                    )
                )
            }
    }

    override fun updateTask(task: Task, result: (UiState<Pair<Task,String>>) -> Unit) {
        val reference = database.reference.child(FireDatabase.TASK).child(task.id)
        reference
            .setValue(task)
            .addOnSuccessListener {
                result.invoke(
                    UiState.Success(Pair(task,"Task has been updated successfully"))
                )
            }
            .addOnFailureListener {
                result.invoke(
                    UiState.Failure(
                        it.localizedMessage
                    )
                )
            }
    }

    override fun getTasks(user: User?, result: (UiState<List<Task>>) -> Unit) {
        val reference = database.reference.child(FireDatabase.TASK)
        reference.get()
            .addOnSuccessListener {
                val tasks = arrayListOf<Task?>()
                for (item in it.children){
                    val task = item.getValue(Task::class.java)
                    tasks.add(task)
                }
                result.invoke(UiState.Success(tasks.filterNotNull()))
            }
            .addOnFailureListener {
                result.invoke(
                    UiState.Failure(
                        it.localizedMessage
                    )
                )
            }
    }

    override fun deleteTask(task: Task, result: (UiState<Pair<Task,String>>) -> Unit) {
        val reference = database.reference.child(FireDatabase.TASK).child(task.id)
        reference.removeValue()
            .addOnSuccessListener {
                result.invoke(
                    UiState.Success(Pair(task,"Task has been deleted successfully"))
                )
            }
            .addOnFailureListener {
                result.invoke(
                    UiState.Failure(
                        it.localizedMessage
                    )
                )
            }
    }
}