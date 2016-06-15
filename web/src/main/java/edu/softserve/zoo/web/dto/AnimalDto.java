package edu.softserve.zoo.web.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import edu.softserve.zoo.core.model.Animal;
import edu.softserve.zoo.web.annotation.DocsFieldDescription;
import edu.softserve.zoo.web.annotation.Dto;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

@Dto(Animal.class)
public class AnimalDto extends BaseDto {

    @DocsFieldDescription(value = "The nickname", optional = true)
    @NotNull
    @NotEmpty
    @Length(max = 50)
    private String nickname;

    @DocsFieldDescription("All species")
    @NotNull
    private SpeciesDto species;

    @DocsFieldDescription("The house")
    @NotNull
    private HouseDto house;

    @DocsFieldDescription("The birthday")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate birthday;

    @DocsFieldDescription("The min temperature")
    @NotNull
    private Integer temperatureMin;

    @DocsFieldDescription("The max temperature")
    @NotNull
    private Integer temperatureMax;

    @DocsFieldDescription("The count of animals per house")
    @NotNull
    private Integer animalsPerHouse;

    @DocsFieldDescription("The food consumption")
    @NotNull
    private Integer foodConsumption;

    public AnimalDto() {
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public SpeciesDto getSpecies() {
        return species;
    }

    public void setSpecies(SpeciesDto species) {
        this.species = species;
    }

    public HouseDto getHouse() {
        return house;
    }

    public void setHouse(HouseDto house) {
        this.house = house;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Integer getTemperatureMin() {
        return temperatureMin;
    }

    public void setTemperatureMin(Integer temperatureMin) {
        this.temperatureMin = temperatureMin;
    }

    public Integer getTemperatureMax() {
        return temperatureMax;
    }

    public void setTemperatureMax(Integer temperatureMax) {
        this.temperatureMax = temperatureMax;
    }

    public Integer getFoodConsumption() {
        return foodConsumption;
    }

    public void setFoodConsumption(Integer foodConsumption) {
        this.foodConsumption = foodConsumption;
    }

    public Integer getAnimalsPerHouse() {
        return animalsPerHouse;
    }

    public void setAnimalsPerHouse(Integer animalsPerHouse) {
        this.animalsPerHouse = animalsPerHouse;
    }


    @Override
    public String toString() {
        return "AnimalDto{" +
                "id=" + getId() +
                ", nickname='" + nickname + '\'' +
                ", species=" + species +
                ", house=" + house +
                ", birthday=" + birthday +
                ", temperatureMin=" + temperatureMin +
                ", temperatureMax=" + temperatureMax +
                ", animalsPerHouse=" + animalsPerHouse +
                ", foodConsumption=" + foodConsumption +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnimalDto animal = (AnimalDto) o;
        return Objects.equals(nickname, animal.nickname) &&
                Objects.equals(species, animal.species) &&
                Objects.equals(house, animal.house) &&
                Objects.equals(birthday, animal.birthday) &&
                Objects.equals(temperatureMin, animal.temperatureMin) &&
                Objects.equals(temperatureMax, animal.temperatureMax) &&
                Objects.equals(foodConsumption, animal.foodConsumption) &&
                Objects.equals(animalsPerHouse, animal.animalsPerHouse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickname, species, house, birthday, temperatureMin, temperatureMax, foodConsumption, animalsPerHouse);
    }
}