package org.example.split;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SplitService {

    private List<Split> splits = new ArrayList<>();
    private int proximoId = 1;

    public Split salvar(Split split) {
        split.setId(proximoId++);
        splits.add(split);
        return split;
    }

    public List<Split> listarTodos() {
        return splits;
    }

    public Split buscarPorId(int id) {
        return splits.stream()
                .filter(split -> split.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Split atualizar(int id, Split novoSplit) {
        Split existente = buscarPorId(id);
        if (existente != null) {
            existente.setCorrida(novoSplit.getCorrida());
            existente.setPassageiros(novoSplit.getPassageiros());
            existente.setValorPorPessoa(novoSplit.getValorPorPessoa());
            existente.setStatusPagamento(novoSplit.getStatusPagamento());
        }
        return existente;
    }

    public void deletar(int id) {
        splits.removeIf(split -> split.getId() == id);
    }

    public void marcarComoPago(int id, String email) {
        Split split = buscarPorId(id);
        if (split != null) {
            split.marcarComoPago(email);
        }
    }
}
