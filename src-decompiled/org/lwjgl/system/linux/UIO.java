/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.linux;

import org.lwjgl.system.Library;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.linux.IOVec;

public class UIO {
    public static final int UIO_FASTIOV;
    public static final int UIO_MAXIOV;
    public static final int RWF_HIPRI;
    public static final int RWF_DSYNC;
    public static final int RWF_SYNC;
    public static final int RWF_NOWAIT;
    public static final int RWF_APPEND;

    protected UIO() {
        throw new UnsupportedOperationException();
    }

    public static native long nreadv(int var0, long var1, int var3);

    @NativeType(value="ssize_t")
    public static long readv(int param0, @NativeType(value="struct iovec const *") IOVec param1, int param2) {
        return UIO.nreadv(param0, param1.address(), param2);
    }

    public static native long nwritev(int var0, long var1, int var3);

    @NativeType(value="ssize_t")
    public static long writev(int param0, @NativeType(value="struct iovec const *") IOVec param1, int param2) {
        return UIO.nwritev(param0, param1.address(), param2);
    }

    public static native long npreadv(int var0, long var1, int var3, long var4);

    @NativeType(value="ssize_t")
    public static long preadv(int param0, @NativeType(value="struct iovec const *") IOVec param1, int param2, @NativeType(value="off_t") long param3) {
        return UIO.npreadv(param0, param1.address(), param2, param3);
    }

    public static native long npwritev(int var0, long var1, int var3, long var4);

    @NativeType(value="ssize_t")
    public static long pwritev(int param0, @NativeType(value="struct iovec const *") IOVec param1, int param2, @NativeType(value="off_t") long param3) {
        return UIO.npwritev(param0, param1.address(), param2, param3);
    }

    public static native long nprocess_vm_readv(int var0, long var1, long var3, long var5, long var7, long var9);

    @NativeType(value="ssize_t")
    public static long process_vm_readv(@NativeType(value="pid_t") int param0, @NativeType(value="struct iovec const *") IOVec param1, @NativeType(value="unsigned long int") long param2, @NativeType(value="struct iovec const *") IOVec param4, @NativeType(value="unsigned long int") long param5, @NativeType(value="unsigned long int") long param7) {
        return UIO.nprocess_vm_readv(param0, param1.address(), param2, param4.address(), param5, param7);
    }

    public static native long nprocess_vm_writev(int var0, long var1, long var3, long var5, long var7, long var9);

    @NativeType(value="ssize_t")
    public static long process_vm_writev(@NativeType(value="pid_t") int param0, @NativeType(value="struct iovec const *") IOVec param1, @NativeType(value="unsigned long int") long param2, @NativeType(value="struct iovec const *") IOVec param4, @NativeType(value="unsigned long int") long param5, @NativeType(value="unsigned long int") long param7) {
        return UIO.nprocess_vm_writev(param0, param1.address(), param2, param4.address(), param5, param7);
    }

    static {
        RWF_APPEND = 16;
        RWF_NOWAIT = 8;
        RWF_SYNC = 4;
        RWF_DSYNC = 2;
        RWF_HIPRI = 1;
        UIO_MAXIOV = 1024;
        UIO_FASTIOV = 8;
        Library.initialize();
    }
}

