package org.example.passageiro;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class PassageiroService {

    private HashMap<String, Passageiro> passageiros = new HashMap<>();

    public HashMap<String, Passageiro> getPassageiros() {
        return passageiros;
    }

    public void salvarPassageiro(Passageiro passageiro) {
        passageiros.put(passageiro.getEmail(), passageiro);
    }

    public Passageiro getPassageiro(String email) {
        return passageiros.get(email);
    }

    public Passageiro removerPassageiro(String email) {
        return passageiros.remove(email);
    }

    public Passageiro editarPassageiro(String email, Passageiro passageiro) {
        Passageiro passageiroEditar = getPassageiro(email);

        if (passageiroEditar != null) {
            if (passageiro.getNome() != null) {
                passageiroEditar.setNome(passageiro.getNome());
            }

            if (passageiro.getTelefone() != null) {
                passageiroEditar.setTelefone(passageiro.getTelefone());
            }

            if (passageiro.getFormaPagamento() != null) {
                passageiroEditar.setFormaPagamento(passageiro.getFormaPagamento());
            }
        }
        return passageiroEditar;
    }
}
