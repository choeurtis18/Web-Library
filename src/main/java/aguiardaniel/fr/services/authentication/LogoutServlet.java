package aguiardaniel.fr.services.authentication;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LogoutServlet", value = "/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        if(user == null)
            this.getServletContext().getRequestDispatcher("/login").forward(request, response);

        session.invalidate();
        this.getServletContext().getRequestDispatcher("/login").forward(request, response);
    }

}
