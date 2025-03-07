package com.example.sistemabancarioweb;

import SistemaBancario.Domain.ContaBancaria;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/sacar")
public class Sacar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        ContaBancaria cliente = (ContaBancaria) getServletContext().getAttribute("clienteGlobal");




        try {
            double valorSaque = Double.parseDouble(req.getParameter("valorSaque"));
            cliente.sacar(valorSaque);
            out.println("<html lang=\"pt-br\">"
                    + "<head>"
                    + "<meta charset=\"UTF-8\">"
                    + "<title>Saque</title>"
                    + "</head>"
                    + "<body>"
                    + "<center>"
                    + "<header>"
                    + "<h1>SAQUE</h1>"
                    + "</header>"
                    + "<form action=\"sacar\" method=\"post\">"
                    + "<label for=\"valor\">Valor do Saque:</label>"
                    + "<input type=\"number\" id=\"valor\" name=\"valorSaque\" step=\"0.01\" required>"
                    + "<button type=\"submit\">Sacar</button>"
                    + "</form>"
                    + "<section>"
                    + "<h1>Saque realizado com sucesso!</h1>"
                    + "<p>Seu novo saldo é: <strong>R$" + cliente.getSaldo() + "</strong></p>"
                    + "</section>"
                    + "<a href='banco'>Voltar</a>"
                    + "</center>"
                    + "</body></html>");
        } catch (NumberFormatException e) {
            out.println("<h1>Erro: Insira um valor válido.</h1>");
        } catch (IllegalArgumentException e) {
            out.println("<h1>Erro ao sacar: " + e.getMessage() + "</h1>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<html lang=\"pt-br\">"
                + "<head>"
                + "<meta charset=\"UTF-8\">"
                + "<title>Saque</title>"
                + "</head>"
                + "<body>"
                + "<center>"
                + "<header>"
                + "<h1>SAQUE</h1>"
                + "</header>"
                + "<form action=\"sacar\" method=\"post\">"
                + "<label for=\"valor\">Valor do Saque:</label>"
                + "<input type=\"number\" id=\"valor\" name=\"valorSaque\" step=\"0.01\" required>"
                + "<button type=\"submit\">Sacar</button>"
                + "</form>"
                + "</center>"
                + "</body></html>");
    }
}
