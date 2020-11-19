
package GUI;

import java.awt.Color;
import static java.awt.Color.black;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class BanhangGUI extends JFrame implements ItemListener,MouseListener{
    JPanel searchpanel,functionpanel1,functionpanel2,infopanel,cartpanel,infokh;
    JPanel displaypanel[];
    JTextField searchtxt;
    JComboBox loai;
    private Font f = new Font("Arial",Font.BOLD,18);
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private JScrollPane searchjsp,cartjsp;
    ArrayList<SanphamGUI> displaymangsp;
//JPanel cartpanel[];
    private JLabel magglbl,idhdlbl,giatienlbl,thongbaolbl,cartlbl,infolbl,totallbl,
            ngaylaplbl,gialbl,hyphenlbl,loaimonanlbl,getgialbl,searchbtn,checkoutbtn,
            reloadbtn,printbtn,loaddatabtn,nextbtn,prebtn,pagelbl,ngaylaptxt;  
    static String[] cartheader = {"IDNV","IDHD","Tên món ăn","Đơn giá","Số lượng","Thành tiền","Tổng tiền",""};
    JLabel a = new JLabel();
    JTable carttable;
    
    public BanhangGUI(){
        inits();
    }
    public void inits(){
        setSize(945,650);
        setLayout(null);
        setBackground(new Color(0, 255, 204));
        //panel gio hang
        cartpanel = new JPanel(null);
        cartpanel.setBounds(0,5,600,300);
        cartpanel.setBorder(new LineBorder(black,3,true));
        
        DefaultTableModel cartmodel = new DefaultTableModel(cartheader,0);
        carttable = new JTable(cartmodel);
        //DefaultTableCellEditor cellRender = new DefaultTableCellEditor();
        //cellRender.add(removebtn);
        //searchtable.getColumnModel().getColumn(4).setCellRenderer(new ButtonRender());
        //{public boolean isCellEditable(int row, int column){return false;}}

        carttable.getColumnModel().getColumn(7).setPreferredWidth(50);
        carttable.getColumnModel().getColumn(2).setPreferredWidth(150);
        carttable.setRowHeight(30);
        
        cartjsp = new JScrollPane(carttable);
        //cartjsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        //cartjsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        cartjsp.setBounds(350,300,580,230);
        cartjsp.setBorder(new LineBorder(black,3,true));
        cartpanel.add(cartjsp);
        
        //panel thong tin
        infopanel = new JPanel(new FlowLayout(0,5,5));
        infopanel.setBounds(620,5,300,300);
        infopanel.setBorder(new LineBorder(black,3,true));
        
        infokh = new JPanel(new FlowLayout(0,5,5));
        
        //panel chuc nang 1
        functionpanel1 = new JPanel(null);
        functionpanel1.setBounds(0,300,600,40);
        functionpanel1.setBorder(new LineBorder(black,3,true));
        ngaylaplbl = new JLabel(new ImageIcon("C:\\Users\\nngia\\Documents\\NetBeansProjects\\QLVPP\\src\\main\\java\\Icons\\calendericon.png"));
        ngaylaplbl.setBounds(5,300,30,40);
        ngaylaptxt = new JLabel("20/11/2020");
        ngaylaptxt.setBounds(37,300,80,40);
        searchtxt = new JTextField(18);
        searchtxt.setBounds(120,305,150,30);
        searchbtn = new JLabel();
        searchbtn.setBounds(340,300,30,40);
        searchbtn.setIcon(new ImageIcon("C:\\Users\\nngia\\Documents\\NetBeansProjects\\QLVPP\\src\\main\\java\\Icons\\searchicon1.png"));
        searchbtn.addMouseListener(this);
        prebtn = new JLabel();
        prebtn.setBounds(370,300,30,40);
        prebtn.setIcon(new ImageIcon("C:\\Users\\nngia\\Documents\\NetBeansProjects\\QLVPP\\src\\main\\java\\Icons\\pre.png"));
        prebtn.addMouseListener(this);
        nextbtn = new JLabel();
        nextbtn.setBounds(430,300,30,40);
        nextbtn.setIcon(new ImageIcon("C:\\Users\\nngia\\Documents\\NetBeansProjects\\QLVPP\\src\\main\\java\\Icons\\next.png"));
        nextbtn.addMouseListener(this);
        pagelbl = new JLabel("1");
        pagelbl.setFont(f);
        pagelbl.setBounds(new Rectangle(400,300,30,40));
        //loai = new JComboBox();
        //loai.setPreferredSize(new Dimension(50,40));
        
        add(ngaylaplbl);
        add(ngaylaptxt);
        add(searchtxt);
        add(searchbtn);
        add(prebtn);
        add(pagelbl);
        add(nextbtn);
        //functionpanel1.add(loai);
        //searchbtn.setIcon(new ImageIcon(this.getClass().getResource("Icons/next.png")));
       // searchbtn.addMouseListener(this);
        //searchbtn = new JLabel();
       // searchbtn.setPreferredSize(new Dimension(30,28));
        //searchbtn.setIcon(new ImageIcon("C:\\Users\\nngia\\Documents\\NetBeansProjects\\QLVPP\\src\\main\\java\\Icons\\pre.png"));
        //searchbtn.addMouseListener(this);
        //timetxt.setPreferredSize(preferredSize);
        //infopanel.add(timetxt);
        

        //panel search
        searchpanel = displaysp(1);
        searchpanel.setBounds(0,340,610,270);
        searchpanel.setBorder(new LineBorder(black,3,true));
        
        
        //panel chuc nang 2
        functionpanel2 = new JPanel(null);
        functionpanel2.setBounds(600,310,500,340);
        functionpanel2.setBorder(new LineBorder(black,3,true));
        add(cartpanel);
        add(searchpanel);
        add(functionpanel1);
        add(functionpanel2);
        add(infopanel);
      
    }
    
    public JPanel displaysp(int page){
        displaypanel = new JPanel[2];
        for(int i=0;i<displaypanel.length;i++){
            displaypanel[i] = new JPanel(new FlowLayout(1,5,5));
            //displaypanel[i].setBounds(0,340,610,270);
            for(int j=0;j<10;j++){
                int count=0,x=0,y=0;
                //SanphamGUI.setBounds(x,y,145,120);
               // displaymangsp[1] = new SanphamGUI("","fwafwa","1000");
                displaypanel[i].add(new SanphamGUI("fwafwa","1000"));
            }
        
        //searchpanel.add(displaypanel[1]);
        //displaypanel[1].setVisible(true);
        //add(displaypanel[1]);
        }
        return displaypanel[page];
    }
    public static void main(String[] args) {
        BanhangGUI a = new BanhangGUI();
        a.setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
