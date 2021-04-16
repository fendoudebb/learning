package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * zbj: created on 2021/4/12 15:48.
 */
public interface IRemote extends Remote {

    String testMethod(String a, String b) throws RemoteException;
}
