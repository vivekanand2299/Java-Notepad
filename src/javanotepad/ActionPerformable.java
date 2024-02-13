/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javanotepad;

import java.awt.event.ActionEvent;
import java.awt.print.PrinterException;
import java.io.IOException;

interface ActionPerformable 
{
    public void action(ActionEvent e)throws IOException, PrinterException;
}
