/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package snifc;

import snifc.sensor.IOPortsIfc;

/**
 *
 * @author mdeclercq
 */
public class Link implements LinkIfc {

    public int linkNumber;
    /*2 packets and 2 ports are created */
    private PacketIfc fromPacket;
    private PacketIfc toPacket;
    private IOPortsIfc fromPort;
    private IOPortsIfc toPort;
    
    public void transmit(PacketIfc p, IOPortsIfc from) {
        
        if ( this.fromPort == from){
            this.fromPacket = p;
        }else{
            this.toPacket = p;    
        }        
     
    }

    public PacketIfc getPendingPacket(IOPortsIfc s) {
       if ( this.fromPort == s){
         return this.fromPacket;  
       }else{
         return this.toPacket;  
       }
   
    }

    public int getId() {
        
        return this.linkNumber;
        
        
    }

}
