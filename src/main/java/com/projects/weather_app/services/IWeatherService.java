package com.projects.weather_app.services;

import com.projects.weather_app.models.WeatherResponse;

public interface IWeatherService {
    public WeatherResponse getWeatherByCity(String city);
}
