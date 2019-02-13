package com.android.coinranking.core.persistence.database.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MapStringBooleanTypeConverter {
    @TypeConverter
    fun fromMap(map: Map<String, Boolean>): String = Gson().toJson(map)

    @TypeConverter
    fun toMap(value: String): Map<String, Boolean> {
        val mapType = object : TypeToken<Map<String, Boolean>>() {}.type

        return try {
            Gson().fromJson(value, mapType)
        } catch (e: Exception) {
            emptyMap()
        }
    }
}
