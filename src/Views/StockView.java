/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Objects.Product;
import Views.LoginView;
import com.opencsv.CSVReader;
import java.awt.Color;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Agent48
 */
public class StockView extends javax.swing.JFrame {

    /**
     * Creates new form StockView2
     */
    public StockView() {
        initComponents();
        setTitle("BMB Inventory");
        setSize(1200,800);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        statusTextLabel.setText(currentState());
        fetch();
        fetchDecreasing();
        fetchLogs();
        fetchRequests();
        fetchOrders();
        
        
        
        addWindowListener(new WindowListener() {
            

            @Override
            public void windowClosing(WindowEvent e) {
                int result;
                result = JOptionPane.showConfirmDialog(null,"Çıkmak istediğinizden emin misiniz ?","Çıkış",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                
                if(result == JOptionPane.YES_OPTION){
                    System.exit(0);
                }
            }

            @Override
            public void windowOpened(WindowEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowClosed(WindowEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowIconified(WindowEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowActivated(WindowEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            
        });
        
        
        
        buttonBack.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                buttonBack.setBackground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                buttonBack.setBackground(null);
            }
        });
            
        
        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginView().setVisible(true);
                dispose();
            }
        });
        
        buttonAdd.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                buttonAdd.setBackground(new Color(40,137,202));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                buttonAdd.setBackground(null);
            }
        });
        
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                new AddProductView().setVisible(true);
            }
        });
        
        buttonUpdate.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                buttonUpdate.setBackground(new Color(40,137,202));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                buttonUpdate.setBackground(null);
            }
        });
        
        buttonUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                new UpdateProductView().setVisible(true);
            }
        });
        
        buttonDelete.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                buttonDelete.setBackground(new Color(40,137,202));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                buttonDelete.setBackground(null);
            }
        });
        
        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                new DeleteProductView().setVisible(true);
            }
        });
        
        buttonRefresh1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mousePressed(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                buttonRefresh1.setBackground(Color.yellow);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                buttonRefresh1.setBackground(null);
            }
        });
        
        buttonRefresh1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fetch();
            }
        }
        );
        
        buttonRefresh2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mousePressed(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                buttonRefresh2.setBackground(Color.yellow);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                buttonRefresh2.setBackground(null);
            }
        });
        
        buttonRefresh2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fetchDecreasing();
            }
        });
        
        buttonRefresh3.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mousePressed(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                buttonRefresh3.setBackground(Color.yellow);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                buttonRefresh3.setBackground(null);
            }
        });
        
        buttonRefresh3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fetchLogs();
            }
        });
        
        buttonOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new OrderView().setVisible(true);
            }
        });
        
        buttonOrder.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mousePressed(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                buttonOrder.setBackground(new Color(40,137,202));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                buttonOrder.setBackground(null);
            }
        });
        
        buttonOrderCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new OrderCancelView().setVisible(true);
            }
        });
        
        buttonOrderCancel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mousePressed(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                buttonOrderCancel.setBackground(new Color(40,137,202));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                buttonOrderCancel.setBackground(null);
            }
        });
        
        buttonBack1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginView().setVisible(true);
                dispose();
            }
        });
        
        buttonBack1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mousePressed(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                buttonBack1.setBackground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                buttonBack1.setBackground(null);
            }
        });
        
        buttonBack2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginView().setVisible(true);
                dispose();
            }
        });
        
        buttonBack2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mousePressed(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                buttonBack2.setBackground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                buttonBack2.setBackground(null);
            }
        });
        
        buttonAccept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AcceptView().setVisible(true);
                
            }
        });
        
        buttonAccept.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mousePressed(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                buttonAccept.setBackground(new Color(40,137,202));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                buttonAccept.setBackground(null);
            }
        });
        
        buttonDecline.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeclineView().setVisible(true);
                
            }
        });
        
        buttonDecline.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mousePressed(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                buttonDecline.setBackground(new Color(40,137,202));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                buttonDecline.setBackground(null);
            }
        }
        );
        
        buttonBack3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginView().setVisible(true);
                dispose();
            }
        });
        
        buttonBack3.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mousePressed(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                buttonBack3.setBackground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                buttonBack3.setBackground(null);
            }
        });
        
        buttonRefresh4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fetchRequests();
            }
        });
        
        buttonRefresh4.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mousePressed(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                buttonRefresh4.setBackground(Color.yellow);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                buttonRefresh4.setBackground(null);
            }
        });
        
        buttonRefresh6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fetchOrders();
            }
        });
        
        buttonRefresh6.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mousePressed(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                buttonRefresh6.setBackground(Color.yellow);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                buttonRefresh6.setBackground(null);
            }
        });
        
    }
    
    public void fetch(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection connection = DriverManager.getConnection("Database Address" + "user=root&password=");
            java.sql.PreparedStatement statement = connection.prepareStatement("SELECT * FROM products ORDER BY ID DESC");
            java.sql.ResultSet result = statement.executeQuery();
            
            jTable1.setModel(DbUtils.resultSetToTableModel(result));
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            
        }
        
    }
    
    public String currentState(){
        String currentstate = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection connection = DriverManager.getConnection("Database Address" + "user=root&password=");
             currentstate = "Bağlantı kuruldu";
        }catch(Exception e){
            currentstate = "Bağlantı hatası!!!";
        }
        return currentstate;
    }
    
    public void fetchDecreasing(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection connection = DriverManager.getConnection("Database Address" + "user=root&password=");
            java.sql.PreparedStatement statement = connection.prepareStatement("SELECT * FROM products WHERE ADET <= 10 ORDER BY ID DESC");
            java.sql.ResultSet result = statement.executeQuery();
            
            jTable2.setModel(DbUtils.resultSetToTableModel(result));
            jTable2.setRowSelectionAllowed(true);
                    
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            
        }
        
    }
    
    public void fetchLogs(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection connection = DriverManager.getConnection("Database Address" + "user=root&password=");
            java.sql.PreparedStatement statement = connection.prepareStatement("SELECT * FROM logs ORDER BY ID DESC");
            java.sql.ResultSet result = statement.executeQuery();
            
            jTable3.setModel(DbUtils.resultSetToTableModel(result));
            jTable3.setRowSelectionAllowed(true);
                    
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            
        }
        
    }
    
    public void fetchRequests(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection connection = DriverManager.getConnection("Database Address" + "user=root&password=");
            java.sql.PreparedStatement statement = connection.prepareStatement("SELECT * FROM requests ORDER BY ID DESC");
            java.sql.ResultSet result = statement.executeQuery();
            
            jTable4.setModel(DbUtils.resultSetToTableModel(result));
            jTable4.setRowSelectionAllowed(true);
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void fetchOrders(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection connection = DriverManager.getConnection("Database Address" + "user=root&password=");
            java.sql.PreparedStatement statement = connection.prepareStatement("SELECT * FROM orders ORDER BY ID DESC");
            java.sql.ResultSet result = statement.executeQuery();
            
            jTable6.setModel(DbUtils.resultSetToTableModel(result));
            jTable6.setRowSelectionAllowed(true);
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        stockTable = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        statusTextLabel = new javax.swing.JLabel();
        fieldSearch3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        buttonRefresh1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        buttonBack = new javax.swing.JButton();
        buttonAdd = new javax.swing.JButton();
        buttonUpdate = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        stockTable1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        buttonRefresh2 = new javax.swing.JButton();
        fieldSearch1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        buttonBack1 = new javax.swing.JButton();
        buttonOrder = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        stockTable3 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        buttonRefresh4 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        buttonBack3 = new javax.swing.JButton();
        buttonAccept = new javax.swing.JButton();
        buttonDecline = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        stockTable5 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        buttonRefresh6 = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        buttonBack5 = new javax.swing.JButton();
        buttonOrderCancel = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        stockTable2 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        buttonRefresh3 = new javax.swing.JButton();
        fieldSearch2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        buttonBack2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setMinimumSize(new java.awt.Dimension(800, 600));
        jTabbedPane1.setName(""); // NOI18N

        jPanel1.setMinimumSize(new java.awt.Dimension(1200, 800));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 800));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Stoklar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), null)); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Ürün Kodu", "Ürün Tipi"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setRowHeight(20);
        stockTable.setViewportView(jTable1);

        jPanel4.add(stockTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 1160, 500));

        statusTextLabel.setText("Durum.........................................");
        jPanel4.add(statusTextLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 560, 230, -1));

        fieldSearch3.setPreferredSize(new java.awt.Dimension(40, 16));
        fieldSearch3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldSearch3KeyReleased(evt);
            }
        });
        jPanel4.add(fieldSearch3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 150, 30));

        jLabel4.setText("Arama :");
        jLabel4.setPreferredSize(new java.awt.Dimension(40, 15));
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 50, -1));

        buttonRefresh1.setText("Tabloyu Yenile");
        jPanel4.add(buttonRefresh1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 30, 150, 30));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1180, 590));

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonBack.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        buttonBack.setText("Geri");
        buttonBack.setToolTipText("");
        jPanel5.add(buttonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 20, 220, 70));

        buttonAdd.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        buttonAdd.setText("Ürün Ekle");
        jPanel5.add(buttonAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 22, 230, 70));

        buttonUpdate.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        buttonUpdate.setText("Ürün Güncelle");
        jPanel5.add(buttonUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 220, 70));

        buttonDelete.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        buttonDelete.setText("Ürün Sil");
        jPanel5.add(buttonDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, 220, 70));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 610, 1180, 120));

        jTabbedPane1.addTab("Stok Paneli", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Azalan Ürünler", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), null)); // NOI18N
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        jTable2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable2.setRowHeight(20);
        stockTable1.setViewportView(jTable2);

        jPanel6.add(stockTable1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 1160, 520));

        buttonRefresh2.setText("Tabloyu Yenile");
        jPanel6.add(buttonRefresh2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 30, 150, 30));

        fieldSearch1.setPreferredSize(new java.awt.Dimension(40, 16));
        fieldSearch1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldSearch1KeyReleased(evt);
            }
        });
        jPanel6.add(fieldSearch1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 150, 30));

        jLabel2.setText("Arama :");
        jLabel2.setPreferredSize(new java.awt.Dimension(40, 15));
        jPanel6.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 50, -1));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1180, 590));

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonBack1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        buttonBack1.setText("Geri");
        buttonBack1.setToolTipText("");
        jPanel8.add(buttonBack1, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 20, 220, 70));

        buttonOrder.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        buttonOrder.setText("Sipariş Ver");
        jPanel8.add(buttonOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 22, 230, 70));

        jPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 610, 1180, 120));

        jTabbedPane1.addTab("Azalanlar", jPanel2);

        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Üyelik İstekleri", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), null)); // NOI18N
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        jTable4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable4.setRowHeight(20);
        stockTable3.setViewportView(jTable4);

        jPanel12.add(stockTable3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 1160, 520));

        buttonRefresh4.setText("Tabloyu Yenile");
        jPanel12.add(buttonRefresh4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 30, 150, 30));

        jPanel11.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1180, 590));

        jPanel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonBack3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        buttonBack3.setText("Geri");
        buttonBack3.setToolTipText("");
        jPanel13.add(buttonBack3, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 20, 220, 70));

        buttonAccept.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        buttonAccept.setText("Onayla");
        jPanel13.add(buttonAccept, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 22, 230, 70));

        buttonDecline.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        buttonDecline.setText("Reddet");
        jPanel13.add(buttonDecline, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 220, 70));

        jPanel11.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 610, 1180, 120));

        jPanel10.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 5, -1, -1));

        jTabbedPane1.addTab("Üyelik İstekleri", jPanel10);

        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sipariş Durumları", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), null)); // NOI18N
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        jTable6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable6.setRowHeight(20);
        stockTable5.setViewportView(jTable6);

        jPanel20.add(stockTable5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 1160, 520));

        buttonRefresh6.setText("Tabloyu Yenile");
        jPanel20.add(buttonRefresh6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 30, 150, 30));

        jPanel19.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1180, 590));

        jPanel21.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonBack5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        buttonBack5.setText("Geri");
        buttonBack5.setToolTipText("");
        jPanel21.add(buttonBack5, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 20, 220, 70));

        buttonOrderCancel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        buttonOrderCancel.setText("Sipariş İptali");
        jPanel21.add(buttonOrderCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 220, 70));

        jPanel19.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 610, 1180, 120));

        jPanel18.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 5, -1, -1));

        jTabbedPane1.addTab("Siparişler", jPanel18);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hareket Kayıtları", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), null)); // NOI18N
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        jTable3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable3.setRowHeight(20);
        stockTable2.setViewportView(jTable3);

        jPanel7.add(stockTable2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 1160, 520));

        buttonRefresh3.setText("Tabloyu Yenile");
        jPanel7.add(buttonRefresh3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 30, 150, 30));

        fieldSearch2.setPreferredSize(new java.awt.Dimension(40, 16));
        fieldSearch2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldSearch2KeyReleased(evt);
            }
        });
        jPanel7.add(fieldSearch2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 150, 30));

        jLabel3.setText("Arama :");
        jLabel3.setPreferredSize(new java.awt.Dimension(40, 15));
        jPanel7.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 50, -1));

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1180, 590));

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonBack2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        buttonBack2.setText("Geri");
        buttonBack2.setToolTipText("");
        jPanel9.add(buttonBack2, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 20, 220, 70));

        jPanel3.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 610, 1180, 120));

        jTabbedPane1.addTab("Hareketler", jPanel3);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldSearch1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldSearch1KeyReleased
        // TODO add your handling code here:
            DefaultTableModel tableModel = (DefaultTableModel)jTable2.getModel();
            String search = fieldSearch1.getText().toUpperCase();
            TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(tableModel);
            jTable2.setRowSorter(sorter);
            sorter.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_fieldSearch1KeyReleased

    private void fieldSearch2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldSearch2KeyReleased
        // TODO add your handling code here:
            DefaultTableModel tableModel = (DefaultTableModel)jTable3.getModel();
            String search = fieldSearch2.getText().toUpperCase();
            TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(tableModel);
            jTable3.setRowSorter(sorter);
            sorter.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_fieldSearch2KeyReleased

    private void fieldSearch3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldSearch3KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldSearch3KeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StockView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StockView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StockView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StockView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StockView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAccept;
    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonBack;
    private javax.swing.JButton buttonBack1;
    private javax.swing.JButton buttonBack2;
    private javax.swing.JButton buttonBack3;
    private javax.swing.JButton buttonBack5;
    private javax.swing.JButton buttonDecline;
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonOrder;
    private javax.swing.JButton buttonOrderCancel;
    private javax.swing.JButton buttonRefresh1;
    private javax.swing.JButton buttonRefresh2;
    private javax.swing.JButton buttonRefresh3;
    private javax.swing.JButton buttonRefresh4;
    private javax.swing.JButton buttonRefresh6;
    private javax.swing.JButton buttonUpdate;
    private javax.swing.JTextField fieldSearch1;
    private javax.swing.JTextField fieldSearch2;
    private javax.swing.JTextField fieldSearch3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable6;
    private javax.swing.JLabel statusTextLabel;
    private javax.swing.JScrollPane stockTable;
    private javax.swing.JScrollPane stockTable1;
    private javax.swing.JScrollPane stockTable2;
    private javax.swing.JScrollPane stockTable3;
    private javax.swing.JScrollPane stockTable5;
    // End of variables declaration//GEN-END:variables
}


