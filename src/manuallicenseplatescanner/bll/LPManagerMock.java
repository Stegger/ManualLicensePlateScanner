/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manuallicenseplatescanner.bll;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import manuallicenseplatescanner.be.Offender;
import manuallicenseplatescanner.be.Offense;

/**
 *
 * @author pgn
 */
public class LPManagerMock implements ILPManagerFacade
{

    private ArrayList<Offender> allOffenders;

    protected LPManagerMock()
    {
        allOffenders = new ArrayList<>();
        generateOffenders();
    }

    /**
     *
     * @return
     */
    @Override
    public List<Offender> getOffenders()
    {
        return allOffenders;
    }

    @Override
    public List<Offender> searchOffenders(String query)
    {
        if (query.trim().isEmpty())
        {
            return allOffenders;
        }

        ArrayList<Offender> searchResult = new ArrayList<>();

        String srch = "(.*)";
        String pattern = srch;
        for (char c : query.trim().toUpperCase().toCharArray())
        {
            pattern += c + srch;
        }

        System.out.println(pattern);

        for (Offender offender : allOffenders)
        {
            if (offender.getLicense().matches(pattern))
            {
                searchResult.add(offender);
            }
        }
        return searchResult;
    }

    private void generateOffenders()
    {
        HashMap<String, Offender> genOff = new HashMap<>();
        Random rnd = new Random(007);
        for (int i = 0; i < 1000; i++)
        {
            StringBuilder sb = new StringBuilder();
            char a = (char) (rnd.nextInt(26) + 'a');
            char b = (char) (rnd.nextInt(26) + 'a');
            String pre = ("" + a + b).toUpperCase();
            sb.append(pre);
            for (int j = 0; j < 5; j++)
            {
                sb.append(rnd.nextInt(10));
            }
            String license = sb.toString();
            if (!genOff.containsKey(license))
            {
                Offender off = new Offender(license, "Peter Stegger");
                off.addOffense(new Offense("Straywalking", 500));
                off.addOffense(new Offense("Flower picking", 25));
                genOff.put(license, off);
            } else
            {
                i--;
            }
        }
        allOffenders.addAll(genOff.values());
        System.out.println("Size " + allOffenders.size());
    }

}
