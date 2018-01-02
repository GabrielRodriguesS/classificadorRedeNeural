/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import javax.swing.JTextField;

/**
 *
 * @author rodri
 */
public class InputUtils {

    public static Integer parseInt(JTextField text) {
        return Integer.parseInt(text.getText());
    }

    public static Float parseFloat(JTextField text) {
        return Float.parseFloat(text.getText());
    }
}
