package com.cdsb.project.repositories;

import java.util.List;

public interface Repo<I, E> {

    List<E> readAll();
    // findAll
    // getAll

    E readById(I id) throws Exception;
    // Optional<E> readById(I id);
    // findById
    // getById

    E create(E data) throws Exception;
    // save

    E updateById(E data) throws Exception;
    // update

    E deleteById(I id) throws Exception;
    // delete
}
