package com.company;

import LsysGUI.Turtle;
import LsysRecursive.Grammatik;
import LsysRecursive.RecursiveLsys;
import LsysRecursive.txt;

/**
 * Created by nanna on 25-10-2016.
 */
public class Controller {

    public Controller(){

        //System.out.println("Main is ON");
        txt test = new txt();
        String txtFile = test.getTxtFile();
        //System.out.println("text file is " + txtFile);

        Grammatik grammatik = new Grammatik(txtFile);
        RecursiveLsys lsys = new RecursiveLsys(grammatik);

        //new LsysGUI.GUI(); - udkommenteret for testing purposes
        Turtle turtle = new Turtle(grammatik, lsys);

    }


}
