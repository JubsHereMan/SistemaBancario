package com.example.sistemabancarioweb;

import SistemaBancario.Domain.ContaBancaria;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/transferir")
public class Transferir extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ContaBancaria[] contas = (ContaBancaria[]) getServletContext().getAttribute("contas");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<html lang=\"pt-br\">"
                + "<head>"
                + "<meta charset=\"UTF-8\">"
                + "<title>Transferencia</title>"
                + "</head>"
                + "<body>"
                + "<center>"
                + "<header>"
                + "<h1>Qual o valor a ser transferido</h1>"
                + "</header>"
                + "<form action=\"transferir\" method=\"post\">"
                + "<label for=\"valor\">Valor:</label>"
                + "<input type=\"number\" id=\"valor\" name=\"valorTransferido\" step=\"0.01\" required>"
                + "<label for=\"contaDestino\">Conta de destino:</label>"
                + "<select id=\"contaDestino\" name=\"contaDestino\" required>");

        for (ContaBancaria conta : contas) {
            out.println("<option value=\"" + conta.getTitular() + "\">" + conta.getTitular() + "</option>");
        }

        out.println("</select>"
                + "<button type=\"submit\">Transferir</button>"
                + "</form>"
                + "</center>"
                + "</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        ContaBancaria[] contas = (ContaBancaria[]) getServletContext().getAttribute("contas");
        double valorTransferido = Double.parseDouble(req.getParameter("valorTransferido"));
        String contaDestinoStr = req.getParameter("contaDestino");

        ContaBancaria clienteGlobal = (ContaBancaria) getServletContext().getAttribute("clienteGlobal");
        ContaBancaria contaDestino = null;

        for (ContaBancaria conta : contas) {
            if (conta.getTitular().equals(contaDestinoStr)) {
                contaDestino = conta;
                break;
            }
        }

        if (contaDestino == null) {
            out.println("<h1>Conta de destino inválida. Tente novamente.</h1>");
            return;
        }

        try {
            clienteGlobal.transferir(valorTransferido, contaDestino);
            out.println("<html lang=\"pt-br\">"
                    + "<head>"
                    + "<meta charset=\"UTF-8\">"
                    + "<title>Transferência realizada</title>"
                    + "</head>"
                    + "<body>"
                    + "<center>"
                    + "<h1>Transferência realizada com sucesso!</h1>"
                    + "<p>Seu novo saldo é: R$" + clienteGlobal.getSaldo() + "</p>"
                    + "<a href='banco'>Voltar</a>"
                    + "</center>"
                    + "</body></html>");
        } catch (IllegalArgumentException e) {
            out.println("<h1>Erro: " + e.getMessage() + "</h1>");
        } catch (Exception e) {
            out.println("<h1>Erro inesperado ao tentar transferir.</h1>");
        }
    }
}
