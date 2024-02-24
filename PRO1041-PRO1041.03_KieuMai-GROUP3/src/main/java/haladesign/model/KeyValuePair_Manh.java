package haladesign.model;

public class KeyValuePair_Manh {

    private int key;
    private String value;
    
    public KeyValuePair_Manh() {
    }

    public KeyValuePair_Manh(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {//Khi 1 đối tượng đc thêm vào JComboBox sẽ gọi method `toString() của obj để xác định cách hiện thị.
        return value;
    }
}
