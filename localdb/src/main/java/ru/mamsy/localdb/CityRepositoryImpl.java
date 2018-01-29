package ru.mamsy.localdb;

import java.util.List;

import io.reactivex.Observable;

/**
 * @author Maxim Berezin.
 */
public class CityRepositoryImpl implements CityRepository {

    private final CityDao cityDao;

    public CityRepositoryImpl(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @Override
    public Observable<List<CityEntity>> getCiies() {
        return Observable.fromCallable(cityDao::getCiies);
    }

    @Override
    public void insert(CityEntity entity) {
        cityDao.insert(entity);
    }
}
