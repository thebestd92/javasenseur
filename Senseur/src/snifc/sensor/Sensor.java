/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package snifc.sensor;

import java.util.logging.Level;
import java.util.logging.Logger;
import snifc.PacketIfc;

/**
 * @author bchervet
 */
public class Sensor implements SensorIfc {
    
    private Captor captor;
    private IOPorts ioPorts;
    public Queue queue;
    private Memory memory;
    private boolean isNewCaptureReady;
    public static int nbSensor;
    private int idSensor;
    
    public Sensor(){
        this.captor=new Captor();
        this.ioPorts=new IOPorts(this);
        this.queue=new Queue();
        this.memory=new Memory();
    }
    public void simulateCapture() {
        
        double rand=Math.random();
        if(rand>0.5){
            isNewCaptureReady=true;
        }else{
            isNewCaptureReady=false;
        }
    }

    public void activateCaptor(){
        captor.triggerCapture();
        if(captor.isPaquetReady()){
            try {                
                queue.enQueue(captor.capture());
            } catch (Exception ex) {
                Logger.getLogger(Sensor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void activatePort() {
        this.ioPorts.getPackets();
    }

    public void activateQueue() {
        if(queue.getSize()>0){
            PacketIfc p=queue.deQueue();
            memory.store(p);
            ioPorts.writePacket(p);
        }
    }

    public IOPortsIfc getPort() {
       return ioPorts;
    }

}
