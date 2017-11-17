package java99.library;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class frmRent extends JFrame {
    
    private JPanel     contentPane;
    private JLabel     label;
    private JLabel     label_1;
    private JLabel     label_2;
    private JTextField tFBname;
    private JTextField tFPublisher;
    private JTextField tFWriter;
    private JLabel     label_3;
    private JTextField tFCid;
    private JButton    btnNewButton;
    private JButton    btnNewButton_1;
    private JButton    button;
    private JTable     table;
    private JScrollPane scrollPane;
    private String    bid;
    private frmMain     parent;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frmRent frame = new frmRent(null, null, null, null, null);
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
    public frmRent(frmMain parent, String bookid, String bookname, String publisher,
            String writer) {
        setTitle("책 대여");
   //   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 467, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(getLabel());
        contentPane.add(getLabel_1());
        contentPane.add(getLabel_2());
        contentPane.add(getTFBname());
        contentPane.add(getTFPublisher());
        contentPane.add(getTFWriter());
        contentPane.add(getLabel_3());
        contentPane.add(getTFCid());
        contentPane.add(getBtnNewButton());
        contentPane.add(getBtnNewButton_1());
        contentPane.add(getButton());
        tFBname.setText(bookname);
        tFPublisher.setText(publisher);
        tFWriter.setText(writer);
        contentPane.add(getScrollPane());
        bid = bookid;
        this.parent = parent;
    }
    
    private JLabel getLabel() {
        if (label == null) {
            label = new JLabel("책 제목");
            label.setBounds(12, 28, 57, 15);
        }
        return label;
    }
    
    private JLabel getLabel_1() {
        if (label_1 == null) {
            label_1 = new JLabel("출판사");
            label_1.setBounds(12, 63, 57, 15);
        }
        return label_1;
    }
    
    private JLabel getLabel_2() {
        if (label_2 == null) {
            label_2 = new JLabel("저자");
            label_2.setBounds(12, 96, 57, 15);
        }
        return label_2;
    }
    
    private JTextField getTFBname() {
        if (tFBname == null) {
            tFBname = new JTextField();
            tFBname.setBounds(66, 25, 116, 21);
            tFBname.setColumns(10);
        }
        return tFBname;
    }
    
    private JTextField getTFPublisher() {
        if (tFPublisher == null) {
            tFPublisher = new JTextField();
            tFPublisher.setColumns(10);
            tFPublisher.setBounds(66, 60, 116, 21);
        }
        return tFPublisher;
    }
    
    private JTextField getTFWriter() {
        if (tFWriter == null) {
            tFWriter = new JTextField();
            tFWriter.setColumns(10);
            tFWriter.setBounds(66, 93, 116, 21);
        }
        return tFWriter;
    }
    
    private JLabel getLabel_3() {
        if (label_3 == null) {
            label_3 = new JLabel("회원번호검색");
            label_3.setBounds(12, 130, 72, 15);
        }
        return label_3;
    }
    
    private JTextField getTFCid() {
        if (tFCid == null) {
            tFCid = new JTextField();
            tFCid.setColumns(10);
            tFCid.setBounds(89, 127, 34, 21);
        }
        return tFCid;
    }
    
    private JButton getBtnNewButton() {
        if (btnNewButton == null) {
            btnNewButton = new JButton("검색");
            btnNewButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ResultSet rs = null;
                    ModelCustomer customer = new ModelCustomer();
                    customer.setCid(Integer.valueOf(tFCid.getText()));
                    ServiceCustomer sc = new ServiceCustomer();
                    try {
                        rs = sc.selectDynamic(customer);
                    } catch (SQLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    try {
                        if (!rs.next()) {
                            JOptionPane.showMessageDialog(null, "잘못된 회원번호");
                            return;
                        }
                    } catch (HeadlessException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    } catch (SQLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    showTable(rs);
                }
                
                public void showTable(ResultSet rs) {
                    Object[] tempObject = new Object[5];
                    DefaultTableModel model = (DefaultTableModel) table
                            .getModel();
                    model.setRowCount(0);
                    
                    try {
                        tempObject[0] = rs.getString("cid");
                        tempObject[1] = rs.getString("name");
                        tempObject[2] = rs.getString("MinBun");
                        tempObject[3] = rs.getString("PhoneNum");
                        tempObject[4] = rs.getString("email");
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                    model.addRow(tempObject);
                    
                    if (model.getRowCount() > 0) {
                        table.setRowSelectionInterval(0, 0);
                    }
                    
                    table.setModel(model);
                }
            });
            btnNewButton.setBounds(125, 126, 57, 23);
        }
        return btnNewButton;
    }
    
    private JButton getBtnNewButton_1() {
        if (btnNewButton_1 == null) {
            btnNewButton_1 = new JButton("대여");
            btnNewButton_1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    int rs = updateBtable();
                    if (rs > 0) {
                        rs = insertRtable();
                        if (rs > 0) {
                            JOptionPane.showMessageDialog(null, "대여 성공!");
                        }
                    }
                    parent.refresh();
                    dispose();           
                }
                
                public int updateBtable() {
                    ServiceBook sb = new ServiceBook();
                    ModelBook wherebook = new ModelBook();
                    ModelBook setbook = new ModelBook();
                    wherebook.setBookid(Integer.valueOf(bid));
                    setbook.setUse_yn(true);
                    int rs = sb.updateBook(wherebook, setbook);
                    return rs;
                }
                
                public int insertRtable() {
                    ServiceRent sr = new ServiceRent();
                    LocalDateTime today = LocalDateTime.now();
                    DefaultTableModel tb = (DefaultTableModel) table.getModel();
                    ModelRent rent = new ModelRent();
                    rent.setCid((Integer.valueOf((String) tb.getValueAt(0, 0))));                                 //cid      
                    rent.setBid(Integer.valueOf(bid));                                          //bid      
                    rent.setBookname(tFBname.getText());                                        //bookname 
                    rent.setName((String)tb.getValueAt(0, 1));                                  //name     
                    rent.setRentdate(today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));  //rentdate 
                    int rs = 0;
                    try {
                        rs = sr.insertRent(rent);
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    return rs;

                }
            });
            btnNewButton_1.setBounds(287, 24, 97, 54);
        }
        return btnNewButton_1;
    }
    
    private JButton getButton() {
        if (button == null) {
            button = new JButton("취소");
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    parent.refresh();
                    dispose();
                }
            });
            button.setBounds(287, 91, 97, 54);
        }
        return button;
    }
    
    private JTable getTable() {
        if (table == null) {
            table = new JTable();
            table.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "No.", "\uC774\uB984", "\uC8FC\uBBFC\uBC88\uD638", "\uC804\uD654\uBC88\uD638", "\uBA54\uC77C\uC8FC\uC18C"
                }
            ));
        }
        return table;
    }
    private JScrollPane getScrollPane() {
        if (scrollPane == null) {
        	scrollPane = new JScrollPane();
        	scrollPane.setBounds(12, 155, 427, 97);
        	scrollPane.setViewportView(getTable());
        }
        return scrollPane;
    }
}
