package com.EirScientific;

/**
 * Staff
 * 
 * @author 
 * @version 
 */
public class Staff
{
    private int staffId;
    private String name;
    private String role;
    private String department;
    
    public Staff (int staffId, String name, String role, String department)
    {
        this.staffId = staffId;
        this.name = name;
        this.role = role;
        this.department = department;
    }
    
    public int getStaffId() 
    { 
        return staffId; 
    }
    
    public String getName() 
    { 
        return name; 
    }
    
    public String toString()
    {
        return "Staff " + staffId + ": " + name;
    }
}
