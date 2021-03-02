package aguiardaniel.fr.services.filters;

import mediatek2021.Utilisateur;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
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

        List<String> acceptedURI = new ArrayList<>(Arrays.asList("/login", ".jsp", ".html", ".css", ".js"));

        if(uri.startsWith("/catalog") && u == null)
            res.sendRedirect("/login");
        else if(u != null || uri.equals("/") || acceptedURI.stream().anyMatch(uri::endsWith))
            chain.doFilter(request, response);
        else
            res.sendRedirect("/login");
    }
}
