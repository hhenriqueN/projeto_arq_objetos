package org.example.passageiro;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PassageiroService {

    private List<Passageiro> passageiros = new ArrayList<>();

    public Passageiro salvar(Passageiro passageiro) {
        passageiros.add(passageiro);
        return passageiro;
    }

    public List<Passageiro> listarTodos() {
        return passageiros;
    }

    public Passageiro buscarPorEmail(String email) {
        return passageiros.stream()
                .filter(passageiro -> passageiro.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    public Passageiro atualizar(String email, Passageiro novoPassageiro) {
        Passageiro existente = buscarPorEmail(email);
        if (existente != null) {
            existente.setNome(novoPassageiro.getNome());
            existente.setTelefone(novoPassageiro.getTelefone());
            existente.setFormaPagamento(novoPassageiro.getFormaPagamento());
        }
        return existente;
    }

    public void deletar(String email) {
        passageiros.removeIf(passageiro -> passageiro.getEmail().equals(email));
    }
}
