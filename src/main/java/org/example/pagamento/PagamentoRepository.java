package org.example.pagamento;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PagamentoRepository extends MongoRepository<Pagamento, String> {
}
