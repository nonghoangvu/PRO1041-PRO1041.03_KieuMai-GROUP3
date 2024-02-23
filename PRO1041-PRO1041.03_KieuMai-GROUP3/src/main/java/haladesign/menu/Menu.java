package haladesign.menu;

import haladesign.Utitlity.BcryptHash;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javaswingdev.GoogleMaterialDesignIcon;
import haladesign.swing.scroll.ScrollBar;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author NONG HOANG VU
 */
public class Menu extends JPanel {

    private int index = -1;
    private final List<EventMenuSelected> events = new ArrayList<>();
    private final BcryptHash bcryptHash = new BcryptHash();

    public Menu() {
        init();
    }

    private void init() {
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        JScrollPane scroll = createScroll();
        panelMenu = createPanelMenu();
        scroll.setViewportView(panelMenu);
        scroll.getViewport().setOpaque(false);
        scroll.setViewportBorder(null);
        add(scroll);
        addTitle(bcryptHash.decodeBase64("VHJhbmcgY2jhu6c="));
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.HOME, bcryptHash.decodeBase64("VOG7lW5nIHF1YW4=")));
        addTitle(bcryptHash.decodeBase64("U+G6o24gUGjhuqlt"));
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.ADD_SHOPPING_CART, bcryptHash.decodeBase64("QsOhbiBow6BuZw=="), bcryptHash.decodeBase64("QsOhbiB04bqhaSBxdeG6p3k="), bcryptHash.decodeBase64("SMOzYSDEkcahbg==")));
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.SHOPPING_BASKET, bcryptHash.decodeBase64("UXXhuqNuIGzDvSBz4bqjbiBwaOG6qW0="), bcryptHash.decodeBase64("RGFuaCBzw6FjaCBz4bqjbiBwaOG6qW0="), bcryptHash.decodeBase64("VGh14buZYyB0w61uaCBz4bqjbiBwaOG6qW0=")));
        addTitle(bcryptHash.decodeBase64("VMOgaSBraG/huqNu"));
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.SUPERVISOR_ACCOUNT, bcryptHash.decodeBase64("UXXhuqNuIGzDvSB0w6BpIGtob+G6o24="), bcryptHash.decodeBase64("TmjDom4gdmnDqm4="), bcryptHash.decodeBase64("S2jDoWNoIGjDoG5n"), bcryptHash.decodeBase64("UXXhuqNuIGzDvSB2YWkgdHLDsg==")));
        addTitle(bcryptHash.decodeBase64("S2jDoWM="));
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.SETTINGS, bcryptHash.decodeBase64("Q8OgaSDEkeG6t3Q=")));
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.ACCOUNT_CIRCLE, bcryptHash.decodeBase64("VMOgaSBraG/huqNuIGPhu6dhIHTDtGk=")));
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.EXIT_TO_APP, bcryptHash.decodeBase64("xJDEg25nIHh14bqldA==")));
    }

    private JScrollPane createScroll() {
        JScrollPane scroll = new JScrollPane();
        scroll.setBorder(null);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setVerticalScrollBar(new ScrollBar());
        return scroll;
    }

    private JPanel createPanelMenu() {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        menuLayout = new MigLayout("wrap,fillx,inset 0,gapy 0", "[fill]");
        panel.setLayout(menuLayout);
        return panel;
    }

    private JPanel createMenuItem(ModelMenuItem item) {
        MenuItem menuItem = new MenuItem(item, ++index, menuLayout);
        menuItem.addEvent((int index1, int indexSubMenu) -> {
            if (!menuItem.isHasSubMenu() || indexSubMenu != 0) {
                clearSelected();
                setSelectedIndex(index1, indexSubMenu);
            }
        });
        return menuItem;
    }

    private void runEvent(int index, int indexSubMenu) {
        for (EventMenuSelected event : events) {
            event.menuSelected(index, indexSubMenu);
        }
    }

    // Public Method
    public void addMenuItem(ModelMenuItem menu) {
        panelMenu.add(createMenuItem(menu), "h 35!");
    }

    public void addTitle(String title) {
        JLabel label = new JLabel(title);
        label.setBorder(new EmptyBorder(15, 20, 5, 5));
        label.setFont(label.getFont().deriveFont(Font.BOLD));
        label.setForeground(new Color(170, 170, 170));
        panelMenu.add(label);
    }

    public void addSpace(int size) {
        panelMenu.add(new JLabel(), "h " + size + "!");
    }

    public void setSelectedIndex(int index, int indexSubMenu) {
        for (Component com : panelMenu.getComponents()) {
            if (com instanceof MenuItem item) {
                if (item.getIndex() == index) {
                    item.setSelectedIndex(indexSubMenu);
                    runEvent(index, indexSubMenu);
                    break;
                }
            }
        }
    }

    public void clearSelected() {
        for (Component com : panelMenu.getComponents()) {
            if (com instanceof MenuItem item) {
                item.clearSelected();
            }
        }
    }

    public void addEvent(EventMenuSelected event) {
        events.add(event);
    }

    private MigLayout menuLayout;
    private JPanel panelMenu;
}
