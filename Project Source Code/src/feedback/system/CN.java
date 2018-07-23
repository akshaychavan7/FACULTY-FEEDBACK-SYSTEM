package feedback.system;
import static feedback.system.Login.ans;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CN extends JFrame implements ActionListener
{
	JLabel l;
	JRadioButton jb[]=new JRadioButton[5];
	JButton b1,b2;
	ButtonGroup bg;
	int count=0,current=0,x=1,y=1,now=0;
	int m[]=new int[10];
        
	CN(String s)
	{
		super(s);
		Login.filename="CN_feedback.txt";
                l=new JLabel();
		add(l);
		bg=new ButtonGroup();
		for(int i=0;i<5;i++)
		{
			jb[i]=new JRadioButton();	
			add(jb[i]);
			bg.add(jb[i]);
		}
		b1=new JButton("Next");
		b2=new JButton("Bookmark");
		b1.addActionListener(this);
		b2.addActionListener(this);
		add(b1);add(b2);
		set();
		l.setBounds(30,40,450,20);
		jb[0].setBounds(50,80,100,20);
		jb[1].setBounds(50,110,100,20);
		jb[2].setBounds(50,140,100,20);
		jb[3].setBounds(50,170,100,20);
                jb[4].setBounds(50,200,100,20);
		b1.setBounds(100,240,100,30);
		b2.setBounds(270,240,100,30);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250,100);
		setVisible(true);
		setSize(600,350);
	}

    CN() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	public void actionPerformed(ActionEvent e)
	{
                if(e.getSource()==b1)
		{
			//if(check())
			//	count=count+1;
			current++;
                        answer();        
                        if(jb[0].isSelected() || jb[1].isSelected() || jb[2].isSelected() || jb[3].isSelected() || jb[4].isSelected())
                        {    
                            
                            set();
                            answer();
                        }
                        else
                            JOptionPane.showMessageDialog(this,"Please select any option..!!");
			if(current==7)
			{
				b1.setEnabled(false);
				b2.setText("Exit");
                                
			}
		}
		if(e.getActionCommand().equals("Bookmark"))
		{
			JButton bk=new JButton("Bookmark"+x);
			bk.setBounds(480,20+30*x,100,30);
			add(bk);
			bk.addActionListener(this);
			m[x]=current;
			x++;
			current++;
			answer();
                        set();
                        answer();
			if(current==7)
                            b2.setText("Exit");
			setVisible(false);
			setVisible(true);
		}
		for(int i=0,y=1;i<x;i++,y++)
		{
		if(e.getActionCommand().equals("Bookmark"+y))
		{
			//if(check())
			//	count=count+1;
			now=current;
			current=m[y];
			set();
                        answer();
			//((JButton)e.getSource()).setEnabled(false);
                        ((JButton)e.getSource()).setVisible(false);
                        current=now;
                        answer();
		}
		}
	
		if(e.getActionCommand().equals("Exit"))
		{
			//if(check())
			//	count=count+1;
			current++;
                        answer();
			//System.out.println("correct ans="+count);
               /*         Connection conn;
            try {
                conn = DriverManager.getConnection("jdbc:sqlite:/home/akshay/NetBeansProjects/Feedback System/feedback.sqlite");
                Statement stmt=conn.createStatement();  
                ResultSet rs=stmt.executeQuery("insert into cn values('good','good','good','good','good','good','good','good','good','good','good')");
            } catch (SQLException ex) {
                Logger.getLogger(CN.class.getName()).log(Level.SEVERE, null, ex);
            }*/
			JOptionPane.showMessageDialog(this,"Thank you for your feedback (^-^)");
                        //if(jb[0].isSelected())
                            //ans[0]="Excellent";
                        //answer();
                        new Feedback_Theory().setVisible(true);
                        //new Feedback_Report().setVisible(true);
			//System.exit(0);
		}
	}
	void set()
	{
		
		if(current==0)
		{
			l.setText("1) Teaching Quality ");
			jb[0].setText("Excellent");
                        jb[1].setText("Very Good");
                        jb[2].setText("Good");
                        jb[3].setText("Average");
                        jb[4].setText("Below Average");
		}
		if(current==1)
		{
			l.setText("2) Clarity of concepts and speed of delivery");
			jb[0].setText("Excellent");
                        jb[1].setText("Very Good");
                        jb[2].setText("Good");
                        jb[3].setText("Average");
                        jb[4].setText("Below Average");
		}
		if(current==2)
		{
			l.setText("3) Teacher's encoursgement for inviting questions and providing satisfactory answers");
			jb[0].setText("Excellent");
                        jb[1].setText("Very Good");
                        jb[2].setText("Good");
                        jb[3].setText("Average");
                        jb[4].setText("Below Average");
		}
		if(current==3)
		{
			l.setText("4) Regularity in conduction of lecture");
			jb[0].setText("Excellent");
                        jb[1].setText("Very Good");
                        jb[2].setText("Good");
                        jb[3].setText("Average");
                        jb[4].setText("Below Average");
		}
		if(current==4)
		{
			l.setText("5) Relating Theory with real life examples");
			jb[0].setText("Excellent");
                        jb[1].setText("Very Good");
                        jb[2].setText("Good");
                        jb[3].setText("Average");
                        jb[4].setText("Below Average");
		}
		if(current==5)
		{
			l.setText("6) Syllabus coverage");
			jb[0].setText("Excellent");
                        jb[1].setText("Very Good");
                        jb[2].setText("Good");
                        jb[3].setText("Average");
                        jb[4].setText("Below Average");
		}
		if(current==6)
		{
			l.setText("7) Class control and discipline");
			jb[0].setText("Excellent");
                        jb[1].setText("Very Good");
                        jb[2].setText("Good");
                        jb[3].setText("Average");
                        jb[4].setText("Below Average");
		}
		if(current==7)
		{
			l.setText("8) Overall impact of the teacher");
			jb[0].setText("Excellent");
                        jb[1].setText("Very Good");
                        jb[2].setText("Good");
                        jb[3].setText("Average");
                        jb[4].setText("Below Average");		
		}
		/*if(current==8)
		{
			l.setText("Que9: which function is not present in Applet class");
			jb[0].setText("init");jb[1].setText("main");jb[2].setText("start");jb[3].setText("destroy");
		}
		if(current==9)
		{
			l.setText("Que10: Which one among these is not a valid component");
			jb[0].setText("JButton");jb[1].setText("JList");jb[2].setText("JButtonGroup");jb[3].setText("JTextArea");
		}*/
		l.setBounds(30,40,450,20);
		for(int i=0,j=0;i<=90;i+=30,j++)
			jb[j].setBounds(50,80+i,200,20);
	}
        
        void answer()
        {
           //ans[0]="Excellent"+current;
            if(current==1)
            {
                for(int i=0;i<5;i++)
                    if(jb[i].isSelected())
                    {
                        switch(i)
                        {
                            case 0:
                                    ans[1]="Excellent";
                                    break;
                            case 1:
                                    ans[1]="Very Good";
                                    break;
                            case 2:
                                    ans[1]="Good";
                                    break;
                            case 3:
                                    ans[1]="Average";
                                    break;
                            case 4:
                                    ans[1]="Below Average";      
                        }
            
                    }
            }
            if(current==2)
            {
                for(int i=0;i<5;i++)
                    if(jb[i].isSelected())
                    {
                        switch(i)
                        {
                            case 0:
                                    ans[2]="Excellent";
                                    break;
                            case 1:
                                    ans[2]="Very Good";
                                    break;
                            case 2:
                                    ans[2]="Good";
                                    break;
                            case 3:
                                    ans[2]="Average";
                                    break;
                            case 4:
                                    ans[2]="Below Average";      
                        }
                    }
            }
            if(current==3)
            {
                for(int i=0;i<5;i++)
                    if(jb[i].isSelected())
                    {
                        switch(i)
                        {
                            case 0:
                                    ans[3]="Excellent";
                                    break;
                            case 1:
                                    ans[3]="Very Good";
                                    break;
                            case 2:
                                    ans[3]="Good";
                                    break;
                            case 3:
                                    ans[3]="Average";
                                    break;
                            case 4:
                                    ans[3]="Below Average";      
                        }
                    }
            }
            if(current==4)
            {
                for(int i=0;i<5;i++)
                    if(jb[i].isSelected())
                    {
                        switch(i)
                        {
                            case 0:
                                    ans[4]="Excellent";
                                    break;
                            case 1:
                                    ans[4]="Very Good";
                                    break;
                            case 2:
                                    ans[4]="Good";
                                    break;
                            case 3:
                                    ans[4]="Average";
                                    break;
                            case 4:
                                    ans[4]="Below Average";      
                        }
                    }
            }
            if(current==5)
            {
                for(int i=0;i<5;i++)
                    if(jb[i].isSelected())
                    {
                        switch(i)
                        {
                            case 0:
                                    ans[5]="Excellent";
                                    break;
                            case 1:
                                    ans[5]="Very Good";
                                    break;
                            case 2:
                                    ans[5]="Good";
                                    break;
                            case 3:
                                    ans[5]="Average";
                                    break;
                            case 4:
                                    ans[5]="Below Average";      
                        }
                    }
            }
            if(current==6)
            {
                for(int i=0;i<5;i++)
                    if(jb[i].isSelected())
                    {
                        switch(i)
                        {
                            case 0:
                                    ans[6]="Excellent";
                                    break;
                            case 1:
                                    ans[6]="Very Good";
                                    break;
                            case 2:
                                    ans[6]="Good";
                                    break;
                            case 3:
                                    ans[6]="Average";
                                    break;
                            case 4:
                                    ans[6]="Below Average";      
                        }
                    }
            }
            if(current==7)
            {
                for(int i=0;i<5;i++)
                    if(jb[i].isSelected())
                    {
                        switch(i)
                        {
                            case 0:
                                    ans[7]="Excellent";
                                    break;
                            case 1:
                                    ans[7]="Very Good";
                                    break;
                            case 2:
                                    ans[7]="Good";
                                    break;
                            case 3:
                                    ans[7]="Average";
                                    break;
                            case 4:
                                    ans[7]="Below Average";      
                        }
                    }
            }
           if(current==8)
            {
                for(int i=0;i<5;i++)
                    if(jb[i].isSelected())
                    {
                        switch(i)
                        {
                            case 0:
                                    ans[8]="Excellent";
                                    break;
                            case 1:
                                    ans[8]="Very Good";
                                    break;
                            case 2:
                                    ans[8]="Good";
                                    break;
                            case 3:
                                    ans[8]="Average";
                                    break;
                            case 4:
                                    ans[8]="Below Average";      
                        }
                    }
            }
           
            
        }
}



















/*
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

