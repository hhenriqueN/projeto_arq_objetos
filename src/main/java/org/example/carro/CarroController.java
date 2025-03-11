package org.example.carro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @PostMapping
    public Carro criarCarro(@RequestBody Carro carro) {
        return carroService.salvar(carro);
    }

    @GetMapping
    public List<Carro> listarCarros() {
        return carroService.listarTodos();
    }

    @GetMapping("/{placa}")
    public Carro buscarCarro(@PathVariable String placa) {
        return carroService.buscarPorPlaca(placa);
    }

    @PutMapping("/{placa}")
    public Carro atualizarCarro(@PathVariable String placa, @RequestBody Carro carro) {
        return carroService.atualizar(placa, carro);
    }

    @DeleteMapping("/{placa}")
    public void deletarCarro(@PathVariable String placa) {
        carroService.deletar(placa);
    }
}
