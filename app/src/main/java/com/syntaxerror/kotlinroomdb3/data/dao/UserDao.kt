package com.syntaxerror.kotlinroomdb3.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.syntaxerror.kotlinroomdb3.data.model.User

/**
 **************************************************************************************
 *
 *** Project Details ***
 *
 * Project Name : KotlinRoomDB3.
 * Package Id : com.syntaxerror.kotlinroomdb3.data.dao
 * Created By :  Shrawan Shinde
 * Created Date :  30,September,2022
 *
 *** Contact Details ***
 *
 * Name : Shrawan B. Shinde
 * Email : syntaxerror1972@gmail.com
 * Github Link : https://github.com/syntaxerror1972/KotlinRoomDB3
 * LinkedIn Link : https://in.linkedin.com/in/shrawan-shinde-59ba57a1
 * Copyright (c) 2022. All rights reserved.
 *
 **************************************************************************************
 */

@Dao
interface UserDAO {

    @Insert
    suspend fun addUser(user: User)

    @Update
    suspend fun updateUser(user:User)

    @Delete
    suspend fun deleteUser(user:User)

    @Query("Select * from  user")
    fun getUserList() : LiveData<List<User>>

}