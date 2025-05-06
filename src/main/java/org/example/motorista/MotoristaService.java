package org.example.motorista;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoristaService {

    @Autowired
    private MotoristaRepository motoristaRepository;

    public List<Motorista> getMotoristas() {
        return motoristaRepository.findAll();
    }

    public void salvarMotorista(Motorista motorista) {
        motoristaRepository.save(motorista);
    }

    public Motorista getMotorista(String cpf) {
        return motoristaRepository.findById(cpf).orElse(null);
    }

    public void removerMotorista(String cpf) {
        motoristaRepository.deleteById(cpf);
    }
}
