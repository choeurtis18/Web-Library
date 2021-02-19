package aguiardaniel.fr.services;

import javax.servlet.*;
import javax.servlet.annotation.*;

@WebListener
public class LoadListener implements ServletContextListener {

    public LoadListener() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            Class.forName("aguiardaniel.fr.persistance.MediatekData");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /* This method is called when the servlet Context is undeployed or Application Server shuts down. */
    }
}
