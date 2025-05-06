package org.example.passageiro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassageiroService {

    @Autowired
    private PassageiroRepository passageiroRepository;

    public List<Passageiro> getPassageiros() {
        return passageiroRepository.findAll();
    }

    public void salvarPassageiro(Passageiro passageiro) {
        passageiroRepository.save(passageiro);
    }

    public Passageiro getPassageiro(String cpf) {
        return passageiroRepository.findById(cpf).orElse(null);
    }

    public Passageiro removerPassageiro(String cpf) {
        Passageiro passageiro = getPassageiro(cpf);
        if (passageiro != null) {
            passageiroRepository.deleteById(cpf);
        }
        return passageiro;
    }

    public Passageiro editarPassageiro(String cpf, Passageiro novo) {
        Passageiro passageiro = getPassageiro(cpf);
        if (passageiro != null) {
            novo.setCpf(cpf);
            return passageiroRepository.save(novo);
        }
        return null;
    }
}
