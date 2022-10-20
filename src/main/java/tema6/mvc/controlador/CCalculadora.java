/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema6.mvc.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import tema6.mvc.modelos.MCalculadora;
import tema6.mvc.vistas.ICalculadora;


/**
 *
 * @author ProfVespertino
 */
public class CCalculadora implements ActionListener{
    private ICalculadora vista;
    private MCalculadora modelo;

    public CCalculadora(ICalculadora vista, MCalculadora modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        float a, b, r;        
            
        if (e.getActionCommand().equals("+")) {
            a = vista.getOperando1();
            b = vista.getOperando2();
            modelo.setOp1(a);
            modelo.setOp2(b);
            r = modelo.suma();
            vista.setResultado(r);
        } // etc...
    }
    
    
}
