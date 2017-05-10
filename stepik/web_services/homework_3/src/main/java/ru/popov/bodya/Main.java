package ru.popov.bodya;


import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import ru.popov.bodya.accounts.AccountService;
import ru.popov.bodya.database.DBService;
import ru.popov.bodya.servlets.SignInServlet;
import ru.popov.bodya.servlets.SignUpServlet;

public class Main {
    public static void main(String[] args) throws Exception {

        DBService dbService = new DBService();
        AccountService accountService = new AccountService(dbService);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(new SignUpServlet(accountService)), "/signup");
        context.addServlet(new ServletHolder(new SignInServlet(accountService)), "/signin");

        Server server = new Server(8080);
        server.setHandler(context);
        server.start();
        java.util.logging.Logger.getGlobal().info("Server started");
        server.join();
    }
}
