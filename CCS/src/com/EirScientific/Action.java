package com.EirScientific;

/**
 * Action
 * 
 * @author 
 * @version 
 */
public class Action
{
    private String description;
    private Date dateCompleted;
    
    public Action (String description, Date dateCompleted)
    {
        this.description = description;
        this.dateCompleted = dateCompleted;
    }
    
    public String toString()
    {
        return "\tAction: " + description + " on " + dateCompleted;
    }
}
