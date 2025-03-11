package org.example.split;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/splits")
public class SplitController {

    @Autowired
    private SplitService splitService;

    @PostMapping
    public Split criarSplit(@RequestBody Split split) {
        return splitService.salvar(split);
    }

    @GetMapping
    public List<Split> listarSplits() {
        return splitService.listarTodos();
    }

    @GetMapping("/{id}")
    public Split buscarSplit(@PathVariable int id) {
        return splitService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Split atualizarSplit(@PathVariable int id, @RequestBody Split split) {
        return splitService.atualizar(id, split);
    }

    @DeleteMapping("/{id}")
    public void deletarSplit(@PathVariable int id) {
        splitService.deletar(id);
    }

    @PutMapping("/{id}/pagar/{email}")
    public void marcarComoPago(@PathVariable int id, @PathVariable String email) {
        splitService.marcarComoPago(id, email);
    }
}
