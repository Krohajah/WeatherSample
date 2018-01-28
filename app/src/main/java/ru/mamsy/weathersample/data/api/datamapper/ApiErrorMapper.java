package ru.mamsy.weathersample.data.api.datamapper;


import ru.mamsy.utils.converter.BaseDataMapper;
import ru.mamsy.weathersample.data.api.ApiError;

/**
 * Конвертер API ApiError в ApiError.
 *
 * @author Maxim Berezin
 */
public class ApiErrorMapper extends BaseDataMapper<ApiError, ru.mamsy.api.model.ApiError> {

    @Override
    protected ru.mamsy.api.model.ApiError fromModelImpl(ApiError model) {
        return null;
    }

    @Override
    protected ApiError toModelImpl(ru.mamsy.api.model.ApiError entity) {
        ApiError apiError = new ApiError();
        apiError.setCod(entity.getCod());
        apiError.setMessage(entity.getMessage());
        return apiError;
    }
}
