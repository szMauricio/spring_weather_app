package com.projects.weather_app.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.projects.weather_app.models.WeatherResponse;

import reactor.core.publisher.Mono;

@Service
public class WeatherService implements IWeatherService {
    private final WebClient webClient;
    private final String apiKey;

    public WeatherService(WebClient webClient, @Value("${openweather.api-key}") String apiKey) {
        this.webClient = webClient;
        this.apiKey = apiKey;
    }

    @Override
    @Cacheable(value = "weather", key = "#city.toLowerCase()")
    public WeatherResponse getWeatherByCity(String city) {
        try {
            return webClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .queryParam("q", city).queryParam("appid", apiKey).queryParam("units", "metric").build())
                    .retrieve()
                    .onStatus(status -> status.is4xxClientError(),
                            response -> Mono.error(new RuntimeException("City not found")))
                    .onStatus(status -> status.is5xxServerError(),
                            response -> Mono.error(new RuntimeException("Remote server error")))
                    .bodyToMono(WeatherResponse.class).block();
        } catch (WebClientResponseException e) {
            throw new RuntimeException("HTTP Error: " + e.getStatusCode() + " - " + e.getResponseBodyAsString());
        } catch (Exception e) {
            throw new RuntimeException("Error connecting to the weather API");
        }
    }

}
