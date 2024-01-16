package org.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String message = "";

        if(username.equals("admin") && password.equals("admin")) {
            message = "<h3>Login successful!</h3><a href='\\home'>Logout</a>";
        }
        else {
            message = "<h3>Wrong password!</h3> <a href='\\home'>Try again</a>";
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(message);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = "";
        String password = "";
        String message = "";
        try {
            username = request.getParameter("username");
            password = request.getParameter("password");

            if(username.isEmpty() || password.isEmpty()) {
                message = "<h3>Please provide username and password!</h3> <a href='/DemoMavenProject_war_exploded'>Try again</a>";
            }
        }
        catch (Exception e) {
            message = "<h3>Please provide username and password!</h3> <a href='/DemoMavenProject_war_exploded'>Try again</a>";
        }

        if(message.isEmpty()) {
            if(username.equals("admin") && password.equals("admin")) {
                message = "<h3>Login successful!</h3><a href='/DemoMavenProject_war_exploded'>Logout</a>";
            }
            else {
                message = "<h3>Wrong credentials!</h3> <a href='/DemoMavenProject_war_exploded'>Try again</a>";
            }
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(message);
    }
}