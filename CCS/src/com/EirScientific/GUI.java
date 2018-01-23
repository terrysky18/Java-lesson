package com.EirScientific;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

/**
 * A graphical user interface (GUI) for the Customer Complaints System(CCS)
 * This GUI interfaces the User to the System and needs an instance of CCS.
 * 
 * @author H. Gan
 * @version 16/08/2015
 */
public class GUI
{
    private CCSImplementation ccs;
    
    private JList<Customer> existingCustomersList;
    private DefaultListModel<Customer> listModel = new DefaultListModel<Customer>();
    private ArrayList<GUIparameter> parms = new ArrayList<GUIparameter>();

    /**
     * GUI: Graphical-User Interface constructor
     * create the visual interface and show it on screen.
     */
    public GUI()
    {
        ccs = new CCSImplementation(); // Note that not all features of CCSImplementation are used; only CCS features 
        // Configure CCS - separate code for system side
        setupSystem(); 
        // Configure GUI - separate code for screen view
        makeFrame();

        // Initialise GUI controls
        refreshList();

    }

    /**
     * getCCS: Get CCS object
     * returns ths copier system as is for testing
     * @return the copier system
     */
    public CCS getCCS()
    {
        return ccs;
    }

    /**
     * setupSystem: Setup CCS
     * Adds a few token cutomers to the system.
     */
    private void setupSystem()
    {
        ccs.addCustomer (ccs.getNewCustomerId(), "Jo Bloggs", "aaa", "jb@yahoo.com", "02088868765");
        ccs.addCustomer (ccs.getNewCustomerId(), "Jill Wyatt", "High Street", "wyatt42@yahoo.com", "0208984532");
        ccs.addCustomer (ccs.getNewCustomerId(), "Paul Bowles", "aaa", "pb99@yahoo.com", "0207632451");        
    }

    /**
     * makeFrame: Make the GUI window frame
     * create the swing frame and its content
     */
    private void makeFrame()
    {
        final int horizMargin = 10;
        final int vertMargin = 10;
        
        final int floorRows = 2;
        final int floorColumns = 1;
        
        final int frameWidth = 320;
        final int frameHeight = 400;
        
        // create the frame and set it to show 2 parts one on top of the other
        JFrame frame = new JFrame("Customer Complaint System"); // create window frame
        Container contentPane = frame.getContentPane();  // get the background window pane/floor
        contentPane.setLayout(new GridLayout(floorRows,floorColumns));      // divide the floor into 2 sections using rows, col

        // create panels for the top and bottom half of the frame and set them to grid with a nice spacing
        JPanel topHalf = new JPanel();

        topHalf.setLayout(new BorderLayout(horizMargin,vertMargin)); // Put gaps horizontally and vertically
        JPanel bottomHalf = new JPanel();
        bottomHalf.setLayout(new BorderLayout(horizMargin,vertMargin)); // Put the same gaps as top half

        createTopHalf(topHalf); //set up the top half components
        createBottomHalf(bottomHalf); //set up the bottom half components

        contentPane.add(topHalf);
        contentPane.add(bottomHalf);
        
        frame.setSize(frameWidth,frameHeight);
        //frame.pack(); //adjust window to correct size
        frame.setVisible(true);
    }

    /**
     * set up the top half of the frame
     * @param panel -the main carpet
     */
    private void createTopHalf(JPanel panel)
    {
        //set up title of top carpet
        JLabel titleLabel = new JLabel ("Existing Customers", SwingConstants.LEFT); 
        panel.add (titleLabel, BorderLayout.NORTH);
        
        //setup list of existing customers
        //JList is used but you can also use the simpler JText
        existingCustomersList = new JList<Customer>(listModel); //**use ListModel to hold list/array of customers. 
        panel.add (existingCustomersList, BorderLayout.CENTER);
        existingCustomersList.addMouseListener(customerListMouseListener);

        //Use a Flow layout panel to hold the button so that the button would not be huge
        JPanel rightTopPanel = new JPanel(); // create new carpet for right side
        panel.add (rightTopPanel, BorderLayout.EAST); // overlay new carpet onto the main carpet
        
        //set up "remove customer" button
        JButton removeCustomerButton = new JButton("Remove customer"); 
        rightTopPanel.add (removeCustomerButton);
        removeCustomerButton.addActionListener(removeButtonActionListener);
    }

    /**
     * set up the bottom half of the frame
     * @param panel -the main carpet
     */
    private void createBottomHalf(JPanel panel)
    {
        //set up title of bottom carpet
        JLabel titleLabel = new JLabel ("Customer profile", SwingConstants.LEFT);
        panel.add (titleLabel, BorderLayout.NORTH);
        
        //Use a Flow layout panel to hold the button so that the button would not be huge
        JPanel rightBottomPanel = new JPanel(); // create new carpet for right side
        panel.add (rightBottomPanel, BorderLayout.EAST); // overlay new carpet onto the main carpet
        
        //set up "add customer" button
        JButton addCustomerButton = new JButton("Add customer"); 
        rightBottomPanel.add (addCustomerButton);
        addCustomerButton.addActionListener(addButtonActionListener);
        
        //Use a Box layout panel to hold the input fields
        JPanel leftBottomPanel = new JPanel(); // create new carpet for left side
        leftBottomPanel.setLayout( new BoxLayout(leftBottomPanel, BoxLayout.Y_AXIS) );
        panel.add (leftBottomPanel, BorderLayout.CENTER); // overlay new carpet onto the main carpet
        
        // set up parameter labels and fields

        parms.add ( new GUIparameter(new JLabel("Name"), new JTextField()) );
        parms.add ( new GUIparameter(new JLabel("Address"), new JTextField()) );
        parms.add ( new GUIparameter(new JLabel("email"), new JTextField()) );
        parms.add ( new GUIparameter(new JLabel("Phone number"), new JTextField()) );
        
        for (int i=0; i < parms.size(); i++)
        {
           leftBottomPanel.add ( parms.get(i).getLabel() ); 
           leftBottomPanel.add ( parms.get(i).getField() ); 
        }
        
        
    }// method

    /**
     * refreshList: Refresh the List Model 
     * refreshes the list of customers with data from the system.
     * RuntimeException is caught as it is thrown if the List Model is too small
     */
    private void refreshList() 
    {
        try
        {
            listModel.clear(); // Clean JList

            java.util.List<Customer> customers =  ccs.getCustomerList();
            int i=0;
            // Loop through customer list and add customer to JList
            for(Customer c : customers)
            {
                // Add customer to listModel
                listModel.add(i, c); //throws array index exception
                i++;
            }
        }
        catch (ArrayIndexOutOfBoundsException  e)
        {
            e.printStackTrace();
        } 

    }// method
    

    /*
     * Action Performed
     * 
     */
    MouseListener customerListMouseListener = new MouseAdapter()
    {

        /**
         * Method mouseClicked on JList selection
         * If the mouse is clicked twice at an item in the JList, the item information is printed
         * @param e object holding mouse event information
         */
        public void mouseClicked(MouseEvent e)
        {            
            if (e.getClickCount() == 2) 
            {
                int index = existingCustomersList.locationToIndex(e.getPoint()); // identify Jlist item
                Customer customer = (Customer) listModel.elementAt(index); // retrieve Jlist item
                System.out.println(customer); // print out Jlist item
            }// if
        }
    };

    ActionListener removeButtonActionListener = new ActionListener()
    {
        /**
         * Method actionPerformed when remove button clicked
         * If a list item is selected and the "remove" button clicked, remove the item from CCS
         * @param e object holding click event information
         */
        public void actionPerformed(ActionEvent e) 
        { 
            // Check if JList has a selection 
            if(existingCustomersList.getSelectedIndex() > -1) 
            {
                // JList has a selection
                Customer cust = (Customer)( existingCustomersList.getSelectedValue() ); // retrieve selection               
                ccs.removeCustomer( cust.getCustomerId() ); // remove selection from CCS

                // Testing: verify that customer was removed
                System.out.println ("Remove customer in GUI");
                for (Customer cus: ccs.getCustomerList())
                    System.out.println (cus);

                refreshList(); // Update the JList
            }// if

        }//actionPerformed
    };//ActionListener
        
    ActionListener addButtonActionListener = new ActionListener()
    {
        public void actionPerformed(ActionEvent e) 
        {
            String[] p = new String[parms.size()];

            // Get the text fields and store in temporary array p
            for ( int i=0; i < (parms.size() -1); i++ )
            {
               p[i] = parms.get(i).getField().getText();
               
               // Validate field
               if ( p[i].equals("") ) return;
            }
            ccs.addCustomer( ccs.getNewCustomerId(), p[0],p[1],p[2],p[3] );
            // Testing: verify that customer was added
            System.out.println ("Add customer in GUI");
            for (Customer cus: ccs.getCustomerList())
                System.out.println (cus);
            
            refreshList();
        }
    };
    
    /*
     * Internal classes
     */
    class GUIparameter 
    {
         JLabel label;
         JTextField field;
         public GUIparameter (JLabel l, JTextField t)         
         {
             label = l;
             field = t;
         }
         public JLabel getLabel() { return label; }
         public JTextField getField() { return field; }
    }//GUIparameter

}// class
