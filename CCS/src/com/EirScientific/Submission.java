package com.EirScientific;

/**
 * Submission
 * 
 * @author 
 * @version 
 */
public abstract class Submission
{
    private int submissionId;

    private String text;
    private Date dateMade;
    private Customer customer;
    
    public Submission (int submissionId, Customer cust, String description, Date dateMade) 
    {
        this.submissionId = submissionId;
        this.customer = cust;
        this.text = description;
        this.dateMade = dateMade;
    }
    
    public int getSubmissionId () {return submissionId;}
    
    public Customer getCustomer () { return customer; }
    
    protected String getText () { return text; }
    
    public Date getSubmissionDate() {return dateMade;}
    
    public String toString () 
    {
        return "FEEDBACK " + submissionId + ": " + text + "\nMade by customer " + customer.getCustomerId() + " on " + dateMade + "\n";
    }
    
    public abstract Submission getUnresolvedSubmission();
    
    protected String getCustomerDataForArchive ()
    {
        String data;
        data = "CUSTOMER NAME: " + customer.getName() + "\n" +
           "CUSTOMER ADDRESS: " + customer.getAddress() + "\n" +
           "CUSTOMER EMAIL: " + customer.getEmail() + "\n" +
           "CUSTOMER PHONE NO: " + customer.getPhoneNo() + "\n" +
           "";
        return data;
    }
    
    public abstract boolean isArchivable ();
    
    public abstract String getArchiveData();

}
