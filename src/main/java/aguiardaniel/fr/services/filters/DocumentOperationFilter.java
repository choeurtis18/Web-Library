package aguiardaniel.fr.services.filters;

import mediatek2021.Utilisateur;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "DocumentOperationFilter")
public class DocumentOperationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession();
        Utilisateur user = (Utilisateur) session.getAttribute("user");

        boolean isAuthorized = false;

        if(user == null)
            res.sendRedirect("/login");
        else
            isAuthorized = (boolean) user.data()[3];

        if(!isAuthorized)
            res.sendRedirect("/login");

        chain.doFilter(request, response);
    }
}
