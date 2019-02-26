package epam.vakulchyk.bookinghotel.entity;
import java.util.Date;

public class Order {
    private long idOrder;
    private int numberSeats;
    private int idClient;
    private String typeApartment;
    private int timeStay;
    private Date dataArrival;


    public long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(long idOrder) {
        this.idOrder = idOrder;
    }

    public int getNumberSeats() {
        return numberSeats;
    }

    public void setNumberSeats(int numberSeats) {
        this.numberSeats = numberSeats;
    }

    public String getTypeApartment() {
        return typeApartment;
    }

    public void setTypeApartment(String typeApartment) {
        this.typeApartment = typeApartment;
    }

    public int getTimeStay() {
        return timeStay;
    }

    public void setTimeStay(int timeStay) {
        this.timeStay = timeStay;
    }

    public int getIdClient() {
        return idClient;
    }

    public Date getDataArrival() {
        return dataArrival;
    }

    public void setDataArrival(Date dataArrival) {
        this.dataArrival = dataArrival;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

}
