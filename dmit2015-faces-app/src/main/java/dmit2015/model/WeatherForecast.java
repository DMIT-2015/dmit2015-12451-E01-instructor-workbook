package dmit2015.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.datafaker.Faker;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
public class WeatherForecast {

    @Id
    private String id;

    @NotBlank(message = "City value cannot be blank")
    private String city;
    @Future(message = "Date must be in the future")
    private LocalDate date;
    @Min(value = -40, message = "TempC must be between -40 and 40.")
    @Max(value = 40, message = "TempC must be between -40 and 40.")
    private int temperatureCelsius;

    public int getTemperatureFahrenheit() {
        return 32 + (int) (temperatureCelsius / 0.5556);
    }

    // copy constructor
    public WeatherForecast(WeatherForecast other) {
        this.id = other.id;
        this.city = other.city;
        this.date = other.date;
        this.temperatureCelsius = other.temperatureCelsius;
    }

    public static WeatherForecast copyOf(WeatherForecast other) {
        return new WeatherForecast(other);
    }

    public static WeatherForecast of(Faker faker) {
        var newWeatherForecast = new WeatherForecast();
        newWeatherForecast.setId(UUID.randomUUID().toString());
        newWeatherForecast.setCity(faker.address().city());
        newWeatherForecast.setDate(LocalDate.now().plusDays(1));
        newWeatherForecast.setTemperatureCelsius(faker.number().numberBetween(-35, 35));
        return newWeatherForecast;
    }

}
