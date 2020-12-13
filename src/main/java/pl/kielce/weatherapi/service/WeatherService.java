package pl.kielce.weatherapi.service;

import pl.kielce.weatherapi.model.Location;
import pl.kielce.weatherapi.model.Weather;

import java.util.List;

public interface WeatherService {
    List<Location> findLocationByName(String name);
    Weather getWeatherById(String woeId);
}
