package flightsgui;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Models an airport flight database, with all particular flight information and
 * data
 *
 * @author chanv
 */
public class Flights {

    private SimpleStringProperty flightNumber, destinationCity, arrivalDate, takeOffLocation,
            planeType, numberOfSeats;

    /**
     * Default constructor in case it is called
     */
    public Flights() {
    }

    /**
     * Constructs a Flights object with parameters to make it a unique flight,
     * it will be set in the set method for each parameter, since
     * IllegalArgumentExceptions are thrown
     *
     * @param flightNumber unique id for each flight (digits)
     * @param destinationCity city where plane arrives off (ex. Montreal)
     * @param arrivalDate what the date of arrival will be (mmddyyyy)
     * @param takeOffLocation city where plane takes off (ex. Toronto)
     * @param numberOfSeats number of seats on the plane
     * @param planeType what kind of plane it is (i.e. Private, Commercial or
     * Passenger)
     */
    public Flights(String flightNumber, String destinationCity, String arrivalDate, String takeOffLocation,
            String numberOfSeats, String planeType) {
        setFlightNumber(flightNumber);
        setDestinationCity(destinationCity);
        setArrivalDate(arrivalDate);
        setTakeOffLocation(takeOffLocation);
        setNumberOfSeats(numberOfSeats);
        setPlaneType(planeType);
    }

    /**
     * Gets the unique flight number of the Flights object
     *
     * @return the unique flight number
     */
    public String getFlightNumber() {
        return flightNumber.get();
    }

    /**
     * Gets the destination city for this Flights object
     *
     * @return the destination city; where the plane will land last
     */
    public String getDestinationCity() {
        return destinationCity.get();
    }

    /**
     * Gets what date (mmddyyyy) the plane will arrive to its destination for
     * this Flights object
     *
     * @return the date of arrival. i.e. what mmddyyyy the plane will arrive to
     * its destination
     */
    public String getArrivalDate() {
        return arrivalDate.get();
    }

    /**
     * Gets the initial city the plane took off in for this Flights object, ex.
     * Toronto
     *
     * @return the initial city the plane took off in
     */
    public String getTakeOffLocation() {
        return takeOffLocation.get();
    }

    /**
     * Gets the number of seats on the plane for this Flights object
     *
     * @return
     */
    public String getNumberOfSeats() {
        return numberOfSeats.get();
    }

    /**
     * Gets the plane type of the current Flights object (i.e. Passenger,
     * Commercial or Private)
     *
     * @return type of plane (Passenger, Commercial, or Private)
     */
    public String getPlaneType() {
        return planeType.get();
    }

    /**
     * Tries to set a valid flight number ID on the current Flights object. The
     * flight number must only contain digits, otherwise an
     * IllegalArgumentException is thrown.
     *
     * @param flightNumber unique id for the flight, any number of digits
     * @throws IllegalArgumentException if any characters other than digits are
     * attempted to be set
     */
    public void setFlightNumber(String flightNumber)
            throws IllegalArgumentException {
        boolean isValid = true;
        for (int i = 0; i < flightNumber.length(); i++) {
            if (Character.isDigit(flightNumber.charAt(i)) == false) {
                isValid = false;
                break;
            }
        }
        if (!isValid) {
            throw new IllegalArgumentException("Only digits in the flight number.");
        } else {
            this.flightNumber = new SimpleStringProperty(flightNumber);
        }
    }

    /**
     * Tries to set a valid destination city on this Flights object. An
     * exception is thrown if the parameter contains any special characters or
     * digits.
     *
     * @param destinationCity city the plane will land in last for its
     * destination (ex. Toronto)
     * @throws IllegalArgumentException is thrown if any special character or
     * number is included for the city input
     */
    public void setDestinationCity(String destinationCity)
            throws IllegalArgumentException {
        boolean isValid = true;
        for (int i = 0; i < destinationCity.length(); i++) {
            if (Character.isLetter(destinationCity.charAt(i)) == false) {
                isValid = false;
                break;
            }
        }
        if (!isValid) {
            throw new IllegalArgumentException("Please enter a valid city, only letters.");
        } else {
            this.destinationCity = new SimpleStringProperty(destinationCity);
        }
    }

    /**
     * Tries to set a valid arrival date for the plane, what date the plane will
     * arive to its destination. It is taken in a MMddYYYY format (ex.
     * 02022005). If not in this format of any special characters or letters are
     * in the parameter, an exception is thrown.
     *
     * @param arrivalDate date plane will arrive to its destination (MMddYYYY)
     * @throws IllegalArgumentException if special characters or letters are in
     * the parameter
     */
    public void setArrivalDate(String arrivalDate)
            throws IllegalArgumentException {
        boolean isValid = true;
        if (!(arrivalDate.length() == 8)) {
            isValid = false;
        }
        for (int i = 0; i < arrivalDate.length(); i++) {
            if (Character.isDigit(arrivalDate.charAt(i)) == false) {
                isValid = false;
                break;
            }
        }
        if (!isValid) {
            throw new IllegalArgumentException("Enter the date in MMddYYYY format.");
        } else {
            this.arrivalDate = new SimpleStringProperty(arrivalDate);
        }

    }

    /**
     * Tries to assign a valid take off location city on this Flights object.
     * The String must only contain letters, where an exception is thrown if
     * not.
     *
     * @param takeOffLocation
     * @throws IllegalArgumentException if the take off location is not valid
     */
    public void setTakeOffLocation(String takeOffLocation)
            throws IllegalArgumentException {
        boolean isValid = true;
        for (int i = 0; i < takeOffLocation.length(); i++) {
            if (Character.isLetter(takeOffLocation.charAt(i)) == false) {
                isValid = false;
                break;
            }
        }
        if (!isValid) {
            throw new IllegalArgumentException("Please enter only letters in the city name.");
        } else {
            this.takeOffLocation = new SimpleStringProperty(takeOffLocation);
        }

    }

    /**
     * This method will set the amount of seats available on the entire plane and 
     * make sure each character is a digit, otherwise throw an exception 
     * ***Exception handling for this method added in final project April 14th, 2020
     *
     * @param numberOfSeats number of seats for passengers and crew combined
     */
    public void setNumberOfSeats(String numberOfSeats)
            throws IllegalArgumentException {
        boolean isValid = true;
        for (int i = 0; i < numberOfSeats.length(); i++) {
            if (Character.isDigit(numberOfSeats.charAt(i)) == false) {
                isValid = false;
                break;
            }
        }
        if (!isValid) {
            throw new IllegalArgumentException("Please enter only digits in the number of seats.");
        } else {
            this.numberOfSeats = new SimpleStringProperty(numberOfSeats);
        }
    }

    /**
     * Tries to assign a valid plane type, from three options (Passenger,
     * Commercial or Private), otherwise an exception is thrown
     *
     * @param planeType kind of flight, "Commercial", "Private", or "Passenger"
     * @throws IllegalArgumentException if the plane type is not valid
     */
    public void setPlaneType(String planeType)
            throws IllegalArgumentException {
        if ((planeType.equals("Private") == false) && (planeType.equals("Commercial") == false) && (planeType.equals("Passenger") == false)) {
            throw new IllegalArgumentException("Enter one of three options: Private, Commercial, or Passenger.");
        } else {
            this.planeType = new SimpleStringProperty(planeType);
        }
    }

    /**
     * Gets the Flights object as a String and displays all the parameters
     *
     * @return the Flights object as string
     */
    public String toString() {
        return flightNumber.get() + ":" + destinationCity.get() + ":" + arrivalDate.get() + ":"
                + takeOffLocation.get() + ":" + numberOfSeats.get() + ":"
                + planeType.get() + "\n";
    }

}
