package org.example.avaliacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;

    @PostMapping
    public Avaliacao criarAvaliacao(@RequestBody Avaliacao avaliacao) {
        return avaliacaoService.salvar(avaliacao);
    }

    @GetMapping
    public List<Avaliacao> listarAvaliacoes() {
        return avaliacaoService.listarTodas();
    }

    @GetMapping("/{id}")
    public Avaliacao buscarAvaliacao(@PathVariable int id) {
        return avaliacaoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Avaliacao atualizarAvaliacao(@PathVariable int id, @RequestBody Avaliacao avaliacao) {
        return avaliacaoService.atualizar(id, avaliacao);
    }

    @DeleteMapping("/{id}")
    public void deletarAvaliacao(@PathVariable int id) {
        avaliacaoService.deletar(id);
    }
}
