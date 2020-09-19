package flightsgui;

import javafx.beans.property.SimpleStringProperty;

/**
 * Extending the Flights class, this subclass ExpressShipmentFlight adds a new
 * parameter (express shipment model) along it's getters and setters. Also
 * overrides the toString method from the super class to display the express
 * plane model. Represents a cargo plane carrying a shipment.
 *
 * @author chanv
 */
public class ExpressShipmentFlight extends Flights {

    String planeType="Commercial";
    private SimpleStringProperty shipmentPlaneModel; //specific model of the shipment plane, can be any combo of characters

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
     * @param shipmentPlaneModel specific model of shipment plane, can be combo
     * of any characters
     */
    public ExpressShipmentFlight(String flightNumber, String destinationCity, String arrivalDate, String takeOffLocation, String numberOfSeats, String planeType, String shipmentPlaneModel) {
        super(flightNumber, destinationCity, arrivalDate, takeOffLocation, numberOfSeats, planeType);
        this.shipmentPlaneModel = new SimpleStringProperty(shipmentPlaneModel);

    }

    /**
     * Retrieves model of the plane
     *
     * @return shipmentPlaneModel
     */
    public String getshipmentPlaneModel() {
        return shipmentPlaneModel.get();
    }

    /**
     * Tries to set the specific model number of the aircraft for this current
     * ExpressShipmentFlight object
     *
     * @param shipmentPlaneModel specific model code of the shipment plane, can
     * be a combination of any characters
     */
    public void setModel(String shipmentPlaneModel) {
        this.shipmentPlaneModel = new SimpleStringProperty(shipmentPlaneModel);
    }

    /**
     * Overrides the superclass toString method to display the
     * passengerPlaneModel
     *
     * @return string representation of all parameters for this current object,
     * including passengerPlaneModel
     */
    public String toString() {
        return super.toString() + "\nPassenger Plane Model: " + shipmentPlaneModel.get();
    }

}
