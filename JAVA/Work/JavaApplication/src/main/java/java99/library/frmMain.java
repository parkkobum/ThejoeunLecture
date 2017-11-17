package java99.library;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JToggleButton;
import javax.swing.JSplitPane;
import javax.swing.JInternalFrame;
import javax.swing.JTree;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.tree.DefaultTreeModel;

import java31.st2table.Book;

import javax.swing.tree.DefaultMutableTreeNode;

public class frmMain extends JFrame {
    
    private static List<ModelBook>     books             = null;
    private static List<ModelCustomer> customers         = null;
    private static List<ModelRent>     rents             = null;
    
    private JPanel                     contentPane;
    private JPanel                     upperMenu;
    private JButton                    btnNewButton;
    private JButton                    button;
    private JButton                    button_1;
    private JButton                    button_2;
    private JPanel                     rentStatus;
    private JTabbedPane                tabbedPane;
    private JPanel                     bookinfo;
    private JPanel                     maninfo;
    private JPanel                     rentlist;
    private JButton                    btnNewButton_1;
    private JTable                     rentlistTable;
    private JScrollPane                scrollPane;
    private JLabel                     lblNewLabel;
    private JLabel                     label;
    private JLabel                     label_1;
    private JLabel                     label_2;
    private JLabel                     label_3;
    private JTextField                 textName;
    private JTextField                 minbun1;
    private JTextField                 phoneNum1;
    private JTextField                 email1;
    private JComboBox                  comboSearchCType;
    private JTextField                 cid;
    private JTextField                 minbun2;
    private JTextField                 phoneNum2;
    private JTextField                 phoneNum3;
    private JTextField                 email2;
    private JTextField                 searchbox;
    private JButton                    button_3;
    private JScrollPane                scrollPane_1;
    private static JTable              cinfotable;
    private JButton                    btnNewButton_2;
    private JButton                    button_4;
    private JButton                    button_5;
    private JLabel                     label_4;
    private JLabel                     label_5;
    private JLabel                     label_6;
    private JScrollPane                scrollPane_2;
    private static JTable              rinfotable;
    private JLabel                     label_7;
    private JLabel                     lblCorwpahr;
    private JTextField                 txtName;
    private JTextField                 txtId;
    private JLabel                     label_9;
    private JTextField                 txtWriter;
    private JLabel                     label_10;
    private JTextField                 txtPrice;
    private JLabel                     label_11;
    private JTextField                 txtType;
    private JLabel                     label_12;
    private JComboBox                  comboBSearch;
    private JButton                    button_6;
    private JTextField                 txtSearch;
    private JLabel                     label_13;
    private JTextField                 txtPublish;
    private JLabel                     label_8;
    private JButton                    btnNewButton_3;
    private JButton                    button_7;
    private JButton                    button_8;
    private JButton                    button_9;
    private JScrollPane                scrollPane_3;
    private static JTable              binfotable;
    private JTree                      tree;
    private static frmMain             frame;
    private static Boolean             clickedbookuse_yn = true;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new frmMain();
                    frame.setVisible(true);
                    refresh();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public static void refresh() {
        try {
            initData();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        frame.refreshBTable(books, binfotable);
        frame.refreshCTable(customers, cinfotable);
        frame.refreshRTable(rents, rinfotable);
        frame.refreshRLTable();
    }
    
    public static void initData() throws SQLException {
        books = new ArrayList<>();
        ServiceBook sb = new ServiceBook();
        ResultSet rs = sb.selectAll();
        
        while (rs.next()) {
            books.add(
                    new ModelBook(rs.getInt("bookid"), rs.getString("bookname"),
                            rs.getString("publisher"), rs.getString("type"),
                            rs.getString("writer"), rs.getInt("price"), // ));
                            rs.getBoolean("use_yn")));
        }
        
        customers = new ArrayList<>();
        ServiceCustomer sc = new ServiceCustomer();
        
        rs = sc.selectAll();
        
        while (rs.next()) {
            customers.add(new ModelCustomer(rs.getInt("cid"),
                    rs.getString("name"), rs.getString("minBun"),
                    rs.getString("phoneNum"), rs.getString("email")));
        }
        
        rents = new ArrayList<>();
        ServiceRent sr = new ServiceRent();
        rs = sr.selectAll();
        
        while (rs.next()) {
            rents.add(new ModelRent(rs.getInt("rentid"),
                    Integer.valueOf(rs.getString("cid")),
                    Integer.valueOf(rs.getInt("bid")), rs.getString("bookname"),
                    rs.getString("name"), rs.getString("rentdate")));
        }
    }
    
    /**
     * Create the frame.
     */
    public frmMain() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1033, 629);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(getUpperMenu());
        contentPane.add(getRentStatus());
        contentPane.add(getTabbedPane());
    }
    
    private JPanel getUpperMenu() {
        if (upperMenu == null) {
            upperMenu = new JPanel();
            upperMenu.setBounds(12, 10, 500, 63);
            upperMenu.setLayout(null);
            upperMenu.add(getBtnNewButton());
            upperMenu.add(getButton());
            upperMenu.add(getButton_1());
            upperMenu.add(getButton_2());
        }
        return upperMenu;
    }
    
    private JButton getBtnNewButton() {
        if (btnNewButton == null) {
            btnNewButton = new JButton("회원등록");
            btnNewButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    frmEntryCustomer frm = new frmEntryCustomer(frame);
                    frm.setVisible(true);
                }
            });
            btnNewButton.setBounds(12, 10, 97, 44);
        }
        return btnNewButton;
    }
    
    private JButton getButton() {
        if (button == null) {
            button = new JButton("책등록");
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    frmEntryBook frm = new frmEntryBook(frame);
                    frm.setVisible(true);
                }
            });
            button.setBounds(122, 10, 97, 44);
        }
        return button;
    }
    
    private JButton getButton_1() {
        if (button_1 == null) {
            button_1 = new JButton("새로고침");
            button_1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    refresh();
                }
            });
            button_1.setBounds(231, 10, 97, 44);
        }
        return button_1;
    }
    
    private JButton getButton_2() {
        if (button_2 == null) {
            button_2 = new JButton("프로그램 종료");
            button_2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            });
            button_2.setBounds(343, 10, 97, 44);
        }
        return button_2;
    }
    
    private JPanel getRentStatus() {
        if (rentStatus == null) {
            rentStatus = new JPanel();
            rentStatus.setBounds(12, 83, 261, 508);
            rentStatus.setLayout(null);
            rentStatus.add(getScrollPane_2());
            rentStatus.add(getLabel_7());
        }
        return rentStatus;
    }
    
    private JTabbedPane getTabbedPane() {
        if (tabbedPane == null) {
            tabbedPane = new JTabbedPane(JTabbedPane.TOP);
            tabbedPane.setBounds(285, 83, 720, 508);
            tabbedPane.addTab("책 정보", null, getBookinfo(), null);
            tabbedPane.addTab("회원 관리", null, getManinfo(), null);
            tabbedPane.addTab("대여 목록", null, getRentlist(), null);
        }
        return tabbedPane;
    }
    
    private JPanel getBookinfo() {
        if (bookinfo == null) {
            bookinfo = new JPanel();
            bookinfo.setLayout(null);
            bookinfo.add(getLblCorwpahr());
            bookinfo.add(getTxtName());
            bookinfo.add(getTxtId());
            bookinfo.add(getLabel_9());
            bookinfo.add(getTxtWriter());
            bookinfo.add(getLabel_10());
            bookinfo.add(getTxtPrice());
            bookinfo.add(getLabel_11());
            bookinfo.add(getTxtType());
            bookinfo.add(getLabel_12());
            bookinfo.add(getComboBSearch());
            bookinfo.add(getButton_6());
            bookinfo.add(getTxtSearch());
            bookinfo.add(getLabel_13());
            bookinfo.add(getTxtPublish());
            bookinfo.add(getLabel_8());
            bookinfo.add(getBtnNewButton_3());
            bookinfo.add(getButton_7());
            bookinfo.add(getButton_8());
            bookinfo.add(getButton_9());
            bookinfo.add(getScrollPane_3());
            bookinfo.add(getTree());
        }
        return bookinfo;
    }
    
    private JPanel getManinfo() {
        if (maninfo == null) {
            maninfo = new JPanel();
            maninfo.setLayout(null);
            maninfo.add(getLblNewLabel());
            maninfo.add(getLabel());
            maninfo.add(getLabel_1());
            maninfo.add(getLabel_2());
            maninfo.add(getLabel_3());
            maninfo.add(getTextName());
            maninfo.add(getMinbun1());
            maninfo.add(getPhoneNum1());
            maninfo.add(getEmail1());
            maninfo.add(getComboSearchCType());
            maninfo.add(getCid());
            maninfo.add(getMinbun2());
            maninfo.add(getPhoneNum2());
            maninfo.add(getPhoneNum3());
            maninfo.add(getEmail2());
            maninfo.add(getSearchbox());
            maninfo.add(getButton_3());
            maninfo.add(getScrollPane_1());
            maninfo.add(getBtnNewButton_2());
            maninfo.add(getButton_4());
            maninfo.add(getButton_5());
            maninfo.add(getLabel_4());
            maninfo.add(getLabel_5());
            maninfo.add(getLabel_6());
        }
        return maninfo;
    }
    
    private JPanel getRentlist() {
        if (rentlist == null) {
            rentlist = new JPanel();
            rentlist.setLayout(null);
            rentlist.add(getBtnNewButton_1());
            rentlist.add(getScrollPane());
        }
        return rentlist;
    }
    
    private JButton getBtnNewButton_1() {
        if (btnNewButton_1 == null) {
            btnNewButton_1 = new JButton("반납 완료");
            btnNewButton_1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ServiceRent sr = new ServiceRent();
                    ModelRent rent = new ModelRent();
                    int row = rentlistTable.getSelectedRow();
                    int rentid = Integer.valueOf(
                            rentlistTable.getValueAt(row, 0).toString());
                    rent.setRentid(rentid);
                    int rs = -1;
                    try {
                        rs = sr.deleteRent(rent);
                    } catch (SQLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    ServiceBook sb = new ServiceBook();
                    ModelBook wherebook = new ModelBook(
                            Integer.valueOf(rentlistTable.getValueAt(row, 9)
                                    .toString()),
                            null, null, null, null, null, null);
                    ModelBook setbook = new ModelBook(null, null, null, null,
                            null, null, false);
                    
                    sb.updateBook(wherebook, setbook);
                    if (rs > 0) {
                        JOptionPane.showMessageDialog(null, "반납 완료");
                    } else {
                        JOptionPane.showMessageDialog(null, "반납 실패");
                    }
                    refresh();
                }
            });
            btnNewButton_1.setBounds(558, 29, 145, 47);
        }
        return btnNewButton_1;
    }
    
    private JTable getRentlistTable() {
        if (rentlistTable == null) {
            rentlistTable = new JTable();
            rentlistTable.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    
                }
            });
            rentlistTable.setModel(new DefaultTableModel(new Object[][] {},
                    new String[] { "No", "\uC774\uB984",
                            "\uC804\uD654\uBC88\uD638",
                            "\uC8FC\uBBFC\uBC88\uD638",
                            "\uBA54\uC77C\uC8FC\uC18C", "\uCC45 \uC81C\uBAA9",
                            "\uCD9C\uD310\uC0AC", "\uC7A5\uB974",
                            "\uC800\uC790", "\uCC45 \uBC88\uD638",
                            "\uB300\uC5EC\uB0A0\uC9DC" }));
        }
        return rentlistTable;
    }
    
    private JScrollPane getScrollPane() {
        if (scrollPane == null) {
            scrollPane = new JScrollPane();
            scrollPane.setBounds(12, 96, 691, 383);
            scrollPane.setViewportView(getRentlistTable());
        }
        return scrollPane;
    }
    
    private JLabel getLblNewLabel() {
        if (lblNewLabel == null) {
            lblNewLabel = new JLabel("이름");
            lblNewLabel.setBounds(36, 26, 57, 15);
        }
        return lblNewLabel;
    }
    
    private JLabel getLabel() {
        if (label == null) {
            label = new JLabel("주민번호");
            label.setBounds(36, 51, 57, 15);
        }
        return label;
    }
    
    private JLabel getLabel_1() {
        if (label_1 == null) {
            label_1 = new JLabel("전화번호");
            label_1.setBounds(36, 76, 57, 15);
        }
        return label_1;
    }
    
    private JLabel getLabel_2() {
        if (label_2 == null) {
            label_2 = new JLabel("메일주소");
            label_2.setBounds(36, 101, 57, 15);
        }
        return label_2;
    }
    
    private JLabel getLabel_3() {
        if (label_3 == null) {
            label_3 = new JLabel("검색");
            label_3.setBounds(36, 126, 57, 15);
        }
        return label_3;
    }
    
    private JTextField getTextName() {
        if (textName == null) {
            textName = new JTextField();
            textName.setBounds(98, 23, 116, 21);
            textName.setColumns(10);
        }
        return textName;
    }
    
    private JTextField getMinbun1() {
        if (minbun1 == null) {
            minbun1 = new JTextField();
            minbun1.setColumns(10);
            minbun1.setBounds(98, 51, 116, 21);
        }
        return minbun1;
    }
    
    private JTextField getPhoneNum1() {
        if (phoneNum1 == null) {
            phoneNum1 = new JTextField();
            phoneNum1.setColumns(10);
            phoneNum1.setBounds(98, 73, 116, 21);
        }
        return phoneNum1;
    }
    
    private JTextField getEmail1() {
        if (email1 == null) {
            email1 = new JTextField();
            email1.setColumns(10);
            email1.setBounds(98, 98, 116, 21);
        }
        return email1;
    }
    
    private JComboBox getComboSearchCType() {
        if (comboSearchCType == null) {
            comboSearchCType = new JComboBox();
            comboSearchCType.setModel(new DefaultComboBoxModel(
                    new String[] { "회원번호", "이      름" }));
            comboSearchCType.setBounds(98, 123, 116, 21);
        }
        return comboSearchCType;
    }
    
    private JTextField getCid() {
        if (cid == null) {
            cid = new JTextField();
            cid.setColumns(10);
            cid.setBounds(223, 23, 57, 21);
        }
        return cid;
    }
    
    private JTextField getMinbun2() {
        if (minbun2 == null) {
            minbun2 = new JTextField();
            minbun2.setColumns(10);
            minbun2.setBounds(223, 48, 116, 21);
        }
        return minbun2;
    }
    
    private JTextField getPhoneNum2() {
        if (phoneNum2 == null) {
            phoneNum2 = new JTextField();
            phoneNum2.setColumns(10);
            phoneNum2.setBounds(223, 73, 116, 21);
        }
        return phoneNum2;
    }
    
    private JTextField getPhoneNum3() {
        if (phoneNum3 == null) {
            phoneNum3 = new JTextField();
            phoneNum3.setColumns(10);
            phoneNum3.setBounds(351, 73, 116, 21);
        }
        return phoneNum3;
    }
    
    private JTextField getEmail2() {
        if (email2 == null) {
            email2 = new JTextField();
            email2.setColumns(10);
            email2.setBounds(223, 98, 116, 21);
        }
        return email2;
    }
    
    private JTextField getSearchbox() {
        if (searchbox == null) {
            searchbox = new JTextField();
            searchbox.setColumns(10);
            searchbox.setBounds(223, 123, 116, 21);
        }
        return searchbox;
    }
    
    private JButton getButton_3() {
        if (button_3 == null) {
            button_3 = new JButton("검색");
            button_3.setBounds(351, 122, 97, 23);
        }
        return button_3;
    }
    
    private JScrollPane getScrollPane_1() {
        if (scrollPane_1 == null) {
            scrollPane_1 = new JScrollPane();
            scrollPane_1.setBounds(36, 223, 641, 246);
            scrollPane_1.setViewportView(getCinfotable());
        }
        return scrollPane_1;
    }
    
    private JTable getCinfotable() {
        if (cinfotable == null) {
            cinfotable = new JTable();
            cinfotable.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int row = cinfotable.getSelectedRow();
                    
                    String savedId = cinfotable.getValueAt(row, 0).toString();
                    String cname = cinfotable.getValueAt(row, 1).toString();
                    String minBun = cinfotable.getValueAt(row, 2).toString();
                    String phoneNUm = cinfotable.getValueAt(row, 3).toString();
                    String email = cinfotable.getValueAt(row, 4).toString();
                    
                    cid.setText(savedId);
                    textName.setText(cname);
                    String[] min = minBun.split("-");
                    minbun1.setText(min[0]);
                    minbun2.setText(min[1]);
                    String[] phone = phoneNUm.split("-");
                    phoneNum1.setText(phone[0]);
                    phoneNum2.setText(phone[1]);
                    phoneNum3.setText(phone[2]);
                    String[] emails = email.split("@");
                    email1.setText(emails[0]);
                    email2.setText(emails[1]);
                }
            });
            cinfotable.setModel(new DefaultTableModel(new Object[][] {},
                    new String[] { "\uD68C\uC6D0\uBC88\uD638", "\uC774\uB984",
                            "\uC8FC\uBBFC\uBC88\uD638",
                            "\uC804\uD654\uBC88\uD638",
                            "\uBA54\uC77C\uC8FC\uC18C" }));
        }
        return cinfotable;
    }
    
    private JButton getBtnNewButton_2() {
        if (btnNewButton_2 == null) {
            btnNewButton_2 = new JButton("회원삭제");
            btnNewButton_2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ModelCustomer customer = new ModelCustomer();
                    customer.setCid(Integer.valueOf(cid.getText()));
                    ServiceCustomer sc = new ServiceCustomer();
                    int rs = -1;
                    try {
                        rs = sc.deleteCustomer(customer);
                    } catch (SQLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    if (rs > 0) {
                        JOptionPane.showMessageDialog(null, "삭제 완료!");
                    } else {
                        JOptionPane.showMessageDialog(null, "삭제 실패!");
                    }
                    refresh();
                }
            });
            btnNewButton_2.setBounds(36, 154, 125, 59);
        }
        return btnNewButton_2;
    }
    
    private JButton getButton_4() {
        if (button_4 == null) {
            button_4 = new JButton("회원수정");
            button_4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    ServiceCustomer sc = new ServiceCustomer();
                    ModelCustomer wherecustomer = new ModelCustomer();
                    ModelCustomer setcustomer = new ModelCustomer();
                    int row = cinfotable.getSelectedRow();
                    
                    wherecustomer.setCid(Integer
                            .valueOf(cinfotable.getValueAt(row, 0).toString()));
                    setcustomer
                            .setName(textName.getText());
                    setcustomer.setMinBun(minbun1.getText()+"-"+minbun2.getText());
                    setcustomer.setPhoneNum(phoneNum1.getText()+"-"+phoneNum2.getText()+"-"+phoneNum3.getText());
                    setcustomer.setEmail(email1.getText()+"@"+email2.getText());
                    
                    int rs = -1;
                    rs = sc.updateCustomer(wherecustomer, setcustomer);
                    if (rs > 0) {
                        JOptionPane.showMessageDialog(null, "수정 완료!");
                    } else {
                        JOptionPane.showMessageDialog(null, "수정 실패!");
                    }
                    refresh();
                }
            });
            button_4.setBounds(214, 154, 125, 59);
        }
        return button_4;
    }
    
    private JButton getButton_5() {
        if (button_5 == null) {
            button_5 = new JButton("취소");
            button_5.setBounds(386, 155, 125, 59);
        }
        return button_5;
    }
    
    private JLabel getLabel_4() {
        if (label_4 == null) {
            label_4 = new JLabel("-");
            label_4.setBounds(214, 51, 21, 15);
        }
        return label_4;
    }
    
    private JLabel getLabel_5() {
        if (label_5 == null) {
            label_5 = new JLabel("-");
            label_5.setBounds(214, 76, 21, 15);
        }
        return label_5;
    }
    
    private JLabel getLabel_6() {
        if (label_6 == null) {
            label_6 = new JLabel("-");
            label_6.setBounds(341, 76, 21, 15);
        }
        return label_6;
    }
    
    private JScrollPane getScrollPane_2() {
        if (scrollPane_2 == null) {
            scrollPane_2 = new JScrollPane();
            scrollPane_2.setBounds(12, 35, 237, 461);
            scrollPane_2.setViewportView(getRinfotable());
        }
        return scrollPane_2;
    }
    
    private JTable getRinfotable() {
        if (rinfotable == null) {
            rinfotable = new JTable();
            rinfotable.setModel(new DefaultTableModel(new Object[][] {},
                    new String[] { "\uC774\uB984", "\uCC45 \uC81C\uBAA9",
                            "\uB300\uC5EC \uB0A0\uC9DC" }));
        }
        return rinfotable;
    }
    
    private JLabel getLabel_7() {
        if (label_7 == null) {
            label_7 = new JLabel("대출상황");
            label_7.setBounds(104, 10, 57, 15);
        }
        return label_7;
    }
    
    private JLabel getLblCorwpahr() {
        if (lblCorwpahr == null) {
            lblCorwpahr = new JLabel("책제목");
            lblCorwpahr.setBounds(271, 13, 57, 15);
        }
        return lblCorwpahr;
    }
    
    private JTextField getTxtName() {
        if (txtName == null) {
            txtName = new JTextField();
            txtName.setColumns(10);
            txtName.setBounds(333, 10, 116, 21);
        }
        return txtName;
    }
    
    private JTextField getTxtId() {
        if (txtId == null) {
            txtId = new JTextField();
            txtId.setColumns(10);
            txtId.setBounds(505, 10, 57, 21);
        }
        return txtId;
    }
    
    private JLabel getLabel_9() {
        if (label_9 == null) {
            label_9 = new JLabel("저자");
            label_9.setBounds(271, 64, 57, 15);
        }
        return label_9;
    }
    
    private JTextField getTxtWriter() {
        if (txtWriter == null) {
            txtWriter = new JTextField();
            txtWriter.setColumns(10);
            txtWriter.setBounds(333, 64, 116, 21);
        }
        return txtWriter;
    }
    
    private JLabel getLabel_10() {
        if (label_10 == null) {
            label_10 = new JLabel("가격");
            label_10.setBounds(271, 89, 57, 15);
        }
        return label_10;
    }
    
    private JTextField getTxtPrice() {
        if (txtPrice == null) {
            txtPrice = new JTextField();
            txtPrice.setColumns(10);
            txtPrice.setBounds(333, 86, 72, 21);
        }
        return txtPrice;
    }
    
    private JLabel getLabel_11() {
        if (label_11 == null) {
            label_11 = new JLabel("장르");
            label_11.setBounds(271, 114, 57, 15);
        }
        return label_11;
    }
    
    private JTextField getTxtType() {
        if (txtType == null) {
            txtType = new JTextField();
            txtType.setColumns(10);
            txtType.setBounds(333, 111, 72, 21);
        }
        return txtType;
    }
    
    private JLabel getLabel_12() {
        if (label_12 == null) {
            label_12 = new JLabel("검색");
            label_12.setBounds(270, 142, 57, 15);
        }
        return label_12;
    }
    
    private JComboBox getComboBSearch() {
        if (comboBSearch == null) {
            comboBSearch = new JComboBox();
            comboBSearch.setModel(new DefaultComboBoxModel(
                    new String[] { "제목", "출판사", "저자", "장르", "가격" }));
            comboBSearch.setBounds(332, 139, 116, 21);
        }
        return comboBSearch;
    }
    
    private JButton getButton_6() {
        if (button_6 == null) {
            button_6 = new JButton("검색");
            button_6.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    ModelBook book = new ModelBook();
                    String item = (String) comboBSearch.getSelectedItem();
                    if (item.equals("제목")) {
                        book.setBookname(txtSearch.getText());
                    }
                    if (item.equals("출판사")) {
                        book.setPublisher(txtSearch.getText());
                    }
                    if (item.equals("저자")) {
                        book.setWriter(txtSearch.getText());
                    }
                    if (item.equals("장르")) {
                        book.setType(txtSearch.getText());
                    }
                    if (item.equals("가격")) {
                        book.setPrice(Integer.valueOf(txtSearch.getText()));
                    }
                    ResultSet rs = null;
                    ServiceBook sb = new ServiceBook();
                    try {
                        rs = sb.selectDynamic(book);
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    
                    books = new ArrayList<>();
                    
                    try {
                        while (rs.next()) {
                            books.add(new ModelBook(rs.getInt("bookid"),
                                    rs.getString("bookname"),
                                    rs.getString("publisher"),
                                    rs.getString("type"),
                                    rs.getString("writer"), rs.getInt("price"), // ));
                                    rs.getBoolean("use_yn")));
                        }
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    
                    refreshBTable(books, binfotable);
                }
            });
            button_6.setBounds(585, 138, 97, 23);
        }
        return button_6;
    }
    
    private JTextField getTxtSearch() {
        if (txtSearch == null) {
            txtSearch = new JTextField();
            txtSearch.setColumns(10);
            txtSearch.setBounds(457, 139, 116, 21);
        }
        return txtSearch;
    }
    
    private JLabel getLabel_13() {
        if (label_13 == null) {
            label_13 = new JLabel("출판사");
            label_13.setBounds(271, 36, 57, 15);
        }
        return label_13;
    }
    
    private JTextField getTxtPublish() {
        if (txtPublish == null) {
            txtPublish = new JTextField();
            txtPublish.setColumns(10);
            txtPublish.setBounds(333, 36, 116, 21);
        }
        return txtPublish;
    }
    
    private JLabel getLabel_8() {
        if (label_8 == null) {
            label_8 = new JLabel("책번호");
            label_8.setBounds(454, 11, 57, 15);
        }
        return label_8;
    }
    
    private JButton getBtnNewButton_3() {
        if (btnNewButton_3 == null) {
            btnNewButton_3 = new JButton("대여하기");
            btnNewButton_3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (clickedbookuse_yn == false) {
                        frmRent frm = new frmRent(frame, txtId.getText(),
                                txtName.getText(), txtPublish.getText(),
                                txtWriter.getText());
                        frm.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "대여 중인 책은 대출 불가!");
                    }
                }
            });
            btnNewButton_3.setBounds(262, 167, 97, 43);
        }
        return btnNewButton_3;
    }
    
    private JButton getButton_7() {
        if (button_7 == null) {
            button_7 = new JButton("수정");
            button_7.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ModelBook setbook = new ModelBook();
                    ModelBook wherebook = new ModelBook();
                    wherebook.setBookid(Integer.valueOf(txtId.getText()));
                    setbook.setBookname(txtName.getText());
                    setbook.setPrice(Integer.valueOf(txtPrice.getText()));
                    setbook.setPublisher(txtPublish.getText());
                    setbook.setType(txtType.getText());
                    setbook.setWriter(txtWriter.getText());
                    ServiceBook sb = new ServiceBook();
                    int rs = sb.updateBookInfo(wherebook, setbook);
                    if (rs > 0) {
                        JOptionPane.showMessageDialog(null, "수정 완료!");
                    } else {
                        JOptionPane.showMessageDialog(null, "수정 실패!");
                    }
                    refresh();
                }
            });
            button_7.setBounds(366, 167, 97, 43);
        }
        return button_7;
    }
    
    private JButton getButton_8() {
        if (button_8 == null) {
            button_8 = new JButton("삭제");
            button_8.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    
                    if (clickedbookuse_yn == false) {
                        ModelBook dbook = new ModelBook(
                                Integer.valueOf(txtId.getText()), null, null,
                                null, null, null, null);
                        ServiceBook sb = new ServiceBook();
                        try {
                            if (sb.deleteBook(dbook) > 0) {
                                JOptionPane.showMessageDialog(null, "삭제 완료");
                            }
                        } catch (SQLException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "대여 중인 책은 대출 불가!");
                    }
                    refresh();
                }
            });
            button_8.setBounds(476, 167, 97, 43);
        }
        return button_8;
    }
    
    private JButton getButton_9() {
        if (button_9 == null) {
            button_9 = new JButton("취소");
            button_9.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    refresh();
                }
            });
            button_9.setBounds(585, 167, 97, 43);
        }
        return button_9;
    }
    
    private JScrollPane getScrollPane_3() {
        if (scrollPane_3 == null) {
            scrollPane_3 = new JScrollPane();
            scrollPane_3.setBounds(22, 220, 653, 249);
            scrollPane_3.setViewportView(getBinfotable());
        }
        return scrollPane_3;
    }
    
    private JTable getBinfotable() {
        if (binfotable == null) {
            binfotable = new JTable();
            binfotable.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int row = binfotable.getSelectedRow();
                    
                    String savedId = binfotable.getValueAt(row, 0).toString();
                    String bname = binfotable.getValueAt(row, 1).toString();
                    String publish = binfotable.getValueAt(row, 2).toString();
                    String type = binfotable.getValueAt(row, 3).toString();
                    String writer = binfotable.getValueAt(row, 4).toString();
                    String price = binfotable.getValueAt(row, 5).toString();
                    String use_yn = binfotable.getValueAt(row, 6).toString();
                    
                    txtId.setText(savedId);
                    txtName.setText(bname);
                    txtPublish.setText(publish);
                    txtType.setText(type);
                    txtWriter.setText(writer);
                    txtPrice.setText(price);
                    clickedbookuse_yn = use_yn.equals("대여 가능") ? false : true;
                    
                }
                
            });
            binfotable.setModel(new DefaultTableModel(new Object[][] {},
                    new String[] { "No.", "\uC81C\uBAA9", "\uCD9C\uD310\uC0AC",
                            "\uC7A5\uB974", "\uC800\uC790", "\uAC00\uACA9",
                            "\uB300\uC5EC\uC815\uBCF4" }));
        }
        return binfotable;
    }
    
    public void refreshBTable(List<ModelBook> list, JTable table) {
        Object[] tempObject = new Object[7];
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        
        for (ModelBook obj : list) {
            tempObject[0] = obj.getBookid();
            tempObject[1] = obj.getBookname();
            tempObject[2] = obj.getPublisher();
            tempObject[3] = obj.getType();
            tempObject[4] = obj.getWriter();
            tempObject[5] = obj.getPrice();
            tempObject[6] = obj.getUse_yn() ? "대여 불가능" : "대여 가능";
            
            model.addRow(tempObject);
        }
        
        if (model.getRowCount() > 0) {
            table.setRowSelectionInterval(0, 0);
        }
        
        table.setModel(model);
        
    }
    
    public void refreshCTable(List<ModelCustomer> list, JTable table) {
        Object[] tempObject = new Object[5];
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        
        for (ModelCustomer obj : list) {
            tempObject[0] = obj.getCid();
            tempObject[1] = obj.getName();
            tempObject[2] = obj.getMinBun();
            tempObject[3] = obj.getPhoneNum();
            tempObject[4] = obj.getEmail();
            
            model.addRow(tempObject);
        }
        
        if (model.getRowCount() > 0) {
            table.setRowSelectionInterval(0, 0);
        }
        
        table.setModel(model);
        
    }
    
    public void refreshRTable(List<ModelRent> list, JTable table) {
        Object[] tempObject = new Object[3];
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        
        for (ModelRent obj : list) {
            tempObject[0] = obj.getName();
            tempObject[1] = obj.getBookname();
            tempObject[2] = obj.getRentdate();
            model.addRow(tempObject);
        }
        
        if (model.getRowCount() > 0) {
            table.setRowSelectionInterval(0, 0);
        }
        
        table.setModel(model);
        
    }
    
    private void refreshRLTable() {
        Object[] tempObject = new Object[11];
        ServiceRent sr = new ServiceRent();
        ResultSet rs = null;
        try {
            rs = sr.selectRent();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        DefaultTableModel model = (DefaultTableModel) rentlistTable.getModel();
        model.setRowCount(0);
        try {
            while (rs.next()) {
                try {
                    tempObject[0] = rs.getInt("rentid");
                    tempObject[1] = rs.getString("name");
                    tempObject[2] = rs.getString("phoneNum");
                    tempObject[3] = rs.getString("minBun");
                    tempObject[4] = rs.getString("email");
                    tempObject[5] = rs.getString("bookname");
                    tempObject[6] = rs.getString("publisher");
                    tempObject[7] = rs.getString("type");
                    tempObject[8] = rs.getString("writer");
                    tempObject[9] = rs.getInt("bookid");
                    tempObject[10] = rs.getString("rentdate");
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                model.addRow(tempObject);
                
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
    private JTree getTree() {
        if (tree == null) {
            tree = new JTree();
            tree.setModel(
                    new DefaultTreeModel(new DefaultMutableTreeNode("장르") {
                        {
                            
                            add(new DefaultMutableTreeNode("소설"));
                            add(new DefaultMutableTreeNode("교육"));
                            add(new DefaultMutableTreeNode("문학"));
                            add(new DefaultMutableTreeNode("해외"));
                            add(new DefaultMutableTreeNode("기타"));
                        }
                    }));
            tree.setBounds(12, 21, 247, 189);
        }
        return tree;
    }
}
