package org.example.split;

import org.example.corrida.Corrida;
import org.example.passageiro.Passageiro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/splits")
public class SplitController {

    @Autowired
    private SplitService splitService;

    // Rota para criar uma divisão de pagamento
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Split criarSplit(@RequestBody SplitRequest splitRequest) {
        Corrida corrida = new Corrida(); // Simulação de criação de corrida
        corrida.setId(splitRequest.getCorridaId());

        ArrayList<Passageiro> passageiros = new ArrayList<>();
        for (String emailPassageiro : splitRequest.getEmailPassageiros()) {
            Passageiro passageiro = new Passageiro(); // Simulação de criação de passageiro
            passageiro.setEmail(emailPassageiro);
            passageiros.add(passageiro);
        }

        return splitService.criarSplit(corrida, splitRequest.getValorTotal(), passageiros);
    }

    // Rota para realizar o pagamento de um passageiro
    @PutMapping("/{splitId}/pagamento/{passageiroEmail}")
    public Split realizarPagamento(@PathVariable int splitId, @PathVariable String passageiroEmail) {
        // Buscar o passageiro por email
        Passageiro passageiro = new Passageiro(); // Simulação de busca
        passageiro.setEmail(passageiroEmail);

        return splitService.realizarPagamento(splitId, passageiro);
    }

    // Rota para verificar se todos os passageiros pagaram
    @GetMapping("/{splitId}/todosPagaram")
    public boolean todosPagaram(@PathVariable int splitId) {
        return splitService.todosPagaram(splitId);
    }

    // Rota para consultar uma divisão de pagamento
    @GetMapping("/{splitId}")
    public Split getSplit(@PathVariable int splitId) {
        return splitService.getSplit(splitId);
    }
}
