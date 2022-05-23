package com.example.pashnev.domain;


import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name="bombs")
public class Bombs  {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String country;
    private int weight;
    private String name;
    private Boolean isDeleted=Boolean.FALSE;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bombs bombs = (Bombs) o;
        return weight == bombs.weight && Objects.equals(id, bombs.id) && Objects.equals(country, bombs.country) && Objects.equals(name, bombs.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, country, weight, name);
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "id=" + id +
                ", nameBrand='" + country +
                ", model='" + weight +
                ", displayDiagonal=" + name + '}';
    }
}
