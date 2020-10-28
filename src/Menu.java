import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Menu {
    Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
    private JMenuBar mb;
    private JMenu editar;
    private JMenuItem cortar,pegar, copiar,archivo;
    private JEditorPane panelTexto;
    public Menu (JEditorPane panelTexto) {
        this.panelTexto = panelTexto;
        initMenu();
    }
    private void initMenu () {
        mb = new JMenuBar(); //Barra de menu principal
        mb.add(getEditar());


        //abrir gestor de archivos
        archivo = new JMenuItem("Archivo");
        archivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser prueba = new JFileChooser();
                prueba.showOpenDialog(new JFrame());

            }
        });
        mb.add(archivo);
    }

    private JMenu getEditar () {


        //Action action = new StyledEditorKit.BoldAction();
        //action.putValue(Action.NAME, "Negrita");
        //editar.add(action);


        //editar.add(new StyledEditorKit.FontSizeAction("12", 12));
        //editar.add(new StyledEditorKit.FontSizeAction("14", 14));
        //editar.add(new StyledEditorKit.FontSizeAction("18", 18));


        editar = new JMenu("Edicion");
        editar.setMnemonic(KeyEvent.VK_E);
        copiar = new JMenuItem("Copiar");
        copiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringSelection ss = new StringSelection(panelTexto.getSelectedText());
                cb.setContents(ss, ss);
            }
        });
        editar.add(copiar);

        cortar = new JMenuItem("Cortar");
        cortar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringSelection ss = new StringSelection(panelTexto.getSelectedText());
                cb.setContents(ss, ss);
                Main.getFondo().getPanelTexto().replaceSelection("");;
            }
        });
        editar.add(cortar)
        ;
        pegar = new JMenuItem("Pegar");
        pegar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = null;
                try {
                    Transferable dato = cb.getContents(this);
                    DataFlavor dataFlavorStringJava = new DataFlavor("application/x-java-serialized-object; class=java.lang.String");
                    if (dato.isDataFlavorSupported(dataFlavorStringJava)) {
                        texto = (String) dato.getTransferData(dataFlavorStringJava);
                    }
                } catch (Exception a) {
                    a.printStackTrace();
                }
                panelTexto.replaceSelection(texto);
            }
        });
        editar.add(pegar);
        return editar;
    }
    public JMenuBar getMb () {
        return mb;
    }
}
