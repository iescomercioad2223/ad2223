/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema6.mvc.modelos;

/**
 *
 * @author ProfVespertino
 */
public class MCalculadora {
    private float op1, op2;

    public void setOp1(float op1) {
        this.op1 = op1;
    }

    public void setOp2(float op2) {
        this.op2 = op2;
    } 
        
    public float suma() {
        return op1+op2;
    }
    
    public float resta() {
        return op1-op2;
    }
    
}
