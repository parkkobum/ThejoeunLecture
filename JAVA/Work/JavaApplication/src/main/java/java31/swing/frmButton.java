package java31.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class frmButton extends JFrame {
    
    private JPanel contentPane;
    private JButton btnNewButton;
    private JButton button;
    private JButton button_1;
    private JButton button_2;
    private JTextField textField;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frmButton frame = new frmButton();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    /**
     * Create the frame.
     */
    public frmButton() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(getBtnNewButton());
        contentPane.add(getButton());
        contentPane.add(getButton_1());
        contentPane.add(getButton_2());
        contentPane.add(getTextField());
    }
    
    private JButton getBtnNewButton() {
        if (btnNewButton == null) {
        	btnNewButton = new JButton("New button");
        	btnNewButton.setBounds(5, 5, 97, 101);
        	btnNewButton.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	    }
        	});
        }
        return btnNewButton;
    }
    private JButton getButton() {
        if (button == null) {
        	button = new JButton("New button");
        	button.setBounds(168, 5, 97, 101);
        }
        return button;
    }
    private JButton getButton_1() {
        if (button_1 == null) {
        	button_1 = new JButton("New button");
        	button_1.setBounds(325, 5, 97, 101);
        }
        return button_1;
    }
    private JButton getButton_2() {
        if (button_2 == null) {
        	button_2 = new JButton("New button");
        	button_2.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        dispose();
        	    }
        	});
        	button_2.setBounds(5, 185, 417, 67);
        }
        return button_2;
    }
    private JTextField getTextField() {
        if (textField == null) {
        	textField = new JTextField();
        	textField.setBounds(5, 129, 417, 46);
        	textField.setColumns(10);
        }
        return textField;
    }
}
