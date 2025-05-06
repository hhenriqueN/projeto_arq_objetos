package org.example.split;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SplitRepository extends MongoRepository<Split, String> {
}
