package rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * zbj: created on 2021/4/12 15:56.
 */
public class RmiClient {

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost",1099);
            IRemote iRemote = (IRemote) registry.lookup("test");
            String s = iRemote.testMethod("hello", "world");
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
