package org.example.historico;
import org.example.passageiro.Passageiro;
import org.example.corrida.Corrida;

import java.util.ArrayList;


public class Historico {
    private Passageiro passageiro;
    private ArrayList<Corrida> corridas;

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }

    public ArrayList<Corrida> getCorridas() {
        return corridas;
    }

    public void setCorridas(ArrayList<Corrida> corridas) {
        this.corridas = corridas;
    }
}
