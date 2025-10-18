# 🌦️ Weather App

A simple and modern **Weather Application** built with **Java 21**, **Spring Boot**, and **Thymeleaf**.  
The app allows users to search for weather information by city using the **OpenWeather API**, displaying temperature, humidity, wind speed, and more.

---

## 🚀 Features

- Search weather data by city name
- Fetches real-time weather info from OpenWeather API
- Server-side rendering with Thymeleaf
- Clean and responsive UI using **Tailwind CSS**
- Caching enabled for faster repeated requests
- Proper error handling and logging
- Environment variable support for API keys

---

## 🛠️ Tech Stack

**Backend**
- Java 21
- Spring Boot 3
- Spring WebFlux (WebClient)
- Spring Cache
- Thymeleaf
- OpenWeather API

**Frontend**
- Tailwind CSS
- Vanilla JS

**Build Tool**
- Maven

---

## ⚙️ Setup & Run Locally

### 1️⃣ Prerequisites
Make sure you have:
- Java 21+
- Maven 3.9+
- A valid [OpenWeather API key](https://openweathermap.org/api)

---

### 2️⃣ Clone the repository
```bash
git clone https://github.com/<your-username>/weather-app.git
cd weather-app
```

---

### 3️⃣ Set your API key

#### 🪟 PowerShell (Windows)
```bash
$env:OPENWEATHER_API_KEY = "your_openweather_api_key"
```

#### 🐧 macOS / Linux
```bash
export OPENWEATHER_API_KEY="your_openweather_api_key"
```

---

### 4️⃣ Run the application
```bash
mvn spring-boot:run
```

Then open your browser and go to:  
👉 `http://localhost:8080`

---

## 🧩 Project Structure

```
src
├── main
│   ├── java/com/weather_app/app
│   │   ├── configs/           # WebClient and Cache configurations
│   │   ├── controllers/       # Handles web requests
│   │   ├── models/            # Data transfer objects (DTOs)
│   │   ├── services/          # Business logic and API calls
│   │   └── AppApplication.java# Main Spring Boot entry point
│   └── resources
│       ├── static/            # Static files (CSS, JS, images)
│       ├── templates/         # Thymeleaf templates
│       └── application.yml    # Config file (without secrets)
└── test                      # Unit tests
```

---

## 🔐 Environment Variables

| Variable | Description | Example |
|-----------|-------------|----------|
| `OPENWEATHER_API_KEY` | Your OpenWeather API key | `123abc456xyz` |

> ⚠️ Never commit your API key to GitHub.  
> It should be stored as an environment variable locally or in GitHub Actions secrets.

---

## 🧰 Logging & Debug

To enable detailed logging for WebClient requests, you can add the following in `application.yml`:

```yaml
logging:
  level:
    "[org.springframework.web.reactive.function.client.ExchangeFunctions]": DEBUG
```

Avoid pushing this level of debug logs to production.

---

## 📸 Screenshots

### Main Search Page

<img width="1359" height="394" alt="github_ss1" src="https://github.com/user-attachments/assets/0738af43-85f1-47ac-8d97-998da021d79d" />


### Weather Results

<img width="1360" height="383" alt="github_ss2" src="https://github.com/user-attachments/assets/f8b06e49-7b18-4b78-92dc-9458426e1365" />

---

## 🧑‍💻 Author

**Mauricio Sánchez**  
📧 Feel free to connect or share feedback!

---

## 📝 License

This project is open source and available under the [MIT License](LICENSE).
