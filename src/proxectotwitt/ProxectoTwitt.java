
package proxectotwitt;

import javax.swing.JOptionPane;
import twitter4j.TwitterException;


public class ProxectoTwitt {

 /**
  * Un menu para seleccionar de cuales de los metodos queremos ejecutar
  * @param args
  * @throws TwitterException 
  */
    public static void main(String[] args) throws TwitterException {
     
         Metodo.acceso();
         
        
        int opcion;

        do { 
            opcion = Integer.parseInt(JOptionPane.showInputDialog("1.TWITEA \n 2.TimeLine \n 3.Buscar un twitt \n 4.Mensaxe Privada \n5.Salir "));
            switch (opcion) {

                case 1:Metodo.twitear(JOptionPane.showInputDialog("¿Que quieres twittear?"));
                    break;
                case 2:Metodo.timeLine();
                    break;
                case 3:Metodo.buscar(JOptionPane.showInputDialog("¿Por que palabra quieres buscar?"));
                    break;
                case 4:Metodo.enviarMensaje(JOptionPane.showInputDialog("¿A quien se lo qieres mandar?"),JOptionPane.showInputDialog("Mensaje: "));
                    break;
                case 5:System.exit(0);
            }

        } 
        while (opcion != 0);
    }
}
      

      
      
        
        
    
    

