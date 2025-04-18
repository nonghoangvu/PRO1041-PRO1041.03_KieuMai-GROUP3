package haladesign.swing.scroll;

import java.awt.Dimension;
import javax.swing.JScrollBar;

/**
 *
 * @author NONG HOANG VU
 */
public class ScrollBar extends JScrollBar {

    public ScrollBar() {
        setUI(new ModernScrollBarUI());
        setPreferredSize(new Dimension(5, 5));
        setOpaque(false);
        setUnitIncrement(20);
    }
}
