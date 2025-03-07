package com.example.sistemabancarioweb;

import SistemaBancario.Domain.ContaBancaria;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/saida")
public class Saida extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ContaBancaria clienteGlobal = (ContaBancaria) getServletContext().getAttribute("clienteGlobal");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<html lang=\"pt-br\">"
                + "<head>"
                + "<meta charset=\"UTF-8\">"
                + "<title>Muito Obrigado</title>"
                + "</head>"
                + "<body>"
                + "<center>"
                + "<header>"
                + "<h1>MUITO OBRIGADO " + clienteGlobal.getTitular().toUpperCase() +"</h1>"
                + "</header>"
                + "<h2>por usar nosso banco :)</h2>"
                + "</center>"
                + "</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
