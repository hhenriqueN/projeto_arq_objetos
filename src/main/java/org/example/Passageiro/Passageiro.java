package org.example.passageiro;

public class Passageiro {
    private String nome;
    private String telefone;
    private String email;
    private String formaPagamento; // "Cartão", "Pix", "Dinheiro"

    public Passageiro() {
    }

    public Passageiro(String nome, String telefone, String email, String formaPagamento) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.formaPagamento = formaPagamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
}
