package org.example.carro;

import org.example.motorista.Motorista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/carros")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @GetMapping
    public HashMap<String, Carro> getCarros() {
        return carroService.getCarros();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String salvarCarro(@RequestBody Carro carro) {
        if (carro.getModelo() == null) {
            return "Modelo não pode ser nulo";
        }

        if (carro.getPlaca() == null) {
            return "Placa não pode ser nula";
        }

        carroService.salvarCarro(carro);
        return "Carro salvo com sucesso";
    }

    @GetMapping("/{placa}")
    public Carro getCarro(@PathVariable String placa) {
        return carroService.getCarro(placa);
    }

    @DeleteMapping("/{placa}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String excluirCarro(@PathVariable String placa) {
        Carro carro = carroService.removerCarro(placa);
        if (carro != null) {
            return "Carro removido com sucesso";
        }
        return "Carro não encontrado";
    }

    @PutMapping("/{placa}")
    public String editarCarro(@PathVariable String placa, @RequestBody Carro carro) {
        Carro carroRetorno = carroService.editarCarro(placa, carro);
        if (carroRetorno != null) {
            return "Carro alterado com sucesso";
        }
        return "Carro não encontrado";
    }

    // Endpoint para associar um motorista a um carro
    @PutMapping("/{placa}/motorista")
    public String associarMotoristaAoCarro(@PathVariable String placa, @RequestBody Motorista motorista) {
        Carro carro = carroService.getCarro(placa);
        if (carro != null) {
            carro.setMotorista(motorista);
            return "Motorista associado ao carro com sucesso";
        }
        return "Carro não encontrado";
    }
}
