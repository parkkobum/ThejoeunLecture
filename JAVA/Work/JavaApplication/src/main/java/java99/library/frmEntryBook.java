package java99.library;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class frmEntryBook extends JFrame {
    
    private JPanel contentPane;
    private JLabel lblNewLabel;
    private JLabel label;
    private JLabel label_1;
    private JLabel label_2;
    private JLabel label_3;
    private JLabel label_4;
    private JTextField textBname;
    private JTextField textPublisher;
    private JTextField textWriter;
    private JTextField textPrice;
    private JComboBox comboType;
    private JButton btnNewButton;
    private JButton button;
    private JButton button_1;
    private frmMain parent;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frmEntryBook frame = new frmEntryBook(null);
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
    public frmEntryBook(frmMain parent) {
        setTitle("책 등록");
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(getLblNewLabel());
        contentPane.add(getLabel());
        contentPane.add(getLabel_1());
        contentPane.add(getLabel_2());
        contentPane.add(getLabel_3());
        contentPane.add(getLabel_4());
        contentPane.add(getTextBname());
        contentPane.add(getTextPublisher());
        contentPane.add(getTextWriter());
        contentPane.add(getTextPrice());
        contentPane.add(getComboType());
        contentPane.add(getBtnNewButton());
        contentPane.add(getButton());
        this.parent = parent;
    }
    private JLabel getLblNewLabel() {
        if (lblNewLabel == null) {
        	lblNewLabel = new JLabel("책 정보 입력");
        	lblNewLabel.setBounds(188, 10, 82, 15);
        }
        return lblNewLabel;
    }
    private JLabel getLabel() {
        if (label == null) {
        	label = new JLabel("책 제목");
        	label.setBounds(12, 38, 82, 15);
        }
        return label;
    }
    private JLabel getLabel_1() {
        if (label_1 == null) {
        	label_1 = new JLabel("출판사");
        	label_1.setBounds(12, 63, 82, 15);
        }
        return label_1;
    }
    private JLabel getLabel_2() {
        if (label_2 == null) {
        	label_2 = new JLabel("저자");
        	label_2.setBounds(12, 88, 82, 15);
        }
        return label_2;
    }
    private JLabel getLabel_3() {
        if (label_3 == null) {
        	label_3 = new JLabel("가격");
        	label_3.setBounds(12, 113, 82, 15);
        }
        return label_3;
    }
    private JLabel getLabel_4() {
        if (label_4 == null) {
        	label_4 = new JLabel("장르");
        	label_4.setBounds(12, 138, 82, 15);
        }
        return label_4;
    }
    private JTextField getTextBname() {
        if (textBname == null) {
        	textBname = new JTextField();
        	textBname.setBounds(72, 35, 198, 21);
        	textBname.setColumns(10);
        }
        return textBname;
    }
    private JTextField getTextPublisher() {
        if (textPublisher == null) {
        	textPublisher = new JTextField();
        	textPublisher.setColumns(10);
        	textPublisher.setBounds(72, 63, 198, 21);
        }
        return textPublisher;
    }
    private JTextField getTextWriter() {
        if (textWriter == null) {
        	textWriter = new JTextField();
        	textWriter.setColumns(10);
        	textWriter.setBounds(72, 88, 198, 21);
        }
        return textWriter;
    }
    private JTextField getTextPrice() {
        if (textPrice == null) {
        	textPrice = new JTextField();
        	textPrice.setColumns(10);
        	textPrice.setBounds(72, 113, 96, 21);
        }
        return textPrice;
    }
    private JComboBox getComboType() {
        if (comboType == null) {
        	comboType = new JComboBox();
        	comboType.setModel(new DefaultComboBoxModel(new String[] {"소설", "교육", "문학", "해외", "기타"}));
        	comboType.setBounds(72, 135, 96, 21);
        }
        return comboType;
    }
    private JButton getBtnNewButton() {
        if (btnNewButton == null) {
        	btnNewButton = new JButton("등록");
        	btnNewButton.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
                    ServiceBook sc = new ServiceBook();
                    ModelBook book = new ModelBook();
                    try {
                        insertBook(sc, book);
                    } catch (SQLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
        	    }
        	    
        	    public void insertBook(ServiceBook sc, ModelBook book) throws SQLException {
        	        //책이름(bookname)
        	        String bname = textBname.getText();
        	        if (bname.isEmpty()) {
                        JOptionPane.showMessageDialog(null, bname,"책제목 입력 오류",2);
                        return;
        	        }
        	        book.setBookname(bname);
        	        //공급사(publisher)
        	        String publisher = textPublisher.getText();
                    if (bname.isEmpty()) {
                        JOptionPane.showMessageDialog(null, bname,"책제목 입력 오류",2);
                        return;
                    }
                    book.setPublisher(publisher);
                    //장르(type)
        	        String type = (String) comboType.getSelectedItem();
        	        book.setType(type);
                    //저자(writer)
        	        String writer = textWriter.getText();
        	        if (writer.isEmpty()) {
                        JOptionPane.showMessageDialog(null, bname,"저자 입력 오류",2);
                        return;
        	        }
        	        book.setWriter(writer);
        	        
        	        //가격(price)
        	        Integer price = Integer.valueOf(textPrice.getText());
        	        if (price == null) {
                        JOptionPane.showMessageDialog(null, bname,"가격 입력 오류",2);
                        return;
        	        }
        	        book.setPrice(price);
        	        //대출여부(use_yn) 등록시 대출 안됨. default false
        	        book.setUse_yn(false);
        	        
        	        sc.insertBook(book);
                    JOptionPane.showMessageDialog(null, "책등록 성공!");
                    parent.refresh();
                    dispose();
        	    }
        	});
        	btnNewButton.setBounds(97, 176, 115, 47);
        }
        return btnNewButton;
    }
    private JButton getButton() {
        if (button == null) {
        	button = new JButton("취소");
        	button.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
//                    refresh(frame);
        	        dispose();
        	    }
        	});
        	button.setBounds(236, 176, 115, 47);
        }
        return button;
    }

}
