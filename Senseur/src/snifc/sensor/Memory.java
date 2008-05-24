/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package snifc.sensor;

import snifc.PacketIfc;
import java.util.Vector;
import snifc.Packet;
import snifc.Simulator;


/**
 *
 * @author mdeclercq
 */



public class Memory implements MemoryIfc{

    public int memorySize;
    private Vector pVector;
    private Vector indexVector;
       
    
   public Memory(){
       
        this.memorySize=Simulator.MEMORY_SIZE;
        this.pVector= new Vector();
        this.indexVector=new Vector();
        System.out.println("Je viens de créer un vecteur");
        
   }
   
   public boolean isPresent(PacketIfc p){
       if(this.pVector.indexOf(p)==-1){
           return false;
       }else{
           return true;
       }
   }

    
    public boolean store(PacketIfc p) {
         
        
        if(this.isPresent(p)==false){
            if (this.pVector.capacity() <= Simulator.MEMORY_SIZE ){

                this.pVector.addElement(p);
                System.out.println("La taille de mon vecteur est : " + this.pVector.size());
                return true;
            } else 
            {
                System.out.println("La taille maximale du memory est atteinte, on enlève le premier element");
                this.pVector.remove(0);
                this.pVector.addElement(p);
                System.out.println("La taille de mon vecteur est : " + this.pVector.size());
                return false;
            }
        }else{
            return false;
        }

    }
    
    public String toString(){
        String s = "";
        int i;
        
        for(i=0; i < this.pVector.size(); i++){
            PacketIfc pTemp = (PacketIfc) this.pVector.get(i);
            s = s + pTemp.toString();
        }
         return s;
               
        
    }

}
