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
    private int idSensor;
    private final int QUEUE_SIZE;
    private Vector queue;
    
    public Queue(int QUEUE_SIZE){
        this.QUEUE_SIZE=QUEUE_SIZE;
        this.queue=new Vector(QUEUE_SIZE);
       
    }        
    
    public void enQueue(PacketIfc p) {
        System.out.println("Paquet ajouté à la queue");
        System.out.println("La queue comporte "+queue.size()+" paquets");
 
            queue.add(p);

    }

    public PacketIfc deQueue() {
        PacketIfc p= (PacketIfc) queue.firstElement();
        System.out.println("Paquet déqueutté");
        System.out.println(p);
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
