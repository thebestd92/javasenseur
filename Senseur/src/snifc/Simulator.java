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
    public int topologie;
    
    public static final int ANNEAU = 0;
    public static final int CENTRALISE = 1;
    public static final int MAILLE = 2;
    public static final int ASYMETRIQUE = 3;
    
    public Simulator(int maxTime, int maxSensor, int memorySize, int ttl, int queueSize){
        this.reset();
        Vsensor=new Vector();
        this.time = 0;
        MAX_TIME = maxTime;
        MAX_SENSOR = maxSensor;
        MEMORY_SIZE = memorySize;
        TTL= ttl ;
        QUEUE_SIZE = queueSize;
        snifc.sensor.Sensor.nbSensor=0;
    }
    
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
        int i,j;
        Sensor sen1;
        Sensor sen2;
        snifc.Link l;
        switch (this.topologie){
            case 0 : System.out.println("Topologie en anneau");
                     for(i=0;i<MAX_SENSOR -1 ;i++){
                        sen1=(Sensor) Vsensor.get(i);
                        sen2=(Sensor) Vsensor.get(i+1);
                        l=new Link(sen1.getPort(),sen2.getPort());
                        System.out.println("Link entre senseur "+i+" et senseur "+(i+1)+" créés ");
                     }
                        sen1=(Sensor) Vsensor.get(MAX_SENSOR-1);
                        sen2=(Sensor) Vsensor.get(0);
                        l=new Link(sen1.getPort(),sen2.getPort());
                        System.out.println("Link entre senseur "+(MAX_SENSOR-1)+" et senseur 0 créés ");
                break;
                
            case 1 : System.out.println("Topologie centralisée");
                     sen1=(Sensor) Vsensor.get(0);
                     for(i=0;i<MAX_SENSOR -1 ;i++){
                        sen2=(Sensor) Vsensor.get(i+1);
                        l=new Link(sen1.getPort(),sen2.getPort());
                        System.out.println("Link entre senseur 0 et senseur "+(i+1)+" créés ");
                     }
                break;
                
            case 2 : System.out.println("Topologie maillée");
            
                     for(i=0;i<MAX_SENSOR -1 ;i++){
                         sen1=(Sensor) Vsensor.get(i);
                          for(j=i;j<MAX_SENSOR ;j++){
                              if (i != j){
                                sen2=(Sensor) Vsensor.get(j);
                                l=new Link(sen1.getPort(),sen2.getPort());
                                System.out.println("Link entre senseur "+i+" et senseur "+j+" créés ");
                              }
                          }
                        }
            
                break;
                
            case 3 : System.out.println("Topologie asymétrique");
                     for(i=0;i< Math.floor((MAX_SENSOR / 2)) ;i++){
                        sen1=(Sensor) Vsensor.get(i);
                        sen2=(Sensor) Vsensor.get(i+1);
                        l=new Link(sen1.getPort(),sen2.getPort());
                        System.out.println("Link entre senseur "+i+" et senseur "+(i+1)+" créés ");
                     }
                        sen1=(Sensor) Vsensor.get((int)Math.floor((MAX_SENSOR-1)/2));
                        sen2=(Sensor) Vsensor.get(0);
                        l=new Link(sen1.getPort(),sen2.getPort());
                        System.out.println("Link entre senseur "+Math.floor((MAX_SENSOR-1)/2)+" et senseur 0 créés ");
                        
                        for(i= ((int)Math.floor((MAX_SENSOR-1)/2)+1);i< MAX_SENSOR ;i++){
                        sen1=(Sensor) Vsensor.get(i - ((int)Math.floor((MAX_SENSOR-1)/2)+1));
                        sen2=(Sensor) Vsensor.get(i);
                        l=new Link(sen1.getPort(),sen2.getPort());
                        System.out.println("Link entre senseur "+(i - ((int)Math.floor((MAX_SENSOR-1)/2)+1))+" et senseur "+(i)+" créés ");
                     }
                break;
        }/*
        for(i=0;i<MAX_SENSOR-1;i++){
            sen1=(Sensor) Vsensor.get(i);
            sen2=(Sensor) Vsensor.get(i+1);
           l=new Link(sen1.getPort(),sen2.getPort());
           System.out.println("Link entre senseur "+i+" et senseur "+(i+1)+" créés ");
        }
        */
        
        
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
            s.topologie = 3;
            s.createSensors();
            s.linkSensors();
            s.runSensors();
            s.showStat();
        } catch (Exception ex) {
            Logger.getLogger(Simulator.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
    }

}
