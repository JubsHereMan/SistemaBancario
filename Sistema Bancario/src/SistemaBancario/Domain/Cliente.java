package SistemaBancario.Domain;

    public class Cliente extends ContaBancaria {

        private double salario;

        public Cliente() {
        }

        public Cliente(String titular, double saldo, double limite , double salario) {
            super(titular, saldo, limite);
            this.salario = salario;
        }



        public double getSalario() {
            return salario;
        }

        public void setSalario(double salario) {
            this.salario = salario;
        }

        @Override
        public void depositar(double valor) {
            try {
                if (valor <= 0) {
                    throw new IllegalArgumentException("Valores negativos ou zero não são permitidos.");
                }
                    setSaldo(getSaldo() + valor);
                    System.out.println("Agora seu saldo é de: R$" + getSaldo());
                } catch (IllegalArgumentException e) {
                    System.out.println("Erro ao sacar: " + e.getMessage());
                }



        }


        @Override
        public void sacar(double valor) {
            try {
                if (valor <= 0) {
                    throw new IllegalArgumentException("Valores negativos ou zero não são permitidos.");
                }
                if (valor > getSaldo()) {
                    throw new IllegalArgumentException("Saldo insuficiente para saque.");
                }

                setSaldo(getSaldo() - valor);
                System.out.println("Saque realizado! Novo saldo: R$" + getSaldo());

            } catch (IllegalArgumentException e) {
                System.out.println("Erro ao sacar: " + e.getMessage());
            }
        }


        @Override
        public void transferir(double valor, ContaBancaria contaDestino) {
            try {
                if (valor <= 0) {
                    throw new IllegalArgumentException("O valor da transferência deve ser maior que zero.");
                }
                if (valor > getSaldo()) {
                    throw new IllegalArgumentException("Saldo insuficiente para transferência.");
                }
                if (contaDestino == null) {
                    throw new NullPointerException("Conta de destino inválida.");
                }

                setSaldo(getSaldo() - valor);
                contaDestino.setSaldo(contaDestino.getSaldo() + valor);

                System.out.println("Transferência realizada com sucesso!");
                System.out.println("Seu novo saldo: R$" + getSaldo());

            } catch (IllegalArgumentException e) {
                System.out.println("Erro na transferência: " + e.getMessage());
            } catch (NullPointerException e) {
                System.out.println("Erro: Conta de destino não encontrada.");
            } catch (Exception e) {
                System.out.println("Ocorreu um erro inesperado ao transferir dinheiro.");
            }
        }


        @Override
        public void mostraSaldo() {
            System.out.println("=========================");
            System.out.println(this.getTitular() + ", aqui está o seu saldo atual: " + "\n SALDO: R$" + this.getSaldo());
        }
    }

