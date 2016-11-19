/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhointelcom;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
                
                
        Pontos pt = new Pontos(20,largura,altura);
        JFrame application = new JFrame("Resultado");
        application.add(pt);
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setSize(largura,altura);
        application.setVisible(true);
        
        
        Gulosa gulosa = new Gulosa(pt.getCustos(), pt.getCoordenadas(), 2);
        int[] rota = gulosa.getRota();
        String aux = "";
        for (int i = 0; i < rota.length; i++) {
            aux+= "--"+rota[i];
        }
        JOptionPane.showMessageDialog(null, aux);
        
        Calculos cal = new Calculos(pt.getCustos(),gulosa.getRota(),pt.getCoordenadas());
        JFrame s_gulosa = new JFrame("Metodo GUloso");
        s_gulosa.add(cal);
        s_gulosa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        s_gulosa.setSize(largura,altura);
        s_gulosa.setVisible(true);
        
        //Busca Local aleatória
        BuscaLocal bl = new BuscaLocal(5, pt.getCustos());
        Calculos cal2 = new Calculos(pt.getCustos(),bl.getRota(),pt.getCoordenadas());
        JFrame buscaAleatorio = new JFrame("Busca Local Aleatória");
        buscaAleatorio.add(cal2);
        buscaAleatorio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buscaAleatorio.setSize(largura,altura);
        buscaAleatorio.setVisible(true);
        
        //Vizinhança
        VizinhaçaAPI va = new VizinhaçaAPI(5, pt.getCustos(), bl.getRota());
        Calculos cal3 = new Calculos(pt.getCustos(),bl.getRota(),pt.getCoordenadas());
        JFrame buscaAleatorio2 = new JFrame("VizinhaçaAPI Aleatória");
        buscaAleatorio2.add(cal3);
        buscaAleatorio2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buscaAleatorio2.setSize(largura,altura);
        buscaAleatorio2.setVisible(true);

        
    }
    
}
