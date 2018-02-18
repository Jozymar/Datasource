package com.ifpb.edu.web.datasource;

import com.ifpb.edu.shared.datasource.Clientes;
import com.ifpb.edu.shared.datasource.ServiceLocator;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletClientes", urlPatterns = {"/clientes"})
public class ServletClientes extends HttpServlet {

    private Clientes clientes = new ServiceLocator().lookup("host-core", "3700", "java:global/core-datasource/ClienteOnline");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Clientes</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Listagem de Clientes </h1>");
            imprimirTodosOsClientes(out);
            out.println("</body>");
            out.println("</html>");
        }

    }

    private void imprimirTodosOsClientes(PrintWriter out) {
        clientes.list().forEach(c -> out.println("<p>" + c.getCpf() + " - " + c.getNome() + "</p>"));
    }
}
