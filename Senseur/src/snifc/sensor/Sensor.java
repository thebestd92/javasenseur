/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package snifc.sensor;

import java.util.logging.Level;
import java.util.logging.Logger;
import snifc.PacketIfc;

/**
 *
 * @author bchervet
 */
public class Sensor implements SensorIfc {
    
    private Captor captor;
    private IOPorts ioPorts;
    private Queue queue;
    private Memory memory;
    private boolean isNewCaptureReady;
    
    public void simulateCapture() {
        
        double rand=Math.random();
        if(rand>0.5){
            isNewCaptureReady=true;
        }else{
            isNewCaptureReady=false;
        }
    }

    public void activateCaptor(){
        if(isNewCaptureReady){
            try {
                captor.triggerCapture();
                queue.enQueue(captor.capture());
            } catch (Exception ex) {
                Logger.getLogger(Sensor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void activatePort() {

      
    }

    public void activateQueue() {
        PacketIfc p=queue.deQueue();
        memory.store(p);
        ioPorts.writePacket(p);
        
    }

    public IOPortsIfc getPort() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
