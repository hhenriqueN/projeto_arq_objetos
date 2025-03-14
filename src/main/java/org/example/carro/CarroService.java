package org.example.carro;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CarroService {

    private HashMap<String, Carro> carros = new HashMap<>();

    public HashMap<String, Carro> getCarros() {
        return carros;
    }

    public void salvarCarro(Carro carro) {
        carros.put(carro.getPlaca(), carro);
    }

    public Carro getCarro(String placa) {
        return carros.get(placa);
    }

    public Carro removerCarro(String placa) {
        return carros.remove(placa);
    }

    public Carro editarCarro(String placa, Carro carro) {
        Carro carroEditar = getCarro(placa);

        if (carroEditar != null) {
            if (carro.getModelo() != null) {
                carroEditar.setModelo(carro.getModelo());
            }

            if (carro.getCor() != null) {
                carroEditar.setCor(carro.getCor());
            }

            if (carro.getAno() != 0) {
                carroEditar.setAno(carro.getAno());
            }

            if (carro.getMotorista() != null) {
                carroEditar.setMotorista(carro.getMotorista());
            }
        }
        return carroEditar;
    }
}
