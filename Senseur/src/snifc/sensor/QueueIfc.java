
package snifc.sensor;

import snifc.PacketIfc;

/**
 *
 * The QueueIfc, represents the Queue of the sensor. A queue maintains a fixed size of incoming
 * Incoming elements come from either the Captor or the IOPort. Priority is given to the Captor 
 * which means that if a new capure is made, it is always put in the sensor's queue. 
 * Two methods are used to queue and deQueue a packet.
 * The size of a queue is limited to QUEUE_SIZE elements.
 * 
 * @author sfrenot
 * 
 * */
public interface QueueIfc {

    /**
     * Puts a Packet p in the queue. If the queue is full, the packet is deleted.
     * 
     * @param p the interface representing a packet
     */
	public abstract void enQueue(PacketIfc p);
	/**
	 * That method is called when the next queued packet has to be extracted from the queue. 
	 * @return null if their is no new packet. The next Packet otherwise
	 */
	public abstract PacketIfc deQueue();
}