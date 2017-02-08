/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manuallicenseplatescanner.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import manuallicenseplatescanner.be.Offender;
import manuallicenseplatescanner.be.Offense;
import manuallicenseplatescanner.gui.model.LicensePlateScannerModel;

/**
 *
 * @author pgn
 */
public class LicensePlateScannerController implements Initializable
{
    
    @FXML
    private ListView<Offense> listOffenses;
    @FXML
    private ListView<Offender> listSearch;
    @FXML
    private TextField txtInFine;
    @FXML
    private TextField txtInOffense;
    @FXML
    private TextField txtOutFines;
    @FXML
    private TextField txtOutLicense;
    @FXML
    private TextField txtOutName;
    @FXML
    private TextField txtSearch;
    
    private LicensePlateScannerModel model;
    
    public LicensePlateScannerController()
    {
        model = new LicensePlateScannerModel();
    }
    
    @FXML
    private void addOffense(ActionEvent event)
    {
        System.out.println("Method addOffense - THREAD: " + Thread.currentThread().getName());
        try
        {
            String offense = txtInOffense.getText().trim();
            double fine = Double.parseDouble(txtInFine.getText().trim());
            if (!offense.isEmpty())
            {
                Offender offender = listSearch.getSelectionModel().getSelectedItem();
                if (offender != null)
                {
                    offender.addOffense(new Offense(offense, fine));
                }
            }
        } catch (Exception e)
        {
            System.out.println("Nothing happens in the prototype.."); //SHAME ON ME!
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
         System.out.println("Method controller init - THREAD: " + Thread.currentThread().getName());
        listSearch.setItems(model.getOffenders());
        
        listSearch.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Offender>()
        {
            @Override
            public void changed(ObservableValue<? extends Offender> observable, Offender oldValue, Offender newValue)
            {
                txtInFine.clear();
                txtInOffense.clear();
                
                txtOutLicense.textProperty().bind(newValue.licenseProperty());
                txtOutFines.textProperty().bind(newValue.finesProperty().asString());
                txtOutName.textProperty().bind(newValue.nameProperty());
                listOffenses.setItems(newValue.getOffenses());
            }
        });
    }
    
    @FXML
    private void performSearch(ActionEvent event)
    {
         System.out.println("Method search - THREAD: " + Thread.currentThread().getName());
        String query = txtSearch.getText().trim();
        model.search(query);
    }
    
}
