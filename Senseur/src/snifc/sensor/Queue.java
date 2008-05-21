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
        if(queue.size()<QUEUE_SIZE){
            queue.add(p);
        }else{
            System.out.println("Queue pleine, objet non ajoutée");
        }
    }

    public PacketIfc deQueue() {
        return (PacketIfc) queue.firstElement();

    }

}
