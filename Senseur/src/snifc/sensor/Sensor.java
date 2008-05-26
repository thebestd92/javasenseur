/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package snifc.sensor;

import snifc.PacketIfc;

/**
 * @author bchervet
 */
public class Sensor implements SensorIfc {
    
    private Captor captor;
    private IOPorts ioPorts;
    private Queue queue;
    private Memory memory;
    private boolean isNewCaptureReady;
    public static int NB_SENSOR;
    private int idSensor;
    
    public Sensor(){
        
        NB_SENSOR++;
        this.idSensor=NB_SENSOR;
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
                System.out.println("Impossible d'ajouter un nouveau message à la queue");
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
    
    public void enQueue(PacketIfc p){
        this.queue.enQueue(p);
    }
    
    public boolean isQueueFull(){
        return this.queue.isFull();
    }

    public IOPortsIfc getPort() {
       return ioPorts;
    }
    
    @Override
    public String toString(){
        return "    Sensor id: "+this.idSensor+"";
                
    }

}
