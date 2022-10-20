/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema6.mvc.vistas;

import tema6.mvc.controlador.CCalculadora;



/**
 *
 * @author ProfVespertino
 */
public interface ICalculadora {
    public abstract float getOperando1();
    public abstract float getOperando2();
    public abstract String getOperando();
    public abstract void setResultado(float f);
    // Otros metodos
    public abstract void setControlador(CCalculadora c);
    public abstract void mostrar();
}
