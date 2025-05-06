package org.example.carro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public List<Carro> getCarros() {
        return carroRepository.findAll();
    }

    public void salvarCarro(Carro carro) {
        carroRepository.save(carro);
    }

    public Carro getCarro(String placa) {
        return carroRepository.findById(placa).orElse(null);
    }

    public Carro removerCarro(String placa) {
        Carro carro = getCarro(placa);
        if (carro != null) {
            carroRepository.deleteById(placa);
        }
        return carro;
    }

    public Carro editarCarro(String placa, Carro novo) {
        Carro carro = getCarro(placa);
        if (carro != null) {
            novo.setPlaca(placa);
            return carroRepository.save(novo);
        }
        return null;
    }
}
