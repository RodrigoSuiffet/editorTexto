import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EscuchaTeclas implements KeyListener {
    Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard(); //El clipboar para el keylistener
    JEditorPane panel; //panel del que quiero obtener los datos (copiados, cortados)

    public EscuchaTeclas(JEditorPane panel) {
        this.panel = panel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println();
        if (e.isControlDown()){
            switch (e.getKeyCode()) {
                case 88:
                    StringSelection textoCortado = new StringSelection(panel.getSelectedText());
                    cb.setContents(textoCortado, textoCortado);
                    panel.replaceSelection("");
                    break;
            }

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.isControlDown()){
            if (e.getKeyCode() == 67) {
                StringSelection textoCopiado = new StringSelection(panel.getSelectedText());
                cb.setContents(textoCopiado, textoCopiado);
            }

        }

    }
}
