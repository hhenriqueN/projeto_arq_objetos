package org.example.split;

import org.example.corrida.Corrida;
import org.example.corrida.CorridaRepository;
import org.example.passageiro.Passageiro;
import org.example.passageiro.PassageiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SplitService {

    @Autowired
    private SplitRepository splitRepository;

    @Autowired
    private CorridaRepository corridaRepository;

    @Autowired
    private PassageiroRepository passageiroRepository;

    public void salvarSplit(SplitRequest splitRequest) {
        Corrida corrida = corridaRepository.findById(splitRequest.getCorridaId()).orElse(null);
        Passageiro passageiro = passageiroRepository.findById(splitRequest.getPassageiroCpf()).orElse(null);

        if (corrida == null || passageiro == null) {
            throw new RuntimeException("Corrida ou passageiro não encontrado");
        }

        Split split = new Split();
        split.setCorrida(corrida);
        split.setPassageiro(passageiro);
        split.setValor(splitRequest.getValor());

        splitRepository.save(split);
    }

    public List<Split> listarSplits() {
        return splitRepository.findAll();
    }
}
