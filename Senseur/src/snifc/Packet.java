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
    
    private int idEmetteur;
    private int ttl;
    private int id;
   public static int NB_PACKET=0;
   public static int NB_TRANS;
    
    public Packet(int Emetteurid){
        idEmetteur = Emetteurid;
        NB_PACKET++;
        id=NB_PACKET+1;
        this.ttl=Simulator.TTL;
    }
    
    public Packet(int Emetteurid, int ttl){
        idEmetteur = Emetteurid;
        NB_PACKET++;
        id=NB_PACKET+1;
        this.ttl=ttl;
    }
    
    public Packet(Packet pbis){
        Packet p= new Packet(pbis.idEmetteur,pbis.ttl);
        p.id=pbis.id;
    }
    public Packet(PacketIfc pIfc){
        Packet p = (Packet) pIfc;
        this.idEmetteur=p.idEmetteur;
        this.ttl=p.ttl;
        this.id=Packet.NB_PACKET;
    }
    
    public int getIdEmetteur(){
        return this.idEmetteur;
    }
    public void decremTtl(){
        this.ttl=this.ttl-1;
    }
    public Packet (int ttl, int id, int idemetteur){
        this.ttl=ttl;
        this.id=id;
        this.idEmetteur=idemetteur;
    }
    
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
    
    public String toString(){
        return "---Paquet--- \n"+"    ttl: "+this.ttl+"\n    id: "+this.id+"\n";
    }

}
