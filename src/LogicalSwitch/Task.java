/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicalSwitch;

import java.io.Serializable;
/**
 *
 * @author moaaz
 */
public class Task implements Serializable{
    String type;
    int id;
    int number;
    int result;
    int numberB, increment;
    
    
    public Task(String t, int n, int d)
    {
        type = t;
        number = n;
        id = d;
    }
    
    // in case of sum problem
    public Task(String t, int a, int b, int inc, int d)
    {
        type = t;
        number = a;
        numberB = b;
        increment = inc;
        id = d;
    }
    
    public void setId(int d)
    {
        id = d;
    }
    
    public int getId()
    {
        return id;
    }
    
    
    public void setType(String t)
    {
        type = t;
    }
    public String getType()
    {
        return type;
    }
    
    public void setNumber(int n)
    {
        number = n;
    }
    
    public int getNumber()
    {
        return number;
    }
    
    public void setNumberb(int n)
    {
        numberB = n;
    }
    
    public int getNumberB()
    {
        return numberB;
    }
    
    public void setIncrement(int n)
    {
        increment = n;
    }
    
    public int getIncrement()
    {
        return increment;
    }
    
    public void setResult(int r)
    {
        result = r;
    }
    
    public int getResult()
    {
        return result;
    }
}
