/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package snifc.sensor;

import snifc.LinkIfc;
import snifc.PacketIfc;
import java.util.Vector;
import snifc.Simulator;
/**
 *
 * @author mdeclercq
 */


public class IOPorts implements IOPortsIfc{
    
private int id;
private Vector lVector;
private Queue queueIOPort;

    public void IOPorts(int id, Queue queueIOPort){
        
        this.id = id;
        this.lVector = new Vector();
        this.queueIOPort = queueIOPort;
        
    }

    public void addLink(LinkIfc l) throws Exception {
        
        this.lVector.add(l);
        
        
    }

    public void writePacket(PacketIfc p) {
        
        
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public PacketIfc getPackets() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
