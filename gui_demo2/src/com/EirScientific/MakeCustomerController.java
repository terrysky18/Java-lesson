package com.EirScientific;

import com.EirScientific.OdeonCinema.Customer;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.ActionEvent;

public class MakeCustomerController {

	@FXML
	private TextArea christianName;
	@FXML
	private TextArea surname;
//	@FXML
//	private Label confirmText;
	@FXML
	private Button saveButton;
	@FXML
	private Button closeButton;

	@FXML
	public Customer getNewCustomer() {
		String christian_name = christianName.getText();
		String surname_str = surname.getText();
		Customer customer = new Customer(christian_name, surname_str);
		return customer;
	}
}
