/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WorkerTerminals;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import LogicalSwitch.SwitchInterface;
import Workers.Worker;

/**
 *
 * @author moaaz
 */
public class Worker1 {
    public static void main(String[] args) throws Exception{
        
        // Connect to Switch Server and Register
        Registry r = LocateRegistry.getRegistry("localhost", 1099);
        SwitchInterface swt = (SwitchInterface) r.lookup("Switch");
        
        // Register Worker
        Worker w1 = new Worker(1);
        swt.registerWorder(w1);
        
        
        
        // Run Worker Server
        Registry w_r = LocateRegistry.createRegistry(2001);
        w_r.bind("WORKER2001", w1);
        System.out.println("Worker 1 is running on 2001 ......");
        
        // UI
        new Worker1UI(w1).setVisible(true);
    }
}
