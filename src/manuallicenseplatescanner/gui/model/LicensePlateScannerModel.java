/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manuallicenseplatescanner.gui.model;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import manuallicenseplatescanner.be.Offender;
import manuallicenseplatescanner.bll.ILPManagerFacade;
import manuallicenseplatescanner.bll.LPManagerFacadeFactory;

/**
 *
 * @author pgn
 */
public class LicensePlateScannerModel
{

    private ILPManagerFacade licensePlateManager;

    private final ObservableList<Offender> offenders;

    public LicensePlateScannerModel()
    {
        offenders = FXCollections.observableArrayList();
        licensePlateManager = LPManagerFacadeFactory.getFacade(LPManagerFacadeFactory.SystemState.PROTOTYPE);
        offenders.addAll(licensePlateManager.getOffenders());

    }

    public ObservableList<Offender> getOffenders()
    {
        return offenders;
    }

    public void search(String query)
    {
        List<Offender> serchedOffenders = licensePlateManager.searchOffenders(query);
        offenders.clear();
        offenders.addAll(serchedOffenders);
    }

}
