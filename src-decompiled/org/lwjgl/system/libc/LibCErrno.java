/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.libc;

import org.lwjgl.system.Library;

public class LibCErrno {
    public static final int EPERM;
    public static final int ENOENT;
    public static final int ESRCH;
    public static final int EINTR;
    public static final int EIO;
    public static final int ENXIO;
    public static final int E2BIG;
    public static final int ENOEXEC;
    public static final int EBADF;
    public static final int ECHILD;
    public static final int EAGAIN;
    public static final int ENOMEM;
    public static final int EACCES;
    public static final int EFAULT;
    public static final int EBUSY;
    public static final int EEXIST;
    public static final int EXDEV;
    public static final int ENODEV;
    public static final int ENOTDIR;
    public static final int EISDIR;
    public static final int EINVAL;
    public static final int ENFILE;
    public static final int EMFILE;
    public static final int ENOTTY;
    public static final int EFBIG;
    public static final int ENOSPC;
    public static final int ESPIPE;
    public static final int EROFS;
    public static final int EMLINK;
    public static final int EPIPE;
    public static final int EDOM;
    public static final int ERANGE;
    public static final int EDEADLK;
    public static final int EDEADLOCK;
    public static final int ENAMETOOLONG;
    public static final int ENOLCK;
    public static final int ENOSYS;
    public static final int ENOTEMPTY;
    public static final int EILSEQ;
    public static final int STRUNCATE;

    protected LibCErrno() {
        throw new UnsupportedOperationException();
    }

    public static native int errno();

    public static native int getErrno();

    static {
        STRUNCATE = 80;
        EILSEQ = 42;
        ENOTEMPTY = 41;
        ENOSYS = 40;
        ENOLCK = 39;
        ENAMETOOLONG = 38;
        EDEADLOCK = 36;
        EDEADLK = 36;
        ERANGE = 34;
        EDOM = 33;
        EPIPE = 32;
        EMLINK = 31;
        EROFS = 30;
        ESPIPE = 29;
        ENOSPC = 28;
        EFBIG = 27;
        ENOTTY = 25;
        EMFILE = 24;
        ENFILE = 23;
        EINVAL = 22;
        EISDIR = 21;
        ENOTDIR = 20;
        ENODEV = 19;
        EXDEV = 18;
        EEXIST = 17;
        EBUSY = 16;
        EFAULT = 14;
        EACCES = 13;
        ENOMEM = 12;
        EAGAIN = 11;
        ECHILD = 10;
        EBADF = 9;
        ENOEXEC = 8;
        E2BIG = 7;
        ENXIO = 6;
        EIO = 5;
        EINTR = 4;
        ESRCH = 3;
        ENOENT = 2;
        EPERM = 1;
        Library.initialize();
    }
}

