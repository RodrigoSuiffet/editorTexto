import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.StyledDocument;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.html.HTMLEditorKit;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Arrays;

public class CuadroTexto {


    private JScrollPane panelPrincipal;
    private JEditorPane panelTexto;
    HTMLEditorKit kit;

    public CuadroTexto () {
        panelTexto = new JEditorPane(){
            public boolean getScrollableTracksViewportWidth() //Sobreescribo el método, para que el texto no se autoajuste al tamaño del frame, sino que aparezcan scrollbars
            {   Component parent = getParent();
                ComponentUI ui = getUI();
                return parent != null ? (ui.getPreferredSize(this).width <= parent.getSize().width) : true;
            }
        };



        kit = new HTMLEditorKit();
        panelTexto.setEditorKit(kit);
        panelTexto.addCaretListener(new VisibleCaretListener());
        panelTexto.setFocusable(true); //para poder hacer uso del key listener
        panelTexto.addKeyListener(new EscuchaTeclas(panelTexto)); //Le paso el panel Texto al keydlistener para poder operar con el
        JPanel noAutoEnter = new JPanel(new BorderLayout());
        noAutoEnter.add(panelTexto);
        panelPrincipal = new JScrollPane(
                noAutoEnter
        );
        addBindings();

    }
    public JScrollPane getPanelPrincipal() {
        return panelPrincipal;
    }
    public JEditorPane getPanelTexto () {
        return panelTexto;
    }


    protected void addBindings() {
        InputMap inputMap = panelTexto.getInputMap();

        //Ctrl-b aplico negrita
        KeyStroke key = KeyStroke.getKeyStroke(KeyEvent.VK_B, Event.CTRL_MASK);
        inputMap.put(key, new StyledEditorKit.BoldAction());


        //Ctrl-i aplico cursiva
        key = KeyStroke.getKeyStroke(KeyEvent.VK_I, Event.CTRL_MASK);
        inputMap.put(key, new StyledEditorKit.ItalicAction());

        //Ctrl-m quiero aumentar en 1 el tamaño del texto
        key = KeyStroke.getKeyStroke(77, Event.CTRL_MASK);
        inputMap.put(key,  new StyledEditorKit.FontSizeAction("15", 12));

    }
}
