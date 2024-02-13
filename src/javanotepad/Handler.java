//Remaining work at open dection where you dont designed dialog for file taht no found

package javanotepad;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class Handler implements ActionPerformable
{
    private String fileDir="";
    private NotePad f;
    private EditHandler e;
    Handler(NotePad f)
    {
        this.f=f;
        e=new EditHandler(f);
    }
    
    @Override
        public void  action(ActionEvent e) throws IOException, PrinterException
        { 
           /* switch(e.getActionCommand())
            {
                case "New" :  new1(e);
                case "Save As"
            }
                    */
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
            else if(e.getSource()==f.font)
            {
                this.e.action(e);
            }
            else if(e.getSource()==f.wordwrap)
            { 
                this.e.action(e);
            }
            else if(e.getSource()==f.theme)
            { 
                this.e.action(e);
            }
            else if(e.getSource()==f.print)
            { 
                print(e);
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
                        AlertDialog alert= new AlertDialog(f);
                            alert.addWindowListener(new WindowAdapter(){
                                public void windowClosing(WindowEvent e) {
                                  f.setEnabled(true);
                                }    
                            });
                            alert.save.addActionListener(new ActionListener(){
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
                            alert.dontSave.addActionListener(new ActionListener(){
                                public void actionPerformed(ActionEvent e) {
                                    System.exit(0);
                                }
                            });
                       
                            alert.cancel.addActionListener(new ActionListener(){
                                public void actionPerformed(ActionEvent e) {
                                    alert.setVisible(false);
                                    f.setEnabled(true);
                                }
                            });
                    alert.setVisible(true);
                    f.setEnabled(false);
                 }
                 else
                     System.exit(0);
         }

    private void new1(ActionEvent e) 
    {
        if(f.alter)
        { 
                        
                           AlertDialog alert= new AlertDialog(f);
                             alert.addWindowListener(new WindowAdapter(){
                                public void windowClosing(WindowEvent e) {
                                  f.setEnabled(true);
                                }    
                            });
                            alert.save.addActionListener(new ActionListener(){
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
                                      alert.setVisible(false);
                                     NotePad.main(new String[2]);
                                    }
                                  
                                }
                            });
                            alert.dontSave.addActionListener(new ActionListener(){
                                public void actionPerformed(ActionEvent e) {
                                    f.setVisible(false);
                                    alert.setVisible(false);
                                   NotePad.main(new String[2]);
                                }
                            });
                            alert.cancel.addActionListener(new ActionListener(){
                                public void actionPerformed(ActionEvent e) {
                                    alert.setVisible(false);
                                    f.setEnabled(true);
                                }
                            });
                    alert.setVisible(true);
                    f.setEnabled(false);
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
                          AlertDialog alert= new AlertDialog(f);
                       
                             alert.addWindowListener(new WindowAdapter(){
                                public void windowClosing(WindowEvent e) {
                                  f.setEnabled(true);
                                }    
                            });
                            alert.save.addActionListener(new ActionListener(){
                                public void actionPerformed(ActionEvent e)
                                { 
                                    try {
                                        save(e);
                                    } catch (IOException ex) {
                                       
                                    }
                                    if(fileDir!=null)
                                    { 
                                        alert.setVisible(false);
                                        f.setEnabled(true);
                                        try {
                                            read(e);
                                        } catch (FileNotFoundException ex) {
                                          
                                        } catch (IOException ex) {
                                            
                                        }
                                    }
                                  
                                }
                            });
                        
                            alert.dontSave.addActionListener(new ActionListener(){
                                public void actionPerformed(ActionEvent e) {
                                    alert.setVisible(false);
                                    f.setEnabled(true);//
                                    try {
                                        read(e);
                                    } catch (FileNotFoundException ex) {
                                     
                                    } catch (IOException ex) {
                                       
                                    }
                                }

                
                            });
                        
                            alert.cancel.addActionListener(new ActionListener(){
                                public void actionPerformed(ActionEvent e) {
                                    alert.setVisible(false);
                                    //f.setEnabled(true);
                                }
                            });              
                    alert.setVisible(true);
                    f.setEnabled(false);
        }
        else
        read(e);
    }
     private void read(ActionEvent e)  throws IOException
     {
          FileDialog fd=new FileDialog(f,"Open file",FileDialog.LOAD);  
          fd.setVisible(true);
          
          System.out.println(fd.getFile());
          if(fd.getFile()!=null)
          { 
              String text="";
              int content;
              
              String tempFileDir=fileDir;
              fileDir=fd.getDirectory()+fd.getFile();
              try{
                FileReader fr=new FileReader(fileDir);
                while((content=fr.read())!=-1)
                { 
                  text=text+(char)content;
                }
                fr.close();
              } catch(FileNotFoundException ex)
              {
                  System.out.println("File Not Found");
                  fileDir=tempFileDir;
              }
           
              if(fileDir!=tempFileDir){
                f.main.setText(text);
                f.setTitle(fd.getFile().replaceAll(".txt", ""));
                f.saved=true;
                f.alter(false);
              }
          }
     
     }      

    private void print(ActionEvent e) throws PrinterException
    {
       f.main.print();
    }
}
