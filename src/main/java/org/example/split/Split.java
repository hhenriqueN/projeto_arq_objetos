package org.example.split;
import org.example.corrida.Corrida;
import org.example.passageiro.Passageiro;

import java.util.ArrayList;
import java.util.HashMap;

public class Split {
    private int id;
    private Corrida corrida;
    private ArrayList<Passageiro> passageiros;
    private double valorPorPessoa;
    private HashMap<Passageiro, Boolean> statusPagamento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Corrida getCorrida() {
        return corrida;
    }

    public void setCorrida(Corrida corrida) {
        this.corrida = corrida;
    }

    public ArrayList<Passageiro> getPassageiros() {
        return passageiros;
    }

    public void setPassageiros(ArrayList<Passageiro> passageiros) {
        this.passageiros = passageiros;
    }

    public double getValorPorPessoa() {
        return valorPorPessoa;
    }

    public void setValorPorPessoa(double valorPorPessoa) {
        this.valorPorPessoa = valorPorPessoa;
    }

    public HashMap<Passageiro, Boolean> getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(HashMap<Passageiro, Boolean> statusPagamento) {
        this.statusPagamento = statusPagamento;
    }
}
