package com.syntaxerror.kotlinroomdb3.data.db

import android.content.Context
import androidx.room.*
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.syntaxerror.kotlinroomdb3.data.dao.UserDAO
import com.syntaxerror.kotlinroomdb3.data.model.User

/**
 **************************************************************************************
 *
 *** Project Details ***
 *
 * Project Name : KotlinRoomDB3.
 * Package Id : com.syntaxerror.kotlinroomdb3.data.db
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


@Database(entities = [User::class], version = 2)
abstract class UserDB : RoomDatabase() {

    abstract fun userDAO() : UserDAO



    companion object{

        val migration_1_2 = object : Migration(1, 2){
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("Alter table user add column country VARCHAR NOT NULL default('India')")
            }
        }

        @Volatile
        private var db_instance : UserDB? = null

        fun getDatabaseInstance(context: Context) : UserDB {
            if(db_instance==null){
                synchronized(this){
                    db_instance = Room.databaseBuilder(context.applicationContext,UserDB::class.java,"user")
                        .addMigrations(migration_1_2)
                        .build()
                }
            }
            return db_instance!!
        }
    }
}