package org.example.pagamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    public List<Pagamento> getPagamentos() {
        return pagamentoRepository.findAll();
    }

    public void salvarPagamento(Pagamento pagamento) {
        pagamentoRepository.save(pagamento);
    }

    public Pagamento getPagamento(String id) {
        return pagamentoRepository.findById(id).orElse(null);
    }

    public Pagamento removerPagamento(String id) {
        Pagamento pagamento = getPagamento(id);
        if (pagamento != null) {
            pagamentoRepository.deleteById(id);
        }
        return pagamento;
    }

    public Pagamento editarPagamento(String id, Pagamento novo) {
        Pagamento pagamento = getPagamento(id);
        if (pagamento != null) {
            novo.setId(id);
            return pagamentoRepository.save(novo);
        }
        return null;
    }
}
