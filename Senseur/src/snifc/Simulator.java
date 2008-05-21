/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package snifc;

/**
 *
 * @author bchervet
 */
public  class Simulator implements SimulatorIfc {

    public static int MEMORY_SIZE;
    public static int TTL;
    public static int QUEUE_SIZE;
    
    public void reset() {
        
        MEMORY_SIZE = 10;
        TTL= 5 ;
        QUEUE_SIZE = 20;
        
    }

    public void createSensors() throws Exception {
        System.out.println("Creation sensors");
    }

    public void linkSensors() throws Exception {
        
        System.out.println("Lancement de linkSensors");
        
        
    }

    public void runSensors() throws Exception {
        System.out.println("lancement de runSensors");
    }

    public void showStat() {
        
        System.out.println("Simulation terminée, vous pouvez regagner votre place calmement");
        System.out.println("    Nombre de liens crées : ");
        System.out.println("    Nombre de paquets transmis : ");
        System.out.println("    Nombre de ports : ");
        
    }

}
