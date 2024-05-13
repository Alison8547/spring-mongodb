package com.br.springmongodb.repository;

import com.br.springmongodb.domain.Responsible;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsibleRepository extends MongoRepository<Responsible, String> {
}
