package javanotepad;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
public class ThemeDialog extends JDialog
{
    JLabel select;
    JScrollPane scrPane;
    static JTextArea txtArea;
    JButton ok,cancel;
    JComboBox themeBox;
    String [] themeArray={"Dark","Light","Ocean","Hacker","Fancy","VS code"};
    {
        select=new JLabel("Select Theme");
        txtArea=new JTextArea("Hello I am Vivek Anand Rathod\n I love programming");
            txtArea.setEditable(false);
        ok=new JButton("Ok");
        cancel=new JButton("Cancel");
        scrPane=new JScrollPane(txtArea);
            scrPane.setBorder(BorderFactory.createTitledBorder("Preview"));
        themeBox=new JComboBox(themeArray);
            themeBox.setSelectedIndex(1);
    }
    ThemeDialog(NotePad f)
    { 
        super(f,"Choose theme");
        setLayout(null);
        setSize(800, 450);
        setLocationRelativeTo(f);
        setResizable(false);
        //Setting bounds
        themeBox.setBounds(195, 57, 164, 22);
        scrPane.setBounds(56, 120, 688, 194);
        ok.setBounds(568, 338, 79, 25);
        cancel.setBounds(665, 338, 79, 25);
        select.setBounds(56, 60, 121, 16);
        
        //adding
        add(themeBox);
        add(scrPane);
        add(ok);
        add(cancel);
        add(select); 
    }
    public static void setTheme(String themeName,JTextArea main)
    {
        switch(themeName)
        { 
            case "Dark" :
                         main.setFont(new Font("Serif",0,18));
                         main.setBackground(Color.DARK_GRAY);
                         main.setCaretColor(Color.white);
                         main.setBorder(BorderFactory.createCompoundBorder());
                         main.setForeground(Color.white);
                         
                         txtArea.setFont(new Font("Serif",0,18));
                         txtArea.setBackground(Color.DARK_GRAY);
                         txtArea.setCaretColor(Color.white);
                         txtArea.setBorder(BorderFactory.createCompoundBorder());
                         txtArea.setForeground(Color.white);
                        break;
            case "Light":
                         main.setBackground(Color.WHITE);
                         main.setFont(new Font("Serif",0,18));
                         main.setCaretColor(Color.black);
                         main.setBorder(BorderFactory.createEmptyBorder());
                         main.setForeground(Color.black);
                         
                         txtArea.setBackground(Color.WHITE);
                         txtArea.setFont(new Font("Serif",0,18));
                         txtArea.setCaretColor(Color.black);
                         txtArea.setBorder(BorderFactory.createEmptyBorder());
                         txtArea.setForeground(Color.black);
                         break;
            case "Ocean" :
                        main.setBackground(Color.WHITE);
                        main.setFont(new Font("Serif",0,18));
                        main.setCaretColor(Color.black);
                        main.setBorder(BorderFactory.createEmptyBorder());
                        main.setForeground(Color.black);
                        
                         txtArea.setBackground(Color.WHITE);
                        txtArea.setFont(new Font("Serif",0,18));
                        txtArea.setCaretColor(Color.black);
                        txtArea.setBorder(BorderFactory.createEmptyBorder());
                        txtArea.setForeground(Color.black);
                        break;
            case "Hacker" :
                        main.setBackground(Color.WHITE);
                         main.setFont(new Font("Serif",0,18));
                         main.setCaretColor(Color.black);
                         main.setBorder(BorderFactory.createEmptyBorder());
                         main.setForeground(Color.black);
                         
                          txtArea.setBackground(Color.WHITE);
                         txtArea.setFont(new Font("Serif",0,18));
                         txtArea.setCaretColor(Color.black);
                         txtArea.setBorder(BorderFactory.createEmptyBorder());
                         txtArea.setForeground(Color.black);
                         break;
            case "Fancy" :
                        main.setBackground(Color.WHITE);
                         main.setFont(new Font("Serif",0,18));
                         main.setCaretColor(Color.black);
                         main.setBorder(BorderFactory.createEmptyBorder());
                         main.setForeground(Color.black);
                         
                         txtArea.setBackground(Color.WHITE);
                         txtArea.setFont(new Font("Serif",0,18));
                         txtArea.setCaretColor(Color.black);
                         txtArea.setBorder(BorderFactory.createEmptyBorder());
                         txtArea.setForeground(Color.black);
                         break;
            case "VS code" :
                        main.setBackground(Color.WHITE);
                         main.setFont(new Font("Serif",0,18));
                         main.setCaretColor(Color.black);
                         main.setBorder(BorderFactory.createEmptyBorder());
                         main.setForeground(Color.black);
                         
                         txtArea.setBackground(Color.WHITE);
                         txtArea.setFont(new Font("Serif",0,18));
                         txtArea.setCaretColor(Color.black);
                         txtArea.setBorder(BorderFactory.createEmptyBorder());
                         txtArea.setForeground(Color.black);
                        break;                   
                        
        }
    }
}