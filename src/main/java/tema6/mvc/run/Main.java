package tema6.mvc.run;


import tema6.mvc.controlador.CCalculadora;
import tema6.mvc.modelos.MCalculadora;
import tema6.mvc.vistas.*;

public class Main {

    public static void main(String[] args) {
        //VCalculadora vista = new VCalculadora();
        ICalculadora vista = new VCCalculadora();
        MCalculadora modelo = new MCalculadora();
        CCalculadora controlador = new CCalculadora(vista, modelo);
        
        vista.setControlador(controlador);        
        vista.mostrar();
        
    }
}
