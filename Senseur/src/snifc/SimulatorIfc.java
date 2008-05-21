package snifc;

/**
 * The SimulatorIfc represents the interface any simulator should implements
 * Each step of the simulator is implemented through a hook method. 
 * Steps are triggered in that order
 *   - reset() 
 *   - createSensors()
 *   - linkSensors()
 *   - runSensors()
 *   - showStats()
 * 
 * @author sfrenot
 *
 */
public interface SimulatorIfc {
	/**
	 * The reset function is call when a new simulation is made. All parameters should be 
	 * resetted to their simulation value. (TTL, QueueSize, Steps, MemorySize, Capture Frequency...)
	 **/
	public abstract void reset();
	/**
	 * Create sensors create sensors of the network. 
	 * @see snifc.sensor.SensorIfc
	 * @throws Exception If a sensor cannot be create
	 **/
	public abstract void createSensors() throws Exception;
	/**
	 * Create links in the network
	 * @see snifc.LinkIfc
	 * @throws Exception if a link is not valid
	 **/
	public abstract void linkSensors() throws Exception;
	/**
	 * Runs the simulation. This is the main execution loop. 
	 * @throws Exception
	 **/
	public abstract void runSensors() throws Exception;
	/**
	 * At the end of a simultation, results are presented when that method is called
	 */
	public abstract void showStat();
}