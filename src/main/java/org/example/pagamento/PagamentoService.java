package org.example.pagamento;

import org.example.corrida.Corrida;
import org.example.passageiro.Passageiro;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class PagamentoService {

    private HashMap<Integer, Pagamento> pagamentos = new HashMap<>();

    // Método para criar um pagamento
    public Pagamento criarPagamento(Passageiro passageiro, Corrida corrida, double valor, String formaPagamento) {
        Pagamento pagamento = new Pagamento();
        pagamento.setCorrida(corrida);
        pagamento.setPassageiro(passageiro);
        pagamento.setValor(valor);
        pagamento.setFormaPagamento(formaPagamento);
        pagamento.setPago(false); // Inicialmente o pagamento não está pago
        pagamento.setId(pagamentos.size() + 1); // Gerando um ID simples

        pagamentos.put(pagamento.getId(), pagamento);
        return pagamento;
    }

    // Método para marcar um pagamento como realizado
    public Pagamento realizarPagamento(int pagamentoId) {
        Pagamento pagamento = pagamentos.get(pagamentoId);
        if (pagamento != null) {
            pagamento.setPago(true);
        }
        return pagamento;
    }

    // Método para buscar um pagamento
    public Pagamento getPagamento(int pagamentoId) {
        return pagamentos.get(pagamentoId);
    }
}
