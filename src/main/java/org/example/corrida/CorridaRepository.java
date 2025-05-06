package org.example.corrida;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CorridaRepository extends MongoRepository<Corrida, String> {
}
