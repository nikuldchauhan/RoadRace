import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class road extends Applet  implements KeyListener,Runnable
{
  int x1=0,y1=550,x2=0,y2=0,lan1=0,lan2=0,sc=0,u=100; 
  boolean q=false,m=true;
  Random rr=new Random();
  Thread t=new Thread(this);
  Image img1,img2,img3;
  AudioClip audioClip,ad1;
  public void init()
  {
   setFocusable(true);
   //requestFocasOfWindow();
   addKeyListener(this);
   img1 = getImage(getCodeBase(),"i1.jpg");
   img2 = getImage(getCodeBase(),"i2.jpg");
   img3 = getImage(getCodeBase(),"index2.jpg");
   ad1 = getAudioClip(getCodeBase(),"Road.wav");
   ad1.loop();
   t.start();
  }
  
  public void start()
  {
   
  }
  
  public void stop()
  {
   
  }
  
  public void destroy()
  {
   
  }
  
  public void run()
  {
    while(m)
	{
	  sc=sc+50;
      lan1=rr.nextInt(3);
	  if(lan1==0)
	  x2=0;
	  if(lan1==1)
	  x2=300;
	  if(lan1==2)
	  x2=600;
	  while(y2<650)
	  {
	   y2=y2+10;
	   repaint();
	   System.out.println(y2);
	   try{
	   if(sc>100)
	   {
	     u=10;
	   }
	   t.sleep(u);}catch(Exception e){}
	   if(y2>440 && lan1==lan2)
	   {
	     m=false;
		 y2=650;
		 repaint();
		 System.out.println(y2+"hello");
	   }
	  }
	  y2=0;
	}
  }
  
  public void keyPressed(KeyEvent e) 
  {
     if(e.getKeyCode()==KeyEvent.VK_LEFT)
	{ 
	  if(x1==300)
	  {
	    x1=0;
		lan2=0;
		repaint();
	  }
	  
	  if(x1==600)
	  {
	    x1=300;
		lan2=1;
		repaint();
	  }
	}
	
	if(e.getKeyCode()==KeyEvent.VK_RIGHT)
	{
	  q=true;
	  if(x1==0)
	  {
	    q=false;
	    x1=300;
		lan2=1;
		repaint();
	  }
	  
	  if(q)
	  {
	    if(x1==300)
	    {
	     x1=600;
		 lan2=2;
		 repaint();
	    }
	  }
    }
  }
  
  public void keyReleased(KeyEvent ae) 
  {
  
  }
  
  public void keyTyped(KeyEvent ee) 
  {
  
  }
  
  public void paint(Graphics g)
  {
   if(m)
   {
    g.drawLine(300,0,300,650);
    g.drawLine(600,0,600,650); 
	g.drawImage(img1,x1,y1,300,100,this);
	g.drawImage(img2,x2,y2,300,100,this);
    //g.fillRect(x1,y1,300,100);
    //g.fillRect(x2,y2,300,100);
   }
   else
   {
     g.drawImage(img3,30,30,800,500,this);
	 g.drawString(sc-50+"",10,20);
	 ad1.stop();
	 audioClip = getAudioClip(getCodeBase(),"gameover.wav");
	 audioClip.play();
   }   
  }
}
/*
<applet code="road" width="900" height="650">
</applet>
*/