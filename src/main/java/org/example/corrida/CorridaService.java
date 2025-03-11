package org.example.corrida;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CorridaService {

    private List<Corrida> corridas = new ArrayList<>();
    private int proximoId = 1;

    public Corrida salvar(Corrida corrida) {
        corrida.setId(proximoId++);
        corrida.setStatus("Solicitada");
        corridas.add(corrida);
        return corrida;
    }

    public List<Corrida> listarTodas() {
        return corridas;
    }

    public Corrida buscarPorId(int id) {
        return corridas.stream()
                .filter(corrida -> corrida.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Corrida atualizar(int id, Corrida novaCorrida) {
        Corrida existente = buscarPorId(id);
        if (existente != null) {
            existente.setPontoPartida(novaCorrida.getPontoPartida());
            existente.setPontoDestino(novaCorrida.getPontoDestino());
            existente.setPreco(novaCorrida.getPreco());
            existente.setStatus(novaCorrida.getStatus());
        }
        return existente;
    }

    public void deletar(int id) {
        corridas.removeIf(corrida -> corrida.getId() == id);
    }
}
