package java31.st2table;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmBooks extends JFrame {
    
    // List
    private static List<Book> books = null;
    
    private JPanel contentPane;
    private JScrollPane scrollPane;
    private static JTable table;
    private JLabel lblNewLabel;
    private JLabel lblBookname;
    private JLabel lblPublisher;
    private JLabel lblYear;
    private JLabel lblPrice;
    private JLabel lblUseyn;
    private JLabel lblAuthid;
    private JCheckBox chckbxNewCheckBox;
    private JTextField txtId;
    private JTextField txtName;
    private JTextField txtExpr;
    private JTextField txtYear;
    private JTextField txtPrice;
    private JTextField txtAuthid;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                    frmBooks frame = new frmBooks();
                    frame.setVisible(true);
                    
                    initData();
                    
                    frame.refreshTable(books, table);
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public static void initData() {
        books = new ArrayList<>();
        books.add( new Book(1, "operating system" , "wiley" , "2003", 30700, false, 1 ) ) ;
        books.add( new Book(2, "mysql" , "oreilly" , "2009", 58700, true , 2 ) ) ;
        books.add( new Book(3, "java" , "hall" , "2013", 40000, true , 3 ) ) ;
        books.add( new Book(4, "first sql" , "wiley" , "2015", 57700, true , 4 ) ) ;

        }
    
    /**
     * Create the frame.
     */
    public frmBooks() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 574, 411);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(getScrollPane());
        contentPane.add(getLblNewLabel());
        contentPane.add(getLblBookname());
        contentPane.add(getLblPublisher());
        contentPane.add(getLblYear());
        contentPane.add(getLblPrice());
        contentPane.add(getLblUseyn());
        contentPane.add(getLblAuthid());
        contentPane.add(getChckbxNewCheckBox());
        contentPane.add(getTxtId());
        contentPane.add(getTxtName());
        contentPane.add(getTxtExpr());
        contentPane.add(getTxtYear());
        contentPane.add(getTxtPrice());
        contentPane.add(getTxtAuthid());
    }
    
    private JScrollPane getScrollPane() {
        if (scrollPane == null) {
        	scrollPane = new JScrollPane();
        	scrollPane.setBounds(5, 5, 548, 114);
        	scrollPane.setViewportView(getTable());
        }
        return scrollPane;
    }
    private JTable getTable() {
        if (table == null) {
        	table = new JTable();
        	table.addMouseListener(new MouseAdapter() {
        	    @Override
        	    public void mouseClicked(MouseEvent e) {
        	        
        	        int row = table.getSelectedRow();
        	        
        	        String savedId = table.getValueAt(row, 0).toString();
        	        String name    = table.getValueAt(row, 1).toString();
        	        String expr    = table.getValueAt(row, 2).toString();
        	        String year    = table.getValueAt(row, 3).toString();
        	        String price   = table.getValueAt(row, 4).toString();
 //                 String use_yn  = table.getValueAt(row, 5).toString();
                    String authid  = table.getValueAt(row, 6).toString();
                    
                    txtId.setText(savedId);
                    txtName.setText(name);
                    txtExpr.setText(expr);
                    txtYear.setText(year);
                    txtPrice.setText(price);
                    txtAuthid.setText(authid);
           
        	    }
        	});
        	table.setModel(new DefaultTableModel(
        	    new Object[][] {
        	    },
        	    new String[] {
        	        "bookid", "bookname", "publisher", "year", "price", "use_yn", "authid"
        	    }
        	));
        }
        return table;
    }
    private JLabel getLblNewLabel() {
        if (lblNewLabel == null) {
        	lblNewLabel = new JLabel("bookid");
        	lblNewLabel.setBounds(12, 174, 57, 15);
        }
        return lblNewLabel;
    }
    private JLabel getLblBookname() {
        if (lblBookname == null) {
        	lblBookname = new JLabel("bookname");
        	lblBookname.setBounds(12, 199, 89, 15);
        }
        return lblBookname;
    }
    private JLabel getLblPublisher() {
        if (lblPublisher == null) {
        	lblPublisher = new JLabel("publisher");
        	lblPublisher.setBounds(12, 224, 57, 15);
        }
        return lblPublisher;
    }
    private JLabel getLblYear() {
        if (lblYear == null) {
        	lblYear = new JLabel("year");
        	lblYear.setBounds(12, 249, 57, 15);
        }
        return lblYear;
    }
    private JLabel getLblPrice() {
        if (lblPrice == null) {
        	lblPrice = new JLabel("price");
        	lblPrice.setBounds(12, 274, 57, 15);
        }
        return lblPrice;
    }
    private JLabel getLblUseyn() {
        if (lblUseyn == null) {
        	lblUseyn = new JLabel("use_yn");
        	lblUseyn.setBounds(12, 299, 57, 15);
        }
        return lblUseyn;
    }
    private JLabel getLblAuthid() {
        if (lblAuthid == null) {
        	lblAuthid = new JLabel("authid");
        	lblAuthid.setBounds(12, 324, 57, 15);
        }
        return lblAuthid;
    }
    private JCheckBox getChckbxNewCheckBox() {
        if (chckbxNewCheckBox == null) {
        	chckbxNewCheckBox = new JCheckBox("New check box");
        	chckbxNewCheckBox.setBounds(86, 295, 115, 23);
        }
        return chckbxNewCheckBox;
    }
    
    public void refreshTable( List<Book> list, JTable table) {
        Object [] tempObject = new Object[7];
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.setRowCount(0);
        
        for (Book obj : list) {
            tempObject[0] = obj.getBookid();
            tempObject[1] = obj.getBookname();
            tempObject[2] = obj.getPublisher();
            tempObject[3] = obj.getYear();
            tempObject[4] = obj.getPrice();
   //         tempObject[5] = obj.get();
            tempObject[6] = obj.getAuthid();
            
            model.addRow(tempObject);   
        }
        
        if(model.getRowCount() > 0) {
            table.setRowSelectionInterval(0, 0);     
        }
        
        table.setModel(model);
        
        
    }
    private JTextField getTxtId() {
        if (txtId == null) {
        	txtId = new JTextField();
        	txtId.setBounds(85, 171, 116, 21);
        	txtId.setColumns(10);
        }
        return txtId;
    }
    private JTextField getTxtName() {
        if (txtName == null) {
        	txtName = new JTextField();
        	txtName.setColumns(10);
        	txtName.setBounds(85, 196, 116, 21);
        }
        return txtName;
    }
    private JTextField getTxtExpr() {
        if (txtExpr == null) {
        	txtExpr = new JTextField();
        	txtExpr.setColumns(10);
        	txtExpr.setBounds(85, 224, 116, 21);
        }
        return txtExpr;
    }
    private JTextField getTxtYear() {
        if (txtYear == null) {
        	txtYear = new JTextField();
        	txtYear.setColumns(10);
        	txtYear.setBounds(85, 246, 116, 21);
        }
        return txtYear;
    }
    private JTextField getTxtPrice() {
        if (txtPrice == null) {
        	txtPrice = new JTextField();
        	txtPrice.setColumns(10);
        	txtPrice.setBounds(85, 271, 116, 21);
        }
        return txtPrice;
    }
    private JTextField getTxtAuthid() {
        if (txtAuthid == null) {
        	txtAuthid = new JTextField();
        	txtAuthid.setColumns(10);
        	txtAuthid.setBounds(96, 321, 116, 21);
        }
        return txtAuthid;
    }
}
