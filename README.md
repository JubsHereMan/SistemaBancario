# Sistema Bancário em Java

Este é um sistema bancário simples desenvolvido em Java, que permite aos usuários realizar operações como depósito, saque, transferência e consulta de saldo. O projeto utiliza conceitos de Programação Orientada a Objetos (POO), incluindo herança, polimorfismo, classes abstratas e interfaces.

## Funcionalidades

- **Criação de contas**: Permite a criação de múltiplas contas com saldo e limite definidos.
- **Operações financeiras**:
  - Depositar
  - Sacar
  - Transferir entre contas
  - Consultar saldo
- **Validações**: Implementação de validações para evitar operações inválidas, como saques com saldo insuficiente.

## Estrutura do Projeto

O projeto é organizado da seguinte forma:

SistemaBancario/ ├── Domain/ │ ├── Cliente.java │ ├── ContaBancaria.java │ ├── Metodos.java │ └── ... ├── Services/ │ └── BancoServices.java └── test/ └── SistemaBancario.java


## Tecnologias Utilizadas

- Java SE
- IDE: IntelliJ IDEA

## Conceitos Trabalhados

- **Programação Orientada a Objetos (POO)**: Utilização de classes e objetos para modelar o sistema.
- **Herança**: A classe `Cliente` herda de `ContaBancaria`, permitindo reutilização de código.
- **Polimorfismo**: Implementação de métodos que podem ser utilizados de forma intercambiável em diferentes subclasses.
- **Classes Abstratas**: A classe `ContaBancaria` é uma classe abstrata que define métodos que devem ser implementados pelas subclasses.
- **Interfaces**: A interface `Metodos` define operações que devem ser implementadas pelas classes que representam contas bancárias.

Licença
Este projeto está licenciado sob a MIT License.
