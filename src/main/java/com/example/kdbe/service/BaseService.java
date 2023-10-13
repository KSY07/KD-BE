package com.example.kdbe.service;

import com.example.kdbe.model.mapStruct.StructMapper;
import com.example.kdbe.repository.BaseRepository;


public interface BaseService<E,D>{

    BaseRepository<E> getRepository();

    StructMapper<E,D> getMapper();
    default E get(Long id){
        return getRepository().findById(id).get();
    }

    default E add(Long id, D dto) {
        E entity = getMapper().toEntity(dto);
        return getRepository().save(entity);
    }

    default E update(Long id, D dto){
        E entity = getMapper().toEntity(dto);
        return getRepository().save(entity);
    }

    default void delete(Long id, D dto){
        E entity = getMapper().toEntity(dto);
        getRepository().delete(entity);
    }
}
