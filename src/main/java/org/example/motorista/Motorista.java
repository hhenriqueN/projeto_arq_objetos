package org.example.motorista;

import org.example.carro.Carro;

public class Motorista {
    private String nome;
    private String cpf;
    private String telefone;
    private double avaliacao;
    private Carro carro;
    private boolean disponivel;

    public Motorista() {
    }

    public Motorista(String nome, String cpf, String telefone, Carro carro) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.avaliacao = 5.0; // Motorista começa com avaliação máxima
        this.carro = carro;
        this.disponivel = true; // Motorista começa como disponível
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
