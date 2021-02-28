package aguiardaniel.fr.services.filters;

import mediatek2021.Utilisateur;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AuthenticationFilter")
public class AuthenticationFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {}

    public void destroy() { }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String uri = req.getRequestURI();
        HttpSession session = req.getSession();
        Utilisateur u = (Utilisateur) session.getAttribute("user");

        if(uri.startsWith("/catalog") && u == null)
            res.sendRedirect("/login");
        else if(u != null || uri.equals("/") || uri.endsWith("/login") || uri.endsWith(".jsp") || uri.endsWith(".html"))
            chain.doFilter(request, response);
        else
            res.sendRedirect("/login");
    }
}
