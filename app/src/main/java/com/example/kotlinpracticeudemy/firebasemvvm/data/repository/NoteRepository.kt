package com.example.kotlinpracticeudemy.firebasemvvm.data.repository

import android.net.Uri
import com.example.kotlinpracticeudemy.firebasemvvm.utils.UiState


import com.example.kotlinpracticeudemy.firebasemvvm.data.model.Note
import com.example.kotlinpracticeudemy.firebasemvvm.data.model.User

interface NoteRepository {
    fun getNotes(user: User?, result: (UiState<List<Note>>) -> Unit)
    fun addNote(note: Note, user: User?, result: (UiState<Pair<Note,String>>) -> Unit)
    fun updateNote(note: Note, user: User?, result: (UiState<String>) -> Unit)
    fun deleteNote(note: Note, user: User?, result: (UiState<String>) -> Unit)
    suspend fun uploadSingleFile(fileUri: Uri, onResult: (UiState<Uri>) -> Unit)
    suspend fun uploadMultipleFile(fileUri: List<Uri>, onResult: (UiState<List<Uri>>) -> Unit)
}