package org.example.split;

import org.example.corrida.Corrida;
import org.example.passageiro.Passageiro;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.ArrayList;


@Service
public class SplitService {

    private HashMap<Integer, Split> splits = new HashMap<>();

    // Método para criar uma divisão de pagamento para uma corrida
    public Split criarSplit(Corrida corrida, double valorTotal, ArrayList<Passageiro> passageiros) {
        Split split = new Split();
        split.setCorrida(corrida);
        split.setPassageiros(passageiros);
        split.setValorPorPessoa(valorTotal / passageiros.size()); // Dividindo o valor total igualmente entre os passageiros
        split.setStatusPagamento(new HashMap<>());

        // Inicializando o status de pagamento de todos os passageiros como "não pago"
        for (Passageiro passageiro : passageiros) {
            split.getStatusPagamento().put(passageiro, false);
        }

        split.setId(splits.size() + 1); // Gerando um ID simples para o split
        splits.put(split.getId(), split);
        return split;
    }

    // Método para realizar o pagamento de um passageiro
    public Split realizarPagamento(int splitId, Passageiro passageiro) {
        Split split = splits.get(splitId);
        if (split != null && split.getStatusPagamento().containsKey(passageiro)) {
            split.getStatusPagamento().put(passageiro, true); // Marcando como pago
        }
        return split;
    }

    // Método para verificar se todos os passageiros pagaram
    public boolean todosPagaram(int splitId) {
        Split split = splits.get(splitId);
        if (split != null) {
            for (boolean pago : split.getStatusPagamento().values()) {
                if (!pago) {
                    return false; // Se algum passageiro não pagou, retorna false
                }
            }
            return true; // Todos pagaram
        }
        return false;
    }

    // Método para buscar uma divisão de pagamento
    public Split getSplit(int splitId) {
        return splits.get(splitId);
    }
}
