/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Objects.Product;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author Agent48
 */
public class OrderView extends javax.swing.JFrame {

    /**
     * Creates new form OrderView
     */
    
    public Product product = new Product();
    public String producCode;
    public String productName;
    public String quantity;
    public String price;
    
    public OrderView() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Sipariş");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setResizable(false);
        
        buttonOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean result = checkProductCode(fieldId.getText());
                
                if(result == true){
                    int choice = JOptionPane.showConfirmDialog(null, "Ürün Adı : "+productName+"\n"+"Birim Fiyatı : "+price+"\nÖzelliklere sahip ürünün "+product.getQuantity()+" adet siparişine onay veriyor musunuz?","Onay",JOptionPane.YES_NO_OPTION);
                    
                    if(choice == JOptionPane.YES_OPTION){
                        boolean result2 = order(product);
                        
                        if(result2 == true){
                            JOptionPane.showMessageDialog(null, "Sipariş işlemi tamamlandı","Başarılı",JOptionPane.INFORMATION_MESSAGE);
                        }else{
                            JOptionPane.showMessageDialog(null, "Sipariş işlemi başarısız!","Başarısız!",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Ürün kodu hatalı!","Başarısız!",JOptionPane.ERROR_MESSAGE);
                }
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
                buttonOrder.setBackground(Color.green);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                buttonOrder.setBackground(new Color(40,137,202));
            }
        });
        
        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        
        buttonBack.addMouseListener(new MouseListener() {
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
                buttonBack.setBackground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                buttonBack.setBackground(new Color(40,137,202));
            }
        });
    }
    
    public boolean checkProductCode(String productCode){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection connection = DriverManager.getConnection("Database Address" + "user=root&password=");
            
            String sql1 = "SELECT * FROM products WHERE URUN_KODU = '"+productCode+"'";
            
            Statement statement = connection.createStatement();
            
            ResultSet result = statement.executeQuery(sql1);
               
            if(result.next()){
                producCode = result.getString("URUN_KODU");
                productName = result.getString("URUN_ADI");
                price = result.getString("BIRIM_FIYAT");
                product.setProductCode(producCode);
                product.setProductName(productName);
                product.setQuantity(fieldQuantity.getText());
                product.setPrice(price);
                product.setLogType("SIPARIS VERILDI");
                return true;
                
            }else{
                return false;
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        
    }
    
    public boolean order(Product p){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection connection = DriverManager.getConnection("Database Address" + "user=root&password=");
            
            String sql = "INSERT INTO orders (URUN_KODU, URUN_ADI, ADET, BIRIM_FIYAT, DURUM) VALUES ('"+p.getProductCode()+"','"+p.getProductName()+"','"+p.getQuantity()+"','"+p.getPrice()+"','"+p.getLogType()+"')";
            java.sql.Statement statement = connection.createStatement();
            
            int result = statement.executeUpdate(sql);
            
            if(result == 1){
                if(log(product) == true){
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean log(Product p){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection connection = DriverManager.getConnection("Database Address" + "user=root&password=");
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Calendar cal = Calendar.getInstance();
            String date = dateFormat.format(cal.getTime());
            
            String sql = "INSERT INTO logs (URUN_KODU, URUN_ADI, ADET, BIRIM_FIYAT, KAYIT, TARIH) VALUES ('"+p.getProductCode()+"','"+p.getProductName()+"','"+p.getQuantity()+"','"+p.getPrice()+"','"+p.getLogType()+"','"+date+"')";
            java.sql.Statement statement = connection.createStatement();
            
            int result = statement.executeUpdate(sql);
            
            if(result == 1){
                return true;
            }else{
                return false;
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
            return false;
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        fieldId = new javax.swing.JTextField();
        buttonBack = new javax.swing.JButton();
        buttonOrder = new javax.swing.JButton();
        fieldQuantity = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sipariş", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel1.setMinimumSize(new java.awt.Dimension(300, 300));
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 150));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ürün kodu ile ;");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 160, 20));

        fieldId.setBackground(new java.awt.Color(124, 124, 124));
        jPanel1.add(fieldId, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 200, 30));

        buttonBack.setBackground(new java.awt.Color(40, 137, 202));
        buttonBack.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        buttonBack.setText("Geri");
        jPanel1.add(buttonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 120, -1));

        buttonOrder.setBackground(new java.awt.Color(40, 137, 202));
        buttonOrder.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        buttonOrder.setText("Sipariş Ver");
        jPanel1.add(buttonOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 120, -1));

        fieldQuantity.setBackground(new java.awt.Color(124, 124, 124));
        jPanel1.add(fieldQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 200, 30));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Adet ;");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 160, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(OrderView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBack;
    private javax.swing.JButton buttonOrder;
    private javax.swing.JTextField fieldId;
    private javax.swing.JTextField fieldQuantity;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
