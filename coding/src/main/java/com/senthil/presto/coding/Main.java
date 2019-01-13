package com.senthil.presto.coding;

import com.senthil.presto.coding.boot.Boot;

public class Main {

    public static void doMain(String[] args) throws Exception {
        Boot boot = new Boot();
        boot.startH2Server();
        boot.bootMenus();
        boot.startJettyServer();
    }

    public static void main(String[] args) throws Exception {
        doMain(args);
    }
}
