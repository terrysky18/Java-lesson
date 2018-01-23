package com.EirScientific;

import java.util.Date;
import java.util.List;
public interface CCS
{
    /**
     * Get an unused customer id.
     * @return the unused customer id
     */
    public int getNewCustomerId();

    /**
     * Get an unused staff id.
     * @return the unused staff id
     */
    public int getNewStaffId();

    /**
     * Get an unused submission id.
     * @return the unused submission id
     */
    public int getNewSubmissionId();

    /**
     * Add a new customer.
     * @param customerId the customer id
     * @param name the customer name
     * @param address the customer address
     * @param email the customer email address
     * @param phone the customer phone number
     */
    public void addCustomer(int customerId, String name, String address, String email, String phone);

    /**
     * Remove an existing customer
     * @param  customerId    the customer id
     */
    public void removeCustomer ( int customerId );

    /**
     * Get the customer with the specified id.
     * @param  customerId the customer id
     * @return the customer
     */
    public Customer getCustomer(int customerId);

    /**
     * Add a new member of staff.
     * @param staffId the staff id
     * @param name the staff name
     * @param role the staff role
     * @param department the staff department
     */
    public void addStaff(int staffId, String name, String role, String department);

    /**
     * Get the staff member with the specified id.
     * @param staffId the staff id
     * @return the staff member
     */
    public Staff getStaff(int staffId);

    /**
     * Get the submission with the specified id.
     * @param submissionId the submission id
     * @return the submission
     */
    public Submission getSubmission(int submissionId);

    /**
     * Add a general complaint.
     * @param submissionId the submission id
     * @param customerId the customer id
     * @param description the description of the complaint
     * @param date the date of the occurence
     */
    public void addGeneralComplaint(int submissionId, int customerId, String description, Date date);

    /**
     * Add a Lift complaint.
     * @param submissionId the submission id
     * @param customerId the customer id
     * @param description the description of the complaint
     * @param list the lift name
     * @param floor the lift floor
     * @param date the date of the occurence
     */
    public void addLiftComplaint(int submissionId, int customerId, String description, String lift, int floor, Date date);

    /**
     * Add a Staff complaint.
     * @param submissionId the submission id
     * @param customerId the customer id
     * @param description the description of the complaint
     * @param staffId the staff id
     * @param date the date of the occurence
     */
    public void addStaffComplaint(int submissionId, int customerId, String description, int staffId, Date date);

    /**
     * Add a comment.
     * @param comment_id the comment id
     * @param customerId the customer id
     * @param comment the description of the comment
     * @param date the date of the comment
     */
    public void addComment(int submissionId, int customerId, String comment, Date date);

    /**
     * Assign or re-assign a Resolver to a complaint.
     * @param complaintId the id of the complaint
     * @param staffId the id of the resolver
     * @param dead_line the date for the resolution of the complaint
     */
    public void assignResolver(int complaintId, int staffId, Date deadLine);

    /**
     * Record an action to a complaint.
     * @param complaintId the id of the complaint
     * @param actionTaken a description of the action taken
     * @param date the date of the action
     */
    public void recordAction(int complaintId, String actionTaken, Date date);

    /**
     * Record a complaint resolved.
     * @param complaintId the id of the complaint
     */
    public void recordComplaintResolved(int complaintId);

    /**
     * Archive submissions.
     */
    public void archiveSubmissions();

    /**
     * Get a list of all actions for a complaint.
     * @param complaintId the complaint id
     * @return the actions for the complaint
     */
    public List<Action> getActionsForComplaint(int complaintId);

    /**
     * Get a list of staff.
     * @return the staff
     */
    public List<Staff> getStaffList();

    /**
     * Get a list of customers.
     * @return the customers
     */
    public List<Customer> getCustomerList();
    
    /**
     * Get a list of submissions.
     * @return the submissions
     */
    public List<Submission> getSubmissionList();
    
}