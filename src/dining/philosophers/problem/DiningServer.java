/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dining.philosophers.problem;

/**
 *
 * @author Rakesh
 */
public interface DiningServer {
    public void pickup(int i);
    
    public void putdown(int i);
}
