package aguiardaniel.fr.services.library;

import mediatek2021.Mediatek;
import mediatek2021.SuppressException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteDocumentServlet", value = "/document/delete")
public class DeleteDocumentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        int docID = Integer.parseInt(id);

        try {
            Mediatek.getInstance().suppressDoc(docID);
        } catch (SuppressException e) {
            request.setAttribute("error", e.getMessage());
        }

        response.sendRedirect(request.getContextPath() + "/documents");
    }
}
