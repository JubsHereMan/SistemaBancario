package SistemaBancario.Domain;

public interface Metodos {

    public void depositar(double valor);

    public void sacar(double valor);

    public void transferir(double valor, ContaBancaria contaDestino);

    public void mostraSaldo();
}