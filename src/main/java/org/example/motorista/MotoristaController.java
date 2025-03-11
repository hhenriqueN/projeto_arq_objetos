package org.example.motorista;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/motoristas")
public class MotoristaController {

    @Autowired
    private MotoristaService motoristaService;

    @PostMapping
    public Motorista criarMotorista(@RequestBody Motorista motorista) {
        return motoristaService.salvar(motorista);
    }

    @GetMapping
    public List<Motorista> listarMotoristas() {
        return motoristaService.listarTodos();
    }

    @GetMapping("/{cpf}")
    public Motorista buscarMotorista(@PathVariable String cpf) {
        return motoristaService.buscarPorCpf(cpf);
    }

    @PutMapping("/{cpf}")
    public Motorista atualizarMotorista(@PathVariable String cpf, @RequestBody Motorista motorista) {
        return motoristaService.atualizar(cpf, motorista);
    }

    @DeleteMapping("/{cpf}")
    public void deletarMotorista(@PathVariable String cpf) {
        motoristaService.deletar(cpf);
    }
}
