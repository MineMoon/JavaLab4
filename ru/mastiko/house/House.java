package ru.mastiko.house;

import ru.mastiko.mcomrapable.Mcomparable;

public class House implements Mcomparable<House> {
    private final int floor;

    // properties
    public int getFloor() {
        return floor;
    }

    // constructor
    public House(int floor) {
        if(floor < 0){
            throw new RuntimeException("Floor cannot be negative");
        } else if(floor > 164) {
            this.floor = 1;
        } else {
            this.floor = floor;
        }
    }

    // copy
    public House(House house) {
        this.floor = house.getFloor();
    }

    //methods
    @Override
    public int compareTo(House other) {
        return Integer.compare(this.floor, other.floor);
    }

    @Override
    public String toString() {

        if (floor % 100 >= 11 && floor % 100 <= 14) {
            return String.format("Дом с %d %s", floor, "этажами");
        }
        if(floor % 10 == 1){
            return String.format("Дом с %d %s", floor, "этажом");
        }

        return String.format("Дом с %d %s", floor, "этажами");
    }

}
