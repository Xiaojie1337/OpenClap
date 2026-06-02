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

public class LibCLocale {
    public static final int LC_ALL;
    public static final int LC_COLLATE;
    public static final int LC_CTYPE;
    public static final int LC_MONETARY;
    public static final int LC_NUMERIC;
    public static final int LC_TIME;

    protected LibCLocale() {
        throw new UnsupportedOperationException();
    }

    private static native int LC_ALL();

    private static native int LC_COLLATE();

    private static native int LC_CTYPE();

    private static native int LC_MONETARY();

    private static native int LC_NUMERIC();

    private static native int LC_TIME();

    public static native long nsetlocale(int var0, long var1);

    @Nullable
    @NativeType(value="char *")
    public static String setlocale(int param0, @NativeType(value="char const *") ByteBuffer param1) {
        if (Checks.CHECKS) {
            Checks.checkNT1(param1);
        }
        long v2 = LibCLocale.nsetlocale(param0, MemoryUtil.memAddress(param1));
        return MemoryUtil.memASCIISafe(v2);
    }

    @Nullable
    @NativeType(value="char *")
    public static String setlocale(int param0, @NativeType(value="char const *") CharSequence param1) {
        MemoryStack v2 = MemoryStack.stackGet();
        int v3 = v2.getPointer();
        try {
            v2.nASCII(param1, true);
            long v4 = v2.getPointerAddress();
            long v6 = LibCLocale.nsetlocale(param0, v4);
            String v8 = MemoryUtil.memASCIISafe(v6);
            return v8;
        }
        finally {
            v2.setPointer(v3);
        }
    }

    static {
        Library.initialize();
        LC_ALL = LibCLocale.LC_ALL();
        LC_COLLATE = LibCLocale.LC_COLLATE();
        LC_CTYPE = LibCLocale.LC_CTYPE();
        LC_MONETARY = LibCLocale.LC_MONETARY();
        LC_NUMERIC = LibCLocale.LC_NUMERIC();
        LC_TIME = LibCLocale.LC_TIME();
    }
}

