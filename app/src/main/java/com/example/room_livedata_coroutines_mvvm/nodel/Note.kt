package com.example.room_livedata_coroutines_mvvm.nodel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
class Note (
    @ColumnInfo(name = "title_col") var title: String = "",
    @ColumnInfo(name = "description") var description: String = ""
        ){

    // khoa chinh, ten col id, auto khoi tao
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "note_id_col") var id: Int = 0
}