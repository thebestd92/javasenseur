/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package snifc.sensor;

import snifc.PacketIfc;
import java.util.Vector;

/**
 *
 * @author bchervet
 */
public class Queue implements QueueIfc {

    private final int QUEUE_SIZE=3;
    private Vector queue;
    
    public Queue(){
        this.queue=new Vector();
        this.queue.setSize(0);
       
    }        
    
    public void enQueue(PacketIfc p) {
        if(isFull()==false){
        System.out.println("Paquet ajouté à la queue");
        System.out.println("La queue comporte "+queue.size()+" paquets");
        
            queue.add(p);
        }    
    }

    public PacketIfc deQueue() {
        PacketIfc p= null;
        if(queue.size()>0){
            p=(PacketIfc) queue.firstElement();
            queue.remove(0);
            System.out.println("Paquet déqueutté");
            System.out.println(p);}
        return p;

    }
    
    public int getSize(){

        return queue.size();
    }
    
    public boolean isFull(){
        if(this.getSize()>=this.QUEUE_SIZE){
          return true;  
        }else{
            return false;
        }
    }

}
