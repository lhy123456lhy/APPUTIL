package com.ds.apputil;

import java.util.TreeMap;

import javax.net.ssl.SSLServerSocketFactory;

/**
 * 获取密码套件字
 *
 */
public class Test {
	public static void main(String[] args) {
		SSLServerSocketFactory ssf =(SSLServerSocketFactory)SSLServerSocketFactory.getDefault();
        TreeMap<String,Boolean> allciphers = new TreeMap<String,Boolean>();
        for(String cipher:ssf.getSupportedCipherSuites()) {
        	allciphers.put(cipher,Boolean.FALSE);
            String[] defaultCipherSuites = ssf.getDefaultCipherSuites();
            for(String str:defaultCipherSuites){
                System.out.println(str);
            }
        }
	}
}
