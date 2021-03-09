package aguiardaniel.fr.services.filters;

import mediatek2021.Utilisateur;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
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
        String loginRedirection = req.getContextPath() + "/login";
        boolean isAuthorized = false;

        if (user == null)
            res.sendRedirect(loginRedirection);
        else
            isAuthorized = (boolean) user.data()[3];

        if (!isAuthorized)
            res.sendRedirect(loginRedirection);

        chain.doFilter(request, response);
    }
}
