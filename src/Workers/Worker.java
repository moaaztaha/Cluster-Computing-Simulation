/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Workers;

import LogicalSwitch.SwitchInterface;
import LogicalSwitch.Task;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author moaaz
 */
public class Worker extends UnicastRemoteObject implements Serializable, WorkerInterface{
    
    ArrayList<Task> tasks;
    int id;
    int port;
    
    public Worker() throws RemoteException{}
    public Worker(int i) throws RemoteException
    {
        id = i;
        port = 2000 + i;
    }
    
    public void setId(int i)
    {
        id = i;
    }
    
    public int getId()
    {
        return id;
    }
    
    public int getPort()
    {
        return port;
    }
    
    public ArrayList<Task> getTasks()
    {
        return tasks;
    }
    
    
    public void solver(int index)
    {
        // check if the task exists
        if (tasks.get(index) != null)
        {
            // Check the task type
            switch (tasks.get(index).getType()) {
                case "PRIME":
                    tasks.get(index).setResult(this.prime(tasks.get(index).getNumber()));
                    break;
                case "FACTORS":
                    tasks.get(index).setResult(this.factors(tasks.get(index).getNumber()));
                    break;
                case "SUM":
                    tasks.get(index).setResult(this.sum(tasks.get(index).getNumber(), tasks.get(index).getNumberB(), tasks.get(index).getIncrement()));
                    break;
                default:
                    System.out.println("Task not found");
                    break;
            }
        }
        else
        {
            System.out.println("Task not found");
        }
        
    }
    
    @Override
    public void getTasksFromSwitch(ArrayList<Task> tasks)
    {
        // Get the tasks
        this.tasks = tasks;
        System.out.println("Tasks: " + this.tasks.size());
        for (int i=0; i < tasks.size(); i++)
        {
            System.out.println(tasks.get(i).getId());
        }
        
        // Solve them
        for (int i=0; i < tasks.size(); i++)
        {
            solver(i);
        }
        System.out.println("All tasks solved!");
        
        
        // Send them back to switch
        try {
            System.out.println("Sending tasks to Switch...");
            sendSolvedTasks();
        } catch (Exception ex) {
            Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sendSolvedTasks() throws Exception
    {
        // send back to switch
        Registry swt_r = LocateRegistry.getRegistry("localhost", 1099);
        SwitchInterface swt = (SwitchInterface) swt_r.lookup("Switch");
        swt.getAnswersFromWorkers(tasks);    
        
    }

    
    
    // prime function
    public int prime(int num)
    {
        boolean flag = false;
        for (int i=2; i <= num/2; ++i)
        {
            if (num % i == 0)
            {
                flag = true;
                break;
            }
        }
        
        if (!flag)
            return 1;
        else
            return 0; 
    }
    
    // Factor function
    public int factors(int num)
    {
        int factorCount = 0;
        for (int i=1; i <= num; i++)
        {
            if (num%i == 0)
            {
                factorCount++;
            }
        }
        return factorCount;
    }
    
    // Sum function
    public int sum(int a, int b, int increament)
    {
        int result = 0;
        for (int i=a; i <=b; i+=increament)
        {
            result += i;
        }
        return result;
    }
    
    
    
    
    
    
//    // testing functions
//    public static void main(String args[]) throws RemoteException
//    {
//        // Testing prime
//        System.out.println("Testing Prime:");
//        Worker w = new Worker();
//        if (w.prime(5) == 1)
//            System.out.println("pass");
//        else
//            System.out.println("fail");
//        if (w.prime(197) == 1)
//            System.out.println("pass");
//        else
//            System.out.println("fail");
//        if (w.prime(100) == 0)
//            System.out.println("pass");
//        else
//            System.out.println("fail");
//        
//        // Testing factors
//        System.out.println("Testing Factors");
//        if (w.factors(5) == 2)
//            System.out.println("pass");
//        else
//            System.out.println("fail");
//        if (w.factors(6) == 4)
//            System.out.println("pass");
//        else
//            System.out.println("fail");
//        if (w.factors(8) == 4)
//            System.out.println("pass");
//        else 
//            System.out.println("fail");
//        
//        // Testing sum
//        System.out.println("Testing Sum");
//        if (w.sum(1, 10, 1) == 55)
//            System.out.println("pass");
//        else
//            System.out.println("fail");
//        if (w.sum(1, 10, 2) == 25)
//            System.out.println("pass");
//        else
//            System.out.println("fail");
//        if (w.sum(1, 10, 3) == 22)
//            System.out.println("pass");
//        else
//            System.out.println("fail");
//        
//    }
//    
}
