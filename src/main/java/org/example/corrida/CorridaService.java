package org.example.corrida;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorridaService {

    @Autowired
    private CorridaRepository corridaRepository;

    public List<Corrida> getCorridas() {
        return corridaRepository.findAll();
    }

    public void salvarCorrida(Corrida corrida) {
        corridaRepository.save(corrida);
    }

    public Corrida getCorrida(String id) {
        return corridaRepository.findById(id).orElse(null);
    }

    public Corrida removerCorrida(String id) {
        Corrida corrida = getCorrida(id);
        if (corrida != null) {
            corridaRepository.deleteById(id);
        }
        return corrida;
    }

    public Corrida editarCorrida(String id, Corrida nova) {
        Corrida corrida = getCorrida(id);
        if (corrida != null) {
            nova.setId(id);
            return corridaRepository.save(nova);
        }
        return null;
    }
}
