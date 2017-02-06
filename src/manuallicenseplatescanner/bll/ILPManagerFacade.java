/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manuallicenseplatescanner.bll;

import java.util.List;
import manuallicenseplatescanner.be.Offender;

/**
 *
 * @author pgn
 */
public interface ILPManagerFacade
{

    public List<Offender> getOffenders();

    public List<Offender> searchOffenders(String query);

}
