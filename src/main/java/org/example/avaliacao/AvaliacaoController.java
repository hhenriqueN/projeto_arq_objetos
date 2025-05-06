package org.example.avaliacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;

    @GetMapping
    public List<Avaliacao> listarAvaliacoes() {
        return avaliacaoService.getAvaliacoes();
    }

    @PostMapping
    public void cadastrarAvaliacao(@RequestBody Avaliacao avaliacao) {
        avaliacaoService.salvarAvaliacao(avaliacao);
    }

    @GetMapping("/{id}")
    public Avaliacao buscarAvaliacao(@PathVariable String id) {
        return avaliacaoService.getAvaliacao(id);
    }

    @DeleteMapping("/{id}")
    public Avaliacao deletarAvaliacao(@PathVariable String id) {
        return avaliacaoService.removerAvaliacao(id);
    }

    @PutMapping("/{id}")
    public Avaliacao atualizarAvaliacao(@PathVariable String id, @RequestBody Avaliacao avaliacao) {
        return avaliacaoService.editarAvaliacao(id, avaliacao);
    }
}
