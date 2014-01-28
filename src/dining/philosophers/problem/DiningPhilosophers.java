/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dining.philosophers.problem;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rakesh
 */
public class DiningPhilosophers {

   static int philosophers;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Thread t;
        DiningPhilosophers dp = new DiningPhilosophers();
        dp.readInput();
        System.out.println(" "+philosophers+" Philosophers");
        // TODO code application logic here
        for (int i = 0; i < philosophers; i++) {
            t = new Thread(new PhilosophersThread(i+1));
            t.start();
            
        }
    }
    
    public void readInput(){
        try {
            System.out.println("Enter the no. of Philosophers");
            Scanner scan = new Scanner(System.in);
            philosophers = scan.nextInt();
           
        } catch (Exception ex) {
            Logger.getLogger(DiningPhilosophers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
