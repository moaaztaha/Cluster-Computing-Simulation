/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientApplication;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import LogicalSwitch.Task;
/**
 *
 * @author moaaz
 */
public class ClientMain {
    public static void main(String args[]) throws Exception
    {
        // Start the Client Server
        Client cl = new Client();
        Registry r = LocateRegistry.createRegistry(2000);
        r.bind("Client", cl);
        System.out.println("Client Started!!");
        
        
        new ClientUI().setVisible(true);
    }
}
