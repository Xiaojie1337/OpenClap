/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.linux;

import java.nio.ByteBuffer;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Library;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class FCNTL {
    public static final int O_ACCMODE;
    public static final int O_RDONLY;
    public static final int O_WRONLY;
    public static final int O_RDWR;
    public static final int O_APPEND;
    public static final int O_ASYNC;
    public static final int O_CLOEXEC;
    public static final int O_CREAT;
    public static final int O_DIRECT;
    public static final int O_DIRECTORY;
    public static final int O_DSYNC;
    public static final int O_EXCL;
    public static final int O_LARGEFILE;
    public static final int O_NOATIME;
    public static final int O_NOCTTY;
    public static final int O_NOFOLLOW;
    public static final int O_NONBLOCK;
    public static final int O_NDELAY;
    public static final int O_PATH;
    public static final int O_SYNC;
    public static final int O_TMPFILE;
    public static final int O_TRUNC;
    public static final int S_IFMT;
    public static final int S_IFBLK;
    public static final int S_IFCHR;
    public static final int S_IFIFO;
    public static final int S_IFREG;
    public static final int S_IFDIR;
    public static final int S_IFLNK;
    public static final int S_IFSOCK;
    public static final int S_IRWXU;
    public static final int S_IRUSR;
    public static final int S_IWUSR;
    public static final int S_IXUSR;
    public static final int S_IRWXG;
    public static final int S_IRGRP;
    public static final int S_IWGRP;
    public static final int S_IXGRP;
    public static final int S_IRWXO;
    public static final int S_IROTH;
    public static final int S_IWOTH;
    public static final int S_IXOTH;
    public static final int S_ISUID;
    public static final int S_ISGID;
    public static final int S_ISVTX;
    public static final int F_DUPFD;
    public static final int F_GETFD;
    public static final int F_SETFD;
    public static final int F_GETFL;
    public static final int F_SETFL;
    public static final int F_GETLK;
    public static final int F_SETLK;
    public static final int F_SETLKW;
    public static final int F_SETOWN;
    public static final int F_GETOWN;
    public static final int F_SETSIG;
    public static final int F_GETSIG;
    public static final int F_SETOWN_EX;
    public static final int F_GETOWN_EX;
    public static final int F_OFD_GETLK;
    public static final int F_OFD_SETLK;
    public static final int F_OFD_SETLKW;
    public static final int F_SETLEASE;
    public static final int F_GETLEASE;
    public static final int F_NOTIFY;
    public static final int F_SETPIPE_SZ;
    public static final int F_GETPIPE_SZ;
    public static final int F_ADD_SEALS;
    public static final int F_GET_SEALS;
    public static final int F_GET_RW_HINT;
    public static final int F_SET_RW_HINT;
    public static final int F_GET_FILE_RW_HINT;
    public static final int F_SET_FILE_RW_HINT;
    public static final int F_DUPFD_CLOEXEC;
    public static final int FD_CLOEXEC;
    public static final int F_RDLCK;
    public static final int F_WRLCK;
    public static final int F_UNLCK;
    public static final int F_EXLCK;
    public static final int F_SHLCK;
    public static final int F_OWNER_TID;
    public static final int F_OWNER_PID;
    public static final int F_OWNER_PGRP;
    public static final int LOCK_SH;
    public static final int LOCK_EX;
    public static final int LOCK_NB;
    public static final int LOCK_UN;
    public static final int LOCK_MAND;
    public static final int LOCK_READ;
    public static final int LOCK_WRITE;
    public static final int LOCK_RW;
    public static final int DN_ACCESS;
    public static final int DN_MODIFY;
    public static final int DN_CREATE;
    public static final int DN_DELETE;
    public static final int DN_RENAME;
    public static final int DN_ATTRIB;
    public static final int DN_MULTISHOT;
    public static final int F_SEAL_SEAL;
    public static final int F_SEAL_SHRINK;
    public static final int F_SEAL_GROW;
    public static final int F_SEAL_WRITE;
    public static final int F_SEAL_FUTURE_WRITE;
    public static final int RWH_WRITE_LIFE_NOT_SET;
    public static final int RWH_WRITE_LIFE_NONE;
    public static final int RWH_WRITE_LIFE_SHORT;
    public static final int RWH_WRITE_LIFE_MEDIUM;
    public static final int RWH_WRITE_LIFE_LONG;
    public static final int RWH_WRITE_LIFE_EXTREME;

    protected FCNTL() {
        throw new UnsupportedOperationException();
    }

    public static native int nopen(long var0, int var2, int var3);

    public static int open(@NativeType(value="char const *") ByteBuffer param0, int param1, @NativeType(value="mode_t") int param2) {
        if (Checks.CHECKS) {
            Checks.checkNT1(param0);
        }
        return FCNTL.nopen(MemoryUtil.memAddress(param0), param1, param2);
    }

    public static int open(@NativeType(value="char const *") CharSequence param0, int param1, @NativeType(value="mode_t") int param2) {
        MemoryStack v3 = MemoryStack.stackGet();
        int v4 = v3.getPointer();
        try {
            v3.nUTF8(param0, true);
            long v5 = v3.getPointerAddress();
            int v7 = FCNTL.nopen(v5, param1, param2);
            return v7;
        }
        finally {
            v3.setPointer(v4);
        }
    }

    public static native int nopenat(int var0, long var1, int var3, int var4);

    public static int openat(int param0, @NativeType(value="char const *") ByteBuffer param1, int param2, @NativeType(value="mode_t") int param3) {
        if (Checks.CHECKS) {
            Checks.checkNT1(param1);
        }
        return FCNTL.nopenat(param0, MemoryUtil.memAddress(param1), param2, param3);
    }

    public static int openat(int param0, @NativeType(value="char const *") CharSequence param1, int param2, @NativeType(value="mode_t") int param3) {
        MemoryStack v4 = MemoryStack.stackGet();
        int v5 = v4.getPointer();
        try {
            v4.nUTF8(param1, true);
            long v6 = v4.getPointerAddress();
            int v8 = FCNTL.nopenat(param0, v6, param2, param3);
            return v8;
        }
        finally {
            v4.setPointer(v5);
        }
    }

    public static native int ncreat(long var0, int var2);

    public static int creat(@NativeType(value="char const *") ByteBuffer param0, @NativeType(value="mode_t") int param1) {
        if (Checks.CHECKS) {
            Checks.checkNT1(param0);
        }
        return FCNTL.ncreat(MemoryUtil.memAddress(param0), param1);
    }

    public static int creat(@NativeType(value="char const *") CharSequence param0, @NativeType(value="mode_t") int param1) {
        MemoryStack v2 = MemoryStack.stackGet();
        int v3 = v2.getPointer();
        try {
            v2.nUTF8(param0, true);
            long v4 = v2.getPointerAddress();
            int v6 = FCNTL.ncreat(v4, param1);
            return v6;
        }
        finally {
            v2.setPointer(v3);
        }
    }

    public static native int fcntl(int var0, int var1);

    public static native int nfcntli(int var0, int var1, int var2);

    public static int fcntli(int param0, int param1, int param2) {
        return FCNTL.nfcntli(param0, param1, param2);
    }

    public static native int nfcntlp(int var0, int var1, long var2);

    public static int fcntlp(int param0, int param1, @NativeType(value="void *") long param2) {
        if (Checks.CHECKS) {
            Checks.check(param2);
        }
        return FCNTL.nfcntlp(param0, param1, param2);
    }

    static {
        RWH_WRITE_LIFE_EXTREME = 5;
        RWH_WRITE_LIFE_LONG = 4;
        RWH_WRITE_LIFE_MEDIUM = 3;
        RWH_WRITE_LIFE_SHORT = 2;
        RWH_WRITE_LIFE_NONE = 1;
        RWH_WRITE_LIFE_NOT_SET = 0;
        F_SEAL_FUTURE_WRITE = 16;
        F_SEAL_WRITE = 8;
        F_SEAL_GROW = 4;
        F_SEAL_SHRINK = 2;
        F_SEAL_SEAL = 1;
        DN_MULTISHOT = Integer.MIN_VALUE;
        DN_ATTRIB = 32;
        DN_RENAME = 16;
        DN_DELETE = 8;
        DN_CREATE = 4;
        DN_MODIFY = 2;
        DN_ACCESS = 1;
        LOCK_RW = 192;
        LOCK_WRITE = 128;
        LOCK_READ = 64;
        LOCK_MAND = 32;
        LOCK_UN = 8;
        LOCK_NB = 4;
        LOCK_EX = 2;
        LOCK_SH = 1;
        F_OWNER_PGRP = 2;
        F_OWNER_PID = 1;
        F_OWNER_TID = 0;
        F_SHLCK = 8;
        F_EXLCK = 4;
        F_UNLCK = 2;
        F_WRLCK = 1;
        F_RDLCK = 0;
        FD_CLOEXEC = 1;
        F_DUPFD_CLOEXEC = 1030;
        F_SET_FILE_RW_HINT = 1038;
        F_GET_FILE_RW_HINT = 1037;
        F_SET_RW_HINT = 1036;
        F_GET_RW_HINT = 1035;
        F_GET_SEALS = 1034;
        F_ADD_SEALS = 1033;
        F_GETPIPE_SZ = 1032;
        F_SETPIPE_SZ = 1031;
        F_NOTIFY = 1026;
        F_GETLEASE = 1025;
        F_SETLEASE = 1024;
        F_OFD_SETLKW = 38;
        F_OFD_SETLK = 37;
        F_OFD_GETLK = 36;
        F_GETOWN_EX = 16;
        F_SETOWN_EX = 15;
        F_GETSIG = 11;
        F_SETSIG = 10;
        F_GETOWN = 9;
        F_SETOWN = 8;
        F_SETLKW = 7;
        F_SETLK = 8;
        F_GETLK = 5;
        F_SETFL = 4;
        F_GETFL = 3;
        F_SETFD = 2;
        F_GETFD = 1;
        F_DUPFD = 0;
        S_ISVTX = 512;
        S_ISGID = 1024;
        S_ISUID = 2048;
        S_IXOTH = 1;
        S_IWOTH = 2;
        S_IROTH = 4;
        S_IRWXO = 7;
        S_IXGRP = 8;
        S_IWGRP = 16;
        S_IRGRP = 32;
        S_IRWXG = 56;
        S_IXUSR = 64;
        S_IWUSR = 128;
        S_IRUSR = 256;
        S_IRWXU = 448;
        S_IFSOCK = 49152;
        S_IFLNK = 40960;
        S_IFDIR = 16384;
        S_IFREG = 32768;
        S_IFIFO = 4096;
        S_IFCHR = 8192;
        S_IFBLK = 24576;
        S_IFMT = 61440;
        O_TRUNC = 512;
        O_TMPFILE = 0x410000;
        O_SYNC = 0x101000;
        O_PATH = 0x200000;
        O_NDELAY = 2048;
        O_NONBLOCK = 2048;
        O_NOFOLLOW = 131072;
        O_NOCTTY = 256;
        O_NOATIME = 262144;
        O_LARGEFILE = 32768;
        O_EXCL = 128;
        O_DSYNC = 4096;
        O_DIRECTORY = 65536;
        O_DIRECT = 16384;
        O_CREAT = 64;
        O_CLOEXEC = 524288;
        O_ASYNC = 8192;
        O_APPEND = 1024;
        O_RDWR = 2;
        O_WRONLY = 1;
        O_RDONLY = 0;
        O_ACCMODE = 3;
        Library.initialize();
    }
}

