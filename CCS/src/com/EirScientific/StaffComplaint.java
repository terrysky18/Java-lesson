package com.EirScientific;

/**
 * Write a description of class StaffComplaint here.
 * 
 * @author 
 * @version 
 */
public class StaffComplaint extends Complaint
{
    private Staff staff;

    public StaffComplaint (int submissionId, Customer cust, String description, Date date, 
        Staff staff)
    {
        super (submissionId, cust, description, date);
        this.staff = staff;
        setComplaintType ("STAFF");
    }
    
    @Override
    public String getArchiveData()
    {
        String archiveData;
        archiveData = "STAFF COMPLAINT" + "\n" +
           getCustomerDataForArchive () +
           "STAFF NAME: " + staff.getName() + "\n" +
           "STAFF ID: " + staff.getStaffId() + "\n" +
           getDateDataForArchive () +
           "END STAFF COMPLAINT" + "\n";
        
        return archiveData;
    }
    
    public String toString()
    {
        return "Staff member: " + staff.getStaffId() + "\n" + super.toString(); 
    }    

}// class end
