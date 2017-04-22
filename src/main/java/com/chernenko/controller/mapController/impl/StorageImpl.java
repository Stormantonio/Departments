package com.chernenko.controller.mapController.impl;

import com.chernenko.controller.MainController;
import com.chernenko.controller.mapController.Storage;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anton on 16.04.2017.
 */
public class StorageImpl implements Storage{
    private Map<Enum, MainController> mainControllerMap = new HashMap<>();
//    private Map<String, MainController> mainControllerMap = new HashMap<>();

    @Override
    public void clear() {
        mainControllerMap.clear();
    }

//    @Override
//    public void add(String url, MainController controller) {
//        mainControllerMap.put(url, controller);
//    }

    @Override
    public void add(Enum url, MainController controller) {
        mainControllerMap.put(url, controller);
    }

    @Override
    public MainController get(String url) {
        MainController controller = null;
        for (Map.Entry<Enum, MainController> entry : mainControllerMap.entrySet()) {
            if (entry.getKey().toString().equals(url)) {
                controller = entry.getValue();
                break;
            }
        }
        return controller;
    }
}
