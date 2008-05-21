
package snifc.sensor;

import snifc.LinkIfc;
import snifc.PacketIfc;

/**
 * The IOPortsIfc represents connexion the Sensor has with the outside world (through links)
 * The IOPortIfc enables the sensor to send and receive packet through links.
 *
 * @author sfrenot -  2004
 * 
 */
public interface IOPortsIfc {
	/**
	 * That method is used to create a new connexion between the IOPorts and a link. An IOPorts
	 * belongs to the Sensor, whereas the Links is the outside world
	 * @param l the Link to connect to
	 * @throws Exception if the connexion is impossible
	 */
	public abstract void addLink(LinkIfc l) throws Exception;
	/**
	 * That methods is called by the sensor when he wants to write the next packet on the link
	 * @param p the packet to send
	 */
	public abstract void writePacket(PacketIfc p);
	/**
	 * That methods treats all incoming packets on the link. Each available packet (on each entry
	 * of the port) is enqueued on the sensor  waiting queue. If the queue is full, the packet is
	 * destroyed 
	 */
	public abstract PacketIfc getPackets();
}