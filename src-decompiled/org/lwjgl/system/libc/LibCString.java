/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.libc;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import javax.annotation.Nullable;
import org.lwjgl.system.Checks;
import org.lwjgl.system.CustomBuffer;
import org.lwjgl.system.Library;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class LibCString {
    protected LibCString() {
        throw new UnsupportedOperationException();
    }

    public static native long nmemset(long var0, int var2, long var3);

    @NativeType(value="void *")
    public static long memset(@NativeType(value="void *") ByteBuffer param0, int param1) {
        return LibCString.nmemset(MemoryUtil.memAddress(param0), param1, (long)param0.remaining());
    }

    @NativeType(value="void *")
    public static long memset(@NativeType(value="void *") ShortBuffer param0, int param1) {
        return LibCString.nmemset(MemoryUtil.memAddress(param0), param1, Integer.toUnsignedLong(param0.remaining()) << 1);
    }

    @NativeType(value="void *")
    public static long memset(@NativeType(value="void *") IntBuffer param0, int param1) {
        return LibCString.nmemset(MemoryUtil.memAddress(param0), param1, Integer.toUnsignedLong(param0.remaining()) << 2);
    }

    @NativeType(value="void *")
    public static long memset(@NativeType(value="void *") LongBuffer param0, int param1) {
        return LibCString.nmemset(MemoryUtil.memAddress(param0), param1, Integer.toUnsignedLong(param0.remaining()) << 3);
    }

    @NativeType(value="void *")
    public static long memset(@NativeType(value="void *") FloatBuffer param0, int param1) {
        return LibCString.nmemset(MemoryUtil.memAddress(param0), param1, Integer.toUnsignedLong(param0.remaining()) << 2);
    }

    @NativeType(value="void *")
    public static long memset(@NativeType(value="void *") DoubleBuffer param0, int param1) {
        return LibCString.nmemset(MemoryUtil.memAddress(param0), param1, Integer.toUnsignedLong(param0.remaining()) << 3);
    }

    public static native long nmemcpy(long var0, long var2, long var4);

    @NativeType(value="void *")
    public static long memcpy(@NativeType(value="void *") ByteBuffer param0, @NativeType(value="void const *") ByteBuffer param1) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)param0, param1.remaining());
        }
        return LibCString.nmemcpy(MemoryUtil.memAddress(param0), MemoryUtil.memAddress(param1), (long)param1.remaining());
    }

    @NativeType(value="void *")
    public static long memcpy(@NativeType(value="void *") ShortBuffer param0, @NativeType(value="void const *") ShortBuffer param1) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)param0, param1.remaining());
        }
        return LibCString.nmemcpy(MemoryUtil.memAddress(param0), MemoryUtil.memAddress(param1), Integer.toUnsignedLong(param1.remaining()) << 1);
    }

    @NativeType(value="void *")
    public static long memcpy(@NativeType(value="void *") IntBuffer param0, @NativeType(value="void const *") IntBuffer param1) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)param0, param1.remaining());
        }
        return LibCString.nmemcpy(MemoryUtil.memAddress(param0), MemoryUtil.memAddress(param1), Integer.toUnsignedLong(param1.remaining()) << 2);
    }

    @NativeType(value="void *")
    public static long memcpy(@NativeType(value="void *") LongBuffer param0, @NativeType(value="void const *") LongBuffer param1) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)param0, param1.remaining());
        }
        return LibCString.nmemcpy(MemoryUtil.memAddress(param0), MemoryUtil.memAddress(param1), Integer.toUnsignedLong(param1.remaining()) << 3);
    }

    @NativeType(value="void *")
    public static long memcpy(@NativeType(value="void *") FloatBuffer param0, @NativeType(value="void const *") FloatBuffer param1) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)param0, param1.remaining());
        }
        return LibCString.nmemcpy(MemoryUtil.memAddress(param0), MemoryUtil.memAddress(param1), Integer.toUnsignedLong(param1.remaining()) << 2);
    }

    @NativeType(value="void *")
    public static long memcpy(@NativeType(value="void *") DoubleBuffer param0, @NativeType(value="void const *") DoubleBuffer param1) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)param0, param1.remaining());
        }
        return LibCString.nmemcpy(MemoryUtil.memAddress(param0), MemoryUtil.memAddress(param1), Integer.toUnsignedLong(param1.remaining()) << 3);
    }

    public static native long nmemmove(long var0, long var2, long var4);

    @NativeType(value="void *")
    public static long memmove(@NativeType(value="void *") ByteBuffer param0, @NativeType(value="void const *") ByteBuffer param1) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)param0, param1.remaining());
        }
        return LibCString.nmemmove(MemoryUtil.memAddress(param0), MemoryUtil.memAddress(param1), (long)param1.remaining());
    }

    @NativeType(value="void *")
    public static long memmove(@NativeType(value="void *") ShortBuffer param0, @NativeType(value="void const *") ShortBuffer param1) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)param0, param1.remaining());
        }
        return LibCString.nmemmove(MemoryUtil.memAddress(param0), MemoryUtil.memAddress(param1), Integer.toUnsignedLong(param1.remaining()) << 1);
    }

    @NativeType(value="void *")
    public static long memmove(@NativeType(value="void *") IntBuffer param0, @NativeType(value="void const *") IntBuffer param1) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)param0, param1.remaining());
        }
        return LibCString.nmemmove(MemoryUtil.memAddress(param0), MemoryUtil.memAddress(param1), Integer.toUnsignedLong(param1.remaining()) << 2);
    }

    @NativeType(value="void *")
    public static long memmove(@NativeType(value="void *") LongBuffer param0, @NativeType(value="void const *") LongBuffer param1) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)param0, param1.remaining());
        }
        return LibCString.nmemmove(MemoryUtil.memAddress(param0), MemoryUtil.memAddress(param1), Integer.toUnsignedLong(param1.remaining()) << 3);
    }

    @NativeType(value="void *")
    public static long memmove(@NativeType(value="void *") FloatBuffer param0, @NativeType(value="void const *") FloatBuffer param1) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)param0, param1.remaining());
        }
        return LibCString.nmemmove(MemoryUtil.memAddress(param0), MemoryUtil.memAddress(param1), Integer.toUnsignedLong(param1.remaining()) << 2);
    }

    @NativeType(value="void *")
    public static long memmove(@NativeType(value="void *") DoubleBuffer param0, @NativeType(value="void const *") DoubleBuffer param1) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)param0, param1.remaining());
        }
        return LibCString.nmemmove(MemoryUtil.memAddress(param0), MemoryUtil.memAddress(param1), Integer.toUnsignedLong(param1.remaining()) << 3);
    }

    public static native long nstrlen(long var0);

    @NativeType(value="size_t")
    public static long strlen(@NativeType(value="char const *") ByteBuffer param0) {
        if (Checks.CHECKS) {
            Checks.checkNT1(param0);
        }
        return LibCString.nstrlen(MemoryUtil.memAddress(param0));
    }

    public static native long nstrerror(int var0);

    @Nullable
    @NativeType(value="char *")
    public static String strerror(int param0) {
        long v1 = LibCString.nstrerror(param0);
        return MemoryUtil.memASCIISafe(v1);
    }

    public static native long nmemset(byte[] var0, int var1, long var2);

    @NativeType(value="void *")
    public static long memset(@NativeType(value="void *") byte[] param0, int param1) {
        return LibCString.nmemset(param0, param1, Integer.toUnsignedLong(param0.length) << 0);
    }

    public static native long nmemset(short[] var0, int var1, long var2);

    @NativeType(value="void *")
    public static long memset(@NativeType(value="void *") short[] param0, int param1) {
        return LibCString.nmemset(param0, param1, Integer.toUnsignedLong(param0.length) << 1);
    }

    public static native long nmemset(int[] var0, int var1, long var2);

    @NativeType(value="void *")
    public static long memset(@NativeType(value="void *") int[] param0, int param1) {
        return LibCString.nmemset(param0, param1, Integer.toUnsignedLong(param0.length) << 2);
    }

    public static native long nmemset(long[] var0, int var1, long var2);

    @NativeType(value="void *")
    public static long memset(@NativeType(value="void *") long[] param0, int param1) {
        return LibCString.nmemset(param0, param1, Integer.toUnsignedLong(param0.length) << 3);
    }

    public static native long nmemset(float[] var0, int var1, long var2);

    @NativeType(value="void *")
    public static long memset(@NativeType(value="void *") float[] param0, int param1) {
        return LibCString.nmemset(param0, param1, Integer.toUnsignedLong(param0.length) << 2);
    }

    public static native long nmemset(double[] var0, int var1, long var2);

    @NativeType(value="void *")
    public static long memset(@NativeType(value="void *") double[] param0, int param1) {
        return LibCString.nmemset(param0, param1, Integer.toUnsignedLong(param0.length) << 3);
    }

    public static native long nmemcpy(byte[] var0, byte[] var1, long var2);

    @NativeType(value="void *")
    public static long memcpy(@NativeType(value="void *") byte[] param0, @NativeType(value="void const *") byte[] param1) {
        if (Checks.CHECKS) {
            Checks.check(param0, param1.length);
        }
        return LibCString.nmemcpy(param0, param1, Integer.toUnsignedLong(param1.length) << 0);
    }

    public static native long nmemcpy(short[] var0, short[] var1, long var2);

    @NativeType(value="void *")
    public static long memcpy(@NativeType(value="void *") short[] param0, @NativeType(value="void const *") short[] param1) {
        if (Checks.CHECKS) {
            Checks.check(param0, param1.length);
        }
        return LibCString.nmemcpy(param0, param1, Integer.toUnsignedLong(param1.length) << 1);
    }

    public static native long nmemcpy(int[] var0, int[] var1, long var2);

    @NativeType(value="void *")
    public static long memcpy(@NativeType(value="void *") int[] param0, @NativeType(value="void const *") int[] param1) {
        if (Checks.CHECKS) {
            Checks.check(param0, param1.length);
        }
        return LibCString.nmemcpy(param0, param1, Integer.toUnsignedLong(param1.length) << 2);
    }

    public static native long nmemcpy(long[] var0, long[] var1, long var2);

    @NativeType(value="void *")
    public static long memcpy(@NativeType(value="void *") long[] param0, @NativeType(value="void const *") long[] param1) {
        if (Checks.CHECKS) {
            Checks.check(param0, param1.length);
        }
        return LibCString.nmemcpy(param0, param1, Integer.toUnsignedLong(param1.length) << 3);
    }

    public static native long nmemcpy(float[] var0, float[] var1, long var2);

    @NativeType(value="void *")
    public static long memcpy(@NativeType(value="void *") float[] param0, @NativeType(value="void const *") float[] param1) {
        if (Checks.CHECKS) {
            Checks.check(param0, param1.length);
        }
        return LibCString.nmemcpy(param0, param1, Integer.toUnsignedLong(param1.length) << 2);
    }

    public static native long nmemcpy(double[] var0, double[] var1, long var2);

    @NativeType(value="void *")
    public static long memcpy(@NativeType(value="void *") double[] param0, @NativeType(value="void const *") double[] param1) {
        if (Checks.CHECKS) {
            Checks.check(param0, param1.length);
        }
        return LibCString.nmemcpy(param0, param1, Integer.toUnsignedLong(param1.length) << 3);
    }

    public static native long nmemmove(byte[] var0, byte[] var1, long var2);

    @NativeType(value="void *")
    public static long memmove(@NativeType(value="void *") byte[] param0, @NativeType(value="void const *") byte[] param1) {
        if (Checks.CHECKS) {
            Checks.check(param0, param1.length);
        }
        return LibCString.nmemmove(param0, param1, Integer.toUnsignedLong(param1.length) << 0);
    }

    public static native long nmemmove(short[] var0, short[] var1, long var2);

    @NativeType(value="void *")
    public static long memmove(@NativeType(value="void *") short[] param0, @NativeType(value="void const *") short[] param1) {
        if (Checks.CHECKS) {
            Checks.check(param0, param1.length);
        }
        return LibCString.nmemmove(param0, param1, Integer.toUnsignedLong(param1.length) << 1);
    }

    public static native long nmemmove(int[] var0, int[] var1, long var2);

    @NativeType(value="void *")
    public static long memmove(@NativeType(value="void *") int[] param0, @NativeType(value="void const *") int[] param1) {
        if (Checks.CHECKS) {
            Checks.check(param0, param1.length);
        }
        return LibCString.nmemmove(param0, param1, Integer.toUnsignedLong(param1.length) << 2);
    }

    public static native long nmemmove(long[] var0, long[] var1, long var2);

    @NativeType(value="void *")
    public static long memmove(@NativeType(value="void *") long[] param0, @NativeType(value="void const *") long[] param1) {
        if (Checks.CHECKS) {
            Checks.check(param0, param1.length);
        }
        return LibCString.nmemmove(param0, param1, Integer.toUnsignedLong(param1.length) << 3);
    }

    public static native long nmemmove(float[] var0, float[] var1, long var2);

    @NativeType(value="void *")
    public static long memmove(@NativeType(value="void *") float[] param0, @NativeType(value="void const *") float[] param1) {
        if (Checks.CHECKS) {
            Checks.check(param0, param1.length);
        }
        return LibCString.nmemmove(param0, param1, Integer.toUnsignedLong(param1.length) << 2);
    }

    public static native long nmemmove(double[] var0, double[] var1, long var2);

    @NativeType(value="void *")
    public static long memmove(@NativeType(value="void *") double[] param0, @NativeType(value="void const *") double[] param1) {
        if (Checks.CHECKS) {
            Checks.check(param0, param1.length);
        }
        return LibCString.nmemmove(param0, param1, Integer.toUnsignedLong(param1.length) << 3);
    }

    @NativeType(value="void *")
    public static <T extends CustomBuffer<T>> long memset(@NativeType(value="void *") T param0, @NativeType(value="int") int param1) {
        return LibCString.nmemset(MemoryUtil.memAddress(param0), param1, Integer.toUnsignedLong(param0.remaining()) * (long)param0.sizeof());
    }

    @NativeType(value="void *")
    public static <T extends CustomBuffer<T>> long memcpy(@NativeType(value="void *") T param0, @NativeType(value="void const *") T param1) {
        if (Checks.CHECKS) {
            Checks.check(param1, param0.remaining());
        }
        return LibCString.nmemcpy(MemoryUtil.memAddress(param0), MemoryUtil.memAddress(param1), (long)param1.remaining() * (long)param1.sizeof());
    }

    @NativeType(value="void *")
    public static <T extends CustomBuffer<T>> long memmove(@NativeType(value="void *") T param0, @NativeType(value="void const *") T param1) {
        if (Checks.CHECKS) {
            Checks.check(param1, param0.remaining());
        }
        return LibCString.nmemmove(MemoryUtil.memAddress(param0), MemoryUtil.memAddress(param1), (long)param1.remaining() * (long)param1.sizeof());
    }

    static {
        Library.initialize();
    }
}

