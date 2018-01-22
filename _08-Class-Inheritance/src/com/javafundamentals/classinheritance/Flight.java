package com.javafundamentals.classinheritance;

public class Flight {
    private int passengers, flightNumber, seats = 150;
    private char flightClass;
    private boolean[] isSeatAvailable;
    {
        isSeatAvailable = new boolean[seats];
        for (int i = 0; i < seats; i++) {
            isSeatAvailable[i] = true;
        }
    }
    public Flight() { }
    public Flight(int flightNumber) {
        this.flightNumber = flightNumber;
    }
    public Flight(char flightClass) {
        this.flightClass = flightClass;
    }

    public void add1Passenger() {
        if (passengers < seats)
            passengers += 1;
        else

    }
    private boolean hasSeating() {
        return passengers < seats;
    }
    private void handleTooMany() {
        System.out.println("No more seat!");
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
