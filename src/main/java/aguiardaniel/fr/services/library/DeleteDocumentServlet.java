package aguiardaniel.fr.services.library;

import mediatek2021.Mediatek;
import mediatek2021.SuppressException;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteDocumentServlet", value = "/document/delete")
public class DeleteDocumentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        int docID = Integer.parseInt(id);

        try {
            Mediatek.getInstance().suppressDoc(docID);
        } catch (SuppressException e) {
            System.out.println("[Delete Servlet] " + e.getMessage());
            request.setAttribute("error", e.getMessage());
        }

        response.sendRedirect("/documents");
    }
}
