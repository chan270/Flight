package flightsgui;

import javafx.beans.property.SimpleStringProperty;

/**
 * Extending the Flights class, this subclass PassengerFlight adds a new
 * parameter (passenger plane model) along it's getters and setters. Also
 * overrides the toString method from the super class to display the passenger
 * plane model. Represents a passenger airliner carrying travellers.
 *
 * @author chanv
 */
public class PassengerFlight extends Flights {
    String planeType="Passenger";
    private SimpleStringProperty passengerPlaneModel; //specific model of the passenger plane, can be any combo of characters

    /**
     * Constructs a PrivateFlight object from extending the superclass. Calls
     * the superclass constructor with all relevant parameters, then adding the
     * privatePlaneModel to set in the setter method
     *
     * @param flightNumber unique id for each flight (digits)
     * @param destinationCity city where plane arrives off (ex. Montreal)
     * @param arrivalDate what the date of arrival will be (mmddyyyy)
     * @param takeOffLocation city where plane takes off (ex. Toronto)
     * @param numberOfSeats number of seats on the plane
     * @param planeType what kind of plane it is (i.e. Private, Commercial or
     * Passenger)
     * @param passengerPlaneModel specific model of passenger plane, can be
     * combo of any characters
     */
    public PassengerFlight(String flightNumber, String destinationCity, String arrivalDate, String takeOffLocation, String numberOfSeats, String planeType, String passengerPlaneModel) {
        super(flightNumber, destinationCity, arrivalDate, takeOffLocation, numberOfSeats, planeType);
        this.passengerPlaneModel = new SimpleStringProperty(passengerPlaneModel);

    }

    /**
     * Retrieves model of the plane
     *
     * @return passengerPlaneModel
     */
    public String getpassengerPlaneModel() {
        return passengerPlaneModel.get();
    }

    /**
     * Tries to set the specific model number of the aircraft for this current
     * PassengerFlight object
     *
     * @param passengerPlaneModel specific model code of the passenger plane,
     * can be a combination of any characters
     */
    public void setModel(String passengerPlaneModel) {
        this.passengerPlaneModel = new SimpleStringProperty(passengerPlaneModel);
    }

    /**
     * Overrides the superclass toString method to display the
     * passengerPlaneModel
     *
     * @return string representation of all parameters for this current object,
     * including passengerPlaneModel
     */
    public String toString() {
        return super.toString() + "\nPassenger Plane Model: " + passengerPlaneModel.get();
    }

}
