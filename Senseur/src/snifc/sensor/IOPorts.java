/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package snifc.sensor;

import snifc.LinkIfc;
import snifc.PacketIfc;

/**
 *
 * @author mdeclercq
 */


public class IOPorts implements IOPortsIfc{
    
private int id;

    public void addLink(LinkIfc l) throws Exception {
        
        
        throw new UnsupportedOperationException("Not supported yet.");
        
    }

    public void writePacket(PacketIfc p) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void getPackets() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
