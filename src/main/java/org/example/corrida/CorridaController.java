package org.example.corrida;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/corridas")
public class CorridaController {

    @Autowired
    private CorridaService corridaService;

    @GetMapping
    public List<Corrida> listarCorridas() {
        return corridaService.getCorridas();
    }

    @PostMapping
    public void cadastrarCorrida(@RequestBody Corrida corrida) {
        corridaService.salvarCorrida(corrida);
    }

    @GetMapping("/{id}")
    public Corrida buscarCorrida(@PathVariable String id) {
        return corridaService.getCorrida(id);
    }

    @DeleteMapping("/{id}")
    public Corrida deletarCorrida(@PathVariable String id) {
        return corridaService.removerCorrida(id);
    }

    @PutMapping("/{id}")
    public Corrida atualizarCorrida(@PathVariable String id, @RequestBody Corrida corrida) {
        return corridaService.editarCorrida(id, corrida);
    }
}
