package xmlescritura;

import DAo.Database;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Node;

public class PantallaXML extends javax.swing.JFrame {

    public PantallaXML() {
        initComponents();
        Mostrar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jOptionPane1 = new javax.swing.JOptionPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        XML = new javax.swing.JButton();
        XMLGenerado = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, "", null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane1.setViewportView(Table);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        XML.setText("genera CMD");
        XML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XMLActionPerformed(evt);
            }
        });

        XMLGenerado.setText("general");
        XMLGenerado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XMLGeneradoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(XMLGenerado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(XML))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(XML)
                    .addComponent(XMLGenerado))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(406, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // boton
    private void XMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XMLActionPerformed
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<Estudiante>").append("\r\n");
        int columnCount = Table.getColumnCount();
        int rowCount = Table.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            stringBuilder.append("\t").append("<Estudiante>").append("\r\n");
            for (int j = 0; j < columnCount; j++) {
                String columnName = Table.getColumnName(j);
                Object value = Table.getValueAt(i, j);
                stringBuilder
                        .append("\t\t")
                        .append("<").append(columnName).append(">")
                        .append(value)
                        .append("</").append(columnName).append(">")
                        .append("\r\n");
            }
            stringBuilder.append("\t").append("</Estudiante>").append("\r\n");
        }
        stringBuilder.append("</Estudiante>");
        System.out.println(stringBuilder.toString());


    }//GEN-LAST:event_XMLActionPerformed

    private void XMLGeneradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XMLGeneradoActionPerformed
        StringBuilder stringBuilder = new StringBuilder();

        try {
            File file = new File("C:\\Users\\BD\\Desktop\\ruta\\Estudiantes.xml");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            stringBuilder.append("<Estudiante>").append("\r\n");
            for (int i = 0; i < Table.getRowCount(); i++) {

                stringBuilder.append("\t").append("<Estudiante>").append("\r\n");
                for (int j = 0; j < Table.getColumnCount(); j++) {
                    String columnName = Table.getColumnName(j);
                    Object value = Table.getValueAt(i, j);
                    stringBuilder
                            .append("\t\t")
                            .append("<").append(columnName).append(">")
                            .append(value)
                            .append("</").append(columnName).append(">")
                            .append("\r\n");
                }
                stringBuilder.append("\t").append("</Estudiante>").append("\r\n");
            }
            stringBuilder.append("</Estudiante>");
            bw.append(stringBuilder);
            bw.close();
            fw.close();
            jOptionPane1.showMessageDialog(null, "Data Exported");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
//        DOMSource fuenteDato = new DOMSource(Table);
//        StreamResult resultado = new StreamResult(new File("C:\\Users\\BD\\Desktop\\ruta/empleados.xml"));
    }//GEN-LAST:event_XMLGeneradoActionPerformed

    private void Mostrar() {
        DefaultTableModel modelo = new DefaultTableModel();
        ResultSet rs = Database.getTabla("SELECT ID,matricula,Cedula,CreditosCursados,IsEmpleado,IsBecado,Promedio,Cuatrimestre_encurso From apec");
        modelo.setColumnIdentifiers(new Object[]{"ID", "matricula", "Cedula", "CreditosCursados", "IsEmpleado", "IsBecado", "Promedio", "Cuatrimestre_encurso"});
        try {
            while (rs.next()) {
                //añade los resultados a la tabla 
                modelo.addRow(new Object[]{rs.getString("ID"), rs.getString("matricula"), rs.getString("Cedula"), rs.getString("CreditosCursados"),
                    rs.getString("IsEmpleado"), rs.getString("IsBecado"), rs.getString("Promedio"), rs.getString("Cuatrimestre_encurso")});
            }
            Table.setModel(modelo);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

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
            java.util.logging.Logger.getLogger(PantallaXML.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaXML.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaXML.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaXML.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaXML().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table;
    private javax.swing.JButton XML;
    private javax.swing.JButton XMLGenerado;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
