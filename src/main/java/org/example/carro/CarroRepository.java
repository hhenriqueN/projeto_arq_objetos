package org.example.carro;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarroRepository extends MongoRepository<Carro, String> {
}
