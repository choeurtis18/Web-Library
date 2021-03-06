package aguiardaniel.fr.services.library;

import mediatek2021.Mediatek;
import mediatek2021.NewDocException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "NewDocumentServlet", value = "/document/new")
public class NewDocumentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        int type = Integer.parseInt(request.getParameter("type"));

        List<Object> requestArguments = new ArrayList<>(Arrays.asList(title, description));
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
            Mediatek.getInstance().newDocument(type, requestArguments.toArray());
        } catch (NewDocException e) {
            e.printStackTrace();
        }

        response.sendRedirect(request.getContextPath() + "/documents");
    }
}
