package com.example.sistemabancarioweb;

import SistemaBancario.Domain.Cliente;
import SistemaBancario.Domain.ContaBancaria;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/saldo")
public class VerificarSaldo extends HttpServlet {

@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    ContaBancaria cliente = (ContaBancaria) getServletContext().getAttribute("clienteGlobal");




    out.println("<html lang=\"pt-br\">"
            + "<head>" +
            "<meta charset=\"UTF-8\">" +
            "<title>Saldo do Cliente</title>" +
            "</head>" +
            "<body>" +
            "<center> "+
            "<header>"+
            "<h1>SALDO</h1>"+
            "</header>" +
            "<section>"+
            "<h1>O seu saldo " + cliente.getTitular() + " é de:</h1>"+
            "<p>R$"+cliente.getSaldo()+"</p>"+
            "</section>"+
           "<a href='banco'>Voltar</a>"+
            "</center> "+
            "</body></html>");

    }

}
