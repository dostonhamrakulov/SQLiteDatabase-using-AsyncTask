package com.idoston.adaptivesystem;

/**
 * Created by Doston on 12/15/2017.
 */

public class University {

    private String ID, name, ranking, tuition, program, city, country, continent;

    public University(String ID, String name, String ranking, String tuition, String program, String city, String country, String continent) {
        this.ID = ID;
        this.name = name;
        this.ranking = ranking;
        this.tuition = tuition;
        this.program = program;
        this.city = city;
        this.country = country;
        this.continent = continent;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    public String getTuition() {
        return tuition;
    }

    public void setTuition(String tuition) {
        this.tuition = tuition;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }
}
