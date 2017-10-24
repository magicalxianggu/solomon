package com.magical.jwgl.query.repository;

import com.magical.jwgl.query.entries.StudentEntry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by zhouxp on 2017/10/20
 */
@RepositoryRestResource(collectionResourceRel = "students", path = "students")
public interface StudentQueryRepository extends MongoRepository<StudentEntry,String> {
}
