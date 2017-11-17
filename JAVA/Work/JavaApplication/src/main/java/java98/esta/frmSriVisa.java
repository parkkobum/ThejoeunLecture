package java98.esta;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

public class frmSriVisa extends JFrame {
    
    private JPanel contentPane;
    private JScrollPane scrollPane;
    private JTabbedPane tabbedPane;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frmSriVisa frame = new frmSriVisa();
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
    public frmSriVisa() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 666, 551);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(getScrollPane());
    }
    private JScrollPane getScrollPane() {
        if (scrollPane == null) {
        	scrollPane = new JScrollPane();
        	scrollPane.setBounds(0, 10, 638, 493);
        	scrollPane.setColumnHeaderView(getTabbedPane());
        }
        return scrollPane;
    }
    private JTabbedPane getTabbedPane() {
        if (tabbedPane == null) {
        	tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        }
        return tabbedPane;
    }
}
