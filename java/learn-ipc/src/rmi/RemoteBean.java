package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * zbj: created on 2021/4/12 15:52.
 */
public class RemoteBean extends UnicastRemoteObject implements IRemote {
    private static final long serialVersionUID = 3682470187378911418L;

    protected RemoteBean() throws RemoteException {
    }

    @Override
    public String testMethod(String a, String b) {
        return a + b;
    }
}
