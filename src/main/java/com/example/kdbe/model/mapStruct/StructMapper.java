package com.example.kdbe.model.mapStruct;

import java.util.List;

public interface StructMapper<E,D> {

    D toDto(E entity);

    E toEntity(D dto);

    List<D> toDtoList(List<E> entityList);

    List<E> toEntityList(List<D> dtoList);
}
