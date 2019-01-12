package com.senthil.presto.coding.boot;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.senthil.presto.coding.beans.Menu;
import com.senthil.presto.coding.config.MenuLoader;
import com.senthil.presto.coding.service.MenuService;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class Boot {

    private Logger logger = LoggerFactory.getLogger(Boot.class.getName());
    private Server jettyServer = new Server(8080);

    public void startJettyServer() throws Exception {
        logger.info("Starting jetty server");
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        jettyServer.setHandler(context);

        ServletHolder jerseyServlet = context.addServlet(org.glassfish.jersey.servlet.ServletContainer.class, "/*");
        jerseyServlet.setInitOrder(0);
        jerseyServlet.setInitParameter( "jersey.config.server.provider.classnames", MenuService.class.getCanonicalName());

        try {
            jettyServer.start();
            jettyServer.join();
        } catch (Exception ex){
            logger.error(ex.getMessage());
            jettyServer.destroy();
        }
        logger.info("Jetty server running...");
    }

    public void stopJettyServer() throws Exception {
        jettyServer.destroy();
        logger.info("Jetty server stopped.");
    }

    public void startH2Server() throws Exception {
        logger.info("Starting H2 database server");
        org.h2.tools.Server.createTcpServer("-tcpPort", "9092", "-tcpAllowOthers").start();
    }

    public void bootMenus() throws Exception {
        logger.info("Loading menu datas read from json...");
        MenuLoader menuLoader = new MenuLoader();
        menuLoader.createTables();
        menuLoader.populateTables(getMenu());
        logger.info("Done.");
    }

    private Menu getMenu() throws Exception {
        logger.info("Reading menu.json for menu data...");
        ObjectMapper mapper = new ObjectMapper();
        Menu menu = mapper.readValue(new File("menu.json"), Menu.class);
        logger.info("Got menu data.");
        return menu;
    }
}
