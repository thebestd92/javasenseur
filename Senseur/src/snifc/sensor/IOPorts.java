/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package snifc.sensor;

import snifc.LinkIfc;
import snifc.PacketIfc;
import java.util.Vector;
import snifc.Link;
import snifc.Packet;



/**
 *
 * @author mdeclercq
 */


public class IOPorts implements IOPortsIfc{
    
private static int NB_PORT=8;
private Sensor sensor;
private Vector lVector;
private int linkIdWriter;

    
    public IOPorts(Sensor s){
        this.sensor=s;
        this.lVector = new Vector(NB_PORT);
        this.linkIdWriter = 0;

    }

    public void addLink(LinkIfc l) throws Exception {
        if(lVector.size()<NB_PORT){
        System.out.println("---On ajoute un lien au port");
        this.lVector.add(l);}else{
            throw new Exception("!!!Nb de port max atteint");
        }
  
    }

    public void writePacket(PacketIfc p) {
        
       System.out.println("---Ecriture des paquets ");
       if(p.isTimeToLiveOK()){ 
           for(int i=0; i< this.lVector.size(); i++){
               Link l=(Link) this.lVector.get(i);
               System.out.println("---Envoie d'un paquet dans le lien : "+l.toString());
                ((Link)this.lVector.get(i)).transmit(new Packet(p), this);
            }
       }
    }

    public void getPackets() {
        
        System.out.println("---Get Packet");
        for(int i=0; i< this.lVector.size(); i++){

              if (this.sensor.isQueueFull()){
            }
            else{
                Packet p=(Packet)(((Link)this.lVector.get(i)).getPendingPacket(this));
                if(p!=null){
                    System.out.println("---Reception du paquet suivant par lien");
                    System.out.println("        :"+p);
                    p.decremTtl();
                    this.sensor.enQueue(p);
                }
            }
          
        }
        
    }
    
  
    public String toString(){
        return ""+this.sensor.toString();
    }

}
