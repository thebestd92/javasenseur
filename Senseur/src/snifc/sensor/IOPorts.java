/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package snifc.sensor;

import snifc.LinkIfc;
import snifc.PacketIfc;
import java.util.Vector;
import snifc.Link;
import snifc.Simulator;
/**
 *
 * @author mdeclercq
 */


public class IOPorts implements IOPortsIfc{
    
private int id;
private Vector lVector;
private Queue queueIOPort;
private int linkIdWriter;

    public void IOPorts(int id, Queue queueIOPort){
        
        this.id = id;
        this.lVector = new Vector();
        this.queueIOPort = queueIOPort;
        this.linkIdWriter = 0;
    }

    public void addLink(LinkIfc l) throws Exception {
        System.out.println("On ajoute un lien au port");
        this.lVector.add(l);
  
    }

    public void writePacket(PacketIfc p) {
        
       System.out.println("On ecrit le paquet dans un lien");
        for(int i=0; i< this.lVector.size(); i++){
            ((Link)this.lVector.get(i)).transmit(p, this);
        }
  
    }

    public void getPackets() {
        
        System.out.println("On fait un get packet");
        for(int i=0; i< this.lVector.size(); i++){

          if (this.queueIOPort.isFull()){
        }
        else{
        this.queueIOPort.enQueue(((Link)this.lVector.get(i)).getPendingPacket(this));
                
        }
          
        }
        
    }

}
