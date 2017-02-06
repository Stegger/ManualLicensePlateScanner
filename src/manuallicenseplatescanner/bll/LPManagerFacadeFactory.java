/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manuallicenseplatescanner.bll;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 *
 * @author pgn
 */
public class LPManagerFacadeFactory
{

    public enum SystemState
    {

        PROTOTYPE, PRODUCTION

    }

    public static ILPManagerFacade getFacade(SystemState state)
    {
        switch (state)
        {
            case PRODUCTION:
                throw new NotImplementedException();
            case PROTOTYPE:
                return new LPManagerMock();
        }
        throw new RuntimeException("Unknown state");
    }

}
