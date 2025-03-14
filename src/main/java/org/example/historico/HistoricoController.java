package org.example.historico;

import org.example.passageiro.Passageiro;
import org.example.corrida.Corrida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/historicos")
public class HistoricoController {

    @Autowired
    private HistoricoService historicoService;

    @GetMapping("/{email}")
    public Historico getHistorico(@PathVariable String email) {
        // Aqui você pode buscar o passageiro com o e-mail fornecido
        // para usar no serviço de histórico
        Passageiro passageiro = new Passageiro(); // Simulação de criação de passageiro
        passageiro.setEmail(email);
        return historicoService.getHistorico(passageiro);
    }

    @PostMapping("/{email}/corridas")
    @ResponseStatus(HttpStatus.CREATED)
    public String adicionarCorridaAoHistorico(@PathVariable String email, @RequestBody Corrida corrida) {
        // Aqui você pode buscar o passageiro com o e-mail fornecido
        // para associar a corrida ao histórico
        Passageiro passageiro = new Passageiro(); // Simulação de criação de passageiro
        passageiro.setEmail(email);
        historicoService.adicionarCorridaAoHistorico(passageiro, corrida);
        return "Corrida adicionada ao histórico com sucesso";
    }

    @DeleteMapping("/{email}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String removerHistorico(@PathVariable String email) {
        // Aqui você pode buscar o passageiro com o e-mail fornecido
        // para remover o histórico
        Passageiro passageiro = new Passageiro(); // Simulação de criação de passageiro
        passageiro.setEmail(email);
        historicoService.removerHistorico(passageiro);
        return "Histórico de corridas removido com sucesso";
    }
}
