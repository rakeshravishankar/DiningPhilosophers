/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dining.philosophers.problem;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rakesh
 */
public class DiningServerImplementation implements DiningServer{

    private int philosopherCount;
    private Semaphore eatSema;
    private Semaphore thinkSema;
    
    public DiningServerImplementation(){
        philosopherCount =0;
        eatSema = new Semaphore(1);
        thinkSema = new Semaphore(1);
    }
    
   public void pickup(int i){
        try {
            eatSema.acquire();
            
            System.out.println("philosopher "+i+"eating");
            ++philosopherCount;
            if(philosopherCount == 1){
                thinkSema.acquire();
                System.out.println("Thinking");
            }
            
            eatSema.release();
            System.out.println("philosopher "+i+"eating 1");
        } catch (InterruptedException ex) {
            Logger.getLogger(PhilosophersThread.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
   
    public void putdown(int i){
        try {
            thinkSema.acquire();
            System.out.println("philosopher "+i+"finished eating");
            --philosopherCount;
            if(philosopherCount ==0)
                eatSema.acquire();
            
            thinkSema.release();
            System.out.println("Philiosopher "+philosopherCount+" is thinking !!!");
        } catch (InterruptedException ex) {
            Logger.getLogger(PhilosophersThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
