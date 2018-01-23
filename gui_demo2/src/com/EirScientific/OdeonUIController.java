package com.EirScientific;

import com.EirScientific.OdeonCinema.Customer;
import com.EirScientific.OdeonCinema.Projection;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.*;


public class OdeonUIController {

	@FXML
	private BorderPane mainWindow;
	@FXML
	private Button projectionToday;
	@FXML
	private Button projectionFuture;
	@FXML
	private Button sellTicket;
	@FXML
	private Button makeCustomer;
	@FXML
	private Button addProjection;
	@FXML
	private Button spectatorReport;
	@FXML
	private Button incomeReport;

	@FXML
	private Button exitButton;
	@FXML
	private Label weekDay;
	@FXML
	private Label currentDate;
	@FXML
	private Label currentTime;
	@FXML
	private ListView centreList;

	// cinema application data
	private List<Projection> projections;

	@FXML
	public void initialize() {
		updateDateTimeLabel();
		handleProjectionToday();
	}

	/**
	 * Continuously update and display the date and time on the application
	 */
	@FXML
	public void updateDateTimeLabel() {
		Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, event -> {
			LocalDate date_now = LocalDate.now();
			LocalTime time_now = LocalTime.now();
			DayOfWeek day_now = date_now.getDayOfWeek();
			DateTimeFormatter date_format = DateTimeFormatter.ofPattern("dd MMMM yyyy");
			DateTimeFormatter time_format = DateTimeFormatter.ofPattern("HH:mm:ss");
			weekDay.setText(day_now.getDisplayName(TextStyle.FULL, Locale.UK));
			currentDate.setText(date_now.format(date_format));
			currentTime.setText(time_now.format(time_format));
		}),
				new KeyFrame(Duration.seconds(1)));
		clock.setCycleCount(Animation.INDEFINITE);
		clock.play();
	}

	/**
	 * Handle all button clicks on UI
	 * @param event
	 */
	@FXML
	public void handleClick(ActionEvent event) {
		if (event.getSource().equals(projectionToday)) {
			// present today's projections
			handleProjectionToday();
		}
		else if (event.getSource().equals(projectionFuture)) {
			handleProjectionFuture();
		}
		else if (event.getSource().equals(makeCustomer)) {

		}
		else if (event.getSource().equals(exitButton)){
			Platform.exit();
			System.exit(0);
		}
		else {

		}
	}

	@FXML
	private void showMakeCustomerDialogue() {
		Dialog<ButtonType> dialogue = new Dialog<ButtonType>();
        dialogue.initOwner(mainWindow.getScene().getWindow());
        dialogue.setTitle("Add New Customer");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("MakeCustomer.fxml"));
        try {
            dialogue.getDialogPane().setContent(fxmlLoader.load());

        } catch(IOException e) {
            System.out.println("Couldn't load the dialogue");
            e.printStackTrace();
            return;
        }

        dialogue.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialogue.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialogue.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK) {
        	MakeCustomerController mcController = fxmlLoader.getController();
			Customer new_customer = mcController.getNewCustomer();

            ContactController contactController = fxmlLoader.getController();
            Contact newContact = contactController.getNewContact();
            data.addContact(newContact);
            data.saveContacts();
        }
	}

	/**
	 * Return a list of projections scheduled for date parameter
	 * The list is sorted by projection time
	 * @param date_param - date parameter
	 * @return ArrayList<Projection>
	 */
	public ArrayList<Projection> getTodayProjections(LocalDate date_param) {
    	ArrayList<Projection> projections = new ArrayList<>();
    	for (Projection single : Odeon.getCurrentProjections()) {
    		if (single.getProjectionDate().isEqual(date_param)) {
    			projections.add(single);
			}
		}
		projections.sort(Comparator.comparing(Projection::getProjectionTime));
		return projections;
	}

	@FXML
	private void handleProjectionToday() {
		projections = Main.getTodayProjections(LocalDate.now());
		centreList.getItems().setAll(projections);
	}

	@FXML
	private void handleProjectionFuture() {
		projections = Main.getFutureProjections(LocalDate.now());
		centreList.getItems().setAll(projections);
	}
}
