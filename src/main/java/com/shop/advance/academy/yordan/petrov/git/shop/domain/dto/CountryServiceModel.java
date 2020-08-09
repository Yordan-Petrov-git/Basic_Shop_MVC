package com.shop.advance.academy.yordan.petrov.git.shop.domain.dto;

import java.util.Objects;
/**
 * Class dto for .
 *
 * @author Yordan Petrov
 * @version 1.0.0.0
 * @since Jul 8, 2020.
 */
public class CountryServiceModel {

    private Long id;
    private String name;
    private String coordinates;

    /**
     * Constructor
     */
    public CountryServiceModel() {
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoordinates() {
        return this.coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CountryServiceModel)) return false;
        CountryServiceModel that = (CountryServiceModel) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(coordinates, that.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, coordinates);
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CountryServiceModel{");
        sb.append("name='").append(name).append('\'');
        sb.append(", coordinates='").append(coordinates).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
