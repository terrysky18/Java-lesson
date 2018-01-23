package com.EirScientific;

/**
 * Complaint
 * 
 * @author 
 * @version 
 */
public class Complaint extends Submission
{
    private boolean assigned = false;
    private boolean resolved = false;
    
    private int staffId; // Resolver id
    private Date deadLine; // Resolver deadline
    private String complaintType = "GENERAL";
    
    public Complaint (int submissionId, Customer cust, String description, Date dateMade)
    {
        super (submissionId, cust, description, dateMade);
       
    }
    
    private java.util.ArrayList<Action> actions =
                                             new java.util.ArrayList<Action> ();
                                             
    public void setComplaintType (String type)
    {
        complaintType = type;
    }
        
    public void addAction (Action action)
    {
        actions.add (action);
    }
    
    public void assignResolver (int staffId, Date deadLine)
    {
        this.staffId = staffId;
        this.deadLine = deadLine;
        assigned = true;
    }   
    
    public boolean isAssigned () {return assigned;}
        
    public void setResolved (boolean resolved) {this.resolved = resolved;}
    
    public boolean isResolved (){return resolved;}    
    
    public Date getDeadLine () {return deadLine;}
    
    public java.util.List<Action> getActions() {return actions;}
    
    @Override
    public Submission getUnresolvedSubmission()
    {
        if ( !isResolved() ) return this;
        else return null;
    }
    
    @Override
    public boolean isArchivable()
    {
        return isResolved();
    }
    

    public String toString()
    {
        String result = complaintType + " COMPLAINT " + super.toString();
        if (assigned) result += "Assigned staff " + staffId + " for resolution by " + deadLine + "\n";
        for (Action action: getActions())
            result += action.toString() + "\n" ;
            
        return result;
    }    
    
    protected String getCustomerDataForArchive ()
    {
        String data;
        data = super.getCustomerDataForArchive() +
        "NATURE OF COMPLAINT: " + super.getText() + "\n" +
           "";
        return data;
    }
    
    protected String getDateDataForArchive ()
    {
        String data;
        data = "DATE OF COMPLAINT: " + super.getSubmissionDate() + "\n" +
           "";
        return data;
    }
    @Override
    public String getArchiveData()
    {
        String archiveData;
        archiveData = "GENERAL COMPLAINT" + "\n" +
           getCustomerDataForArchive () +
           getDateDataForArchive () +
           "END GENERAL COMPLAINT" + "\n";
        
        return archiveData;
    }
}// class end
