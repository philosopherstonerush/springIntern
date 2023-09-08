package com.aula.assign.crudApp.repository;

import com.aula.assign.crudApp.documents.taskItem;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface taskRepository extends MongoRepository<taskItem, String> {

    @Query("{'_id': ?0}")
    @Update("{'$set': ?1}")
    Integer updateTask(String id, taskItem updatedItem);

}
