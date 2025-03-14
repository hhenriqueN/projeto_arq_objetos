package org.example.corrida;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/corridas")
public class CorridaController {

    @Autowired
    private CorridaService corridaService;

    @GetMapping
    public HashMap<Integer, Corrida> getCorridas() {
        return corridaService.getCorridas();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String salvarCorrida(@RequestBody Corrida corrida) {
        if (corrida.getMotorista() == null) {
            return "Motorista não pode ser nulo";
        }

        if (corrida.getPassageiro() == null) {
            return "Passageiro não pode ser nulo";
        }

        if (corrida.getPontoPartida() == null || corrida.getPontoDestino() == null) {
            return "Pontos de partida e destino não podem ser nulos";
        }

        corridaService.salvarCorrida(corrida);
        return "Corrida salva com sucesso";
    }

    @GetMapping("/{id}")
    public Corrida getCorrida(@PathVariable int id) {
        return corridaService.getCorrida(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String excluirCorrida(@PathVariable int id) {
        Corrida corrida = corridaService.removerCorrida(id);
        if (corrida != null) {
            return "Corrida removida com sucesso";
        }
        return "Corrida não encontrada";
    }

    @PutMapping("/{id}")
    public String editarCorrida(@PathVariable int id, @RequestBody Corrida corrida) {
        Corrida corridaRetorno = corridaService.editarCorrida(id, corrida);
        if (corridaRetorno != null) {
            return "Corrida alterada com sucesso";
        }
        return "Corrida não encontrada";
    }
}
