package org.example.split;

public class SplitRequest {

    private String corridaId;
    private String passageiroCpf;
    private double valor;

    public String getCorridaId() {
        return corridaId;
    }

    public void setCorridaId(String corridaId) {
        this.corridaId = corridaId;
    }

    public String getPassageiroCpf() {
        return passageiroCpf;
    }

    public void setPassageiroCpf(String passageiroCpf) {
        this.passageiroCpf = passageiroCpf;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
