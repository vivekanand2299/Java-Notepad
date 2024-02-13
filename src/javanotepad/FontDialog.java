package javanotepad;
import java.awt.GraphicsEnvironment;
import java.awt.event.KeyEvent;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

class FontDialog extends JDialog
{
            JLabel fontLabel,style,size,sampleLabel;
            JTextField fontField,styleField,sizeField;
            JList fontList,styleList,sizeList;
            JPanel sample;
            JButton ok,cancel;
            JScrollPane s1,s2,s3;
            String [] font;
            DefaultListModel fontModel,styleModel,sizeModel;
            {
                font=fonts();

                fontLabel=new JLabel("Font:");
                style=new JLabel("Font style:");
                size=new JLabel("Size:");
                sampleLabel=new JLabel("Vivek Anand");
                   sampleLabel.setHorizontalAlignment(JLabel.CENTER);
                fontField=new JTextField();
                styleField=new JTextField();
                sizeField=new JTextField();
                
                fontList=new JList(); s1=new JScrollPane();
                    fontList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                styleList=new JList(); s2=new JScrollPane();
                sizeList=new JList(); s3=new JScrollPane();
                listIntializer();
                
                sample=new JPanel(new java.awt.GridLayout());
                    sample.setBorder(javax.swing.BorderFactory.createTitledBorder("Sample"));
                
                ok=new JButton("OK");
                cancel=new JButton("Cancel");
                
                
            }
            private void listIntializer()
            {   
                
                 fontModel=new DefaultListModel();
                 sizeModel=new DefaultListModel();
                 styleModel=new DefaultListModel();
                int[] size={3,5,8,10,12,14,18,24,30,48};
                
                for(String x:font)
                { 
                    fontModel.addElement("<html><font face="+x+">"+x+"</font></html>");
                }
                for(int x:size)
                { 
                    sizeModel.addElement(x+"");
                }
                styleModel.addElement("Plain");
                styleModel.addElement("Bold");
                styleModel.addElement("Italic");
                styleModel.addElement("Bold Italic");
                
                styleList.setModel(styleModel);
                sizeList.setModel(sizeModel);
                fontList.setModel(fontModel);
                
                fontList.setSelectedIndex(31);
                styleList.setSelectedIndex(0);
                sizeList.setSelectedIndex(5);
            }
            FontDialog(NotePad f)
            {
                super(f,"Choose Font");
                setLayout(null);
                setSize(389,395);
                setResizable(false);
                this.setLocationRelativeTo(f);
                fontLabel.setBounds(12, 20, 57, 16);
                    add(fontLabel);
                style.setBounds(189, 20, 60, 16);
                    add(style);
                size.setBounds(319, 20, 30, 16);
                    add(size);
                fontField.setBounds(12, 43, 159, 22);
                    add(fontField);
                styleField.setBounds(189, 43, 112, 22);
                    add(styleField);
                sizeField.setBounds(319, 43, 54, 22);
                    add(sizeField);
                s1.setBounds(12, 72, 159, 110);
                    s1.setViewportView(fontList);
                    add(s1);
                s2.setBounds(189, 72, 112, 110);
                    s2.setViewportView(styleList);
                    add(s2);
                s3.setBounds(319, 72, 54, 110);
                    s3.setViewportView(sizeList);
                    add(s3);
                sample.setBounds(189, 200, 188, 109);
                    sample.add(sampleLabel);
                    add(sample);
                ok.setBounds(189, 327, 75, 25);
                    add(ok);
                cancel.setBounds(302, 327, 75, 25);
                    add(cancel);
                    ok.setMnemonic(KeyEvent.VK_F9);
            }
            
            private String [] fonts()
            {
                   GraphicsEnvironment ge;
                   ge= GraphicsEnvironment.getLocalGraphicsEnvironment();
                   String[] names=ge.getAvailableFontFamilyNames();
                   return names;
            }
}
