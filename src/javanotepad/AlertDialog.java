package javanotepad;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JDialog;

 class AlertDialog extends JDialog 
        {
            javax.swing.JButton save;
            javax.swing.JButton dontSave;
            javax.swing.JButton cancel;
            javax.swing.JLabel messege;
            java.awt.Panel panel1;
            {
                 panel1 = new java.awt.Panel();
                    panel1.setBounds(0, 68, 379, 60);
                    panel1.setBackground(Color.LIGHT_GRAY);
                    panel1.setLayout(new FlowLayout());
                 save = new javax.swing.JButton("Save");
                 dontSave = new javax.swing.JButton("Don't Save");
                 cancel = new javax.swing.JButton("Cancel");
                 messege = new javax.swing.JLabel("Do you want to save changes?");
                    messege.setBounds(12, 28, 265, 25);
                    messege.setFont(new Font("Cambria",1,18));
                    
            }
            AlertDialog(NotePad f)
            {
                super(f,"NotePad");
                setLayout(null);
                this.setLocationRelativeTo(f);
                panel1.add(save);
                panel1.add(dontSave);
                panel1.add(cancel);
                setSize(379,162);
                setResizable(false);
                add(messege);
                add(panel1);
            }
        }