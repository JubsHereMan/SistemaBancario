package SistemaBancario.Services;

import SistemaBancario.Domain.ContaBancaria;

public class BancoServices {
    public void depositar(ContaBancaria conta, double valor) {
        conta.depositar(valor);
    }

    public void sacar(ContaBancaria conta, double valor) {
        conta.sacar(valor);
    }

    public void transferir(ContaBancaria origem, ContaBancaria destino, double valor) {
        origem.transferir(valor, destino);
    }

    public void mostrarSaldo(ContaBancaria conta) {
        System.out.println("Saldo atual de " + conta.getTitular() + ": R$" + conta.getSaldo());
    }
}

