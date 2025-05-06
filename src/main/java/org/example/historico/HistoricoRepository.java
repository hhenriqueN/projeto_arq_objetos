package org.example.historico;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface HistoricoRepository extends MongoRepository<Historico, String> {
}
