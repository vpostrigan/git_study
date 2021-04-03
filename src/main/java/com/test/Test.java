package com.test;

import javax.net.ssl.SSLContext;

public class Test {
    public static final String S = "1";
    public final String ss = "1";

    static {
        System.setProperty("file.encoding", "UTF-8");
        System.setProperty("java.net.preferIPv4Stack", "true");
        System.setProperty("networkaddress.cache.ttl", "300"); // seconds
        System.setProperty("networkaddress.cache.negative.ttl", "5");

        System.setProperty("http.keepAlive", "true");
        System.setProperty("http.maxConnections", "4");

        System.setProperty("sun.net.http.errorstream.enableBuffering", "true");
        // the timeout (in millisec) waiting the error stream to be buffered; default is 300 ms
        // ErrorStream isn't used, changed to 10
        System.setProperty("sun.net.http.errorstream.timeout", /* "300" */"10");
        System.setProperty("sun.net.http.errorstream.bufferSize", "4096");

        // -Djavax.net.ssl.sessionCacheSize=1000
        System.setProperty("javax.net.ssl.sessionCacheSize", "50000");
        // 0.5 hour
        System.setProperty("javax.net.ssl.sessionCacheTimeout", "" + (60 * 30));
        try {
            SSLContext sslContext = SSLContext.getDefault();
            sslContext.getServerSessionContext().setSessionTimeout((60 * 30));
        } catch (Throwable e) {
            e.printStackTrace();
        }

        // //

        System.out.println(S);
        System.out.println(new Test().ss);
    }

    public static void init() {
        // init
    }

}
