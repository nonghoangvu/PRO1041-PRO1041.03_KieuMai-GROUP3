package utility;

import java.awt.Component;
import javax.swing.JOptionPane;

public class MsgBox {

    /*
    Hiện thị hộp thoại thông báo đơn giản 
    Component parent : Đối tượng cha của hộp thoại, thường là cửu sổ hoặc giao diện bạn muốn hiện thị hộp thoại
    String messager : Nd muốn thông báo 
     */
    public static void alter(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message, "Hệ Thống phần mềm bán giày", JOptionPane.INFORMATION_MESSAGE);
    }

    /*
Hiện thị hộp thoại với 2 nút "Có" / "Không". 
hộp thoại đc hiện thị bởi JOptionPane.showMessageDialog.
Phương thức trả về "true" = "Có" / "False" = "Không".    
     */
    public static boolean confirm(Component parent, String message) {
        int result = JOptionPane.showConfirmDialog(parent, message, "Hệ Thống phần mềm bán giày", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return result == JOptionPane.YES_OPTION;
    }

    /*Hộp thoại yêu cầu người dùng nhập dữ liệu
    Phương thức trả về chuỗi mà người dùng nhập hoặc là null.*/
    public static String prompt(Component parent, String message) {
        //Nếu nhấn Oke thì trả về chuỗi String người dùng đã nhập. 
        //Nếu nhấn cancel thì trả về null
        return JOptionPane.showInputDialog(parent, message, "Hệ Thống phần mềm bán giày", JOptionPane.INFORMATION_MESSAGE);
    }
}
