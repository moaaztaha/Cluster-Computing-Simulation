/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Workers;

import LogicalSwitch.Task;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
/**
 *
 * @author moaaz
 */
public interface WorkerInterface extends Remote{
    
//    public void setTask(Task task) throws RemoteException;
//    public Task getTask() throws RemoteException;
    public int getPort() throws RemoteException;
    public int getId() throws RemoteException;
    public void getTasksFromSwitch(ArrayList<Task> tasks) throws RemoteException;
}
