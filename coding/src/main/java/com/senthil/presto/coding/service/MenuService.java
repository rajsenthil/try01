package com.senthil.presto.coding.service;

import com.senthil.presto.coding.beans.Menu;
import com.senthil.presto.coding.dao.H2MenuDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

/**
 * RestService for accessing all the menu related request.
 */
@Path("menu")
public class MenuService {

    private Logger logger = LoggerFactory.getLogger(MenuService.class.getName());
    private H2MenuDao menuDao = new H2MenuDao();
    private static final Map<Integer, Map<Integer, Menu>> ALL_MENUS = new HashMap<>();

    /**
     * Menu for the restaurant
     * Restaurant id:
     * @param restaurantId
     * @param menuId
     * @return
     */
    @GET
    @Path("/{restaurantId}/{menuId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Menu menu(@PathParam("restaurantId") int restaurantId, @PathParam("menuId") int menuId){
        logger.info("Requested Menu:{} for restaurant id:{}", menuId, restaurantId);

        //Check the cache if exists
        Map<Integer, Menu> menus = ALL_MENUS.get(restaurantId);
        if (menus != null) {
            Menu menu = menus.get(menuId);
            if (menu != null) return menu;
        }
        logger.info("Menu is not cached and getting it from DB");
        Menu menu = null;
        try {
            menu = menuDao.getMenu(restaurantId, menuId);
            if (menus == null) {
                menus = new HashMap<>();
                menus.put(menuId, menu);
                ALL_MENUS.put(restaurantId, menus);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        if (menu == null) throw new NotFoundException("Menu Not found");
        return menu;
    }
}
