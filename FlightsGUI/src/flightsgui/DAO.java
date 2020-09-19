package flightsgui;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * This class writes data to file, only containing one method : writeToFile,
 * where it takes a parameter of an arraylist filled with data to write or 
 * overwrite to a file
 * flights.dat
 *
 * @author chanv
 */
public class DAO {

    private static File file = new File("flights.dat");

    public static void writeToFile(ArrayList<Flights> f) {
        try (
                PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("flights.dat", false)))) {
            for(Flights flight: f){
                pw.print(flight.toString());
            }

        } catch (IOException ex) {

        }

    }
}
