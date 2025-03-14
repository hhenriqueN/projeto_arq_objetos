package org.example.avaliacao;
import org.example.motorista.Motorista;
import org.example.corrida.Corrida;
import org.example.passageiro.Passageiro;


public class Avaliacao {
    private int id;
    private Corrida corrida;
    private Passageiro avaliador;
    private Motorista avaliado;
    private float nota;
    private String comentario;

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

    public Passageiro getAvaliador() {
        return avaliador;
    }

    public void setAvaliador(Passageiro avaliador) {
        this.avaliador = avaliador;
    }

    public Motorista getAvaliado() {
        return avaliado;
    }

    public void setAvaliado(Motorista avaliado) {
        this.avaliado = avaliado;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}

