package com.example.shopathome.ui.note

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinpracticeudemy.firebasemvvm.utils.UiState


import com.example.kotlinpracticeudemy.firebasemvvm.data.model.Note
import com.example.kotlinpracticeudemy.firebasemvvm.data.model.User
import com.example.kotlinpracticeudemy.firebasemvvm.data.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    val repository: NoteRepository
): ViewModel() {

    private val _notes = MutableLiveData<UiState<List<Note>>>()
    val note: LiveData<UiState<List<Note>>>
            get() = _notes

    private val _addNote = MutableLiveData<UiState<Pair<Note,String>>>()
    val addNote: LiveData<UiState<Pair<Note,String>>>
        get() = _addNote

    private val _updateNote = MutableLiveData<UiState<String>>()
    val updateNote: LiveData<UiState<String>>
        get() = _updateNote

    private val _deleteNote = MutableLiveData<UiState<String>>()
    val deleteNote: LiveData<UiState<String>>
        get() = _deleteNote

    fun getNotes(user: User?) {
        _notes.value = UiState.Loading
        repository.getNotes(user) { _notes.value = it }
    }

    fun addNote(note: Note, user: User?){
        _addNote.value = UiState.Loading
        repository.addNote(note,user) { _addNote.value = it }
    }

    fun updateNote(note: Note, user: User?){
        _updateNote.value = UiState.Loading
        repository.updateNote(note,user) { _updateNote.value = it }
    }

    fun deleteNote(note: Note, user: User?){
        _deleteNote.value = UiState.Loading
        repository.deleteNote(note,user) { _deleteNote.value = it }
    }

    fun onUploadSingleFile(fileUris: Uri, onResult: (UiState<Uri>) -> Unit){
        onResult.invoke(UiState.Loading)
        viewModelScope.launch {
            repository.uploadSingleFile(fileUris,onResult)
        }
    }

    fun onUploadMultipleFile(fileUris: List<Uri>, onResult: (UiState<List<Uri>>) -> Unit){
        onResult.invoke(UiState.Loading)
        viewModelScope.launch {
            repository.uploadMultipleFile(fileUris,onResult)
        }
    }

}