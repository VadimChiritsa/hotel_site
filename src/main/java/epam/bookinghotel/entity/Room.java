package epam.vakulchyk.bookinghotel.entity;

public class Room {
    private int number;
    private String typeApartment;
    private int numberSeats;
    private int cost;
    private String employment;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTypeApartment() {
        return typeApartment;
    }

    public void setTypeApartment(String typeApartment) {
        this.typeApartment = typeApartment;
    }

    public int getNumberSeats() {
        return numberSeats;
    }

    public void setNumberSeats(int numberSeats) {
        this.numberSeats = numberSeats;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getEmployment() {
        return employment;
    }

    public void setEmployment(String employment) {
        this.employment = employment;
    }
}
