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
public class UpdateProductView extends javax.swing.JFrame {

    /**
     * Creates new form UpdateProductView
     */
    public Product product = new Product();
    public String pCode2;
    public String pName;
    public String pDate;
    public String cDate;
    public String pQuantity;
    public String pPrice;
    public String pName2;
    public String pDate2;
    public String cDate2;
    public String pQuantity2;
    public String pPrice2;
    
    public UpdateProductView() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Ürün Güncelle");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setResizable(true);
        
        fieldProductName.setEnabled(false);
        formattedFieldProdDate.setEnabled(false);
        formattedFieldConsDate.setEnabled(false);
        formattedFieldQuantity.setEnabled(false);
        formattedFieldPrice.setEnabled(false);
        
        buttonUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String productCode = fieldProductCode.getText();
                String productName = fieldProductName.getText();
                String productionDate = formattedFieldProdDate.getText();
                String consumeDate = formattedFieldConsDate.getText();
                String productQuantity = formattedFieldQuantity.getText();
                String productPrice = formattedFieldPrice.getText();
                
                boolean result = updateProduct(productCode,productName,productionDate,consumeDate,productQuantity,productPrice);
                
                if(result == true){
                    JOptionPane.showMessageDialog(null, "Ürün güncelleme işlemi tamamlandı","Başarılı",JOptionPane.WARNING_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "Ürün güncelleme işlemi tamamlanamadı!","Başarısız!",JOptionPane.ERROR_MESSAGE);
                }
                
            }
        });
        
        buttonControl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean checkProductResult = checkProductCode(fieldProductCode.getText());
                
                if(checkProductResult == true){
                    fieldProductName.setEnabled(true);
                    formattedFieldProdDate.setEnabled(true);
                    formattedFieldConsDate.setEnabled(true);
                    formattedFieldQuantity.setEnabled(true);
                    formattedFieldPrice.setEnabled(true);
                    
                 
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Ürün kodu bulunamadı!","Kontrol Sonucu",JOptionPane.ERROR_MESSAGE);
                }
                
                
            }
        });
        
        buttonCancel4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        
        buttonUpdate.addMouseListener(new MouseListener() {
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
                buttonUpdate.setBackground(Color.green);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                buttonUpdate.setBackground(new Color(40,137,202));
            }
        });
        
        buttonControl.addMouseListener(new MouseListener() {
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
                buttonControl.setBackground(Color.yellow);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                buttonControl.setBackground(new Color(40,137,202));
            }
        });
        
        buttonCancel4.addMouseListener(new MouseListener() {
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
                buttonCancel4.setBackground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                buttonCancel4.setBackground(new Color(40,137,202));
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

        jPanel6 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        buttonCancel4 = new javax.swing.JButton();
        buttonUpdate = new javax.swing.JButton();
        fieldProductName = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        fieldProductCode = new javax.swing.JTextField();
        buttonControl = new javax.swing.JButton();
        formattedFieldProdDate = new javax.swing.JFormattedTextField();
        formattedFieldConsDate = new javax.swing.JFormattedTextField();
        formattedFieldQuantity = new javax.swing.JFormattedTextField();
        formattedFieldPrice = new javax.swing.JFormattedTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel6.setBackground(new java.awt.Color(102, 102, 102));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ürün Bilgileri Güncelle", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel6.setPreferredSize(new java.awt.Dimension(500, 620));

        jLabel29.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 0, 0));
        jLabel29.setText("Ürün Adı");

        jLabel30.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 0, 0));
        jLabel30.setText("Üretim Tarihi");

        jLabel31.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 0, 0));
        jLabel31.setText("Son Tüketim Tarihi");

        jLabel32.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 0, 0));
        jLabel32.setText("Adet");

        jLabel33.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 0, 0));
        jLabel33.setText("Birim Fiyatı");

        buttonCancel4.setBackground(new java.awt.Color(40, 137, 202));
        buttonCancel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        buttonCancel4.setText("Geri");

        buttonUpdate.setBackground(new java.awt.Color(40, 137, 202));
        buttonUpdate.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        buttonUpdate.setText("Güncelle");

        fieldProductName.setBackground(new java.awt.Color(124, 124, 124));

        jLabel35.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 0, 0));
        jLabel35.setText("Ürün Kodu");

        fieldProductCode.setBackground(new java.awt.Color(124, 124, 124));

        buttonControl.setBackground(new java.awt.Color(40, 137, 202));
        buttonControl.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        buttonControl.setText("Kontrol");

        formattedFieldProdDate.setBackground(new java.awt.Color(124, 124, 124));
        formattedFieldProdDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy.MM.dd"))));

        formattedFieldConsDate.setBackground(new java.awt.Color(124, 124, 124));
        formattedFieldConsDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy.MM.dd"))));

        formattedFieldQuantity.setBackground(new java.awt.Color(124, 124, 124));
        formattedFieldQuantity.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        formattedFieldPrice.setBackground(new java.awt.Color(124, 124, 124));
        formattedFieldPrice.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));

        jLabel34.setForeground(new java.awt.Color(255, 255, 0));
        jLabel34.setText("Yıl.Ay.Gün formatında giriniz(yyyy.MM.dd)");

        jLabel36.setForeground(new java.awt.Color(255, 255, 0));
        jLabel36.setText("Yıl.Ay.Gün formatında giriniz(yyyy.MM.dd)");

        jLabel37.setForeground(new java.awt.Color(255, 255, 0));
        jLabel37.setText("Birim fiyatı ayırırken . yerine , kullanınız");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(71, 71, 71)
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(buttonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fieldProductName, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(fieldProductCode)
                                    .addComponent(formattedFieldProdDate)
                                    .addComponent(formattedFieldConsDate, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(formattedFieldQuantity)
                                    .addComponent(formattedFieldPrice))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonControl, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(buttonCancel4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldProductCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonControl, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(formattedFieldProdDate, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel34)
                .addGap(43, 43, 43)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(formattedFieldConsDate, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel36)
                .addGap(42, 42, 42)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(formattedFieldQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(formattedFieldPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonCancel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
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
                String productName = result.getString("URUN_ADI");
                String prodDate = result.getString("URETIM_TARIHI");
                String consDate = result.getString("SON_TUKETIM_TARIHI");
                String quantity = result.getString("ADET");
                String price = result.getString("BIRIM_FIYAT");
                fieldProductName.setText(productName);
                formattedFieldProdDate.setText(prodDate);
                formattedFieldConsDate.setText(consDate);
                formattedFieldQuantity.setText(quantity);
                formattedFieldPrice.setText(price);
                pCode2 = fieldProductCode.getText();
                pName = fieldProductName.getText();
                pDate = formattedFieldProdDate.getText();
                cDate = formattedFieldConsDate.getText();
                pQuantity = formattedFieldQuantity.getText();
                pPrice = formattedFieldPrice.getText();
                product.setProductName(pName);
                product.setProductionDate(pDate);
                product.setConsumeDate(cDate);
                product.setQuantity(pQuantity.toString());
                product.setPrice(pPrice.toString());
                product.setLogType("GUNCELLENDI");
                return true;
                
                
            }else{
                return false;
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        
    }
    
    public boolean updateProduct(String productCode, String productName, String productionDate, String consumeDate, String productQuantity, String productPrice){
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection connection = DriverManager.getConnection("Database Address" + "user=root&password=");
            String sql = "UPDATE products SET URUN_ADI = '"+productName+"', URETIM_TARIHI = '"+productionDate+"', SON_TUKETIM_TARIHI = '"+consumeDate+"', ADET = '"+productQuantity+"', BIRIM_FIYAT = '"+productPrice+"' WHERE URUN_KODU = '"+productCode+"'";
            java.sql.Statement statement = connection.createStatement();
            
            int result = statement.executeUpdate(sql);
            
            if(result == 1){
                pCode2 = productCode;
                pName2 = productName;
                pDate2 = productionDate;
                cDate2 = consumeDate;
                pQuantity2 = productQuantity;
                pPrice2 = productPrice;
                
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
            
            String sql = "INSERT INTO logs (URUN_KODU, URUN_ADI, URETIM_TARIHI, SON_TUKETIM_TARIHI, ADET, BIRIM_FIYAT, KAYIT, TARIH) VALUES ('"+pCode2+"','"+p.getProductName()+" "+"--->"+" "+pName2+"','"+p.getProductionDate()+" "+"--->"+" "+pDate2+"','"+p.getConsumeDate()+" "+"--->"+" "+cDate2+"','"+p.getQuantity()+" "+"--->"+" "+pQuantity2+"','"+p.getPrice()+" "+"--->"+" "+pPrice2+"','"+p.getLogType()+"','"+date+"')";
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
            java.util.logging.Logger.getLogger(UpdateProductView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateProductView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateProductView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateProductView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateProductView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancel4;
    private javax.swing.JButton buttonControl;
    private javax.swing.JButton buttonUpdate;
    private javax.swing.JTextField fieldProductCode;
    private javax.swing.JTextField fieldProductName;
    private javax.swing.JFormattedTextField formattedFieldConsDate;
    private javax.swing.JFormattedTextField formattedFieldPrice;
    private javax.swing.JFormattedTextField formattedFieldProdDate;
    private javax.swing.JFormattedTextField formattedFieldQuantity;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JPanel jPanel6;
    // End of variables declaration//GEN-END:variables
}
