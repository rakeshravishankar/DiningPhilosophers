/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dining.philosophers.problem;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rakesh
 */
public class PhilosophersThread implements Runnable{
    
   int threadvalue;
    DiningServerImplementation dsImpl = new DiningServerImplementation();
    public PhilosophersThread(int i){
        threadvalue = i;
    }
    
    @Override
    public void run() {
        try {
            System.out.println("Thread No: "+Thread.currentThread());
            dsImpl.pickup(threadvalue);
            dsImpl.putdown(threadvalue);
        } catch (Exception ex) {
            Logger.getLogger(PhilosophersThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     
    
}
