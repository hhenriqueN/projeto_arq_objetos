package org.example.avaliacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    public List<Avaliacao> getAvaliacoes() {
        return avaliacaoRepository.findAll();
    }

    public void salvarAvaliacao(Avaliacao avaliacao) {
        avaliacaoRepository.save(avaliacao);
    }

    public Avaliacao getAvaliacao(String id) {
        return avaliacaoRepository.findById(id).orElse(null);
    }

    public Avaliacao removerAvaliacao(String id) {
        Avaliacao avaliacao = getAvaliacao(id);
        if (avaliacao != null) {
            avaliacaoRepository.deleteById(id);
        }
        return avaliacao;
    }

    public Avaliacao editarAvaliacao(String id, Avaliacao nova) {
        Avaliacao avaliacao = getAvaliacao(id);
        if (avaliacao != null) {
            nova.setId(id);
            return avaliacaoRepository.save(nova);
        }
        return null;
    }
}
