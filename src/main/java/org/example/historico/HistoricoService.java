package org.example.historico;

import org.example.passageiro.Passageiro;
import org.example.corrida.Corrida;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.ArrayList;

@Service
public class HistoricoService {

    private HashMap<String, Historico> historicos = new HashMap<>();

    // Método para buscar o histórico de corridas de um passageiro
    public Historico getHistorico(Passageiro passageiro) {
        return historicos.get(passageiro.getEmail());
    }

    // Método para adicionar uma corrida ao histórico de um passageiro
    public void adicionarCorridaAoHistorico(Passageiro passageiro, Corrida corrida) {
        Historico historico = historicos.get(passageiro.getEmail());

        if (historico == null) {
            historico = new Historico();
            historico.setPassageiro(passageiro);
            historico.setCorridas(new ArrayList<>());
            historicos.put(passageiro.getEmail(), historico);
        }

        historico.getCorridas().add(corrida);
    }

    // Método para remover um histórico de corridas de um passageiro
    public void removerHistorico(Passageiro passageiro) {
        historicos.remove(passageiro.getEmail());
    }
}
