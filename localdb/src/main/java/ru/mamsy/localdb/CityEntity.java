package ru.mamsy.localdb;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * @author Maxim Berezin.
 */
@Entity(tableName = "cities")
public class CityEntity {

    @PrimaryKey
    private int id;

    public CityEntity(int id) {
        this.id = id;
    }

    public CityEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
