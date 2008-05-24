/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package snifc.sensor;

import snifc.PacketIfc;
import snifc.Packet;
import snifc.Simulator;
/**
 *
 * @author bchervet
 */
public class Captor implements CaptorIfc {

    private boolean isPaquetReady;


    Captor() {
      
    }
    
    public boolean isPaquetReady(){
        return isPaquetReady;
    }

    
    public void triggerCapture() {
        System.out.println("Triggering d'une capture");
        double rand=Math.random();
        if(rand>0.5){
           this.isPaquetReady=true; 
        }else{
            this.isPaquetReady=false;
        }
    }

    public PacketIfc capture() throws Exception {
        if(this.isPaquetReady){
            
            int ttl = Simulator.TTL;int Emetteurid = 0;
            Packet p=new Packet(Emetteurid,ttl);
            System.out.println("Capture d'un paquet :"+p.toString());
            return p;    
            
        }else{
            throw new Exception("Paquet non prêt");
        }
        
    }
    


}
