package javanotepad;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditHandler implements ActionPerformable
{
    private NotePad f;
    
    EditHandler(NotePad f)
    {
        this.f=f;
    }
    @Override
    public void action(ActionEvent e)
    { 
        switch(e.getActionCommand())
        { 
            case  "Font.." :   font();
                                break;
            case "Word Wrap" : 
                                if(f.wordwrap.isSelected())
                                { 
                                    f.main.setLineWrap(true);
                                }
                                else
                                    f.main.setLineWrap(false);
                                break;
            case "Theme" :
                                theme();
                                break;
        }
        
    }
    
    //methods
    void font()
    { 
        FontDialog fd= new FontDialog(f);
        fd.setVisible(true);
        fd.ok.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
               int style=fd.styleList.getSelectedIndex();
               String size=(String) fd.sizeList.getSelectedValue();
               String font= (String) fd.fontList.getSelectedValue();
               font=font.substring(17);
               for(int i=0;i<font.length();i++)
               { 
                   if(font.charAt(i)=='>')
                   { 
                       font=font.substring(0,i);
                       break;
                   }
               }
               
               f.main.setFont(new Font(font,style,Integer.parseInt(size)));
               fd.sampleLabel.setFont(new Font(font,style,Integer.parseInt(size))); 
         
            }
        });
        fd.cancel.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e) 
            {
               fd.dispose();
            }
            
        });
    }

    private void theme() 
    {
        ThemeDialog t=new ThemeDialog(f);
        t.setVisible(true);
        t.ok.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                ThemeDialog.setTheme((String)t.themeBox.getSelectedItem(), f.main);
            }
        });
        t.cancel.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e) 
            {
               t.dispose();
            }
        });
    }
}
