/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system;

import org.lwjgl.system.Checks;
import org.lwjgl.system.Library;
import org.lwjgl.system.NativeType;

final class MemoryAccessJNI {
    static final long malloc;
    static final long calloc;
    static final long realloc;
    static final long free;
    static final long aligned_alloc;
    static final long aligned_free;

    private MemoryAccessJNI() {
        throw new UnsupportedOperationException();
    }

    static native int getPointerSize();

    @NativeType(value="void * (*) (size_t)")
    private static native long malloc();

    @NativeType(value="void * (*) (size_t, size_t)")
    private static native long calloc();

    @NativeType(value="void * (*) (void *, size_t)")
    private static native long realloc();

    @NativeType(value="void (*) (void *)")
    private static native long free();

    @NativeType(value="void * (*) (size_t, size_t)")
    private static native long aligned_alloc();

    @NativeType(value="void (*) (void *)")
    private static native long aligned_free();

    static native byte ngetByte(long var0);

    @NativeType(value="int8_t")
    static byte getByte(@NativeType(value="void *") long param0) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return MemoryAccessJNI.ngetByte(param0);
    }

    static native short ngetShort(long var0);

    @NativeType(value="int16_t")
    static short getShort(@NativeType(value="void *") long param0) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return MemoryAccessJNI.ngetShort(param0);
    }

    static native int ngetInt(long var0);

    @NativeType(value="int32_t")
    static int getInt(@NativeType(value="void *") long param0) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return MemoryAccessJNI.ngetInt(param0);
    }

    static native long ngetLong(long var0);

    @NativeType(value="int64_t")
    static long getLong(@NativeType(value="void *") long param0) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return MemoryAccessJNI.ngetLong(param0);
    }

    static native float ngetFloat(long var0);

    static float getFloat(@NativeType(value="void *") long param0) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return MemoryAccessJNI.ngetFloat(param0);
    }

    static native double ngetDouble(long var0);

    static double getDouble(@NativeType(value="void *") long param0) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return MemoryAccessJNI.ngetDouble(param0);
    }

    static native long ngetAddress(long var0);

    @NativeType(value="uintptr_t")
    static long getAddress(@NativeType(value="void *") long param0) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return MemoryAccessJNI.ngetAddress(param0);
    }

    static native void nputByte(long var0, byte var2);

    static void putByte(@NativeType(value="void *") long param0, @NativeType(value="int8_t") byte param2) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        MemoryAccessJNI.nputByte(param0, param2);
    }

    static native void nputShort(long var0, short var2);

    static void putShort(@NativeType(value="void *") long param0, @NativeType(value="int16_t") short param2) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        MemoryAccessJNI.nputShort(param0, param2);
    }

    static native void nputInt(long var0, int var2);

    static void putInt(@NativeType(value="void *") long param0, @NativeType(value="int32_t") int param2) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        MemoryAccessJNI.nputInt(param0, param2);
    }

    static native void nputLong(long var0, long var2);

    static void putLong(@NativeType(value="void *") long param0, @NativeType(value="int64_t") long param2) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        MemoryAccessJNI.nputLong(param0, param2);
    }

    static native void nputFloat(long var0, float var2);

    static void putFloat(@NativeType(value="void *") long param0, float param2) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        MemoryAccessJNI.nputFloat(param0, param2);
    }

    static native void nputDouble(long var0, double var2);

    static void putDouble(@NativeType(value="void *") long param0, double param2) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        MemoryAccessJNI.nputDouble(param0, param2);
    }

    static native void nputAddress(long var0, long var2);

    static void putAddress(@NativeType(value="void *") long param0, @NativeType(value="uintptr_t") long param2) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        MemoryAccessJNI.nputAddress(param0, param2);
    }

    static {
        Library.initialize();
        malloc = MemoryAccessJNI.malloc();
        calloc = MemoryAccessJNI.calloc();
        realloc = MemoryAccessJNI.realloc();
        free = MemoryAccessJNI.free();
        aligned_alloc = MemoryAccessJNI.aligned_alloc();
        aligned_free = MemoryAccessJNI.aligned_free();
    }
}

