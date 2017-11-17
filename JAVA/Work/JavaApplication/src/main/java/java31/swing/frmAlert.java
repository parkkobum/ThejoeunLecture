package java31.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmAlert extends JFrame {
    
    private JPanel contentPane;
    private JTextField textField;
    private JButton btnClick;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frmAlert frame = new frmAlert();
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
    public frmAlert() {
        setTitle("알림창 띄우기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(getTextField());
        contentPane.add(getBtnClick());
    }
    
    private JTextField getTextField() {
        if (textField == null) {
        	textField = new JTextField();
        	textField.setBounds(12, 41, 223, 21);
        	textField.setColumns(10);
        }
        return textField;
    }
    private JButton getBtnClick() {
        if (btnClick == null) {
        	btnClick = new JButton("click");
        	btnClick.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        JOptionPane.showMessageDialog(null, textField.getText(),"바보야",2);
        	        
        	        
        	    }
        	});
        	btnClick.setBounds(293, 40, 97, 23);
        }
        return btnClick;
    }
}
