/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicalSwitch;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import ClientApplication.ClientInterface;
import java.util.ArrayList;

/**
 *
 * @author moaaz
 */
public class SwitchMain {
    public static void main(String[] args) throws Exception
    {
        
        // Get the Client 
        Registry client_r = LocateRegistry.getRegistry("localhost", 2000);
        ClientInterface cl = (ClientInterface) client_r.lookup("Client");
        Switch swt = new Switch();
        
        // Register the switch to the client
        cl.registerSwitch(swt);
        
        
        // Start the Switch
        Registry r = LocateRegistry.createRegistry(1099);
        r.bind("Switch", swt);
        System.out.println("Switch Started");
        
        new SwitchUI().setVisible(true);
        
    }
}
