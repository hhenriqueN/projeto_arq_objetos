package org.example.pagamento;

import org.example.passageiro.Passageiro;
import org.example.corrida.Corrida;

public class Pagamento {
    private int id;
    private Corrida corrida;
    private Passageiro passageiro;
    private double valor;
    private String formaPagamento;
    private boolean pago;

    public Pagamento() {
    }

    public Pagamento(int id, Corrida corrida, Passageiro passageiro, double valor, String formaPagamento, boolean pago) {
        this.id = id;
        this.corrida = corrida;
        this.passageiro = passageiro;
        this.valor = valor;
        this.formaPagamento = formaPagamento;
        this.pago = pago;
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

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }
}
