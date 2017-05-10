package com.example.alhas.googlemapapi;

import java.util.List;

public interface DirectionFinderListener {
    void onDirectionFinderStart();
    void onDirectionFinderSuccess(List<Route> route);
}