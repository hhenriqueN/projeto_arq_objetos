package org.example.motorista;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MotoristaService {

    private List<Motorista> motoristas = new ArrayList<>();

    public Motorista salvar(Motorista motorista) {
        motorista.setDisponivel(true); // Por padrão, um novo motorista está disponível
        motorista.setAvaliacao(5.0); // Motorista começa com avaliação máxima
        motoristas.add(motorista);
        return motorista;
    }

    public List<Motorista> listarTodos() {
        return motoristas;
    }

    public Motorista buscarPorCpf(String cpf) {
        return motoristas.stream()
                .filter(motorista -> motorista.getCpf().equals(cpf))
                .findFirst()
                .orElse(null);
    }

    public Motorista atualizar(String cpf, Motorista novoMotorista) {
        Motorista existente = buscarPorCpf(cpf);
        if (existente != null) {
            existente.setNome(novoMotorista.getNome());
            existente.setTelefone(novoMotorista.getTelefone());
            existente.setCarro(novoMotorista.getCarro());
            existente.setDisponivel(novoMotorista.isDisponivel());
            existente.setAvaliacao(novoMotorista.getAvaliacao());
        }
        return existente;
    }

    public void deletar(String cpf) {
        motoristas.removeIf(motorista -> motorista.getCpf().equals(cpf));
    }
}
