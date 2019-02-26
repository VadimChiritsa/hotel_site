package epam.vakulchyk.bookinghotel.validation;

import epam.vakulchyk.bookinghotel.entity.Client;
import epam.vakulchyk.bookinghotel.entity.Order;

import java.util.Date;

public class Validation {
    private static final String DIFFERENT_PASSWORD = "Different password";
    private static final String ERROR_ORDER = "Different password";
    private static final String ERROR_DATE_ORDER = "Your date should be later than today";
    private static final String ERROR_CLIENT = "Check your data";

    private static final int MIN_LENGTH_APARTMENT = 2;
    private static final int MIN_LENGTH_0 = 0;
    private static final int MIN_LENGTH_2 = 2;
    private static final int MIN_LENGTH_PHONE = 999999999;

    public String cheakPassword(String password, String secondPassword) {

        String result = null;
        if (!password.equals(secondPassword)) {
            result = DIFFERENT_PASSWORD;
        }
        return result;
    }

    public String validationOrder(Order order) {
        Date date = new Date();
        String result = null;
        if (order.getTypeApartment().length() < MIN_LENGTH_APARTMENT || order.getNumberSeats() < MIN_LENGTH_0 || order.getTimeStay() < MIN_LENGTH_0) {
            result = ERROR_ORDER;
        }
        if (date.after(order.getDataArrival())) {
            result = ERROR_DATE_ORDER;
        }
        return result;
    }
    public String validationClient(String name,String surname,int phone) {
        String result = null;
        if(MIN_LENGTH_2 > name.length() ||MIN_LENGTH_2>surname.length()||MIN_LENGTH_PHONE>phone){
            result =ERROR_CLIENT;
        }

        return result;
    }

}
