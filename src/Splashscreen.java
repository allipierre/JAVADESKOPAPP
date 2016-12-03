import java.awt.SplashScreen; 

import javax.swing.JFrame; 

public class Splashscreen extends JFrame { 

    private static final int SHOW_FOR = 4000; 
    Startpage p=new Startpage();
    public Splashscreen() { 


        Thread t = new Thread() { 
            public void run() { 
                SplashScreen splash = SplashScreen.getSplashScreen(); 
                if (splash == null) { 
                    System.out 
                            .println("SplashScreen kann nicht erzeugt werden."); 
                    return; 
                } 
                try { 
                    Thread.sleep(SHOW_FOR); 
                } catch (InterruptedException e) { 
                    System.err.println("Thread unterbrochen"); 
                } 
                splash.close(); 
                p.frmAngebotsportal.setVisible(true); 
            } 
        }; 
        t.start(); 
    } 

    public static void main(String[] args) { 
        new Splashscreen(); 
    } 
} 