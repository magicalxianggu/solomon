package com.magical.jwgl.repository;

import com.magical.jwgl.entries.TeachingClassEntry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "teachingClasses", path = "teachingClasses")
public interface TeachingClassRepository extends MongoRepository<TeachingClassEntry,String> {
}

