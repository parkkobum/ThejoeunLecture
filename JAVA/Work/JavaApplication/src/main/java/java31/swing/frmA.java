package java31.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmA extends JFrame {
    
    private JPanel contentPane;
    private JButton btnNewButton;
    private JTextArea textArea;
    private static frmA frame = null;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new frmA();
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
    public frmA() {
        setTitle("frmA");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 223, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(getBtnNewButton());
        contentPane.add(getTextArea());
    }
    
    private JButton getBtnNewButton() {
        if (btnNewButton == null) {
        	btnNewButton = new JButton("새창띄우기");
        	btnNewButton.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        frmB frm = new frmB(frame);
                    frm.setVisible(true);
        	    }
        	});
        	btnNewButton.setBounds(12, 56, 190, 23);
        }
        return btnNewButton;
    }
    private JTextArea getTextArea() {
        if (textArea == null) {
        	textArea = new JTextArea();
        	textArea.setBounds(23, 148, 172, 46);
        }
        return textArea;
    }
    public void refresh(String value) {
        textArea.setText(value);
    }
    
}
