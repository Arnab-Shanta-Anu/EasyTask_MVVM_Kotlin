package com.shajt3ch.todomvvm.model.local.dao

import androidx.room.*
import com.shajt3ch.todomvvm.model.local.entity.TaskEntity

/**
 * Created by Shakil Ahmed Shaj on 26,April,2020.
 * shakilahmedshaj@gmail.com
 */
@Dao
interface TaskDao {

    @Insert
    suspend fun insert(taskEntity: TaskEntity): Long

    @Update
    suspend fun update(taskEntity: TaskEntity): Int

    @Delete
    suspend fun delete(taskEntity: TaskEntity): Int

    @Query("SELECT * FROM task_entity")
    suspend fun getAllTaskFromDb(): List<TaskEntity>

    @Query("SELECT MAX(taskId) FROM task_entity")
    suspend fun getMaxTaskId(): Int?

}