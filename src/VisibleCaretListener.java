import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.JTextComponent;
import java.awt.*;

public class VisibleCaretListener implements CaretListener
{
    private int visiblePixels;


    public VisibleCaretListener()
    {
        this(2);
    }

    public VisibleCaretListener(int visiblePixels)
    {
        setVisiblePixels( visiblePixels );
    }


    public int getVisiblePixels()
    {
        return visiblePixels;
    }


    public void setVisiblePixels(int visiblePixels)
    {
        this.visiblePixels = visiblePixels;
    }
    //
//	Implement CaretListener interface
//
    public void caretUpdate(final CaretEvent e)
    {
        //  Attempt to scroll the viewport to make sure Caret is visible

        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                try
                {
                    JTextComponent component = (JTextComponent)e.getSource();
                    int position = component.getCaretPosition();
                    Rectangle r = component.modelToView(position);
                    r.x += visiblePixels;
                    component.scrollRectToVisible(r);
                }
                catch(Exception ble) {}
            }
        });
    }
}