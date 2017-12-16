package com.idoston.adaptivesystem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Doston on 12/16/2017.
 */

public class DefaultValues {




    public static final String[] NAME = {"Riga Technical University", "Seoul National University", "Oxford University", "University of Uzbekistan", "Harward University"};
    public static final String[] RANK = {"355", "100", "4", "255", "2"};
    public static final String[] FEE= {"1000", "5000", "20000", "20000", "45000"};
    public static final String[] PROGRAM = {"Computer Systems", "Business Management", "Technical Translation", "Mechanical Engineering", "Aviation Engineer"};
    public static final String[] CITY = {"Riga", "Seoul", "London", "Samarkand", "Massachusetts"};
    public static final String[] COUNTRY = {"Latvia", "South Korea", "United Kingdom", "Uzbekistan", "USA"};
    public static final String[] CONTINENT = {"Europa", "Asia", "Europa", "Asia", "North america"};

    public DefaultValues() {

    }

    public String getNAME(int i) {
        return NAME[i];
    }

    public String getRANK(int i) {
        return RANK[i];
    }

    public String getFEE(int i) {
        return FEE[i];
    }

    public String getPROGRAM(int i) {
        return PROGRAM[i];
    }

    public String getCITY(int i) {
        return CITY[i];
    }

    public String getCOUNTRY(int i) {
        return COUNTRY[i];
    }

    public String getCONTINENT(int i) {
        return CONTINENT[i];
    }
}
