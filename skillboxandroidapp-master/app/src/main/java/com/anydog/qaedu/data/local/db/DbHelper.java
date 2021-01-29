package com.anydog.qaedu.data.local.db;

import com.anydog.qaedu.data.model.db.User;

import java.util.List;

import io.reactivex.Observable;

public interface DbHelper {
    Observable<List<User>> getAllUsers();
    Observable<Boolean> insertUser(final User user);
}
