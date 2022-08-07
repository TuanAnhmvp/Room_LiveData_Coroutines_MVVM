package com.example.room_livedata_coroutines_mvvm.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "note_table")
class Note (
    @ColumnInfo(name = "title_col", defaultValue = "") var title: String = "",
    @ColumnInfo(name = "description", defaultValue = "") var description: String = ""
        ):Serializable {

    @ColumnInfo(name = "note_id_col")
    @PrimaryKey(autoGenerate = true) var id: Int = 0

}