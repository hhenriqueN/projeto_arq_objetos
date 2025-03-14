package org.example.pagamento;

import org.example.corrida.Corrida;
import org.example.passageiro.Passageiro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    // Rota para criar um pagamento
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pagamento criarPagamento(@RequestBody PagamentoRequest pagamentoRequest) {
        Passageiro passageiro = new Passageiro(); // Simulação de criação de passageiro
        passageiro.setEmail(pagamentoRequest.getEmailPassageiro());

        Corrida corrida = new Corrida(); // Simulação de criação de corrida
        corrida.setId(pagamentoRequest.getCorridaId());

        return pagamentoService.criarPagamento(passageiro, corrida, pagamentoRequest.getValor(), pagamentoRequest.getFormaPagamento());
    }

    // Rota para realizar o pagamento
    @PutMapping("/{pagamentoId}")
    public Pagamento realizarPagamento(@PathVariable int pagamentoId) {
        return pagamentoService.realizarPagamento(pagamentoId);
    }

    // Rota para consultar um pagamento
    @GetMapping("/{pagamentoId}")
    public Pagamento getPagamento(@PathVariable int pagamentoId) {
        return pagamentoService.getPagamento(pagamentoId);
    }
}
