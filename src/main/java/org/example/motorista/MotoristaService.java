package org.example.motorista;

import org.example.carro.Carro;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class MotoristaService {

    private HashMap<String, Motorista> motoristas = new HashMap<>();

    public HashMap<String, Motorista> getMotoristas() {
        return motoristas;
    }

    public void salvarMotorista(Motorista motorista) {
        motoristas.put(motorista.getCpf(), motorista);
    }

    public Motorista getMotorista(String cpf) {
        return motoristas.get(cpf);
    }

    public Motorista removerMotorista(String cpf) {
        return motoristas.remove(cpf);
    }

    public Motorista editarMotorista(String cpf, Motorista motorista) {
        Motorista motoristaEditar = getMotorista(cpf);

        if (motoristaEditar != null) {
            if (motorista.getNome() != null) {
                motoristaEditar.setNome(motorista.getNome());
            }

            if (motorista.getTelefone() != null) {
                motoristaEditar.setTelefone(motorista.getTelefone());
            }

            if (motorista.isDisponivel() != motoristaEditar.isDisponivel()) {
                motoristaEditar.setDisponivel(motorista.isDisponivel());
            }

            // Atualizando o carro do motorista
            if (motorista.getCarro() != null) {
                motoristaEditar.setCarro(motorista.getCarro());
            }
        }
        return motoristaEditar;
    }

    // Método para associar um carro ao motorista
    public Motorista associarCarroAoMotorista(String cpf, Carro carro) {
        Motorista motorista = getMotorista(cpf);
        if (motorista != null) {
            motorista.setCarro(carro);
        }
        return motorista;
    }
}
