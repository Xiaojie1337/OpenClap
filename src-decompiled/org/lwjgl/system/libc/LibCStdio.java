/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.libc;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Library;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class LibCStdio {
    public static final long sscanf;
    public static final long snprintf;

    protected LibCStdio() {
        throw new UnsupportedOperationException();
    }

    @NativeType(value="void *")
    private static native long sscanf();

    public static native int nvsscanf(long var0, long var2, long var4);

    public static int vsscanf(@NativeType(value="char const *") ByteBuffer param0, @NativeType(value="char const *") ByteBuffer param1, @NativeType(value="va_list") long param2) {
        if (Checks.CHECKS) {
            Checks.checkNT1(param0);
            Checks.checkNT1(param1);
            Checks.check(param2);
        }
        return LibCStdio.nvsscanf(MemoryUtil.memAddress(param0), MemoryUtil.memAddress(param1), param2);
    }

    public static int vsscanf(@NativeType(value="char const *") CharSequence param0, @NativeType(value="char const *") CharSequence param1, @NativeType(value="va_list") long param2) {
        if (Checks.CHECKS) {
            Checks.check(param2);
        }
        MemoryStack v4 = MemoryStack.stackGet();
        int v5 = v4.getPointer();
        try {
            v4.nASCII(param0, true);
            long v6 = v4.getPointerAddress();
            v4.nASCII(param1, true);
            long v8 = v4.getPointerAddress();
            int v10 = LibCStdio.nvsscanf(v6, v8, param2);
            return v10;
        }
        finally {
            v4.setPointer(v5);
        }
    }

    @NativeType(value="void *")
    private static native long snprintf();

    public static native int nvsnprintf(long var0, long var2, long var4, long var6);

    public static int vsnprintf(@Nullable @NativeType(value="char *") ByteBuffer param0, @NativeType(value="char const *") ByteBuffer param1, @NativeType(value="va_list") long param2) {
        if (Checks.CHECKS) {
            Checks.checkNT1(param1);
            Checks.check(param2);
        }
        return LibCStdio.nvsnprintf(MemoryUtil.memAddressSafe(param0), Checks.remainingSafe(param0), MemoryUtil.memAddress(param1), param2);
    }

    public static int vsnprintf(@Nullable @NativeType(value="char *") ByteBuffer param0, @NativeType(value="char const *") CharSequence param1, @NativeType(value="va_list") long param2) {
        if (Checks.CHECKS) {
            Checks.check(param2);
        }
        MemoryStack v4 = MemoryStack.stackGet();
        int v5 = v4.getPointer();
        try {
            v4.nASCII(param1, true);
            long v6 = v4.getPointerAddress();
            int v8 = LibCStdio.nvsnprintf(MemoryUtil.memAddressSafe(param0), Checks.remainingSafe(param0), v6, param2);
            return v8;
        }
        finally {
            v4.setPointer(v5);
        }
    }

    static {
        Library.initialize();
        sscanf = LibCStdio.sscanf();
        snprintf = LibCStdio.snprintf();
    }
}

