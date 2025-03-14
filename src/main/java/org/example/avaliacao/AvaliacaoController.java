package org.example.avaliacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;

    @GetMapping
    public HashMap<Integer, Avaliacao> getAvaliacoes() {
        return avaliacaoService.getAvaliacoes();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String salvarAvaliacao(@RequestBody Avaliacao avaliacao) {
        if (avaliacao.getNota() <= 0) {
            return "Nota não pode ser menor ou igual a zero";
        }

        if (avaliacao.getAvaliador() == null) {
            return "Passageiro avaliador não pode ser nulo";
        }

        if (avaliacao.getAvaliado() == null) {
            return "Motorista avaliado não pode ser nulo";
        }

        if (avaliacao.getCorrida() == null) {
            return "Corrida não pode ser nula";
        }

        avaliacaoService.salvarAvaliacao(avaliacao);
        return "Avaliação salva com sucesso";
    }

    @GetMapping("/{id}")
    public Avaliacao getAvaliacao(@PathVariable int id) {
        return avaliacaoService.getAvaliacao(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String excluirAvaliacao(@PathVariable int id) {
        Avaliacao avaliacao = avaliacaoService.removerAvaliacao(id);
        if (avaliacao != null) {
            return "Avaliação removida com sucesso";
        }
        return "Avaliação não encontrada";
    }

    @PutMapping("/{id}")
    public String editarAvaliacao(@PathVariable int id, @RequestBody Avaliacao avaliacao) {
        Avaliacao avaliacaoRetorno = avaliacaoService.editarAvaliacao(id, avaliacao);
        if (avaliacaoRetorno != null) {
            return "Avaliação alterada com sucesso";
        }
        return "Avaliação não encontrada";
    }
}
