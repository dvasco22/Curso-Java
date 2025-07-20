package com.cdsb.serial;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cyclist {

    private String name;
    private LocalDate birthday;
    private List<Bicycle> bikes = new ArrayList<>();

    public void addBike(Bicycle bike) {
        bikes.add(bike);
    }

    public Cyclist() {}

    public Cyclist(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Cyclist [name=" + name + ", birthday=" + birthday + ", bikes=" + bikes + "]";
    }

}