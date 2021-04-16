package rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * zbj: created on 2021/4/12 15:48.
 */
public class RmiServer {

    public static void main(String[] args) {
        try {
            IRemote iRemote = new RemoteBean();
            LocateRegistry.createRegistry(1099);
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("test", iRemote);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
