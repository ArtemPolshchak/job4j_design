package ru.job4j.jdbc;

/**
 * @author User on 21.06.2022.
 * @project job4j_design
 */
public class City {
    private int id;
    private String name;
    private int population;

    public City(int id, String name, int population) {
        this.id = id;
        this.name = name;
        this.population = population;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

}
