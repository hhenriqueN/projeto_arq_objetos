package org.example.corrida;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/corridas")
public class CorridaController {

    @Autowired
    private CorridaService corridaService;

    @PostMapping
    public Corrida criarCorrida(@RequestBody Corrida corrida) {
        return corridaService.salvar(corrida);
    }

    @GetMapping
    public List<Corrida> listarCorridas() {
        return corridaService.listarTodas();
    }

    @GetMapping("/{id}")
    public Corrida buscarCorrida(@PathVariable int id) {
        return corridaService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Corrida atualizarCorrida(@PathVariable int id, @RequestBody Corrida corrida) {
        return corridaService.atualizar(id, corrida);
    }

    @DeleteMapping("/{id}")
    public void deletarCorrida(@PathVariable int id) {
        corridaService.deletar(id);
    }
}
