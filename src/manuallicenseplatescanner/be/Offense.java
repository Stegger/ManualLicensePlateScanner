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

/**
 *
 * @author pgn
 */
public class Offense
{

    private final StringProperty offense = new SimpleStringProperty();
    private final DoubleProperty fine = new SimpleDoubleProperty();

    public Offense(String offense, double fine)
    {
        setOffense(offense);
        setFine(fine);
    }

    public double getFine()
    {
        return fine.get();
    }

    public void setFine(double value)
    {
        fine.set(value);
    }

    public DoubleProperty fineProperty()
    {
        return fine;
    }

    public String getOffense()
    {
        return offense.get();
    }

    public void setOffense(String value)
    {
        offense.set(value);
    }

    public StringProperty offenseProperty()
    {
        return offense;
    }

    @Override
    public String toString()
    {
        return getOffense() + " - " + getFine();
    }

}
