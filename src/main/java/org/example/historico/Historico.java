package org.example.historico;

import org.example.passageiro.Passageiro;
import org.example.corrida.Corrida;

import java.util.ArrayList;
import java.util.List;

public class Historico {
    private Passageiro passageiro;
    private List<Corrida> corridas;

    public Historico() {
        this.corridas = new ArrayList<>();
    }

    public Historico(Passageiro passageiro) {
        this.passageiro = passageiro;
        this.corridas = new ArrayList<>();
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }

    public List<Corrida> getCorridas() {
        return corridas;
    }

    public void adicionarCorrida(Corrida corrida) {
        this.corridas.add(corrida);
    }
}
