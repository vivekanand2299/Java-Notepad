/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javanotepad;

import java.awt.GraphicsEnvironment;

/**
 *
 * @author DELL
 */

public class JavaNotePad {


    public static void main(String[] args) 
    {
        GraphicsEnvironment ge;
        ge= GraphicsEnvironment.getLocalGraphicsEnvironment();
        
        String[] names=ge.getAvailableFontFamilyNames();
        for(int i=0;i<names.length;i++)
            System.out.println(names[i]);
    }
    
}
//Handler coy
/*
package javanotepad;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Handler
{
    private String fileDir="";
    private NotePad f;
    Handler(NotePad f)
    {
        this.f=f;
    }
    
        void  action(ActionEvent e) throws IOException
        { 
            if(e.getSource()==f.saveAs)
             { 
                 fileDir=saveAs(e);
             }
            else if(e.getSource()==f.save)
            { 
                save(e);
            }
            else if(e.getSource()==f.new1)
            { 
                new1(e);
            }
            else if(e.getSource()==f.exit)
            { 
                window(new WindowEvent(f,201));
            }
            else if(e.getSource()==f.open)
            { 
                open(e);
            }
       
        }

        void text(KeyEvent e)
        { 
            f.alter(true);
        }
        void window(WindowEvent e)
        { 
            windowClose(e);
        }

        //Handling methods
        private String saveAs(ActionEvent e) throws IOException
        { 
            FileDialog fd=new FileDialog(f,"Save As",FileDialog.SAVE);
            fd.setVisible(true);
            if(fd.getFile()==null&&f.saved)
            {
                return fileDir;
            }
            if(fd.getFile()==null)
            { 
                return null;
            }
            if(!fd.getFile().endsWith(".txt"))
            {
                 File file=new File(fd.getDirectory()+fd.getFile()+".txt");
                 FileWriter fwrite=new FileWriter(file);
                 fwrite.write(f.main.getText());
                 fwrite.close();
                 f.saved=true;
                f.alter(false);
                
                f.setTitle(fd.getFile());
                
                return fd.getDirectory()+fd.getFile()+".txt";
            }
            else
            {
                 File file=new File(fd.getDirectory()+fd.getFile());
                 FileWriter fwrite=new FileWriter(file);
                 fwrite.write(f.main.getText());
                 fwrite.close();
                    f.saved=true;
                f.alter(false);
                
                 f.setTitle(fd.getFile());
                
                return fd.getDirectory()+fd.getFile()+".txt";
            }
        }

        private void save(ActionEvent e) throws IOException
        {
            if(f.saved==false)
            {
                fileDir=saveAs(e);
            }
            else
            {
                FileWriter fwrite=new FileWriter(fileDir);
                 fwrite.write(f.main.getText());
                 fwrite.close();
                    f.saved=true;
                    f.alter(false);
            }
        }
        
       
        private void windowClose(WindowEvent e)
        { 
                 if(f.alter)
                 { 
                    
                     JDialog d=new JDialog(new NotePad(),"NotePad");
                     GridLayout gbg=new GridLayout(0,1);
                     JPanel p1=new JPanel(new FlowLayout());
                    JPanel p2=new JPanel(new FlowLayout());

                        p1.setBackground(Color.LIGHT_GRAY);
                        JLabel messege=new JLabel("Do you wants to save changes ?");
                        messege.setFont(new Font("Cambria",1,18));
                        p1.add(messege);

                        JButton save=new JButton("Save");
                            save.addActionListener(new ActionListener(){
                                public void actionPerformed(ActionEvent e)
                                { 
                                    try {
                                        save(e);
                                    } catch (IOException ex) {
                                       
                                    }
                                    if(fileDir!=null)
                                        System.exit(0);
                                }
                            });
                        JButton noSave=new JButton("Don't Save");
                            noSave.addActionListener(new ActionListener(){
                                public void actionPerformed(ActionEvent e) {
                                    System.exit(0);
                                }
                            });
                        JButton cancel =new JButton("Cancel");
                            cancel.addActionListener(new ActionListener(){
                                public void actionPerformed(ActionEvent e) {
                                    d.setVisible(false);
                                }
                            });
                        p2.add(save);
                        p2.add(noSave);
                        p2.add(cancel);
                     d.add(p1);
                     d.add(p2);
                     d.setBounds(500, 600, 400, 250);
                     d.setLayout(gbg);
                    d.setVisible(true);
                 }
                 else
                     System.exit(0);
         }

    private void new1(ActionEvent e) 
    {
        if(f.alter)
        { 
                  JDialog d=new JDialog(new NotePad(),"NotePad");
                     GridLayout gbg=new GridLayout(0,1);
                     JPanel p1=new JPanel(new FlowLayout());
                    JPanel p2=new JPanel(new FlowLayout());

                        p1.setBackground(Color.LIGHT_GRAY);
                        JLabel messege=new JLabel("Do you wants to save changes ?");
                        messege.setFont(new Font("Cambria",1,18));
                        p1.add(messege);

                        JButton save=new JButton("Save");
                            save.addActionListener(new ActionListener(){
                                public void actionPerformed(ActionEvent e)
                                { 
                                    try {
                                        save(e);
                                    } catch (IOException ex) {
                                       
                                    }
                                    if(fileDir!=null)
                                    { 
                                      f.setEnabled(false);
                                      f.setVisible(false);
                                      d.setVisible(false);
                                     NotePad.main(new String[2]);
                                    }
                                  
                                }
                            });
                        JButton noSave=new JButton("Don't Save");
                            noSave.addActionListener(new ActionListener(){
                                public void actionPerformed(ActionEvent e) {
                                    f.setVisible(false);
                                    d.setVisible(false);
                                   NotePad.main(new String[2]);
                                }
                            });
                        JButton cancel =new JButton("Cancel");
                            cancel.addActionListener(new ActionListener(){
                                public void actionPerformed(ActionEvent e) {
                                    d.setVisible(false);
                                }
                            });
                        p2.add(save);
                        p2.add(noSave);
                        p2.add(cancel);
                     d.add(p1);
                     d.add(p2);
                     d.setBounds(500, 600, 400, 250);
                     d.setLayout(gbg);
                    d.setVisible(true);
        }
        else
        { 
            f.setEnabled(false);
             f.setVisible(false);
            NotePad.main(new String[2]);
        }
    }

    private void open(ActionEvent e) throws IOException 
    {
        if(f.alter)
        { 
            JDialog d=new JDialog(new NotePad(),"NotePad");
                     GridLayout gbg=new GridLayout(0,1);
                     JPanel p1=new JPanel(new FlowLayout());
                    JPanel p2=new JPanel(new FlowLayout());

                        p1.setBackground(Color.LIGHT_GRAY);
                        JLabel messege=new JLabel("Do you wants to save changes ?");
                        messege.setFont(new Font("Cambria",1,18));
                        p1.add(messege);

                        JButton save=new JButton("Save");
                            save.addActionListener(new ActionListener(){
                                public void actionPerformed(ActionEvent e)
                                { 
                                    try {
                                        save(e);
                                    } catch (IOException ex) {
                                       
                                    }
                                    if(fileDir!=null)
                                    { 
                                        try {
                                            read(e);
                                        } catch (FileNotFoundException ex) {
                                            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
                                        } catch (IOException ex) {
                                            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                  
                                }
                            });
                        JButton noSave=new JButton("Don't Save");
                            noSave.addActionListener(new ActionListener(){
                                public void actionPerformed(ActionEvent e) {
                                    d.setVisible(false);
                                    try {
                                        read(e);
                                    } catch (FileNotFoundException ex) {
                                     
                                    } catch (IOException ex) {
                                        Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }

                
                            });
                        JButton cancel =new JButton("Cancel");
                            cancel.addActionListener(new ActionListener(){
                                public void actionPerformed(ActionEvent e) {
                                    d.setVisible(false);
                                }
                            });
                        p2.add(save);
                        p2.add(noSave);
                        p2.add(cancel);
                     d.add(p1);
                     d.add(p2);
                     d.setBounds(500, 600, 400, 250);
                     d.setLayout(gbg);
                    d.setVisible(true);
        }
        else
        read(e);
    }
     private void read(ActionEvent e) throws FileNotFoundException, IOException 
     {
          FileDialog fd=new FileDialog(f,"Open file",FileDialog.LOAD);  
          fd.setVisible(true);
          
          
          if(fd.getFile()!=null)
          { 
              fileDir=fd.getDirectory()+fd.getFile();
              FileReader fr=new FileReader(fileDir);
              String text="";
              int content;
              while((content=fr.read())!=-1)
              { 
                  text=text+(char)content;
              }
              fr.close();
              f.main.setText(text);
              f.setTitle(fd.getFile());
              f.saved=true;
              f.alter(false);
          }
     
     }      
}

*/