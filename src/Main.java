import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main {
    static private Pantalla fondo;

    public static void main(String[] args) {

            EventQueue.invokeLater(new Runnable() {
                public void run() {

                    try {
                        fondo = new Pantalla();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

    }

    public static Pantalla getFondo() {
        return fondo;
    }
}
