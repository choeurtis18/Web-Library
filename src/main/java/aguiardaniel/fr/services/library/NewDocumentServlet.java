package aguiardaniel.fr.services.library;

import mediatek2021.Mediatek;
import mediatek2021.NewDocException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "NewDocumentServlet", value = "/document/new")
public class NewDocumentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");

        System.out.println("FORM POSTTTTTTTTTTTTTTTTT");
//        if(user == null)
//            this.getServletContext().getRequestDispatcher("/authentication/login.jsp").forward(request, response);

//        String title = request.getParameter("title");
//        int type = Integer.parseInt(request.getParameter("type"));
//        Mediatek mediatek = Mediatek.getInstance();
//
//        Object[] args;
//        switch (type) {
//            case 1:
//                args = new Object[]{title, request.getParameter("author")};
//                break;
//            case 2:
//                args = new Object[]{title, request.getParameter("artist")};
//                break;
//            case 3:
//                args = new Object[]{title, request.getParameter("producer")};
//                break;
//            default:
//                throw new IllegalStateException("Unexpected value: " + type);
//        }
//        try {
//            mediatek.newDocument(type, args);
//        }catch (NewDocException e) {
//            e.printStackTrace();
//        }

    }

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        setAccessControlHeaders(resp);
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    private void setAccessControlHeaders(HttpServletResponse resp) {
        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        resp.setHeader("Access-Control-Allow-Methods", "POST");
    }
}
