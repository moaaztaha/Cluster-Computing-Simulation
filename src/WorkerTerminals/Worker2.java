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
public class Worker2 {
    public static void main(String[] args) throws Exception{
        // Connect to Switch Server and Register
        Registry r = LocateRegistry.getRegistry("localhost", 1099);
        SwitchInterface swt = (SwitchInterface) r.lookup("Switch");
        
        // Register Worker
        Worker w2 = new Worker(2);
        swt.registerWorder(w2);
        
        
        
        // Run Worker Server
        Registry w_r = LocateRegistry.createRegistry(2002);
        w_r.bind("WORKER2002", w2);
        System.out.println("Worker 2 is running on 2002 ......");
        new Worker1UI(w2).setVisible(true);
    }
}
