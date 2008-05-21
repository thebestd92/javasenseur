/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package snifc.sensor;

import snifc.PacketIfc;
import snifc.Packet;
/**
 *
 * @author bchervet
 */
public class Captor implements CaptorIfc {

    private boolean isPaquetReady;
    
    public void triggerCapture() {
        double rand=Math.random();
        if(rand>0.5){
           this.isPaquetReady=true; 
        }else{
            this.isPaquetReady=false;
        }
    }

    public PacketIfc capture() throws Exception {
        triggerCapture();
        if(this.isPaquetReady){
            int ttl = 0;int id = 0;
            int data=(int)(Math.random()*200000);
            Packet p=new Packet(ttl,id,data);
            return p;    
            
        }else{
            throw new Exception("Paquet non prêt");
        }
        
    }

}
