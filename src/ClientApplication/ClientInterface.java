/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientApplication;

import LogicalSwitch.SwitchInterface;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import LogicalSwitch.Task;
/**
 *
 * @author moaaz
 */
public interface ClientInterface  extends Remote{
    public void registerSwitch(SwitchInterface sw) throws RemoteException;
    public ArrayList<Task> getAllTasks() throws RemoteException;
    public void recieveSolvedTasks(ArrayList<Task> tasks) throws RemoteException;
}
