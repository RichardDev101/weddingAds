package dev.projects.backend.repository;

import dev.projects.backend.collection.Advertisement;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdRepository extends MongoRepository<Advertisement, String> {

}
