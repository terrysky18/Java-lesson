package com.EirScientific;

/**
 * Write a description of class Comment here.
 * 
 * @author  
 * @version 
 */
public class Comment extends Submission
{
    /**
     * Constructor for objects of class Comment
     */
    public Comment(int submissionId, int customerId, Customer cust, String description, Date dateMade)
    {        
        // initialise instance variables       
        super (submissionId, cust, description, dateMade);
    }

    public Submission getUnresolvedSubmission()
    {
        return null;
    }
     public boolean isArchivable ()
    {
        return true;
    }
       
    @Override
    public String getArchiveData()
    {
        String archiveData;
        archiveData = "COMMENT" + "\n" +        
           super.getCustomerDataForArchive() +
           "COMMENT TEXT: " + super.getText() + "\n" +
           "DATE OF COMMENT " + super.getSubmissionDate () + "\n" +        
           "END COMMENT" + "\n";
        return archiveData;
    }
}
