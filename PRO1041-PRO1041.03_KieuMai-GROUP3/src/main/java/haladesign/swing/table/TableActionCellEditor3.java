package haladesign.swing.table;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;


public class TableActionCellEditor3 extends DefaultCellEditor {

    private TableActionEvent1 event;

    public TableActionCellEditor3(TableActionEvent1 event) {
        super(new JCheckBox());
        this.event = event;
    }

    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int row, int column) {
        PenalAction3 action = new PenalAction3();
        action.initEvent(event, row);
        action.setBackground(jtable.getSelectionBackground());
        return action;
    }
}
