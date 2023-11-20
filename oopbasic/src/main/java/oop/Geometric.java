package oop;

import java.time.LocalDate;

public class Geometric {
    private String color;       //null
    private boolean filled;     // boolean
    private LocalDate dateCreated;  // null

    public Geometric(){

    }
    public Geometric(String color, boolean filled){
        this.color = color;
        this.filled = filled;
        dateCreated = LocalDate.now();
    }

    @Override
    public String toString() {
        return String.format("Geometric: color - %s, filled - %s, dateCreated: %s", this.color, this.filled, this.dateCreated);
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public String getColor() {
        return color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }
}
