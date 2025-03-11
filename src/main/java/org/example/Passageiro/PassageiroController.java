package org.example.passageiro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passageiros")
public class PassageiroController {

    @Autowired
    private PassageiroService passageiroService;

    @PostMapping
    public Passageiro criarPassageiro(@RequestBody Passageiro passageiro) {
        return passageiroService.salvar(passageiro);
    }

    @GetMapping
    public List<Passageiro> listarPassageiros() {
        return passageiroService.listarTodos();
    }

    @GetMapping("/{email}")
    public Passageiro buscarPassageiro(@PathVariable String email) {
        return passageiroService.buscarPorEmail(email);
    }

    @PutMapping("/{email}")
    public Passageiro atualizarPassageiro(@PathVariable String email, @RequestBody Passageiro passageiro) {
        return passageiroService.atualizar(email, passageiro);
    }

    @DeleteMapping("/{email}")
    public void deletarPassageiro(@PathVariable String email) {
        passageiroService.deletar(email);
    }
}
