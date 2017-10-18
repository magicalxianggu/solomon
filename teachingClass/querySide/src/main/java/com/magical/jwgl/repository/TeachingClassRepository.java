package com.magical.jwgl.repository;

import com.magical.jwgl.entries.TeachingClassEntry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TeachingClassRepository extends MongoRepository<TeachingClassEntry,String> {
}

