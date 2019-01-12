package com.senthil.presto.coding.service;

import com.senthil.presto.coding.beans.Menu;
import com.senthil.presto.coding.dao.H2MenuDao;

import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("menu")
public class MenuService {

    private H2MenuDao menuDao;

    @GET
    @Path("/{restaurantId}/{menuType}")
    @Produces(MediaType.APPLICATION_JSON)
    public Menu menu(@PathParam("restaurantId") int restaurantId, @PathParam("menuType") String menuType){
        Menu menu = menuDao.getMenu(restaurantId, menuType);
        if (menu == null) throw new NotFoundException("Menu Not found");
        return menu;
    }
}
