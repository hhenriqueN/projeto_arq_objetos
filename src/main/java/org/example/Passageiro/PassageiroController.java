package org.example.passageiro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passageiros")
public class PassageiroController {

    @Autowired
    private PassageiroService passageiroService;

    @GetMapping
    public List<Passageiro> listarPassageiros() {
        return passageiroService.getPassageiros();
    }

    @PostMapping
    public void cadastrarPassageiro(@RequestBody Passageiro passageiro) {
        passageiroService.salvarPassageiro(passageiro);
    }

    @GetMapping("/{cpf}")
    public Passageiro buscarPassageiro(@PathVariable String cpf) {
        return passageiroService.getPassageiro(cpf);
    }

    @DeleteMapping("/{cpf}")
    public Passageiro deletarPassageiro(@PathVariable String cpf) {
        return passageiroService.removerPassageiro(cpf);
    }

    @PutMapping("/{cpf}")
    public Passageiro atualizarPassageiro(@PathVariable String cpf, @RequestBody Passageiro passageiro) {
        return passageiroService.editarPassageiro(cpf, passageiro);
    }
}
