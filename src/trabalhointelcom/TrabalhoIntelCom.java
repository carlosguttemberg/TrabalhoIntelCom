/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhointelcom;

import javax.swing.JFrame;

/**
 *
 * @author carlos
 */
public class TrabalhoIntelCom {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       int largura=800, altura=600;
                
                
        Pontos pt = new Pontos(4,largura,altura);
        JFrame application = new JFrame("Resultado");
        application.add(pt);
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setSize(largura,altura);
        application.setVisible(true);
        
        
    }
    
}
