/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author edmar_sr
 */
public class DiaHora extends Thread {
    
    Calendar calendario = new GregorianCalendar();
    
    SimpleDateFormat sdfDia = new SimpleDateFormat("dd-MM-yyyy");
    SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm:ss");
    
    private JTextField caixa;

    public DiaHora(JTextField caixa) {
        this.caixa = caixa;
    }
   
    public void run() {
        while (true) {
            try {
                Calendar c=Calendar.getInstance();
                Date diaCompleto = c.getTime();
           
                String horaCompleta = sdfHora.format(diaCompleto).toString();
                String anoCompleto = sdfDia.format(diaCompleto).toString();
                this.caixa.setText(horaCompleta+"  "+anoCompleto);
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(null, ex);
                Logger.getLogger(DiaHora.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
