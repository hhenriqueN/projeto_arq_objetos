package org.example.corrida;

import org.example.motorista.Motorista;
import org.example.passageiro.Passageiro;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CorridaService {

    private HashMap<Integer, Corrida> corridas = new HashMap<>();

    // Método para buscar todas as corridas
    public HashMap<Integer, Corrida> getCorridas() {
        return corridas;
    }

    // Método para salvar uma corrida
    public void salvarCorrida(Corrida corrida) {
        corridas.put(corrida.getId(), corrida);
    }

    // Método para buscar uma corrida pelo ID
    public Corrida getCorrida(int id) {
        return corridas.get(id);
    }

    // Método para remover uma corrida
    public Corrida removerCorrida(int id) {
        return corridas.remove(id);
    }

    // Método para editar uma corrida
    public Corrida editarCorrida(int id, Corrida corrida) {
        Corrida corridaEditar = getCorrida(id);

        if (corridaEditar != null) {
            if (corrida.getPassageiro() != null) {
                corridaEditar.setPassageiro(corrida.getPassageiro());
            }

            if (corrida.getMotorista() != null) {
                corridaEditar.setMotorista(corrida.getMotorista());
            }

            if (corrida.getPontoPartida() != null) {
                corridaEditar.setPontoPartida(corrida.getPontoPartida());
            }

            if (corrida.getPontoDestino() != null) {
                corridaEditar.setPontoDestino(corrida.getPontoDestino());
            }

            if (corrida.getPreco() > 0) {
                corridaEditar.setPreco(corrida.getPreco());
            }

            if (corrida.getStatus() != null) {
                corridaEditar.setStatus(corrida.getStatus());
            }
        }
        return corridaEditar;
    }
}
