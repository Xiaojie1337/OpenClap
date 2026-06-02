/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.linux;

import org.lwjgl.system.Library;

public class Socket {
    public static final int SHUT_RD;
    public static final int SHUT_WR;
    public static final int SHUT_RDWR;

    protected Socket() {
        throw new UnsupportedOperationException();
    }

    public static native int socket(int var0, int var1, int var2);

    static {
        SHUT_RDWR = 2;
        SHUT_WR = 1;
        SHUT_RD = 0;
        Library.initialize();
    }
}

