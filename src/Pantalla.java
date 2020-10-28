import javax.swing.*;

public class Pantalla {
    private JFrame contenedorPrincipal;
    private JEditorPane panelTexto;
    private Menu menu;
    public Pantalla () {
        initPantalla();
    }

    private void initPantalla() {
        contenedorPrincipal = new JFrame();
        contenedorPrincipal.setTitle("Archivo nuevo. Sin guardar");
        contenedorPrincipal.setSize(1920/2,1080/2);
        agregarCuadroTexto();
        agregarMenu();


        contenedorPrincipal.setVisible(true);
        contenedorPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
        contenedorPrincipal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void agregarCuadroTexto() {
        CuadroTexto cuadroTexto = new CuadroTexto();
        contenedorPrincipal.getContentPane().add(cuadroTexto.getPanelPrincipal());
        this.panelTexto =cuadroTexto.getPanelTexto();
    }
    private void agregarMenu (){
        menu = new Menu(panelTexto);
        contenedorPrincipal.setJMenuBar(menu.getMb());
    }
    public JEditorPane getPanelTexto() {
        return panelTexto;
    }

}
