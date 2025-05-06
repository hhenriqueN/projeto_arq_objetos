package org.example.pagamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @GetMapping
    public List<Pagamento> listarPagamentos() {
        return pagamentoService.getPagamentos();
    }

    @PostMapping
    public void cadastrarPagamento(@RequestBody Pagamento pagamento) {
        pagamentoService.salvarPagamento(pagamento);
    }

    @GetMapping("/{id}")
    public Pagamento buscarPagamento(@PathVariable String id) {
        return pagamentoService.getPagamento(id);
    }

    @DeleteMapping("/{id}")
    public Pagamento deletarPagamento(@PathVariable String id) {
        return pagamentoService.removerPagamento(id);
    }

    @PutMapping("/{id}")
    public Pagamento atualizarPagamento(@PathVariable String id, @RequestBody Pagamento pagamento) {
        return pagamentoService.editarPagamento(id, pagamento);
    }
}
