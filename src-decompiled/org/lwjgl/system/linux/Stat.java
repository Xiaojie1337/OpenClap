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

public class Stat {
    protected Stat() {
        throw new UnsupportedOperationException();
    }

    public static native int nstat(long var0, long var2);

    public static int stat(@NativeType(value="char const *") ByteBuffer param0, @NativeType(value="struct stat *") long param1) {
        if (Checks.CHECKS) {
            Checks.checkNT1(param0);
            Checks.check(param1);
        }
        return Stat.nstat(MemoryUtil.memAddress(param0), param1);
    }

    public static int stat(@NativeType(value="char const *") CharSequence param0, @NativeType(value="struct stat *") long param1) {
        if (Checks.CHECKS) {
            Checks.check(param1);
        }
        MemoryStack v3 = MemoryStack.stackGet();
        int v4 = v3.getPointer();
        try {
            v3.nUTF8(param0, true);
            long v5 = v3.getPointerAddress();
            int v7 = Stat.nstat(v5, param1);
            return v7;
        }
        finally {
            v3.setPointer(v4);
        }
    }

    public static native int nfstat(int var0, long var1);

    public static int fstat(int param0, @NativeType(value="struct stat *") long param1) {
        if (Checks.CHECKS) {
            Checks.check(param1);
        }
        return Stat.nfstat(param0, param1);
    }

    static {
        Library.initialize();
    }
}

