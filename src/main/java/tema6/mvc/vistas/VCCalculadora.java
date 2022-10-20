/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema6.mvc.vistas;

import java.awt.event.ActionEvent;
import java.util.Scanner;
import tema6.mvc.controlador.CCalculadora;

/**
 *
 * @author ProfVespertino
 */
public class VCCalculadora implements ICalculadora{
    private int operando1, operando2;
    private String operador;
    private float resultado;
    private CCalculadora controlador;
    

    @Override
    public float getOperando1() {
        return this.operando1;
    }

    @Override
    public float getOperando2() {
        return this.operando2;
    }

    @Override
    public String getOperando() {
        return this.operador;
    }

    @Override
    public void setResultado(float f) {
        this.resultado =f;
    }

    @Override
    public void setControlador(CCalculadora c) {
        this.controlador = c;
    }

    @Override
    public void mostrar() {
        Scanner s = new Scanner(System.in);
        System.out.println("Operando 1:");        
        this.operando1 = s.nextInt();
        System.out.println("Operando 2:");
        this.operando2 = s.nextInt();
        System.out.println("Operador (+,-,*,/):");
        s.nextLine(); // Absurdo pero necesario
        this.operador = s.nextLine();
        ActionEvent ae = new ActionEvent(this, 1, this.operador);
        this.controlador.actionPerformed(ae);
        System.out.println("Resuldado es: " + this.resultado);
    }
    
}
