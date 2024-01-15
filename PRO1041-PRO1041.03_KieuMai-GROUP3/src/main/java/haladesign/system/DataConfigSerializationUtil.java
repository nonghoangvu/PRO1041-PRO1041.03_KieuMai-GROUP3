package haladesign.system;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author NONG HOANG VU
 */
 public class DataConfigSerializationUtil {

        public void saveConfigInfoToFile(DatabaseConfig config) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("config.ser"))) {
                oos.writeObject(config);
            } catch (IOException e) {
            }
        }

        public DatabaseConfig readConfigInfoFromFile() {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("config.ser"))) {
                return (DatabaseConfig) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                return null;
            }
        }
    }