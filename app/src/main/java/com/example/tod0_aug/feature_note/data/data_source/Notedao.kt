package com.example.tod0_aug.feature_note.data.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tod0_aug.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface Notedao {
   @Query(" SELECT * FROM note ")
  fun getNotes(): Flow<List<Note>>

  @Query("SELECT * FROM note WHERE id = :id")
  suspend fun getNoteById(id: Int) : Note?

   @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insetNote(note : Note)

   @Delete
   suspend fun deleteNote(note : Note)
}