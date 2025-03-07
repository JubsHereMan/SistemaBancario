package com.example.sistemabancarioweb;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/banco")
public class BancoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();



        out.println("<html><head><title>Banco Jubístico</title></head><body>");
        out.println("<center>");
        out.println("<h1>BEM VINDO AO BANCO JUBS</h1>");
        out.println("<hr>");
        out.println("<ul>");
        out.println("<li><a href='depositar'>1. Depositar</a></li>");
        out.println("<li><a href='sacar'>2. Sacar</a></li>");
        out.println("<li><a href='transferir'>3. Transferir</a></li>");
        out.println("<li><a href='saldo'>4. Mostrar o saldo</a></li>");
        out.println("<li><a href='saida'>5. Sair</a></li>");
        out.println("</ul>");
        out.println("</center>");
        out.println("</body></html>");
    }




}
