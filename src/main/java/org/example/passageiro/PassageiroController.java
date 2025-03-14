package org.example.passageiro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/passageiros")
public class PassageiroController {

    @Autowired
    private PassageiroService passageiroService;

    @GetMapping
    public HashMap<String, Passageiro> getPassageiros() {
        return passageiroService.getPassageiros();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String salvarPassageiro(@RequestBody Passageiro passageiro) {
        if (passageiro.getNome() == null) {
            return "Nome não pode ser nulo";
        }

        if (passageiro.getEmail() == null) {
            return "Email não pode ser nulo";
        }

        passageiroService.salvarPassageiro(passageiro);
        return "Passageiro salvo com sucesso";
    }

    @GetMapping("/{email}")
    public Passageiro getPassageiro(@PathVariable String email) {
        return passageiroService.getPassageiro(email);
    }

    @DeleteMapping("/{email}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String excluirPassageiro(@PathVariable String email) {
        Passageiro passageiro = passageiroService.removerPassageiro(email);
        if (passageiro != null) {
            return "Passageiro removido com sucesso";
        }
        return "Passageiro não encontrado";
    }

    @PutMapping("/{email}")
    public String editarPassageiro(@PathVariable String email, @RequestBody Passageiro passageiro) {
        Passageiro passageiroRetorno = passageiroService.editarPassageiro(email, passageiro);
        if (passageiroRetorno != null) {
            return "Passageiro alterado com sucesso";
        }
        return "Passageiro não encontrado";
    }
}
