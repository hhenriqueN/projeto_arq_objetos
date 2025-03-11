package org.example.carro;

import org.example.motorista.Motorista;

public class Carro {

        private String modelo;
        private String placa;
        private String cor;
        private int ano;
        private Motorista motorista;

        public Carro() {
        }

        public Carro(String modelo, String placa, String cor, int ano, Motorista motorista) {
                this.modelo = modelo;
                this.placa = placa;
                this.cor = cor;
                this.ano = ano;
                this.motorista = motorista;
        }

        public String getModelo() {
                return modelo;
        }

        public void setModelo(String modelo) {
                this.modelo = modelo;
        }

        public String getPlaca() {
                return placa;
        }

        public void setPlaca(String placa) {
                this.placa = placa;
        }

        public String getCor() {
                return cor;
        }

        public void setCor(String cor) {
                this.cor = cor;
        }

        public int getAno() {
                return ano;
        }

        public void setAno(int ano) {
                this.ano = ano;
        }

        public Motorista getMotorista() {
                return motorista;
        }

        public void setMotorista(Motorista motorista) {
                this.motorista = motorista;
        }
}
