package com.EirScientific;

/**
 * Write a description of class LiftComplaint here.
 * 
 * @author 
 * @version 
 */
public class LiftComplaint extends Complaint
{
    private String lift;
    private int floor;
    
    public LiftComplaint (int submissionId, Customer cust, String description, String lift, 
        int floor, Date date)
    {
        super (submissionId, cust, description, date);
        super.setComplaintType ("LIFT");
        this.lift = lift;
        this.floor = floor;
    }
    
    @Override
    public String getArchiveData()
    {
        String archiveData;
        archiveData = "LIFT COMPLAINT" + "\n" +
           getCustomerDataForArchive () +
           "WHICH LIFT: " + lift + "\n" +
           "FLOOR: " + floor + "\n" +
           getDateDataForArchive () +
           "END STAFF COMPLAINT" + "\n";
        
        return archiveData;
    }
        
    public String toString()
    {
        return super.toString() + " Lift: " + lift + " at floor " + floor + "\n";
    }
}// class end
