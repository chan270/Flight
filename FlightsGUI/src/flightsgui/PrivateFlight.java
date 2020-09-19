package flightsgui;

import javafx.beans.property.SimpleStringProperty;

/**
 * Extending the Flights class, this subclass PrivateFlight adds a new parameter
 * (private plane model) along it's getters and setters. Also overrides the
 * toString method from the super class to display the private plane model.
 * Represents a private jet flown on an individual's dime.
 *
 * @author chanv
 */
public class PrivateFlight extends Flights {
    String planeType="Private";
    private SimpleStringProperty privatePlaneModel; //specific model of the private jet, can be a combo of any characters

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
     * @param privatePlaneModel specific model of private jet, can be combo of
     * any characters
     */
    public PrivateFlight(String flightNumber, String destinationCity, String arrivalDate, String takeOffLocation, String numberOfSeats, String planeType, String privatePlaneModel) {
        super(flightNumber, destinationCity, arrivalDate, takeOffLocation, numberOfSeats, planeType);
        this.privatePlaneModel = new SimpleStringProperty(privatePlaneModel);

    }

    /**
     * Retrieves model of the plane
     *
     * @return privatePlaneModel
     */
    public String getprivatePlaneModel() {
        return privatePlaneModel.get();
    }

    /**
     * Tries to set the specific model number of the aircraft for this current
     * PrivateFlight object
     *
     * @param privatePlaneModel specific model code of the private jet, can be a
     * combination of any characters
     */
    public void setprivatePlaneModel(String privatePlaneModel) {
        this.privatePlaneModel = new SimpleStringProperty(privatePlaneModel);
    }

    /**
     * Overrides the superclass toString method to display the privatePlaneModel
     *
     * @return string representation of all parameters, including
     * privatePlaneModel
     */
    public String toString() {
        return super.toString() + "\nPassenger Plane Model: " + privatePlaneModel;
    }
}
