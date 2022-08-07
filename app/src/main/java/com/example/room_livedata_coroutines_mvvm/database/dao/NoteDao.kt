package com.example.room_livedata_coroutines_mvvm.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.room_livedata_coroutines_mvvm.model.Note


@Dao
interface NoteDao {
    @Insert
    suspend fun insertNote(note: Note)

    @Update
    suspend fun updateNote(note: Note)

    //dung spen de query database khi sd coroutine
    @Delete
    suspend fun deleteNote(note: Note)

    //live data k can spen
    @Query("select * from note_table")
    fun getAllNote(): LiveData<List<Note>>

//    @Query("select * from note_table where title_col =:title")
//    fun getNoteBytitle(title:String): LiveData<List<Note>>

}