package com.anydog.qaedu.data.local.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.anydog.qaedu.data.local.db.dao.UserDao;
import com.anydog.qaedu.data.model.db.User;

@Database(entities = {User.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao userDao();
}
