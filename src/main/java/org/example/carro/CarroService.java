package org.example.carro;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarroService {

    private List<Carro> carros = new ArrayList<>();

    public Carro salvar(Carro carro) {
        carros.add(carro);
        return carro;
    }

    public List<Carro> listarTodos() {
        return carros;
    }

    public Carro buscarPorPlaca(String placa) {
        return carros.stream()
                .filter(carro -> carro.getPlaca().equals(placa))
                .findFirst()
                .orElse(null);
    }

    public Carro atualizar(String placa, Carro novoCarro) {
        Carro existente = buscarPorPlaca(placa);
        if (existente != null) {
            existente.setModelo(novoCarro.getModelo());
            existente.setCor(novoCarro.getCor());
            existente.setAno(novoCarro.getAno());
            existente.setMotorista(novoCarro.getMotorista());
        }
        return existente;
    }

    public void deletar(String placa) {
        carros.removeIf(carro -> carro.getPlaca().equals(placa));
    }
}
