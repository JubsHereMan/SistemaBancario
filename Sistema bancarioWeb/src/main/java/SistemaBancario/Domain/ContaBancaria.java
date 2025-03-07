package SistemaBancario.Domain;

public abstract class ContaBancaria implements Metodos{
    private String titular;
    private double saldo;
    private double limite;

    //constructors
    public ContaBancaria() {
    }

    public ContaBancaria(
            String titular, double saldo, double limite) {
        this.titular = titular;
        this.saldo = saldo;
        this.limite = limite;
    }

    //getters and setters
    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    @Override
    public String toString() {
        return "Cliente{" + "titular='" + titular + '\'' + ", saldo=" + saldo + ", limite=" + limite + '}';
    }
}