import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

//rendering and logic of the UI
public class MenuUI extends JFrame implements ActionListener{
    private JLabel IDLabel;
    private JTextField IDField;
    private JLabel weightLabel;
    private JTextField weightField;
    private JLabel sendLabel;
    private JTextField senderField;
    private JLabel recieveLabel;
    private JTextField recieveField;
    private JLabel descLabel;
    private JTextField descField;
    private JLabel status;
    private JButton save;
    private JButton clear;
    private inventoryLogic logic;

    //initialize the UI upon creating the object, also starts the inventory logic
    public MenuUI(){
        logic = new inventoryLogic();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 300);
        setTitle("Inventory");

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 10, 5, 10);

        IDLabel = new JLabel("ID: ");
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(IDLabel,gbc);
        IDField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(IDField,gbc);

        weightLabel = new JLabel("Weight: ");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(weightLabel,gbc);
        weightField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(weightField,gbc);

        sendLabel = new JLabel("Sender: ");
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(sendLabel,gbc);
        senderField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(senderField,gbc);

        recieveLabel = new JLabel("Reciever: ");
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(recieveLabel,gbc);
        recieveField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(recieveField,gbc);

        descLabel = new JLabel("Description: ");
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(descLabel,gbc);
        descField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 4;
        add(descField,gbc);

        save = new JButton("Save");
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(save,gbc);
        save.addActionListener(this);

        clear = new JButton("Clear");
        gbc.gridx = 1;
        gbc.gridy = 5;
        add(clear,gbc);
        clear.addActionListener(this);

        status = new JLabel(" ");
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        add(status,gbc);

        setVisible(true);
    }

    //method for handling button click events
    //updates status message on the UI
    //sends command to begin writing to csv file
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == save){
            switch(getInputFields()){
                case -1:
                    System.out.println("duplicate id");
                    status.setText("Item(s) with this ID already exists");
                    break;
                case -2:
                    System.out.println("inventory full");
                    status.setText("The inventory has already reached capacity");
                    break;
                case -3:
                    System.out.println("invalid int input");
                    status.setText("Invalid input for ID and/or weight");
                    break;
                case -4:
                    System.out.println("string fields empty");
                    status.setText("Sender/Reciever/Description fields cannot be empty");
                    break;
                default:
                    try {
                        logic.saveRecentToCSV();
                    } catch (IOException e1) {
                        System.out.println("failed to save to csv");
                        status.setText("An error occured while saving");
                        break;
                    }
                    System.out.println("successful save");
                    status.setText("Item saved successfully");
                    break;
            }
        } else {
            System.out.println("cleared");
            status.setText(" ");
        }

        //clear input fields upon pressing either button
        IDField.setText("");
        weightField.setText("");
        senderField.setText("");
        recieveField.setText("");
        descField.setText("");
    }

    //method for getting data from input fields and (potentially) creating an object
    //refer to saveInventoryEntry in inventoryLogic.java for return values -1 and -2
    //returns -3 on invalid integer parse (non-integer values or no input)
    private int getInputFields(){
        int id;
        int weight;
        
        try {
            id = Integer.parseInt(IDField.getText());
            weight = Integer.parseInt(weightField.getText());
        } catch (NumberFormatException num) {
            return -3;
        }

        String senderName = senderField.getText();
        String recieveName = recieveField.getText();
        String description = descField.getText();

        if(senderName.trim().equals("") || recieveName.trim().equals("") || description.trim().equals("")){
            return -4;
        }

        return logic.saveInventoryEntry(id,weight,senderName,recieveName,description);
    }
}
