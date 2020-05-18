/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicalSwitch;

import ClientApplication.ClientInterface;
import Workers.WorkerInterface;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author moaaz
 */
public class Switch extends UnicastRemoteObject implements SwitchInterface{

    ArrayList<WorkerInterface> workers;
    ArrayList<Task> tasks;
    static ArrayList<Task> w1_tasks;
    static ArrayList<Task> w2_tasks;
    static ArrayList<Task> w3_tasks;
    ArrayList<Task> solved_tasks;
    
    public Switch() throws RemoteException{
        this.solved_tasks = new ArrayList<>();
        this.workers = new ArrayList<>();
        this.w1_tasks = new ArrayList<>();
        this.w2_tasks = new ArrayList<>();
        this.w3_tasks = new ArrayList<>();
}
    
    @Override
    public synchronized void registerWorder(WorkerInterface wr) throws RemoteException {
        workers.add(wr);
        System.out.println("Worker "+ wr.getId() +" joined!!!");
    }


    @Override
    public void getTasksFromClient(ArrayList<Task> t) throws RemoteException
    {
        // get the new batch of tasks
        this.tasks = t;
        System.out.println("Tasks Got from Client" + tasks.size());
        // Distribute the tasks
        this.distributeTasks();
        // Send Tasks to Workers to be solved
        for (int i=0; i<workers.size(); i++)
        {
            try {
                // Connect to workers
                Registry w_r = LocateRegistry.getRegistry("localhost", workers.get(i).getPort());
                String name = "WORKER" + workers.get(i).getPort();
                System.out.println("Name: " + name);
                WorkerInterface worker = (WorkerInterface) w_r.lookup(name);
                System.out.println("Sending tasks to: " + name);
                
                // Send the tasks
                if (name.equals("WORKER2001"))
                {
                    worker.getTasksFromSwitch(w1_tasks);
                }
                else if (name.equals("WORKER2002"))
                {
                    worker.getTasksFromSwitch(w2_tasks);
                }
                else if (name.equals("WORKER2003"))
                {
                    worker.getTasksFromSwitch(w3_tasks);
                }
                else
                {
                    System.out.println("Name: " + name + " not found!!");
                }
                
                
            } catch (NotBoundException ex) {
                Logger.getLogger(Switch.class.getName()).log(Level.SEVERE, null, ex);
            } catch (AccessException ex) {
                Logger.getLogger(Switch.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
    
    
    
    
    public void distributeTasks()
    {
        // Clear workers
        w1_tasks.clear();
        w2_tasks.clear();
        w3_tasks.clear();
        
        // all workers must be connected first
        if (workers.size() == 3 && tasks.size()!=0)
        {
            int i=0;
            while (i < tasks.size())
            {
                System.out.println(tasks.get(0).getType());
                w1_tasks.add(tasks.get(i++));
                if (i == tasks.size())
                    break;
                w2_tasks.add(tasks.get(i++));
                if (i == tasks.size())
                    break;
                w3_tasks.add(tasks.get(i++));
            }
            
            System.out.println("Tasks Distributed!");
            System.out.println("Task for w1: " + w1_tasks.size());
            System.out.println("Task for w2: " + w2_tasks.size());
            System.out.println("Task for w3: " + w2_tasks.size());
        }
        else
        {
            System.out.println("All workers must be connected!!!");
            System.out.println("Number of tasks: " + tasks.size());
        }
    }
    
    public void sendSolvedTasks() throws Exception
    {
        // send back to client
            Registry client_r = LocateRegistry.getRegistry("localhost", 2000);
            ClientInterface cl = (ClientInterface) client_r.lookup("Client");
            cl.recieveSolvedTasks(this.solved_tasks);   
        // Clear Solved Tasks
        this.solved_tasks.clear();
        
    }
    
    @Override
    public synchronized void getAnswersFromWorkers(ArrayList<Task> t) throws RemoteException
    {
        // get a batch of solved tasks
        solved_tasks.addAll(t);
        System.out.println("A batch of Solved tasks has arrived! total: " + solved_tasks.size());
        
        // If all is solved -> send to client
        if (solved_tasks.size() == tasks.size())
        {
            try {
                System.out.println("Sending tasks to Client...");
                sendSolvedTasks();
            } catch (Exception ex) {
                Logger.getLogger(Switch.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            System.out.println("Some tasks are still being processed!");
        }
    }
    
    
    public static ArrayList<Task> getWorkerTasks(int i)
    {
        switch (i) {
            case 1:
                return w1_tasks;
            case 2:
                return w2_tasks;
            case 3:
                return w3_tasks;
            default:
                break;
        }
        return w1_tasks;
    }
    
}
