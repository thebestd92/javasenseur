/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package snifc;

/**
 *
 * @author bchervet
 */
public class Packet implements PacketIfc {
    
    private int ttl;
    private int id;

    public boolean isTimeToLiveOK() {
        if(this.ttl>0){
            return true;
        }else{
            return false;
        }
    }

    public int compareTo(Object o) {
     try {
     Packet p=(Packet)o;
     return new Integer(this.id).compareTo(new Integer(p.id));
     }catch(ClassCastException e){
     throw e;
     }
    }

    public void setId(int id) {
        this.id=id;
    }
    
    public int getId() {
        return this.id;
    }

}
