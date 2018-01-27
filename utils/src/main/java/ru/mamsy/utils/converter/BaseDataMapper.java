package ru.mamsy.utils.converter;

import java.util.ArrayList;
import java.util.List;

/**
 * Конвертер сущностей.
 *
 * @param <M> Тип 1
 * @param <E> Тип 2
 */
public abstract class BaseDataMapper<M, E> {

    public E fromModel(M model) {
        if (model == null) {
            return fromNullModel();
        } else {
            return (fromModelImpl(model));
        }
    }

    public M toModel(E entity) {
        if (entity == null) {
            return toNullModel();
        } else {
            return (toModelImpl(entity));
        }
    }

    public E fromNullModel() {
        return null;
    }

    public M toNullModel() {
        return null;
    }

    protected abstract E fromModelImpl(M model);

    protected abstract M toModelImpl(E entity);

    public List<M> toModelList(List<E> entities) {
        List<M> models = new ArrayList<>();
        M model;
        if (entities == null) {
            return models;
        }
        for (E entity : entities) {
            model = toModel(entity);
            models.add(model);
        }
        return models;
    }

    public List<E> fromModelList(List<M> models) {
        List<E> entities = new ArrayList<>();
        E entity;
        if (models == null) {
            return entities;
        }
        for (M model : models) {
            entity = fromModel(model);
            entities.add(entity);
        }
        return entities;
    }

}
