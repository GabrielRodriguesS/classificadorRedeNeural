/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author rodri
 */
public class SeparadorUtils {

    public static String getSeparador(Object selectedItem) {
        if (selectedItem.equals("espaço")) {
            return " ";
        } else if (selectedItem.equals("tab")) {
            return "    ";
        }
        return (String) selectedItem;
    }
}
