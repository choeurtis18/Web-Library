package aguiardaniel.fr.services.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

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
}
