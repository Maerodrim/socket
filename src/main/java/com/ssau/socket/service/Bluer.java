package com.ssau.socket.service;

import java.rmi.RemoteException;

public interface Bluer
{
    byte[]  blurring(byte[] byteOfImage) throws RemoteException;
}
