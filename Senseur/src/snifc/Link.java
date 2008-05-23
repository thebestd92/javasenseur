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

    public static int LINK_NUMBER=0;
    private int id;
    /*2 packets and 2 ports are created */
    private PacketIfc fromPacket;
    private PacketIfc toPacket;
    private IOPortsIfc fromPort;
    private IOPortsIfc toPort;
    
    
    public void Link(IOPortsIfc fromPort , IOPortsIfc toPort, int temps){
        
        this.toPort = toPort;
        this.fromPort = fromPort;
        this.LINK_NUMBER++;
        this.id = LINK_NUMBER;
    }
    
    public void transmit(PacketIfc p, IOPortsIfc from) {
        
        if ( this.fromPort == from){
            this.fromPacket = p;
        }else if(this.toPort== from){
            this.toPacket = p;    
        }        
     
    }

    public PacketIfc getPendingPacket(IOPortsIfc s) {
       PacketIfc returnPacket;
        if ( this.fromPort == s){
         returnPacket= this.fromPacket;  
       }else if (this.toPort ==s){
         returnPacket= this.toPacket;  
       }
       return returnPacket;
    }

    public int getId() {
        
        return this.id;
        
        
    }

}
