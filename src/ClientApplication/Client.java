/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientApplication;

import LogicalSwitch.SwitchInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import LogicalSwitch.Task;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Random;

/**
 *
 * @author moaaz
 */
public class Client extends UnicastRemoteObject implements ClientInterface{
    
    
    static ArrayList<Task> tasks;
    
    public Client() throws RemoteException{
        tasks = new ArrayList<>();
    }
    
    @Override
    public void registerSwitch(SwitchInterface sw) throws RemoteException
    {
        System.out.println("Switch has joined!!");
    }
    
    @Override
    public ArrayList<Task> getAllTasks() throws RemoteException
    {
        return tasks;
    }
    
    @Override
    public void recieveSolvedTasks(ArrayList<Task> tasks)
    {
        System.out.println("Solved Tasks Recived!!");
        this.tasks = tasks;
        System.out.println("Answers:");
        for (int i=0; i < tasks.size(); i++)
        {
            System.out.println(tasks.get(i).getResult());
        }
    }
    
    public static ArrayList<Task> getTasks()
    {
        return tasks;
    }
    
    public static ArrayList<Task> setTask() throws RemoteException, NotBoundException
    {
        // clear tasks 
        tasks.clear();
        
        // Generating tasks
        ArrayList<String> tasks_types = new ArrayList<>();
        tasks_types.add("PRIME");
        tasks_types.add("FACTORS");
        tasks_types.add("SUM");
        
        Random random = new Random();
        
        for (int i=0; i<50; i++)
        {
                // First random task type
            String task_type = tasks_types.get(random.nextInt(tasks_types.size()));

            // Second the values
            if (task_type.equals("PRIME") || task_type.equals("FACTORS"))
            {
                // random number 1:50
                int n = random.nextInt(50) + 1; 

                // Print task
                System.out.println("Task " + i + " " + task_type + "n:" + n);
                
                // adding the task to tasks
                tasks.add(new Task(task_type, n, i+1));
            }
            else if (task_type.equals("SUM"))
            {
                // random start 1:10
                int a = random.nextInt(10) + 1;
                // random end 10:1000
                int b = random.nextInt((1000 - 10) + 1) + 10;
                // random step 1:10
                int s = random.nextInt(10) + 1;

                // Print task
                System.out.println("Task " + i + " " + task_type + " a:" + a + " b:"+b+" s:"+s);
                
                // adding the task to tasks
                tasks.add(new Task(task_type, a, b, s, i+1));
            }
            else
            {
                System.out.println("Task type not found!!");
            }
        }
        
        
        // Connecting to Switch
        Registry sw_r = LocateRegistry.getRegistry("localhost", 1099);
        SwitchInterface swt = (SwitchInterface) sw_r.lookup("Switch");
        
        // Sending Tasks to Switch
        swt.getTasksFromClient(tasks);

        
        return tasks;
    }
}
