package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class Split {
    private int id;
    private Corrida corrida;
    private ArrayList<Passageiro> passageiros;
    private double valorPorPessoa;
    private HashMap<Passageiro, Boolean> statusPagamento; // Quem já pagou
}
