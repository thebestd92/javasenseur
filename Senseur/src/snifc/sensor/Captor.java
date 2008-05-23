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
    private int id;
    
    public Captor(int id){
        this.id=id;
    }
    
    public void triggerCapture() {
        double rand=Math.random();
        if(rand>0.5){
           this.isPaquetReady=true; 
        }else{
            this.isPaquetReady=false;
        }
    }

    public PacketIfc capture() throws Exception {
        if(this.isPaquetReady){
            int ttl = 10;int Emetteurid = 0;
            Packet p=new Packet(Emetteurid,ttl);
            return p;    
            
        }else{
            throw new Exception("Paquet non prêt");
        }
        
    }
    


}
