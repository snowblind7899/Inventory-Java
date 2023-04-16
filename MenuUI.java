import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuUI extends JFrame implements ActionListener{
    JButton save;
    JButton clear;
    public MenuUI(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200, 500);

        save = new JButton("Save");
        clear = new JButton("Clear");
        save.addActionListener(this);
        clear.addActionListener(this);

        JPanel panel = new JPanel();
        panel.add(save);
        panel.add(clear);
        add(panel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == save){
            System.out.println("Saved");
        } else {
            System.out.println("Cleared");
        }
    }
}
