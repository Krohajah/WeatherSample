package ru.mamsy.localdb;

import java.util.List;

import io.reactivex.Observable;

/**
 * @author Maxim Berezin.
 */
public interface CityRepository {

    Observable<List<CityEntity>> getCiies();

    void insert(CityEntity entity);
}
