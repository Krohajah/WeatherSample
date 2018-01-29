package ru.mamsy.weathersample.data.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.OnConflictStrategy;
import android.content.ContentValues;

import java.util.ArrayList;
import java.util.List;

import ru.mamsy.localdb.CityEntity;

/**
 * Генератор пунктов для главного меню.
 *
 * @author Maxim Berezin
 */
public class InitialCitiesGenerator {

    public static void generateInitialCities(SupportSQLiteDatabase db) {
        List<CityEntity> entities = new ArrayList<>();

        CityEntity hurzuf = new CityEntity(707860);
        CityEntity novinki = new CityEntity(519188);
        CityEntity gorka = new CityEntity(1283378);
        CityEntity holubynka = new CityEntity(708546);
        CityEntity kathmandu = new CityEntity(1283240);
        CityEntity merida = new CityEntity(3632308);
        CityEntity vinogradovo = new CityEntity(473537);

        entities.add(hurzuf);
        entities.add(novinki);
        entities.add(gorka);
        entities.add(holubynka);
        entities.add(kathmandu);
        entities.add(merida);
        entities.add(vinogradovo);

        for (CityEntity entity : entities) {
            db.insert("cities", OnConflictStrategy.REPLACE, generateContentValues(entity));
        }
    }

    private static ContentValues generateContentValues(CityEntity entry) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", entry.getId());
        return contentValues;
    }
}
