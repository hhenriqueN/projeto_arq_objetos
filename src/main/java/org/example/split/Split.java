package org.example.split;

import org.example.passageiro.Passageiro;
import org.example.corrida.Corrida;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Split {
    private int id;
    private Corrida corrida;
    private List<Passageiro> passageiros;
    private double valorPorPessoa;
    private Map<String, Boolean> statusPagamento; // Armazena email do passageiro e status de pagamento

    public Split() {
        this.passageiros = new ArrayList<>();
        this.statusPagamento = new HashMap<>();
    }

    public Split(int id, Corrida corrida, List<Passageiro> passageiros, double valorPorPessoa) {
        this.id = id;
        this.corrida = corrida;
        this.passageiros = passageiros;
        this.valorPorPessoa = valorPorPessoa;
        this.statusPagamento = new HashMap<>();
        for (Passageiro passageiro : passageiros) {
            this.statusPagamento.put(passageiro.getEmail(), false);
        }
    }

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

    public List<Passageiro> getPassageiros() {
        return passageiros;
    }

    public void setPassageiros(List<Passageiro> passageiros) {
        this.passageiros = passageiros;
    }

    public double getValorPorPessoa() {
        return valorPorPessoa;
    }

    public void setValorPorPessoa(double valorPorPessoa) {
        this.valorPorPessoa = valorPorPessoa;
    }

    public Map<String, Boolean> getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(Map<String, Boolean> statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public void marcarComoPago(String passageiroEmail) {
        if (statusPagamento.containsKey(passageiroEmail)) {
            statusPagamento.put(passageiroEmail, true);
        }
    }
}
