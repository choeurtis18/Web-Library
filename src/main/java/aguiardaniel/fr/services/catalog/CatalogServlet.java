package aguiardaniel.fr.services.catalog;

import mediatek2021.Document;
import mediatek2021.Mediatek;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CatalogServlet", value = "/documents")
public class CatalogServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Document> documentList = Mediatek.getInstance().catalogue(1);
        request.setAttribute("documents", documentList);

        System.out.println(documentList);
        //this.getServletContext().getRequestDispatcher("/catalog/catalog.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
