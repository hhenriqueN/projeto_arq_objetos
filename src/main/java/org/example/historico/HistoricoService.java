package org.example.historico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoricoService {

    @Autowired
    private HistoricoRepository historicoRepository;

    public List<Historico> getHistoricos() {
        return historicoRepository.findAll();
    }

    public void salvarHistorico(Historico historico) {
        historicoRepository.save(historico);
    }

    public Historico getHistorico(String id) {
        return historicoRepository.findById(id).orElse(null);
    }

    public Historico removerHistorico(String id) {
        Historico historico = getHistorico(id);
        if (historico != null) {
            historicoRepository.deleteById(id);
        }
        return historico;
    }

    public Historico editarHistorico(String id, Historico novo) {
        Historico historico = getHistorico(id);
        if (historico != null) {
            novo.setId(id);
            return historicoRepository.save(novo);
        }
        return null;
    }
}
