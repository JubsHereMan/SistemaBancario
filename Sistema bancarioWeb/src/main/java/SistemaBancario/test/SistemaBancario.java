package SistemaBancario.test;

import SistemaBancario.Domain.Cliente;
import SistemaBancario.Domain.ContaBancaria;
import SistemaBancario.Services.BancoServices;

import java.util.Scanner;

public class SistemaBancario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContaBancaria cliente = new Cliente("Júlio César", 1000, 3000, 5000);
        ContaBancaria cliente2 = new Cliente("Nicolas", 100, 1000, 3000);
        ContaBancaria cliente3 = new Cliente("Caue", 100, 1000, 3000);

        ContaBancaria[] contas = {cliente, cliente2, cliente3};

        BancoServices bancoServices = new BancoServices();

        System.out.println("BEM VINDO AO BANCO JUBÍSTICO");
        System.out.println("==============================");

        while (true) {
            System.out.println("==============================");
            System.out.println("Bem vindo " + cliente.getTitular() + ", o que vamos fazer hoje? " + "\n1.Depositar." + "\n2.Sacar." + "\n3.Transferir." + "\n4.Mostrar o saldo." + "\n5.Sair.");

            int opcao = scanner.nextInt();
            switch (opcao) {

                case 1:
                    System.out.println("DEPOSITAR");
                    System.out.println("==================" + "\n" + cliente.getTitular() + " qual valor você gostaria de depositar?" + "\nO seu saldo é de:" + cliente.getSaldo());
                    double valor = scanner.nextDouble();
                    bancoServices.depositar(cliente, valor);
                    break;

                case 2:
                    System.out.println("SACAR");
                    System.out.println("==================" + "\n" + cliente.getTitular() + " qual valor você gostaria de sacar?" + "\nO seu saldo é de:" + cliente.getSaldo());
                    valor = scanner.nextDouble();
                    bancoServices.sacar(cliente, valor);
                    break;

                case 3:
                    System.out.println("TRANSFERÊNCIA");

                    System.out.println("==================" +
                            "\n" + cliente.getTitular() + ", qual valor você gostaria de transferir?" +
                            "\nSeu saldo é de: R$" + cliente.getSaldo());

                    double valorTransferencia = scanner.nextDouble();

                    System.out.println(cliente.getTitular() + ", para qual conta você gostaria de transferir?");

                    for (int i = 0; i < contas.length; i++) {
                        if (contas[i] != cliente) {
                            System.out.println((i + 1) + ". " + contas[i].getTitular());
                        }
                    }

                    int destino = scanner.nextInt() ;


                    ContaBancaria contaDestino = null;
                    if (destino > 0 && destino <= contas.length && contas[destino - 1] != cliente) {
                        contaDestino = contas[destino - 1];
                    } else {
                        System.out.println("Conta de destino inválida. Tente novamente.");
                        break;
                    }


                    bancoServices.transferir(cliente, contaDestino, valorTransferencia);
                    System.out.println(cliente2.getTitular() + cliente2.getSaldo()+"\n"+cliente3.getTitular() + cliente3.getSaldo());
                    break;

                case 4:
                    System.out.println("SALDO");
                    bancoServices.mostrarSaldo(cliente);
                    break;

                case 5:
                    System.out.println("Obrigado por usar o banco Jubístico!");
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");

            }
        }
    }
}