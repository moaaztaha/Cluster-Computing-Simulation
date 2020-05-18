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
public class Worker3 {
    public static void main(String[] args) throws Exception{
        // Connect to Switch Server and Register
        Registry r = LocateRegistry.getRegistry("localhost", 1099);
        SwitchInterface swt = (SwitchInterface) r.lookup("Switch");
        
        // Register Worker
        Worker w3 = new Worker(3);
        swt.registerWorder(w3);
        
        
        
        // Run Worker Server
        Registry w_r = LocateRegistry.createRegistry(2003);
        w_r.bind("WORKER2003", w3);
        System.out.println("Worker 3 is running on 2003 ......");
        new Worker1UI(w3).setVisible(true);
    }
}
