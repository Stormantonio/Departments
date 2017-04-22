package com.chernenko.controller.mapController;

import com.chernenko.controller.MainController;

/**
 * Created by Anton on 16.04.2017.
 */
public interface Storage {

    void clear();

    void add(Enum url, MainController controller);
//    void add(String url, MainController controller);

    MainController get(String url);
}
