package org.example.pagamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @PostMapping
    public Pagamento criarPagamento(@RequestBody Pagamento pagamento) {
        return pagamentoService.salvar(pagamento);
    }

    @GetMapping
    public List<Pagamento> listarPagamentos() {
        return pagamentoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Pagamento buscarPagamento(@PathVariable int id) {
        return pagamentoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Pagamento atualizarPagamento(@PathVariable int id, @RequestBody Pagamento pagamento) {
        return pagamentoService.atualizar(id, pagamento);
    }

    @DeleteMapping("/{id}")
    public void deletarPagamento(@PathVariable int id) {
        pagamentoService.deletar(id);
    }
}
