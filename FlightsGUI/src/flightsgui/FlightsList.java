package flightsgui;

import java.util.ArrayList;

/**
 * This class creates an arraylist object to store all user created data in the
 * GUI. Has methods for adding, removing, and editing flights in the arraylist,
 * which the controller uses to update the flights.dat file
 *
 * @author chanv
 */
public class FlightsList {

    // Arraylist Object created "flightsList"
    private ArrayList<Flights> flightsList = new ArrayList<Flights>();

    /**
     * Method for the user to add a new flight to the end of the arraylist
     *
     * @param flights
     */
    public void addFlights(Flights flights) {
        flightsList.add(flights);
    }

    /**
     * Method to delete a flight record from the array list
     *
     * @param index of the flight the user wants to remove
     */
    public void removeFlights(int index) {
        flightsList.remove(index);
    }

    /**
     * Method to edit (replace) old flight with a new, edited one in the record
     * (in arraylist of objects)
     *
     * @param index of the flight to replace
     * @param flights object of new edited flight user wants to replace with
     */
    public void editFlights(int index, Flights flights) {
        flightsList.set(index, flights);
    }

    /**
     * Accessor for flightsList arraylist for writing into the file
     *
     * @return
     */
    public ArrayList<Flights> getFlightsList() {
        return flightsList;
    }
}
