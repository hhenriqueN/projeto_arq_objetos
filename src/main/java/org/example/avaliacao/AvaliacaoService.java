package org.example.avaliacao;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AvaliacaoService {

    private List<Avaliacao> avaliacoes = new ArrayList<>();
    private int proximoId = 1;

    public Avaliacao salvar(Avaliacao avaliacao) {
        avaliacao.setId(proximoId++);
        avaliacoes.add(avaliacao);
        return avaliacao;
    }

    public List<Avaliacao> listarTodas() {
        return avaliacoes;
    }

    public Avaliacao buscarPorId(int id) {
        return avaliacoes.stream()
                .filter(avaliacao -> avaliacao.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Avaliacao atualizar(int id, Avaliacao novaAvaliacao) {
        Avaliacao existente = buscarPorId(id);
        if (existente != null) {
            existente.setNota(novaAvaliacao.getNota());
            existente.setComentario(novaAvaliacao.getComentario());
        }
        return existente;
    }

    public void deletar(int id) {
        avaliacoes.removeIf(avaliacao -> avaliacao.getId() == id);
    }
}
