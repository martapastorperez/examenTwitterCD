/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxectotwitt;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.*;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

public class Metodo {
    static ConfigurationBuilder cb;
    static Twitter twitter;
    static Status status;
    static DirectMessage mensaje;
    static ArrayList <Status> twits = new ArrayList<Status>();
    static Iterator <Status>it = twits.iterator();
    
    /**
     * Ponemos nuestros datos para poder acceder a nuestra cuenta, codigos de twitter developers
     */
//      public static void acceso(){
//          
//
//        
//        cb = new ConfigurationBuilder();
//        cb.setDebugEnabled(true);
//        cb.setOAuthConsumerKey("nipbbZAo4YYvZTiJ9eTqoweor");
//        cb.setOAuthConsumerSecret("bBPcuZLVDzrhvcRYkLHgoEAy7TGgzgJtrTtYn4zL2UowgVEyHn");
//        cb.setOAuthAccessToken("848794118230769664-eRC9ShFPcKgnOZh9U6hRQOSfHGISCyY");
//        cb.setOAuthAccessTokenSecret("or2LmVjEXELuaRtjJSPDH1CMlQCWIH4rbPfGGMRQ9nDho");
//        TwitterFactory tf = new TwitterFactory(cb.build());
//        twitter = tf.getInstance();
//    }
/**
 * Con esto visualizaremos todos nuestros twitts publicados
 */
    public static void timeLine () {

        List<Status> statuses;

        try {
            statuses= twitter.getHomeTimeline();
            System.out.println("Enseñando timeline.");
            for (twitter4j.Status status : statuses) {
                System.out.println(status.getUser().getName() + ":"
                        + status.getText());
                twits.add(status);
            }
        } catch (TwitterException ex) {
            java.util.logging.Logger.getLogger(Metodo.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
/**
 * Pasamos el parametro publicacion que es lo que twittearemos (añadiremos un nuevo estado a nuestra red social)
 * @param publicacion 
 */
   public static void twitear(String publicacion) {
    try {
            status = twitter.updateStatus(publicacion);
            System.out.println("Publicacion -> [" + status.getText() + "].");
        } catch (TwitterException ex) {
            java.util.logging.Logger.getLogger(Metodo.class.getName()).log(Level.SEVERE, null, ex);
        }
}

/**
 * Pasaremos el paremetro buscar para buscar todos los twits con esa palabra
 * @param buscar 
 */
    public static void buscar(String buscar) {

        QueryResult result;
        try {
           Query query = new Query(JOptionPane.showInputDialog("Hashtag a buscar: "));
            result=twitter.search(query);
            for (twitter4j.Status statuse : result.getTweets()) {
            System.out.println("@" + statuse.getUser().getScreenName() + ":" + statuse.getText());
            }
        }catch (TwitterException ex) {
            java.util.logging.Logger.getLogger(Metodo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

/**
 * Elegiremos el destinatario al que le queremos mandar el mensaje y el mensaje que le escribiremos
 * @param destinatario
 * @param mensaje 
 */
   public static void enviarMensaje(String destinatario, String mensaje) {

        try {

            Metodo.mensaje = twitter.sendDirectMessage(destinatario, mensaje);
        } catch (TwitterException ex) {
            java.util.logging.Logger.getLogger(Metodo.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Enviar: " + Metodo.mensaje.getText() + " a @" + Metodo.mensaje.getRecipientScreenName());

    }
    
    
    
}
