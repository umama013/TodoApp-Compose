package com.example.tod0_aug.feature_note.data.repository

import com.example.tod0_aug.feature_note.data.data_source.Notedao
import com.example.tod0_aug.feature_note.domain.model.Note
import com.example.tod0_aug.feature_note.domain.repository.NoteRepo
import kotlinx.coroutines.flow.Flow

class NoteRepoImpl(
  private  val dao : Notedao
) : NoteRepo {

  override fun getNotes(): Flow<List<Note>> {
    return dao.getNotes()
  }

  override suspend fun insertNotes(note: Note) {
    dao.insetNote(note)
  }

  override suspend fun deleteNotes(note: Note) {
    dao.deleteNote(note)
  }

  override suspend fun getNoteById(id: Int): Note? {
     return dao.getNoteById(id)
  }
}