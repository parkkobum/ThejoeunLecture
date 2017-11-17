package java31.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class frmEmail extends JFrame {
    
    private JPanel contentPane;
    private JLabel lblNewLabel;
    private JLabel label;
    private JLabel label_1;
    private JLabel label_2;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JLabel lblE;
    private JLabel label_3;
    private JTextField textField_3;
    private JButton btnAdd;
    private JTextPane textPane;
    private JButton btnEdit;
    private JButton btnRemove;
    private JButton button;
    private JLabel lblMailFormat;
    private JRadioButton rdbtnHtml;
    private JRadioButton rdbtnPlainText;
    private JRadioButton rdbtnCustom;
    private JButton btnNewButton;
    private JButton btnCanc;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frmEmail frame = new frmEmail();
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
    public frmEmail() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 513, 508);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(getLblNewLabel());
        contentPane.add(getLabel());
        contentPane.add(getLabel_1());
        contentPane.add(getLabel_2());
        contentPane.add(getTextField());
        contentPane.add(getTextField_1());
        contentPane.add(getTextField_2());
        contentPane.add(getLblE());
        contentPane.add(getLabel_3());
        contentPane.add(getTextField_3());
        contentPane.add(getBtnAdd());
        contentPane.add(getTextPane());
        contentPane.add(getBtnEdit());
        contentPane.add(getBtnRemove());
        contentPane.add(getButton());
        contentPane.add(getLblMailFormat());
        contentPane.add(getRdbtnHtml());
        contentPane.add(getRdbtnPlainText());
        contentPane.add(getRdbtnCustom());
        contentPane.add(getBtnNewButton());
        contentPane.add(getBtnCanc());
    }
    private JLabel getLblNewLabel() {
        if (lblNewLabel == null) {
        	lblNewLabel = new JLabel("Name");
        	lblNewLabel.setBounds(41, 10, 57, 15);
        }
        return lblNewLabel;
    }
    private JLabel getLabel() {
        if (label == null) {
        	label = new JLabel("이름");
        	label.setBounds(41, 53, 57, 15);
        }
        return label;
    }
    private JLabel getLabel_1() {
        if (label_1 == null) {
        	label_1 = new JLabel("직책");
        	label_1.setBounds(41, 98, 57, 15);
        }
        return label_1;
    }
    private JLabel getLabel_2() {
        if (label_2 == null) {
        	label_2 = new JLabel("아이디");
        	label_2.setBounds(241, 98, 57, 15);
        }
        return label_2;
    }
    private JTextField getTextField() {
        if (textField == null) {
        	textField = new JTextField();
        	textField.setBounds(94, 50, 116, 21);
        	textField.setColumns(10);
        }
        return textField;
    }
    private JTextField getTextField_1() {
        if (textField_1 == null) {
        	textField_1 = new JTextField();
        	textField_1.setColumns(10);
        	textField_1.setBounds(94, 95, 116, 21);
        }
        return textField_1;
    }
    private JTextField getTextField_2() {
        if (textField_2 == null) {
        	textField_2 = new JTextField();
        	textField_2.setColumns(10);
        	textField_2.setBounds(295, 95, 116, 21);
        }
        return textField_2;
    }
    private JLabel getLblE() {
        if (lblE == null) {
        	lblE = new JLabel("E-MAIL");
        	lblE.setBounds(41, 152, 57, 15);
        }
        return lblE;
    }
    private JLabel getLabel_3() {
        if (label_3 == null) {
        	label_3 = new JLabel("이메일주소");
        	label_3.setBounds(41, 194, 75, 15);
        }
        return label_3;
    }
    private JTextField getTextField_3() {
        if (textField_3 == null) {
        	textField_3 = new JTextField();
        	textField_3.setColumns(10);
        	textField_3.setBounds(112, 191, 233, 21);
        }
        return textField_3;
    }
    private JButton getBtnAdd() {
        if (btnAdd == null) {
        	btnAdd = new JButton("ADD");
        	btnAdd.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        textPane.setText(textPane.getText()+"\n"+textField_3.getText());
        	    }
        	});
        	btnAdd.setBounds(371, 190, 97, 40);
        }
        return btnAdd;
    }
    private JTextPane getTextPane() {
        if (textPane == null) {
        	textPane = new JTextPane();
        	textPane.setBounds(41, 240, 304, 88);
        }
        return textPane;
    }
    private JButton getBtnEdit() {
        if (btnEdit == null) {
        	btnEdit = new JButton("EDIT");
        	btnEdit.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	    }
        	});
        	btnEdit.setBounds(371, 237, 97, 31);
        }
        return btnEdit;
    }
    private JButton getBtnRemove() {
        if (btnRemove == null) {
        	btnRemove = new JButton("REMOVE");
        	btnRemove.setBounds(371, 278, 97, 31);
        }
        return btnRemove;
    }
    private JButton getButton() {
        if (button == null) {
        	button = new JButton("DEFAULT");
        	button.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	    }
        	});
        	button.setBounds(371, 319, 97, 31);
        }
        return button;
    }
    private JLabel getLblMailFormat() {
        if (lblMailFormat == null) {
        	lblMailFormat = new JLabel("Mail Format");
        	lblMailFormat.setBounds(41, 345, 97, 15);
        }
        return lblMailFormat;
    }
    private JRadioButton getRdbtnHtml() {
        if (rdbtnHtml == null) {
        	rdbtnHtml = new JRadioButton("HTML");
        	rdbtnHtml.setBounds(41, 368, 59, 23);
        }
        return rdbtnHtml;
    }
    private JRadioButton getRdbtnPlainText() {
        if (rdbtnPlainText == null) {
        	rdbtnPlainText = new JRadioButton("Plain Text");
        	rdbtnPlainText.setBounds(151, 368, 97, 23);
        }
        return rdbtnPlainText;
    }
    private JRadioButton getRdbtnCustom() {
        if (rdbtnCustom == null) {
        	rdbtnCustom = new JRadioButton("Custom");
        	rdbtnCustom.setBounds(268, 368, 97, 23);
        }
        return rdbtnCustom;
    }
    private JButton getBtnNewButton() {
        if (btnNewButton == null) {
        	btnNewButton = new JButton("OK");
        	btnNewButton.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        int result = JOptionPane.showConfirmDialog(rootPane, textField.getText()+textField_1.getText()+textField_2.getText()+textPane.getText());     
        	    }
        	});
        	btnNewButton.setBounds(248, 412, 97, 48);
        }
        return btnNewButton;
    }
    private JButton getBtnCanc() {
        if (btnCanc == null) {
        	btnCanc = new JButton("Cancel");
        	btnCanc.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        dispose();
        	    }
        	});
        	btnCanc.setBounds(371, 412, 97, 48);
        }
        return btnCanc;
    }
}
