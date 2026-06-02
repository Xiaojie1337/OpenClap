/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.linux;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Library;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class DynamicLinkLoader {
    public static final int RTLD_LAZY;
    public static final int RTLD_NOW;
    public static final int RTLD_BINDING_MASK;
    public static final int RTLD_NOLOAD;
    public static final int RTLD_DEEPBIND;
    public static final int RTLD_GLOBAL;
    public static final int RTLD_LOCAL;
    public static final int RTLD_NODELETE;

    protected DynamicLinkLoader() {
        throw new UnsupportedOperationException();
    }

    public static native long ndlopen(long var0, int var2);

    @NativeType(value="void *")
    public static long dlopen(@Nullable @NativeType(value="char const *") ByteBuffer param0, int param1) {
        if (Checks.CHECKS) {
            Checks.checkNT1Safe(param0);
        }
        return DynamicLinkLoader.ndlopen(MemoryUtil.memAddressSafe(param0), param1);
    }

    @NativeType(value="void *")
    public static long dlopen(@Nullable @NativeType(value="char const *") CharSequence param0, int param1) {
        MemoryStack v2 = MemoryStack.stackGet();
        int v3 = v2.getPointer();
        try {
            v2.nUTF8Safe(param0, true);
            long v4 = param0 == null ? 0L : v2.getPointerAddress();
            long v6 = DynamicLinkLoader.ndlopen(v4, param1);
            return v6;
        }
        finally {
            v2.setPointer(v3);
        }
    }

    public static native long ndlerror();

    @Nullable
    @NativeType(value="char *")
    public static String dlerror() {
        long v0 = DynamicLinkLoader.ndlerror();
        return MemoryUtil.memUTF8Safe(v0);
    }

    public static native long ndlsym(long var0, long var2);

    @NativeType(value="void *")
    public static long dlsym(@NativeType(value="void *") long param0, @NativeType(value="char const *") ByteBuffer param2) {
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.checkNT1(param2);
        }
        return DynamicLinkLoader.ndlsym(param0, MemoryUtil.memAddress(param2));
    }

    @NativeType(value="void *")
    public static long dlsym(@NativeType(value="void *") long param0, @NativeType(value="char const *") CharSequence param2) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        MemoryStack v3 = MemoryStack.stackGet();
        int v4 = v3.getPointer();
        try {
            v3.nASCII(param2, true);
            long v5 = v3.getPointerAddress();
            long v7 = DynamicLinkLoader.ndlsym(param0, v5);
            return v7;
        }
        finally {
            v3.setPointer(v4);
        }
    }

    public static native int ndlclose(long var0);

    public static int dlclose(@NativeType(value="void *") long param0) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return DynamicLinkLoader.ndlclose(param0);
    }

    static {
        RTLD_NODELETE = 4096;
        RTLD_LOCAL = 0;
        RTLD_GLOBAL = 256;
        RTLD_DEEPBIND = 8;
        RTLD_NOLOAD = 4;
        RTLD_BINDING_MASK = 3;
        RTLD_NOW = 2;
        RTLD_LAZY = 1;
        Library.initialize();
    }
}

