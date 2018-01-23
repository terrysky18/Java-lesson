package com.EirScientific;

import com.EirScientific.OdeonCinema.Cinema;
import com.EirScientific.OdeonCinema.Film;
import com.EirScientific.OdeonCinema.Projection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

public class Main extends Application {

	private static Cinema Odeon;
	private static Stage mainWindow;
	private static Scene mainScene;
	private static Scene makeCustomer;

    @Override
    public void start(Stage primaryStage) throws Exception{
		// initialisation
		Odeon = new Cinema();
		setProjection(Odeon);

        // Load the grid pane with FXMLoader
		mainWindow = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("OdeonUI.fxml"));

        mainWindow.setTitle("Odeon Cinema");
        mainScene = new Scene(root, 950, 575);
        mainWindow.setScene(mainScene);


        mainWindow.show();
    }


	/**
	 * Return a list of projections scheduled for date parameter
	 * The list is sorted by projection time
	 * @param date_param - date parameter
	 * @return ArrayList<Projection>
	 */
	public static ArrayList<Projection> getTodayProjections(LocalDate date_param) {
    	ArrayList<Projection> projections = new ArrayList<>();
    	for (Projection single : Odeon.getCurrentProjections()) {
    		if (single.getProjectionDate().isEqual(date_param)) {
    			projections.add(single);
			}
		}
		projections.sort(Comparator.comparing(Projection::getProjectionTime));
		return projections;
	}

	/**
	 * Return a list of projections scheduled after date parameter
	 * @param date_param - date parameter
	 * @return ArrayList<Projection>
	 */
	public static ArrayList<Projection> getFutureProjections(LocalDate date_param) {
    	ArrayList<Projection> projections = new ArrayList<>();
    	for (Projection single : Odeon.getCurrentProjections()) {
    		if (single.getProjectionDate().isAfter(date_param)) {
    			projections.add(single);
			}
		}
		return projections;
	}

    public static void main(String[] args) {
        launch(args);
    }

    private void setProjection(Cinema cinema) {
 		String[] film_names = {"Lawrence of Arabia",
						"Kingsman The Secret Service",
						"\'76",
						"The King's Speech",
						"The Grand Budapest Hotel",
						"Suffragette",
						"Ex Machina",
						"The Danish Girl",
						"Macbeth",
						"Spooks:  The Greater Good",
						"Bridget Jones' Baby",
						"Florence Foster Jenkins",
						"The Death of Stalin",
						"Dunkirk",
						"Mary Shelby",
						"Victoria & Abdul",
						"Tulip Fever",
						"My Cousin Rachel"};
		// add films and projections to cinema
		// set some projections in the past so reviews can be added
		int screen_id = 1;
		LocalDate date1 = LocalDate.now().minusMonths(1);
		LocalDate date2 = date1.plusDays(10);

		for (String film_name : film_names) {
			Film film = new Film(film_name);
			Odeon.addFilm(film);
			if (screen_id < 7) {
				Odeon.setProjectionSchedule(film, Integer.toString(screen_id), date1, date2);
			}
			else {
				// all 6 screens in use, reset the screen ID
				date1 = date2.plusDays(1);
				date2 = date1.plusDays(10);
				screen_id = 1;
				Odeon.setProjectionSchedule(film, Integer.toString(screen_id), date1, date2);
			}
			screen_id++;
		}
	}
}
