package create.prototype;

import java.io.*;

/**
 * 使用ByteArrayOutputStream/ObjectOutputStream/ByteArrayInputStream/ObjectInputStream
 *
 * 深拷贝
 */
public class DeepClonePrototype implements Serializable, Cloneable {

    public Helper helper;

    public DeepClonePrototype deepClone() throws Exception {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (DeepClonePrototype) ois.readObject();
        }
    }
}

class Helper implements Serializable {

}


