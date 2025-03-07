package com.example.sistemabancarioweb;

import SistemaBancario.Domain.ContaBancaria;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/depositar")
public class Depositar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ContaBancaria cliente = (ContaBancaria) getServletContext().getAttribute("clienteGlobal");


        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<html lang=\"pt-br\">"
                + "<head>"
                + "<meta charset=\"UTF-8\">"
                + "<title>Depósito</title>"
                + "</head>"
                + "<body>"
                + "<center>"
                + "<header>"
                + "<h1>Qual o valor a ser depositado?</h1>"
                + "</header>"
                + "<form action=\"depositar\" method=\"post\">"
                + "<label for=\"valor\">Valor:</label>"
                + "<input type=\"number\" id=\"valor\" name=\"valorDeposito\" step=\"0.01\" required>"
                + "<button type=\"submit\">Depositar</button>"
                + "</form>"
                + "</center>"
                + "</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        double valorDeposito = Double.parseDouble(req.getParameter("valorDeposito"));

        ContaBancaria clienteGlobal = (ContaBancaria) getServletContext().getAttribute("clienteGlobal");

        try {
            clienteGlobal.depositar(valorDeposito);
            out.println("<html lang=\"pt-br\">"
                    + "<head>"
                    + "<meta charset=\"UTF-8\">"
                    + "<title>Depósito realizado</title>"
                    + "</head>"
                    + "<body>"
                    + "<center>"
                    + "<h1>Depósito realizado com sucesso!</h1>"
                    + "<p>Seu novo saldo é: R$" + clienteGlobal.getSaldo() + "</p>"
                    + "<a href='banco'>Voltar</a>"
                    + "</center>"
                    + "</body></html>");
        } catch (IllegalArgumentException e) {
            out.println("<h1>Erro: " + e.getMessage() + "</h1>");
        } catch (Exception e) {
            out.println("<h1>Erro inesperado ao tentar depositar.</h1>");
        }
    }
}

