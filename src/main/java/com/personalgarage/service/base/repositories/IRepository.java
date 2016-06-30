package com.personalgarage.service.base.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface IRepository<T, ID extends Serializable>
        extends MongoRepository<T, ID> {
}