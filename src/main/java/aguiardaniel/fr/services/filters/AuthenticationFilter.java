package aguiardaniel.fr.services.filters;

import mediatek2021.Utilisateur;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebFilter(filterName = "AuthenticationFilter")
public class AuthenticationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String uri = req.getRequestURI();
        HttpSession session = req.getSession();

        Utilisateur u = (Utilisateur) session.getAttribute("user");
        List<String> protectedRoutes = Arrays.asList("/catalog", "/documents");
        String loginRedirection = req.getContextPath() + "/login";

        if (protectedRoutes.stream().anyMatch(uri::contains) && u == null)
            res.sendRedirect(loginRedirection);
        else if (u != null || uri.equals("/") || uri.endsWith("/login") || uri.matches(".*"))
            chain.doFilter(request, response);
        else
            res.sendRedirect(loginRedirection);
    }
}
