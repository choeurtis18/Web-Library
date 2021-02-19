package aguiardaniel.fr.services.authentication;


import mediatek2021.Mediatek;
import mediatek2021.Utilisateur;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");

        if(user != null)
            this.getServletContext().getRequestDispatcher("/").forward(request, response);

        response.sendRedirect("/authentication/login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");

        if(user != null)
            this.getServletContext().getRequestDispatcher("/").forward(request, response);

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if(login.isEmpty() || password.isEmpty()){
            request.setAttribute("error", "Please enter a login and password");
            this.getServletContext().getRequestDispatcher("/authentication/login.jsp").forward(request, response);
        }

        if(!login.matches("^(.+)@(.+)$") || !password.matches(" [a-zA-Z0-9]{8,}")){
            request.setAttribute("error", "Please enter valid credentials");
            this.getServletContext().getRequestDispatcher("/authentication/login.jsp").forward(request, response);
        }

        Utilisateur u = Mediatek.getInstance().getUser(login, password);

        // check if the user is a librarian
        if(u == null) {
            request.setAttribute("error", "Your login and password doesn't match");
            this.getServletContext().getRequestDispatcher("/authentication/login.jsp").forward(request, response);
        }
        session.setAttribute("user", u);

        response.sendRedirect("/documents");
    }
}
