//package aguiardaniel.fr.services.filters;
//
//import javax.servlet.*;
//import javax.servlet.annotation.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebFilter(filterName = "CorsFilter")
//public class CorsFilter implements Filter {
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
//        HttpServletRequest servletRequest = (HttpServletRequest) request;
//        System.out.println("CORSFilter HTTP Request: " + servletRequest.getMethod());
//
//        // Authorize (allow) all domains to consume the content
//        ((HttpServletResponse) response).addHeader("Access-Control-Allow-Origin", "*");
//        ((HttpServletResponse) response).addHeader("Access-Control-Allow-Methods","GET, OPTIONS, HEAD, PUT, POST");
//
//        HttpServletResponse resp = (HttpServletResponse) response;
//
//        // For HTTP OPTIONS verb/method reply with ACCEPTED status code -- per CORS handshake
//        if (servletRequest.getMethod().equals("OPTIONS")) {
//            resp.setStatus(HttpServletResponse.SC_ACCEPTED);
//            return;
//        }
//
//        // pass the request along the filter chain
//        chain.doFilter(request, response);
//    }
//}
