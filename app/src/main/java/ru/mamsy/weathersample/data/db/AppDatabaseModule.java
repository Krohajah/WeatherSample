package ru.mamsy.weathersample.data.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.mamsy.localdb.AppDatabase;
import ru.mamsy.localdb.CityDao;
import ru.mamsy.localdb.CityRepository;
import ru.mamsy.localdb.CityRepositoryImpl;
import ru.mamsy.weathersample.App;
import ru.mamsy.weathersample.AppModule;

/**
 * DI-модуль для БД.
 *
 * @author Maxim Berezin
 */
@Module(includes = AppModule.class)
public class AppDatabaseModule {

    private static final String DATABASE_NAME = "Local.db";

    @Provides
    @Singleton
    public AppDatabase appDatabase(App app) {
        return Room.databaseBuilder(app, AppDatabase.class, DATABASE_NAME).addCallback(new RoomDatabase.Callback() {
            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(db);
                InitialCitiesGenerator.generateInitialCities(db);
            }
        }).build();
    }

    @Provides
    @Singleton
    public CityRepository cityRepository(CityDao cityDao) {
        return new CityRepositoryImpl(cityDao);
    }

    @Provides
    @Singleton
    public CityDao cityDao(AppDatabase database) {
        return database.cityDao();
    }

}
