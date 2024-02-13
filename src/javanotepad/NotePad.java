package javanotepad;

import java.awt.event.*;
import java.awt.Font;
import java.awt.print.PrinterException;
import java.io.IOException;
import javax.swing.*;


public class NotePad extends JFrame
{
            ImageIcon img=new ImageIcon("C:\\Users\\DELL\\Downloads\\icon2.png");
            boolean alter=false;
            boolean saved=false;
            JTextArea main;
            JMenuBar mb;
            JMenu  file,edit,format,view,help;
            JScrollPane sp;
            JMenuItem new1,newWindow,open,save,saveAs,exit,font,theme,print; JCheckBox wordwrap;
            Handler h=new Handler(this);
            EventHandlerInvoker invoker=new EventHandlerInvoker();
            
           {
               main=new JTextArea(); main.setFont(new Font("Serif",0,18));
                 main.addKeyListener(invoker); 
                 main.setTabSize(5);
                 main.setBorder(BorderFactory.createEmptyBorder());

               sp=new JScrollPane(main);

               file=new JMenu("File");
               edit=new JMenu("Edit");
               format=new JMenu("Format");
               view=new JMenu("View");
               help=new JMenu("help");

               mb=new JMenuBar();
               
               //File
               new1=new JMenuItem("New");  
                    new1.addActionListener(invoker);
               newWindow=new JMenuItem("New Window");
                    
               open=new JMenuItem("Open...");
                open.addActionListener(invoker);
               save=new JMenuItem("Save");
                   save.addActionListener(invoker);
                   save.setMnemonic(KeyEvent.VK_S);
               saveAs=new JMenuItem("Save As..."); 
                   saveAs.addActionListener(invoker);
               exit=new JMenuItem("Exit");
                    exit.addActionListener(invoker);
               print=new JMenuItem("Print..");
                    print.addActionListener(invoker);
               //Edit
               font=new JMenuItem("Font..");
                    font.addActionListener(invoker);
               wordwrap=new JCheckBox("Word Wrap");
                    wordwrap.addActionListener(invoker);
               theme=new JMenuItem("Theme");
                    theme.addActionListener(invoker);
           }

           NotePad()
           {
               super("NotePad");
               
               mb.add(file);
                   file.add(new1);
                   file.add(newWindow);
                   file.add(open);
                   file.add(save);
                   file.add(saveAs); file.insertSeparator(5);
                   file.add(print);
                   file.add(exit);
               mb.add(edit);
               mb.add(format);
                format.add(wordwrap);
                format.add(font);
                format.add(theme);
               mb.add(view);
               mb.add(help);
               
               this.setIconImage(img.getImage());
               this.setJMenuBar(mb);
               addWindowListener(invoker);
               this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
               add(sp);
           }

           public static void main(String args[])
           { 
               NotePad n=new NotePad();
               n.setSize(700, 700);
               n.setVisible(true);
           }   
           
        void alter(boolean status)
           { 
               if(status)
               { 
                   alter=true;
                   if(getTitle().charAt(0)!='*')
                   { 
                     setTitle("*"+getTitle());
                   }
               }
               else
               { 
                   alter=false;
                   if(getTitle().charAt(0)=='*')
                    setTitle(getTitle().substring(1));
               }
           }
           
        class EventHandlerInvoker extends WindowAdapter implements ActionListener,KeyListener,WindowListener,ActionPerformable
        {
            public void actionPerformed(ActionEvent e) 
            {
                 try {
                     h.action(e);
                 } catch (IOException ex) {

                 } catch (PrinterException ex) {
                   
                }
            }
            public void keyTyped(KeyEvent e)
            {
                h.text(e);
            }
            public void keyPressed(KeyEvent e) 
            {

            }
            public void keyReleased(KeyEvent e) 
            {

            } 
             public void windowClosing(WindowEvent e) {
                     h.window(e);
             }

        @Override
        public void action(ActionEvent e) throws IOException, PrinterException
        {
            
        }

        }
  

  

}








/*
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFocusCycleRoot(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(java.awt.Color.darkGray);
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Preview", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 13), java.awt.Color.white)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 676, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 169, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(56, 120, 688, 194);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(195, 57, 164, 22);

        jLabel1.setText("Select Themes:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(56, 60, 121, 16);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(568, 338, 79, 25);

        jButton2.setText("jButton2");
        getContentPane().add(jButton2);
        jButton2.setBounds(665, 338, 79, 25);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

*/