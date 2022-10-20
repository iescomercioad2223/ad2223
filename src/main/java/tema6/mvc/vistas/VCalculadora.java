/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema6.mvc.vistas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import tema6.mvc.controlador.CCalculadora;

public class VCalculadora extends JFrame implements ICalculadora {
    private JTextField jtxtOp1, jtxtOp2;
    private JComboBox jcboOperando;
    private JLabel jlbResultado;
    private JButton jbtnCalcular, jbtnLimpiar;
    private CCalculadora controlador;

    public VCalculadora()  {
        jtxtOp1 = new JTextField();
        jtxtOp2 = new JTextField();
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement("+");
        model.addElement("-");
        jcboOperando = new JComboBox(model);
        jlbResultado = new JLabel("Resultado:");
        jbtnCalcular = new JButton("Calcular");
        jbtnCalcular.setActionCommand("+");
        jbtnLimpiar = new JButton("Limpiar");
        //BoxLayout box = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);
        getContentPane().setLayout(new GridLayout(6,1));        
        getContentPane().add(jtxtOp1);
        getContentPane().add(jcboOperando);
        getContentPane().add(jtxtOp2);
        getContentPane().add(jbtnCalcular);
        getContentPane().add(jbtnLimpiar);
        getContentPane().add(jlbResultado);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jbtnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtxtOp1.setText("");
                jtxtOp2.setText("");
            }
        });
        
        
        setLocationRelativeTo(null);                
        pack();

        
    }
        

    @Override
    public float getOperando1() {
        float aux = Float.parseFloat(jtxtOp1.getText());
        return aux;
    }

    @Override
    public float getOperando2() {
        float aux = Float.parseFloat(jtxtOp2.getText());
        return aux;
    }

    @Override
    public String getOperando() {
        String s = (String) jcboOperando.getModel().getSelectedItem();        
        return s;
    }

    @Override
    public void setResultado(float f) {
        jlbResultado.setText("Resultado:" + f);
    }

    @Override
    public void setControlador(CCalculadora c) {
        this.controlador = c;
        jbtnCalcular.addActionListener(controlador);        
    }
    
    @Override
    public void mostrar() {
        this.setVisible(true);
    }
    
}
