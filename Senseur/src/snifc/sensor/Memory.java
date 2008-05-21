/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package snifc.sensor;

import snifc.PacketIfc;
import java.util.Vector;
import snifc.Simulator;


/**
 *
 * @author mdeclercq
 */



public class Memory implements MemoryIfc{

    private Vector pVector;
    
    
    
   public Memory(){
   
        this.pVector= new Vector();
        this.pVector.setSize(1);
        System.out.println("Je viens de créer un vecteur");
   }
   
 

    
    public boolean store(PacketIfc p) {
        
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
