package com.EirScientific;

import java.util.*;
import java.util.Date;

/**
 * CCSImplementation
 * 
 * @author 
 * @version 
 */
public class CCSImplementation implements CCS
{
    private static int HIGHEST_CUST = 1;
    private static int HIGHEST_STAFF = 1;
    private static int HIGHEST_SUBMISSION = 1;

    private HashMap<Integer, Customer> customers;
    private HashMap<Integer, Staff> staff;
    protected HashMap<Integer, Submission> submissions;

    public CCSImplementation ()
    {
        customers = new HashMap<Integer, Customer>();
        staff = new HashMap<Integer, Staff>(); 
        submissions = new HashMap<Integer, Submission>();
    }

    /**
     * Get an unused customer id.
     * @return the unused customer id
     */
    public int getNewCustomerId()
    {
        int i = HIGHEST_CUST++;  
        return i;
    } // Note post-fix increment. Return value then add 1. 

    /**
     * Get an unused staff id.
     * @return the unused staff id
     */
    public int getNewStaffId() 
    {
        int i = HIGHEST_STAFF++;  
        return i;
    }

    /**
     * Get an unused submission id.
     * @return the unused submission id
     */
    public int getNewSubmissionId(){int i = HIGHEST_SUBMISSION++;  return i;}

    /**
     * Add a new customer.
     * @param customerId the customer id
     * @param name the customer name
     * @param address the customer address
     * @param email the customer email address
     * @param phone the customer phone number
     */
    public void addCustomer(int customerId, String name, String address, String email, String phone)
    {
        Customer cust = new Customer (customerId, name, address, email, phone);
        customers.put (customerId, cust);
    }

    /**
     * Remove an existing customer
     * @param  customerId    the customer id
     */
    public void removeCustomer ( int customerId )   //OK
    {
        customers.remove (customerId);
    }

    /**
     * Get the customer with the specified id.
     * @param  customerId the customer id
     * @return the customer
     */
    public Customer getCustomer(int customerId) {return customers.get (customerId);}

    /**
     * Add a new member of staff.
     * @param staffId the staff id
     * @param name the staff name
     * @param role the staff role
     * @param department the staff department
     */
    public void addStaff(int staffId, String name, String role, String department)
    {
        Staff st = new Staff (staffId, name, role, department);
        staff.put (staffId, st);
    }

    /**
     * Get the staff member with the specified id.
     * @param staffId the staff id
     * @return the staff member
     */
    public Staff getStaff(int staffId){return staff.get(staffId);}

    /**
     * Get the submission with the specified id.
     * @param submissionId the submission id
     * @return the submission
     */
    public Submission getSubmission(int submissionId){return submissions.get(submissionId);}; //OK

    /**
     * Add a general complaint.
     * @param submissionId the submission id
     * @param customerId the customer id
     * @param description the description of the complaint
     * @param date the date of the occurence
     */

    public void addGeneralComplaint(int submissionId, int customerId, String description, Date date)
    {
        Complaint complaint = new Complaint(submissionId, getCustomer(customerId), description, date);
        submissions.put (submissionId, complaint);
    }

    /**
     * Add a Lift complaint.
     * @param submissionId the submission id
     * @param customerId the customer id
     * @param description the description of the complaint
     * @param list the lift name
     * @param floor the lift floor
     * @param date the date of the occurence
     */
    public void addLiftComplaint(int submissionId, int customerId, String description, String lift, int floor, Date date)
    {
        LiftComplaint lc = new LiftComplaint (submissionId, getCustomer(customerId), description, lift, floor, date);
        submissions.put (submissionId, lc);      
    }

    /**
     * Add a Staff complaint.
     * @param submissionId the submission id
     * @param customerId the customer id
     * @param description the description of the complaint
     * @param staffId the staff id
     * @param date the date of the occurence
     */
    public void addStaffComplaint(int submissionId, int customerId, String description, int staffId, Date date)
    {
        StaffComplaint sc = new StaffComplaint (submissionId, getCustomer(customerId), description, date, getStaff(staffId) );
        submissions.put (submissionId, sc);
    }

    /**
     * Add a comment.
     * @param comment_id the comment id
     * @param customerId the customer id
     * @param comment the description of the comment
     * @param date the date of the comment
     */
    public void addComment(int submissionId, int customerId, String comment, Date date)
    {
        Submission comm = new Comment(submissionId, customerId, getCustomer(customerId), comment, date);
        submissions.put (submissionId, comm);      
    }

    /**
     * Assign or re-assign a Resolver to a complaint.
     * @param complaintId the id of the complaint
     * @param staffId the id of the resolver
     * @param dead_line the date for the resolution of the complaint
     */
    public void assignResolver(int complaintId, int staffId, Date deadLine)
    {
        Submission sub = submissions.get(complaintId);
        ((Complaint) sub).assignResolver (staffId, deadLine);
    }

    /**
     * Record an action to a complaint.
     * @param complaintId the id of the complaint
     * @param action_taken a description of the action taken
     * @param date the date of the action
     */
    public void recordAction(int complaintId, String actionTaken, Date date)  //OK
    {
        Submission sub = submissions.get(complaintId);
        ((Complaint) sub).addAction (new Action (actionTaken, date));
    }  

    /**
     * Record a complaint resolved.
     * @param complaintId the id of the complaint
     */
    public void recordComplaintResolved(int complaintId)    //OK
    {
        Submission sub = submissions.get(complaintId);
        ((Complaint) sub).setResolved (true);      
    }

    /**
     *  Archive submissions.
     */
    public void archiveSubmissions()
    {
        Iterator it = submissions.values().iterator();
        while (it.hasNext())
        {
            Submission item = (Submission) (  it.next()  );
            if ( item.isArchivable() )
            {
                System.out.println(item.getArchiveData());
            }          
        }      
    }

    /**
     * Get a list of all actions for a complaint.
     * @param complaintId the complaint id
     * @return the actions for the complaint
     */
    public List<Action> getActionsForComplaint(int complaintId)
    {
        Submission sub = submissions.get(complaintId);
        return ((Complaint) sub).getActions();
    }

    /**
     * Get a list of staff.
     * @return the staff
     */
    public List<Staff> getStaffList()
    {
        return new ArrayList<Staff> (staff.values());
    }

    /**
     * Get a list of customers.
     * @return the customers
     */
    public List<Customer> getCustomerList()
    {
        return new ArrayList<Customer> (customers.values());
    }  

    /**
     * Get a list of submissions.
     * @return the submissions
     */
    public List<Submission> getSubmissionList()
    {
        return new ArrayList<Submission> (submissions.values());
    } 
}//class
