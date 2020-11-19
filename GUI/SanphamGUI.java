/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static java.awt.Color.black;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author nngia
 */
public class SanphamGUI extends JPanel{
    JLabel namelbl,pricelbl,hinhlbl;
    public SanphamGUI(String name,String price){
        inits(name,price);
    }
    
    public void inits(String name,String price){
        setLayout(null);
        setPreferredSize(new Dimension(140,130));
        //setBounds(145);
        setBorder(new LineBorder(black,3,true));
        //ImageIcon img = new ImageIcon(this.getClass().getResource(source));
       //hinhlbl = new JLabel(source,img,JLabel.CENTER);
        //hinhlbl.setBounds();
        pricelbl = new JLabel(price,JLabel.CENTER);
        pricelbl.setBounds(0,100,130,30);
        namelbl = new JLabel(name,JLabel.CENTER);
        namelbl.setBounds(100,0,40,40);
        //add(hinhlbl);
        add(namelbl);
        add(pricelbl);
    }
}
