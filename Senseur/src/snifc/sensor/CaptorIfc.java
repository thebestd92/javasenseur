
package snifc.sensor;

import snifc.PacketIfc;

/**
 *  The captor interface represents a captor from a sensor
 * 
 * @author sfrenot
 *
 **/
public interface CaptorIfc {
	/**
	 * The triggerCapture method is called before the simulation runs.  That method is 
	 * called before the real capture takes place (through the capture method), and positions
	 * a boolean that indicates if a new capture is ready. The trigger Capture can implement various
	 * packet generation policies
	 */
	public abstract void triggerCapture();
	/**
	 * The capture method is called when the sensor needs the next capture packet.
	 * An  exception is thrown if no packet is available (the trigger method has not produced a new
	 * packet). 
	 * @return Packetifc
	 * @throws Exception if the packet has not been produced
	 */
	public abstract PacketIfc capture() throws Exception;
}