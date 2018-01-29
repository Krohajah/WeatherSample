package ru.mamsy.localdb;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * БД приложения.
 *
 * @author Maxim Berezin
 */
@Database(entities = {
        CityEntity.class,
}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract CityDao cityDao();
}
