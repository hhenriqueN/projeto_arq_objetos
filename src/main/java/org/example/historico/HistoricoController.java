package org.example.historico;

import org.example.corrida.Corrida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/historicos")
public class HistoricoController {

    @Autowired
    private HistoricoService historicoService;

    @GetMapping("/{passageiroEmail}")
    public Historico buscarHistorico(@PathVariable String passageiroEmail) {
        return historicoService.buscarPorPassageiro(passageiroEmail);
    }

    @PostMapping("/{passageiroEmail}/adicionarCorrida")
    public Historico adicionarCorrida(@PathVariable String passageiroEmail, @RequestBody Corrida corrida) {
        return historicoService.adicionarCorrida(passageiroEmail, corrida);
    }
}
