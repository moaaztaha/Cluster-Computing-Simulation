/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicalSwitch;

import Workers.WorkerInterface;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.NotBoundException;
import java.util.ArrayList;
/**
 *
 * @author moaaz
 */
public interface SwitchInterface extends Remote{
    public void registerWorder(WorkerInterface wr) throws RemoteException;
//    public void sendAnswers(Task ans) throws RemoteException, NotBoundException;
    public void getTasksFromClient(ArrayList<Task> tasks) throws RemoteException;
    public void getAnswersFromWorkers(ArrayList<Task> tasks) throws RemoteException;
}
