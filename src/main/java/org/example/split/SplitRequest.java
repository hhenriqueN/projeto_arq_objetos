package org.example.split;

import java.util.List;

public class SplitRequest {

    private int corridaId;
    private double valorTotal;
    private List<String> emailPassageiros;

    public int getCorridaId() {
        return corridaId;
    }

    public void setCorridaId(int corridaId) {
        this.corridaId = corridaId;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<String> getEmailPassageiros() {
        return emailPassageiros;
    }

    public void setEmailPassageiros(List<String> emailPassageiros) {
        this.emailPassageiros = emailPassageiros;
    }
}
