/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicalSwitch;

import java.util.ArrayList;

/**
 *
 * @author moaaz
 */
public class SwitchUI extends javax.swing.JFrame {

    /**
     * Creates new form SwitchUI
     */
    public SwitchUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Show Workers Tasks");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Switch");

        jLabel2.setText("Worker 1");

        jLabel3.setText("Worker 2");

        jLabel4.setText("Worker 3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel2)
                .addGap(246, 246, 246)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(91, 91, 91))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(161, 161, 161)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(22, 22, 22))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ArrayList<Task> w1_task = Switch.getWorkerTasks(1);
        ArrayList<Task> w2_task = Switch.getWorkerTasks(2);
        ArrayList<Task> w3_task = Switch.getWorkerTasks(3);
        
            if (w1_task.isEmpty())
            {
              jTextArea1.setText("Empty");
            }
            else
            {
                String task_test = "ID|Type|Data\n";
                for (int i=0; i <w1_task.size(); i++)
                {
                    if (w1_task.get(i).getType().equals("PRIME") || w1_task.get(i).getType().equals("FACTORS"))
                    {
                        task_test += w1_task.get(i).getId()+"."+w1_task.get(i).getType() + "(" + w1_task.get(i).getNumber() +  ")\n";
                    }
                    else
                    {
                        task_test += w1_task.get(i).getId()+"."+w1_task.get(i).getType() + "(" + w1_task.get(i).getNumber()+","+ w1_task.get(i).getNumberB()+","+w1_task.get(i).getIncrement()+ ")\n";
                    }
                }

                jTextArea1.setText(task_test);
            }
            
            if (w2_task.isEmpty())
            {
              jTextArea2.setText("Empty");
            }
            else
            {
                String task_test = "ID|Type|Data\n";
                for (int i=0; i <w2_task.size(); i++)
                {
                    if (w2_task.get(i).getType().equals("PRIME") || w2_task.get(i).getType().equals("FACTORS"))
                    {
                        task_test +=  w2_task.get(i).getId()+"."+w2_task.get(i).getType() + "(" + w2_task.get(i).getNumber() +  ")\n";
                    }
                    else
                    {
                        task_test +=  w2_task.get(i).getId()+"."+w2_task.get(i).getType() + "(" + w2_task.get(i).getNumber()+","+ w2_task.get(i).getNumberB()+","+w2_task.get(i).getIncrement()+ ")\n";
                    }
                }

                jTextArea2.setText(task_test);
            }
            
            if (w3_task.isEmpty())
            {
              jTextArea3.setText("Empty");
            }
            else
            {
                String task_test = "ID|Type|Data\n";
                for (int i=0; i <w3_task.size(); i++)
                {
                    if (w3_task.get(i).getType().equals("PRIME") || w3_task.get(i).getType().equals("FACTORS"))
                    {
                        task_test += w3_task.get(i).getId()+"."+w3_task.get(i).getType() + "(" + w3_task.get(i).getNumber() +  ")\n";
                    }
                    else
                    {
                        task_test += w3_task.get(i).getId()+"."+w3_task.get(i).getType() + "(" + w3_task.get(i).getNumber()+","+ w3_task.get(i).getNumberB()+","+w3_task.get(i).getIncrement()+ ")\n";
                    }
                }

                jTextArea3.setText(task_test);
            }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    // End of variables declaration//GEN-END:variables
}
