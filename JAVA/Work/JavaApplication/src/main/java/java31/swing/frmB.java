package java31.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class frmB extends frmA  {
    
    private JPanel contentPane;
    private JButton btnNewButton;
    private JTextArea textArea;
    private frmA parent =  null;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {

    }
    
    /**
     * Create the frame.
     */
    public frmB(frmA parent) {
        setTitle("frmB");
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 223, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(getBtnNewButton());
        contentPane.add(getTextArea());
        this.parent = parent;
    }
    
    private JButton getBtnNewButton() {
        if (btnNewButton == null) {
            btnNewButton = new JButton("값돌려주기");
            btnNewButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    parent.refresh(textArea.getText());
                }
            });
            btnNewButton.setBounds(12, 183, 190, 23);
        }
        return btnNewButton;
    }
    private JTextArea getTextArea() {
        if (textArea == null) {
            textArea = new JTextArea();
            textArea.setBounds(12, 50, 172, 46);
        }
        return textArea;
    }
    
}
