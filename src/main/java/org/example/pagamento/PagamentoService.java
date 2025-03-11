package org.example.pagamento;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PagamentoService {

    private List<Pagamento> pagamentos = new ArrayList<>();
    private int proximoId = 1;

    public Pagamento salvar(Pagamento pagamento) {
        pagamento.setId(proximoId++);
        pagamento.setPago(false); // Por padrão, o pagamento não foi realizado
        pagamentos.add(pagamento);
        return pagamento;
    }

    public List<Pagamento> listarTodos() {
        return pagamentos;
    }

    public Pagamento buscarPorId(int id) {
        return pagamentos.stream()
                .filter(pagamento -> pagamento.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Pagamento atualizar(int id, Pagamento novoPagamento) {
        Pagamento existente = buscarPorId(id);
        if (existente != null) {
            existente.setFormaPagamento(novoPagamento.getFormaPagamento());
            existente.setValor(novoPagamento.getValor());
            existente.setPago(novoPagamento.isPago());
        }
        return existente;
    }

    public void deletar(int id) {
        pagamentos.removeIf(pagamento -> pagamento.getId() == id);
    }
}
