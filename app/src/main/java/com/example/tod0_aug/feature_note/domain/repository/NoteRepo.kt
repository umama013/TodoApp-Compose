package com.example.tod0_aug.feature_note.domain.repository

import com.example.tod0_aug.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepo {

  fun getNotes():Flow<List<Note>>

  suspend fun insertNotes(note: Note)

  suspend fun deleteNotes(note: Note)

  suspend fun getNoteById(id:Int) : Note?
}