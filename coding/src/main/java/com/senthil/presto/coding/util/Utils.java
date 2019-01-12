package com.senthil.presto.coding.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.senthil.presto.coding.beans.Item;
import com.senthil.presto.coding.beans.Menu;
import com.senthil.presto.coding.beans.MenuType;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static void writeJson(String path, Menu menu) {
        File file = new File(path);
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(file, menu);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
