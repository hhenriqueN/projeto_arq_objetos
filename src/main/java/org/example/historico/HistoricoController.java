package org.example.historico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historicos")
public class HistoricoController {

    @Autowired
    private HistoricoService historicoService;

    @GetMapping
    public List<Historico> listarHistoricos() {
        return historicoService.getHistoricos();
    }

    @PostMapping
    public void cadastrarHistorico(@RequestBody Historico historico) {
        historicoService.salvarHistorico(historico);
    }

    @GetMapping("/{id}")
    public Historico buscarHistorico(@PathVariable String id) {
        return historicoService.getHistorico(id);
    }

    @DeleteMapping("/{id}")
    public Historico deletarHistorico(@PathVariable String id) {
        return historicoService.removerHistorico(id);
    }

    @PutMapping("/{id}")
    public Historico atualizarHistorico(@PathVariable String id, @RequestBody Historico historico) {
        return historicoService.editarHistorico(id, historico);
    }
}
