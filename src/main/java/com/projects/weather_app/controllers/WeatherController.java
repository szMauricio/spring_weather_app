package com.projects.weather_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.projects.weather_app.models.WeatherResponse;
import com.projects.weather_app.services.IWeatherService;

@Controller
public class WeatherController {
    private final IWeatherService weatherService;

    public WeatherController(IWeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather")
    public String getWeather(@RequestParam("city") String city, Model model) {
        try {
            WeatherResponse response = weatherService.getWeatherByCity(city);
            if (response == null) {
                model.addAttribute("error", "City not found");
                return "weather";
            }
            model.addAttribute("city", response.getName());
            model.addAttribute("country", response.getSys().getCountry());
            model.addAttribute("weatherDescription", response.getWeather().get(0).getDescription());
            model.addAttribute("temperature", response.getMain().getTemp());
            model.addAttribute("humidity", response.getMain().getHumidity());
            model.addAttribute("windSpeed", response.getWind().getSpeed());

            String weatherIcon = "wi wi-owm-" + response.getWeather().get(0).getId();
            model.addAttribute("weatherIcon", weatherIcon);

            return "weather";

        } catch (Exception e) {
            model.addAttribute("error", "Error retrieving data: " + e.getMessage());
            return "weather";
        }
    }
}
