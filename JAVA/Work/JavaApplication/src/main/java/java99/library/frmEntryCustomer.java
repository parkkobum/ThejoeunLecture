package java99.library;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class frmEntryCustomer extends JFrame {
    
    private JPanel contentPane;
    private JLabel label;
    private JButton button;
    private JButton button_1;
    private JLabel label_1;
    private JTextField textName;
    private JLabel label_2;
    private JTextField textMinbun1;
    private JTextField textMinbun2;
    private JLabel label_3;
    private JLabel label_4;
    private JLabel label_5;
    private JTextField textPhoneNum2;
    private JLabel label_6;
    private JTextField textPhoneNum3;
    private JLabel label_7;
    private JTextField textEmail1;
    private JComboBox textPhoneNum1;
    private JComboBox textEmail2;
    private JLabel label_8;
    private frmMain parent;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frmEntryCustomer frame = new frmEntryCustomer(null);
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
    public frmEntryCustomer(frmMain parent) {
        setTitle("회원가입");
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(getLabel());
        contentPane.add(getButton());
        contentPane.add(getButton_1());
        contentPane.add(getLabel_1());
        contentPane.add(getTextName());
        contentPane.add(getLabel_2());
        contentPane.add(getTextMinbun1());
        contentPane.add(getTextMinbun2());
        contentPane.add(getLabel_3());
        contentPane.add(getLabel_4());
        contentPane.add(getLabel_5());
        contentPane.add(getTextPhoneNum2());
        contentPane.add(getLabel_6());
        contentPane.add(getTextPhoneNum3());
        contentPane.add(getLabel_7());
        contentPane.add(getTextEmail1());
        contentPane.add(getTextPhoneNum1());
        contentPane.add(getTextEmail2());
        contentPane.add(getLabel_8());
    }
    
    private JLabel getLabel() {
        if (label == null) {
        	label = new JLabel("회원 정보 입력");
        	label.setBounds(176, 10, 82, 15);
        }
        return label;
    }
    private JButton getButton() {
        if (button == null) {
        	button = new JButton("등록");
        	button.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        ServiceCustomer sc = new ServiceCustomer();
        	        ModelCustomer customer = new ModelCustomer();
        	        insertCustomer(sc, customer);
        	    }

                public void insertCustomer(ServiceCustomer sc,
                        ModelCustomer customer) {
                    //주민번호
                    String minbun1 = textMinbun1.getText();
                    String minbun2 = textMinbun2.getText();
                    if (minbun1.length() != 6 || minbun1.isEmpty()) {
                        JOptionPane.showMessageDialog(null, minbun1,"주민번호 입력 오류",2);
                        return;
                    }
                    if (minbun2.length() != 7 || minbun2.isEmpty() ) {
                        JOptionPane.showMessageDialog(null, minbun2,"주민번호 입력 오류",2);
                        return;
                    }
                    customer.setMinBun(minbun1+"-"+minbun2); 
                    
                    //Email
                    String email1 = textEmail1.getText();
                    if (email1.isEmpty()) {
                        JOptionPane.showMessageDialog(null, email1,"Email 입력 오류",2);
                        return;
                    }
                    customer.setEmail(email1+"@"+textEmail2.getSelectedItem());
                   
                    //이름
                    String name = textName.getText();
                    if (name.isEmpty()) {
                        JOptionPane.showMessageDialog(null, name,"이름 입력 오류",2);
                        return;                        
                    }
                    customer.setName(name);
                    
                    //전화번호
                    String pnum1 = textPhoneNum2.getText();
                    String pnum2 = textPhoneNum3.getText();
                    if ((pnum1.length() !=3 && pnum1.length() !=4) || pnum2.length() !=4 ) {
                        JOptionPane.showMessageDialog(null, pnum1+pnum2, "전화번호 입력 오류",2);
                        return;
                    }
        	        customer.setPhoneNum(textPhoneNum1.getSelectedItem()+"-"+pnum1+"-"+pnum2);
        	        try {
                        sc.insertCustomer(customer);
                    } catch (SQLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(null, "회원등록 성공!");
                    parent.refresh();
                    dispose();
                }
        	});
        	button.setBounds(133, 187, 115, 47);
        }
        return button;
    }
    private JButton getButton_1() {
        if (button_1 == null) {
        	button_1 = new JButton("취소");
        	button_1.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        dispose();
        	    }
        	});
        	button_1.setBounds(272, 187, 115, 47);
        }
        return button_1;
    }
    private JLabel getLabel_1() {
        if (label_1 == null) {
        	label_1 = new JLabel("이름");
        	label_1.setBounds(12, 38, 57, 15);
        }
        return label_1;
    }
    private JTextField getTextName() {
        if (textName == null) {
        	textName = new JTextField();
        	textName.setColumns(10);
        	textName.setBounds(74, 35, 116, 21);
        }
        return textName;
    }
    private JLabel getLabel_2() {
        if (label_2 == null) {
        	label_2 = new JLabel("주민번호");
        	label_2.setBounds(12, 63, 57, 15);
        }
        return label_2;
    }
    private JTextField getTextMinbun1() {
        if (textMinbun1 == null) {
        	textMinbun1 = new JTextField();
        	textMinbun1.setColumns(10);
        	textMinbun1.setBounds(74, 63, 116, 21);
        }
        return textMinbun1;
    }
    private JTextField getTextMinbun2() {
        if (textMinbun2 == null) {
        	textMinbun2 = new JTextField();
        	textMinbun2.setColumns(10);
        	textMinbun2.setBounds(199, 60, 116, 21);
        }
        return textMinbun2;
    }
    private JLabel getLabel_3() {
        if (label_3 == null) {
        	label_3 = new JLabel("-");
        	label_3.setBounds(190, 63, 21, 15);
        }
        return label_3;
    }
    private JLabel getLabel_4() {
        if (label_4 == null) {
        	label_4 = new JLabel("전화번호");
        	label_4.setBounds(12, 88, 57, 15);
        }
        return label_4;
    }
    private JLabel getLabel_5() {
        if (label_5 == null) {
        	label_5 = new JLabel("-");
        	label_5.setBounds(133, 88, 21, 15);
        }
        return label_5;
    }
    private JTextField getTextPhoneNum2() {
        if (textPhoneNum2 == null) {
        	textPhoneNum2 = new JTextField();
        	textPhoneNum2.setColumns(10);
        	textPhoneNum2.setBounds(142, 85, 116, 21);
        }
        return textPhoneNum2;
    }
    private JLabel getLabel_6() {
        if (label_6 == null) {
        	label_6 = new JLabel("-");
        	label_6.setBounds(260, 88, 21, 15);
        }
        return label_6;
    }
    private JTextField getTextPhoneNum3() {
        if (textPhoneNum3 == null) {
        	textPhoneNum3 = new JTextField();
        	textPhoneNum3.setColumns(10);
        	textPhoneNum3.setBounds(270, 85, 95, 21);
        }
        return textPhoneNum3;
    }
    private JLabel getLabel_7() {
        if (label_7 == null) {
        	label_7 = new JLabel("메일주소");
        	label_7.setBounds(12, 113, 57, 15);
        }
        return label_7;
    }
    private JTextField getTextEmail1() {
        if (textEmail1 == null) {
        	textEmail1 = new JTextField();
        	textEmail1.setColumns(10);
        	textEmail1.setBounds(74, 110, 116, 21);
        }
        return textEmail1;
    }
    private JComboBox getTextPhoneNum1() {
        if (textPhoneNum1 == null) {
        	textPhoneNum1 = new JComboBox();
        	textPhoneNum1.setModel(new DefaultComboBoxModel(new String[] {"010", "011", "016", "018", "019"}));
        	textPhoneNum1.setBounds(74, 85, 57, 21);
        }
        return textPhoneNum1;
    }
    private JComboBox getTextEmail2() {
        if (textEmail2 == null) {
        	textEmail2 = new JComboBox();
        	textEmail2.setModel(new DefaultComboBoxModel(new String[] {"naver.com", "gmail.com", "hanmail.net", "nate.com"}));
        	textEmail2.setBounds(204, 110, 143, 21);
        }
        return textEmail2;
    }
    private JLabel getLabel_8() {
        if (label_8 == null) {
        	label_8 = new JLabel("@");
        	label_8.setBounds(191, 116, 57, 15);
        }
        return label_8;
    }
}
