package LsysGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

/**
 * Created by naja on 01-12-2016.
 */
public class ButtonNode {

    Color greenCol = new Color(34,139,34);
    JButton terminalBtn;
    ButtonNodeActionListener buttonListener;

    public ButtonNode(AffineTransform currentT) {

        int buttonX = (int) currentT.getTranslateX();
        int buttonY = (int) currentT.getTranslateY();
        int buttonsize = 10;

        terminalBtn = new JButton();

        terminalBtn.setBounds(buttonX-buttonsize/2,buttonY-buttonsize,buttonsize,buttonsize);
        terminalBtn.setBackground(Color.MAGENTA);
        buttonListener = new ButtonNodeActionListener();
        terminalBtn.addActionListener(buttonListener);

    }
}
