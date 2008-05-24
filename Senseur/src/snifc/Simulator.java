/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package snifc;

import java.util.Vector;

import java.util.logging.Level;
import java.util.logging.Logger;
import snifc.sensor.Sensor;

/**
 *
 * @author bchervet
 */
public  class Simulator implements SimulatorIfc {
    
    Vector Vsensor;
    private int time;
    private static int MAX_SENSOR;
    private int MAX_TIME;
    public static int MEMORY_SIZE;
    public static int TTL;
    public static int QUEUE_SIZE;
    
    public Simulator(){
        this.reset();
        Vsensor=new Vector();
        time=0;
        MAX_TIME=10;
        MAX_SENSOR=5;
        MEMORY_SIZE = 10;
        TTL= 5 ;
        QUEUE_SIZE = 20;
        snifc.sensor.Sensor.nbSensor=0;
    }
    
    public void reset() {
        Vsensor=new Vector(MAX_SENSOR);
        snifc.sensor.Sensor.nbSensor=0;
        snifc.Packet.NB_PACKET=0;
        snifc.Link.LINK_NUMBER=0;
        
        
        
    }

    public void createSensors() throws Exception {
        System.out.println("Creation de "+MAX_SENSOR+" sensors");
        for(int i=0;i<MAX_SENSOR;i++){
            Vsensor.add(new Sensor());
        }
        
    }

    public void linkSensors() throws Exception {
        
        System.out.println("Lancement de linkSensors");
        for(int i=0;i<MAX_SENSOR-1;i++){
            Sensor sen1=(Sensor) Vsensor.get(i);
            Sensor sen2=(Sensor) Vsensor.get(i+1);
           snifc.Link l=new Link(sen1.getPort(),sen2.getPort());
           System.out.println("Link entre senseur "+i+" et senseur "+(i+1)+" créés ");
        }
        
        
        
    }

    public void runSensors() throws Exception {
        
        System.out.println("lancement de runSensors");
        
        for(this.time=0; time < MAX_TIME;time++){
            System.out.println("--------------------------------");
            System.out.println("t="+time);
            System.out.println("--------------------------------");
            
            for(int j=0; j< Vsensor.size();j++){
                Sensor sen=(Sensor) Vsensor.get(j);
                sen.activateCaptor();
            }
            
            for(int j=0; j< Vsensor.size();j++){
                Sensor sen=(Sensor) Vsensor.get(j);
                sen.activatePort();
            }
            
            for(int j=0; j< Vsensor.size();j++){
                Sensor sen=(Sensor) Vsensor.get(j);
                sen.activateQueue();
            }
            System.out.println("Simulation terminée");
        }
    }

    public void showStat() {
        
        System.out.println("Simulation terminée, vous pouvez regagner votre place calmement");
        System.out.println("    Nombre de liens crées : "+Link.LINK_NUMBER);
        System.out.println("    Nombre de paquets créés : "+Packet.NB_PACKET);
        System.out.println("    Nombre de paquets transmis: "+Packet.NB_TRANS);
     
        
    }
    
    public static void main(String[] args){
        try {
            Simulator s = new Simulator();
            s.createSensors();
            s.linkSensors();
            s.runSensors();
            s.showStat();
        } catch (Exception ex) {
            Logger.getLogger(Simulator.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
    }

}
