package com.developer.mousika.base.mapstruct;

import java.io.Serializable;
import java.util.List;

/**
 * Project name：lambda.
 * Created by xiadongwei on 2018/4/5.
 * Current Version: 1.0
 * Discription:
 */
public interface EntityMapStruct<D extends Serializable, E extends Serializable> {

    E toEntity(D dto);

    D toDto(E entity);

    D copyDto(D dto);

    E copyEntity(E entity);

    List<E> toEntity(List<D> dtoList);

    List<D> toDto(List<E> entityList);

    List<E> copyEntity(List<E> entityList);

    List<D> copyDto(List<D> dtoList);
}
