package ru.mamsy.localdb;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * @author Maxim Berezin.
 */
@Dao
public interface CityDao {

    @Query("SELECT * FROM cities")
    List<CityEntity> getCiies();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(CityEntity entity);
}
