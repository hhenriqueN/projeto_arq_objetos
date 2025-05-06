package org.example.carro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @GetMapping
    public List<Carro> listarCarros() {
        return carroService.getCarros();
    }

    @PostMapping
    public void cadastrarCarro(@RequestBody Carro carro) {
        carroService.salvarCarro(carro);
    }

    @GetMapping("/{placa}")
    public Carro buscarCarro(@PathVariable String placa) {
        return carroService.getCarro(placa);
    }

    @DeleteMapping("/{placa}")
    public Carro deletarCarro(@PathVariable String placa) {
        return carroService.removerCarro(placa);
    }

    @PutMapping("/{placa}")
    public Carro atualizarCarro(@PathVariable String placa, @RequestBody Carro carro) {
        return carroService.editarCarro(placa, carro);
    }
}
