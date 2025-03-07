package com.example.sistemabancarioweb;


import SistemaBancario.Domain.Cliente;
import SistemaBancario.Domain.ContaBancaria;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;


@WebListener
public class Listener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ContaBancaria clienteGlobal = new Cliente("Julio", 1000, 5000, 1500);
        ContaBancaria cliente1 = new Cliente("João", 100, 1000, 3000);
        ContaBancaria cliente2 = new Cliente("Nicolas", 100, 1000, 3000);
        ContaBancaria cliente3 = new Cliente("Caue", 100, 1000, 3000);

        ContaBancaria[] contas = {cliente1, cliente2, cliente3};
        ServletContext context = sce.getServletContext();
        context.setAttribute("contas", contas);
        context.setAttribute("clienteGlobal", clienteGlobal);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
