package org.example.avaliacao;

import org.example.motorista.Motorista;
import org.example.corrida.Corrida;
import org.example.passageiro.Passageiro;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AvaliacaoService {

    private HashMap<Integer, Avaliacao> avaliacoes = new HashMap<>();

    // Método para buscar todas as avaliações
    public HashMap<Integer, Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    // Método para salvar uma avaliação
    public void salvarAvaliacao(Avaliacao avaliacao) {
        avaliacoes.put(avaliacao.getId(), avaliacao);
    }

    // Método para buscar uma avaliação pelo ID
    public Avaliacao getAvaliacao(int id) {
        return avaliacoes.get(id);
    }

    // Método para remover uma avaliação
    public Avaliacao removerAvaliacao(int id) {
        return avaliacoes.remove(id);
    }

    // Método para editar uma avaliação
    public Avaliacao editarAvaliacao(int id, Avaliacao avaliacao) {
        Avaliacao avaliacaoEditar = getAvaliacao(id);

        if (avaliacaoEditar != null) {
            if (avaliacao.getNota() > 0) {
                avaliacaoEditar.setNota(avaliacao.getNota());
            }

            if (avaliacao.getComentario() != null) {
                avaliacaoEditar.setComentario(avaliacao.getComentario());
            }

            if (avaliacao.getAvaliador() != null) {
                avaliacaoEditar.setAvaliador(avaliacao.getAvaliador());
            }

            if (avaliacao.getAvaliado() != null) {
                avaliacaoEditar.setAvaliado(avaliacao.getAvaliado());
            }

            if (avaliacao.getCorrida() != null) {
                avaliacaoEditar.setCorrida(avaliacao.getCorrida());
            }
        }
        return avaliacaoEditar;
    }
}
