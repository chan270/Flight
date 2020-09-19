/**
 * Controller for the FlightsLibrary.fxml, used when user interacts with any button
 * "delete", "add", and "edit" buttons handling included, along with creating a tableView
 * to organize data for the user
 */
package flightsgui;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author chanv
 */
public class FlightsLibraryController implements Initializable {

    /**
     * Initializes the controller class.
     */
    /**
     * Creates a new list object so all Flights objects can be added to an ArrayList
     */
    FlightsList list = new FlightsList();
    
    @FXML
    private TableView<Flights> tableView;
    @FXML
    private TableColumn<Flights, String> flightNumberColumn;
    @FXML
    private TableColumn<Flights, String> destCityColumn;
    @FXML
    private TableColumn<Flights, String> arrivalDateColumn;
    @FXML
    private TableColumn<Flights, String> takeOffLocationColumn;
    @FXML
    private TableColumn<Flights, String> numOfSeatsColumn;
    @FXML
    private TableColumn<Flights, String> planeTypeColumn;
    
    @FXML
    private TextField flightNumberT;
    @FXML
    private TextField destCityT;
    @FXML
    private TextField arrivalT;
    @FXML
    private TextField takeOffT;
    @FXML
    private TextField seatsT;
    @FXML
    private TextField typeT;
    @FXML
    private TextArea error;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        flightNumberColumn.setCellValueFactory(new PropertyValueFactory<Flights,String>("flightNumber"));
        destCityColumn.setCellValueFactory(new PropertyValueFactory<Flights,String>("destinationCity"));
        arrivalDateColumn.setCellValueFactory(new PropertyValueFactory<Flights,String>("arrivalDate"));
        takeOffLocationColumn.setCellValueFactory(new PropertyValueFactory<Flights,String>("takeOffLocation"));
        numOfSeatsColumn.setCellValueFactory(new PropertyValueFactory<Flights,String>("numberOfSeats"));
        planeTypeColumn.setCellValueFactory(new PropertyValueFactory<Flights,String>("planeType"));
        
    }    
    
    public void addFlight(){
        try{
        Flights newFlight = new Flights(flightNumberT.getText(),destCityT.getText(),arrivalT.getText(),
        takeOffT.getText(),seatsT.getText(),typeT.getText());
        
        tableView.getItems().add(newFlight);
        list.addFlights(newFlight);
        }
        catch (IllegalArgumentException i){
            String errorText=""+i;
            error.setText(errorText);
        }
        DAO.writeToFile(list.getFlightsList());
    }
    
    public void deleteFlight(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete this record?",
        ButtonType.YES,ButtonType.NO);
        alert.setTitle("Delete Flight");
        alert.setHeaderText(null);
        Optional<ButtonType> result = alert.showAndWait();
        
        if (result.get()==ButtonType.YES){
        ObservableList<Flights> rowPicked, allFlights;
        allFlights = tableView.getItems();
        
        rowPicked = tableView.getSelectionModel().getSelectedItems();
        
        int rowIndex = tableView.getSelectionModel().getSelectedIndex();
        
        allFlights.removeAll(rowPicked);
        
        list.removeFlights(rowIndex);
        
        DAO.writeToFile(list.getFlightsList());
    }
    }
    
    public void editFlight(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to edit this record?",
        ButtonType.YES,ButtonType.NO);
        alert.setTitle("Delete Flight");
        alert.setHeaderText(null);
        Optional<ButtonType> result = alert.showAndWait();
        
        if (result.get()==ButtonType.YES){
        ObservableList<Flights> allFlights;
        allFlights = tableView.getItems();
        Flights flightPicked = tableView.getSelectionModel().getSelectedItem();
        
        int rowIndex = tableView.getSelectionModel().getSelectedIndex();
        try{
        flightPicked.setArrivalDate(arrivalT.getText());
        flightPicked.setDestinationCity(destCityT.getText());
        flightPicked.setFlightNumber(flightNumberT.getText());
        flightPicked.setTakeOffLocation(takeOffT.getText());
        flightPicked.setNumberOfSeats(seatsT.getText());
        flightPicked.setPlaneType(typeT.getText());
        }
        catch (IllegalArgumentException i){
            String errorText=""+i;
            error.setText(errorText);
        }
        list.editFlights(rowIndex, flightPicked);
        
        allFlights.remove(rowIndex);
        allFlights.add(rowIndex, flightPicked); 
        DAO.writeToFile(list.getFlightsList());
        }
    }
}
    

