package view;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;

import java.awt.*;
import javax.swing.*;

public class SplashScreen extends JWindow {

    private int duration;
    static JProgressBar pBar;

    public SplashScreen(int d) {
        duration = d;
    }


// Este é um método simples para mostrar uma tela de apresentção

// no centro da tela durante a quantidade de tempo passada no construtor

    public void showSplash() {

        Container container = getContentPane();

        JPanel panel = new JPanel();
        panel.setBackground(Color.white);

        int width = 650;
        int height =415;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width-width)/2;
        int y = (screen.height-height)/2;
        setBounds(x,y,width,height);

        // Constrói o splash screen
        JLabel label = new JLabel(new ImageIcon(SplashScreen.class.getResource("/imagens/TelaPrincipal.jpg")));
        panel.add(label, BorderLayout.CENTER);
        Color oraRed = new Color(149, 156, 87,  255);
        panel.setBorder(BorderFactory.createLineBorder(oraRed, 10));
        setVisible(true);

        pBar = new JProgressBar();
        pBar.setValue(0);
        pBar.setStringPainted(true);
        pBar.setBounds(80, 380, 500, 20);
        panel.add(pBar, BorderLayout.SOUTH);

        fill();
        setVisible(false);
    }

    public static void fill()
    {
        int i = 0;
        try {
            while (i <= 100) {
                // fill the menu bar
                pBar.setValue(i + 5);

                // delay the thread
                Thread.sleep(1000);
                i += 20;
            }
        }
        catch (Exception e) {
        }
    }
}