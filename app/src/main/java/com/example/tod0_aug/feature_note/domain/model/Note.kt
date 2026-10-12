package com.example.tod0_aug.feature_note.domain.model

import androidx.compose.material3.darkColorScheme
import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
  val title: String,
  val content: String,
  val color: Int,
  val timeStamp: Long,
  @PrimaryKey
  val Id: Int? = null
) {

  companion object {

    val noteColors = listOf(Color.Red, Color.Gray, Color.Green, Color.Blue, Color.Magenta)

  }

}

