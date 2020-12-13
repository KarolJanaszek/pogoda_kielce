package pl.kielce.weatherapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.kielce.weatherapi.model.Location;
import pl.kielce.weatherapi.model.Weather;
import pl.kielce.weatherapi.service.WeatherService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WeatherController {
    private WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    public String getWeather(Model model, @RequestParam(required = false, defaultValue = "") String query,
                             @RequestParam(required = false, defaultValue = "") String id) {

        List<Location> locations = new ArrayList<>();
        Weather weather = new Weather();

        if (!query.isEmpty()) {
            locations = weatherService.findLocationByName(query);
        }
        if (!id.isEmpty()) {
            weather = weatherService.getWeatherById(id);
        }
        model.addAttribute("loc", locations);
        model.addAttribute("weather", weather);

        return "home";
    }
}
