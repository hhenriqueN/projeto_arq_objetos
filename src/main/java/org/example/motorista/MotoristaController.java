package org.example.motorista;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/motoristas")
public class MotoristaController {

    @Autowired
    private MotoristaService motoristaService;

    @GetMapping
    public List<Motorista> getMotoristas() {
        return motoristaService.getMotoristas();
    }

    @PostMapping
    public String salvarMotorista(@RequestBody Motorista motorista) {
        motoristaService.salvarMotorista(motorista);
        return "Motorista salvo com sucesso!";
    }

    @GetMapping("/{cpf}")
    public Motorista getMotorista(@PathVariable String cpf) {
        return motoristaService.getMotorista(cpf);
    }

    @DeleteMapping("/{cpf}")
    public void removerMotorista(@PathVariable String cpf) {
        motoristaService.removerMotorista(cpf);
    }
}
