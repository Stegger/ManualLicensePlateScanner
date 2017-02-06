/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manuallicenseplatescanner.be;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author pgn
 */
public class Offender
{

    private final ObservableList<Offense> offenses = FXCollections.observableArrayList();
    private final DoubleProperty fines = new SimpleDoubleProperty();
    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty license = new SimpleStringProperty();

    public Offender()
    {

    }

    @Override
    public String toString()
    {
        return getLicense() + " - " + getName();
    }

    public Offender(String license, String name)
    {
        setName(name);
        setLicense(license);
    }

    public ObservableList<Offense> getOffenses()
    {
        return offenses;
    }

    public void addOffense(Offense offense)
    {
        offenses.add(offense);
        fines.set(fines.get() + offense.getFine());
    }

    public String getLicense()
    {
        return license.get();
    }

    public String getName()
    {
        return name.get();
    }

    public void setName(String value)
    {
        name.set(value);
    }

    public StringProperty nameProperty()
    {
        return name;
    }

    public double getFines()
    {
        return fines.get();
    }

    public void setFines(double value)
    {
        fines.set(value);
    }

    public DoubleProperty finesProperty()
    {
        return fines;
    }

    public void setLicense(String value)
    {
        license.set(value);
    }

    public StringProperty licenseProperty()
    {
        return license;
    }

}
