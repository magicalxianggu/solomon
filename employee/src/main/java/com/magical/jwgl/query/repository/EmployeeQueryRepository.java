package com.magical.jwgl.query.repository;

import com.magical.jwgl.query.entries.EmployeeEntry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by zhouxp on 2017/10/25
 */
@RepositoryRestResource(collectionResourceRel = "employees",path = "employees")
public interface EmployeeQueryRepository extends MongoRepository<EmployeeEntry,String>{
}
