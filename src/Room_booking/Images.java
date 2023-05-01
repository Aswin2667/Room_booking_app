package Room_booking;
import java.awt.Image;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.JOptionPane;
public class Images extends javax.swing.JFrame {
   private ResultSet rs;
   private Connection con;
   LinkedList<byte[]> images = new LinkedList<>();
  public static String rname ;
   int pointer = 0;
   private String owner = Owner.usr;
   
    public Images() {
       
       try {
           initComponents();
           rname = Owner.roomname;
           con = DbConnection.getConnection();
           String query="select *from image where Name='"+rname+"'";
           System.out.print(query);
           Statement st = con.prepareStatement(query);
           rs= st.executeQuery(query);
           while(rs.next()){
               images.add(rs.getBytes(2));
           }
           ImageIcon i = new ImageIcon(images.get(pointer++));  
           Image im= i.getImage();
           Image imj = im.getScaledInstance(img.getWidth(), img.getHeight(), Image.SCALE_SMOOTH);
           img.setIcon(new ImageIcon(imj));
       } catch (Exception ex) {
          ex.printStackTrace();
        
    }
    }
    public Images(String user){
      
       try {
           initComponents();
           this.rname = user;
           con = DbConnection.getConnection();
           String query="select *from image where Name='"+rname+"'";
           System.out.print(query);
           Statement st = con.prepareStatement(query);
           rs= st.executeQuery(query);
           while(rs.next()){
               images.add(rs.getBytes(2));
           }
           ImageIcon i = new ImageIcon(images.get(pointer));  
           Image im= i.getImage();
           Image imj = im.getScaledInstance(img.getWidth(), img.getHeight(), Image.SCALE_SMOOTH);
           img.setIcon(new ImageIcon(imj));
       } catch (Exception ex) {
                     ex.printStackTrace();

       }
       
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        img = new javax.swing.JLabel();
        next = new javax.swing.JButton();
        prev = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        next.setText("Next ");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        prev.setText("Prev");
        prev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(106, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(prev, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(313, 313, 313)
                        .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(377, 377, 377))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 1110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prev, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

public byte[] thumbnail() throws Exception{
    return images.get(0);
}
    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        if(pointer<images.size()&&pointer>=0){   
        ImageIcon i = new ImageIcon(images.get(pointer++));  
           Image im= i.getImage();
           Image imj = im.getScaledInstance(img.getWidth(), img.getHeight(), Image.SCALE_SMOOTH);
           img.setIcon(new ImageIcon(imj));}
        else{
            pointer=0;
        
            JOptionPane.showMessageDialog(this, "End Of Images :)");
        }
    }//GEN-LAST:event_nextActionPerformed

    private void prevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevActionPerformed
            
          if(pointer<images.size()&&pointer>=0){   
        ImageIcon i = new ImageIcon(images.get(pointer--));  
           Image im= i.getImage();
           Image imj = im.getScaledInstance(img.getWidth(), img.getHeight(), Image.SCALE_SMOOTH);
           img.setIcon(new ImageIcon(imj));}
        else{ 
              pointer=0;
          
            JOptionPane.showMessageDialog(this, "End Of Images :)");
           
        }
    }//GEN-LAST:event_prevActionPerformed
public static void main(String []args){
    Images s = new Images();
    s.setVisible(true);
    
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel img;
    private javax.swing.JButton next;
    private javax.swing.JButton prev;
    // End of variables declaration//GEN-END:variables
}
