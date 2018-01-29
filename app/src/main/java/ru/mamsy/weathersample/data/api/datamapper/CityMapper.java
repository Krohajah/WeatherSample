package ru.mamsy.weathersample.data.api.datamapper;

import ru.mamsy.api.model.AddCity;
import ru.mamsy.localdb.CityEntity;
import ru.mamsy.utils.converter.BaseDataMapper;

/**
 * @author Maxim Berezin.
 */
public class CityMapper extends BaseDataMapper<CityEntity, AddCity> {
    @Override
    protected AddCity fromModelImpl(CityEntity model) {
        return null;
    }

    @Override
    protected CityEntity toModelImpl(AddCity entity) {
        //предположим что в addcity попадает всегда нужный город.
        //понятно что Лондонов будет несколько. К сожалению, как я понял, нельзя добавить к квери код страны
        CityEntity cityEntity = new CityEntity();
        cityEntity.setId(entity.getList().get(0).getId());
        return cityEntity;
    }
}
