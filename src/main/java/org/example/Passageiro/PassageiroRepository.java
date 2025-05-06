package org.example.passageiro;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PassageiroRepository extends MongoRepository<Passageiro, String> {
}
