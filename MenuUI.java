import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuUI extends JFrame implements ActionListener{
    private JButton save;
    private JButton clear;
    private JLabel IDLabel;
    private JTextField IDField;
    private JLabel weightLabel;
    private JTextField weightField;
    private JLabel sendLabel;
    private JTextField senderField;
    private JLabel recieveLabel;
    private JTextField recieveField;
    private JLabel status;

    public MenuUI(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 250);
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

        save = new JButton("Save");
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(save,gbc);
        save.addActionListener(this);

        clear = new JButton("Clear");
        gbc.gridx = 1;
        gbc.gridy = 4;
        add(clear,gbc);
        clear.addActionListener(this);

        status = new JLabel(" ");
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        add(status,gbc);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == save){
            status.setText("Saved");
            System.out.println("Saved");
        } else {
            status.setText("Cleared");
            System.out.println("Cleared");
        }
        IDField.setText("");
        weightField.setText("");
        senderField.setText("");
        recieveField.setText("");
    }
}
