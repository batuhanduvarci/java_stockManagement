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
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 *
 * @author Agent48
 */
public class DeleteProductView extends javax.swing.JFrame {

    /**
     * Creates new form DeleteProductView
     */
    public Product product = new Product();
    public String producCode;
    public String productName;
    public String prodDate;
    public String consDate;
    public String quantity;
    public String price;
    public boolean res;
    
    public DeleteProductView() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Ürün Sil");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setResizable(false);
        
        
        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                boolean result = checkProductCode(fieldProductCode.getText());
                boolean result2 = checkProductCodeId(fieldProductId.getText());
                
                if(result == true || result2 == true){
                    int choice = JOptionPane.showConfirmDialog(null, "Ürün Adı : "+productName+"\n"+"Üretim Tarihi : "+prodDate+"\n"+"Son Tüketim Tarihi : "+consDate+"\n"+"Adet : "+quantity+"\n"+"Birim Fiyatı : "+price+"\nÖzelliklere sahip ürünün silinmesine onay veriyor musunuz?","Onay",JOptionPane.YES_NO_OPTION);
                    
                    if(choice == JOptionPane.YES_OPTION){
                        if(!fieldProductCode.getText().isEmpty() && fieldProductId.getText().isEmpty()){
                            
                            res = deleteProduct(fieldProductCode.getText());
                        
                        }else if(!fieldProductId.getText().isEmpty() && fieldProductCode.getText().isEmpty()){
                            
                            res = deleteProductById(fieldProductId.getText());
                            
                        }else{
                            JOptionPane.showMessageDialog(null, "Ürün silerken hata meydana geldi!","Başarısız",JOptionPane.ERROR_MESSAGE);
                        }
                        
                        if(res == true){
                            JOptionPane.showMessageDialog(null, "Ürün silme işlemi tamamlandı","Başarılı",JOptionPane.INFORMATION_MESSAGE);
                        }else{
                            JOptionPane.showMessageDialog(null, "Ürün silme işlemi başarısız!","Başarısız!",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Ürün kodu bulunamadı!","Başarısız!",JOptionPane.ERROR_MESSAGE);
                }
                
            }
        });
        
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        
        buttonDelete.addMouseListener(new MouseListener() {
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
                buttonDelete.setBackground(Color.green);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                buttonDelete.setBackground(new Color(40,137,202));
            }
        });
        
         buttonCancel.addMouseListener(new MouseListener() {
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
                buttonCancel.setBackground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                buttonCancel.setBackground(new Color(40,137,202));
            }
        });
        
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
        fieldProductId = new javax.swing.JTextField();
        buttonCancel = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        fieldProductCode = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(300, 300));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ürün Sil", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel1.setMinimumSize(new java.awt.Dimension(300, 150));
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 150));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ID ile ;");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 160, 20));

        fieldProductId.setBackground(new java.awt.Color(124, 124, 124));
        jPanel1.add(fieldProductId, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 200, 30));

        buttonCancel.setBackground(new java.awt.Color(40, 137, 202));
        buttonCancel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        buttonCancel.setText("Geri");
        jPanel1.add(buttonCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 120, -1));

        buttonDelete.setBackground(new java.awt.Color(40, 137, 202));
        buttonDelete.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        buttonDelete.setText("Ürünü Sil");
        jPanel1.add(buttonDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 120, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Ürün kodu ile ;");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 160, 20));

        fieldProductCode.setBackground(new java.awt.Color(124, 124, 124));
        jPanel1.add(fieldProductCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 200, 30));

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
                prodDate = result.getString("URETIM_TARIHI");
                consDate = result.getString("SON_TUKETIM_TARIHI");
                quantity = result.getString("ADET");
                price = result.getString("BIRIM_FIYAT");
                product.setProductCode(producCode);
                product.setProductName(productName);
                product.setProductionDate(prodDate);
                product.setConsumeDate(consDate);
                product.setQuantity(quantity);
                product.setPrice(price);
                product.setLogType("SILINDI");
                return true;
                
            }else{
                return false;
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        
    }
     
     public boolean checkProductCodeId(String id){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection connection = DriverManager.getConnection("Database Address" + "user=root&password=");
            
            String sql1 = "SELECT * FROM products WHERE ID = '"+id+"'";
            
            Statement statement = connection.createStatement();
            
            ResultSet result = statement.executeQuery(sql1);
               
            if(result.next()){
                producCode = result.getString("URUN_KODU");
                productName = result.getString("URUN_ADI");
                prodDate = result.getString("URETIM_TARIHI");
                consDate = result.getString("SON_TUKETIM_TARIHI");
                quantity = result.getString("ADET");
                price = result.getString("BIRIM_FIYAT");
                product.setProductCode(producCode);
                product.setProductName(productName);
                product.setProductionDate(prodDate);
                product.setConsumeDate(consDate);
                product.setQuantity(quantity);
                product.setPrice(price);
                product.setLogType("SILINDI");
                return true;
                
            }else{
                return false;
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        
    }
     
     public boolean deleteProduct(String productCode){
         try{
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection connection = DriverManager.getConnection("Database Address" + "user=root&password=");
            
            String sql = "DELETE FROM products WHERE URUN_KODU = '"+productCode+"'";
            java.sql.Statement statement = connection.createStatement();
            
            int result = statement.executeUpdate(sql);
            
            if(result == 1){
                if(log(product)==true){
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
     
     public boolean deleteProductById(String id){
         try{
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection connection = DriverManager.getConnection("Database Address" + "user=root&password=");
            
            String sql = "DELETE FROM products WHERE ID = '"+id+"'";
            java.sql.Statement statement = connection.createStatement();
            
            int result = statement.executeUpdate(sql);
            
            if(result == 1){
                if(log(product)==true){
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
            
            String sql = "INSERT INTO logs (URUN_KODU, URUN_ADI, URETIM_TARIHI, SON_TUKETIM_TARIHI, ADET, BIRIM_FIYAT, KAYIT, TARIH) VALUES ('"+p.getProductCode()+"','"+p.getProductName()+"','"+p.getProductionDate()+"','"+p.getConsumeDate()+"','"+p.getQuantity()+"','"+p.getPrice()+"','"+p.getLogType()+"','"+date+"')";
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
            java.util.logging.Logger.getLogger(DeleteProductView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeleteProductView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeleteProductView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeleteProductView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DeleteProductView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonDelete;
    private javax.swing.JTextField fieldProductCode;
    private javax.swing.JTextField fieldProductId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
