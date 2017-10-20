package com.magical.jwgl.query.repository;

import com.magical.jwgl.query.entries.StudentEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by zhouxp on 2017/10/20
 */
public interface StudentRepository extends MongoRepository<StudentEntry,String> {
}
