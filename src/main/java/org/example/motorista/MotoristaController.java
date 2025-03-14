package org.example.motorista;

import org.example.carro.Carro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/motoristas")
public class MotoristaController {

    @Autowired
    private MotoristaService motoristaService;

    @GetMapping
    public HashMap<String, Motorista> getMotoristas() {
        return motoristaService.getMotoristas();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String salvarMotorista(@RequestBody Motorista motorista) {
        if (motorista.getNome() == null) {
            return "Nome não pode ser nulo";
        }

        if (motorista.getCpf() == null) {
            return "CPF não pode ser nulo";
        }

        motoristaService.salvarMotorista(motorista);
        return "Motorista salvo com sucesso";
    }

    @GetMapping("/{cpf}")
    public Motorista getMotorista(@PathVariable String cpf) {
        return motoristaService.getMotorista(cpf);
    }

    @DeleteMapping("/{cpf}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String excluirMotorista(@PathVariable String cpf) {
        Motorista motorista = motoristaService.removerMotorista(cpf);
        if (motorista != null) {
            return "Motorista removido com sucesso";
        }
        return "Motorista não encontrado";
    }

    @PutMapping("/{cpf}")
    public String editarMotorista(@PathVariable String cpf, @RequestBody Motorista motorista) {
        Motorista motoristaRetorno = motoristaService.editarMotorista(cpf, motorista);
        if (motoristaRetorno != null) {
            return "Motorista alterado com sucesso";
        }
        return "Motorista não encontrado";
    }

    // Endpoint para associar um carro a um motorista
    @PutMapping("/{cpf}/carro")
    public String associarCarroAoMotorista(@PathVariable String cpf, @RequestBody Carro carro) {
        Motorista motorista = motoristaService.associarCarroAoMotorista(cpf, carro);
        if (motorista != null) {
            return "Carro associado com sucesso ao motorista";
        }
        return "Motorista não encontrado";
    }
}
