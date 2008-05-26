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

    
    
    Link(IOPortsIfc fromPort , IOPortsIfc toPort){
        try {
            System.out.println("---Création d'un lien");
            System.out.println("    Port from: "+fromPort);
            System.out.println("    Port to: "+toPort);

            this.toPort = toPort;
            this.fromPort = fromPort;
            LINK_NUMBER++;
            this.id = LINK_NUMBER;
            fromPort.addLink(this);
            toPort.addLink(this);
        } catch (Exception ex) {
           System.out.println("!!!Impossible d'ajouter les ports au lien");
        }
    }
    
    public void transmit(PacketIfc p, IOPortsIfc from) {
        System.out.println("---Transmission d'un paquet");
        System.out.println("    Paquet: "+p.toString());
        System.out.println("    Emetteur: "+from.toString());
        Packet.NB_TRANS++;
        if ( this.fromPort == from){
            this.fromPacket = p;
        }else if(this.toPort== from){
            this.toPacket = p;    
        }        
     
    }

    public PacketIfc getPendingPacket(IOPortsIfc s) {
       PacketIfc returnPacket=null;
        if ( this.fromPort == s){
         returnPacket= this.fromPacket;  
       }else if (this.toPort ==s){
         returnPacket= this.toPacket;  
       }
       if(returnPacket==null){
           System.out.println("---Récupération d'un paquet");
           System.out.println("     Paquet: "+returnPacket);
           System.out.println("     Port: "+ s.toString());
       }
       return returnPacket;
    }

    public int getId() {
        
        return this.id;
        
        
    }
    
    public String toString(){
        return "de "+this.fromPort+"à "+this.toPort;
    }

}
