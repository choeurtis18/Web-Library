package aguiardaniel.fr.services.library;

import mediatek2021.Mediatek;
import mediatek2021.NewDocException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "NewDocumentServlet", value = "/document/new")
public class NewDocumentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");

        if(user == null)
            this.getServletContext().getRequestDispatcher("/login").forward(request, response);

        String title = request.getParameter("title");
        String description = request.getParameter("description");
        int type = Integer.parseInt(request.getParameter("type"));
        Mediatek mediatek = Mediatek.getInstance();

        List<Object> requestArguments = new ArrayList<>(Arrays.asList(title,description)) ;
        switch (type) {
            case 1:
                requestArguments.add(request.getParameter("author"));
                break;
            case 2:
                requestArguments.add(request.getParameter("artist"));
                break;
            case 3:
                requestArguments.add(request.getParameter("producer"));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }

        try {
            mediatek.newDocument(type, requestArguments.toArray());
        }catch (NewDocException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/documents");

    }
}
