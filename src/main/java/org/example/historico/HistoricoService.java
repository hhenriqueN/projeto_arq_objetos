package org.example.historico;

import org.example.corrida.Corrida;
import org.example.passageiro.Passageiro;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HistoricoService {

    private List<Historico> historicos = new ArrayList<>();

    public Historico buscarPorPassageiro(String passageiroEmail) {
        return historicos.stream()
                .filter(h -> h.getPassageiro().getEmail().equals(passageiroEmail))
                .findFirst()
                .orElse(new Historico(new Passageiro("", "", passageiroEmail, "")));
    }

    public Historico adicionarCorrida(String passageiroEmail, Corrida corrida) {
        Historico historico = buscarPorPassageiro(passageiroEmail);
        historico.adicionarCorrida(corrida);
        return historico;
    }
}
