package java31.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmYelloPink extends JFrame {
    
    private JPanel contentPane;
    private JButton btnNewButton;
    private JButton button;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frmYelloPink frame = new frmYelloPink();
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
    public frmYelloPink() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(getBtnNewButton());
        contentPane.add(getButton());
    }
    
    private JButton getBtnNewButton() {
        if (btnNewButton == null) {
        	btnNewButton = new JButton("노란색");
        	btnNewButton.setBounds(66, 10, 144, 23);
        	btnNewButton.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        contentPane.setBackground(Color.yellow);
        	    }
        	});
        }
        return btnNewButton;
    }
    private JButton getButton() {
        if (button == null) {
        	button = new JButton("핑크색");
        	button.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
                    contentPane.setBackground(Color.pink);
        	    }
        	});
        	button.setBounds(217, 10, 144, 23);
        }
        return button;
    }
}
