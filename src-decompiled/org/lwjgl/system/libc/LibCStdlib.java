/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.libc;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import javax.annotation.Nullable;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.Library;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class LibCStdlib {
    protected LibCStdlib() {
        throw new UnsupportedOperationException();
    }

    public static native long nmalloc(long var0);

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer malloc(@NativeType(value="size_t") long param0) {
        long v2 = LibCStdlib.nmalloc(param0);
        return MemoryUtil.memByteBufferSafe(v2, (int)param0);
    }

    public static native long ncalloc(long var0, long var2);

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer calloc(@NativeType(value="size_t") long param0, @NativeType(value="size_t") long param2) {
        long v4 = LibCStdlib.ncalloc(param0, param2);
        return MemoryUtil.memByteBufferSafe(v4, (int)param0 * (int)param2);
    }

    public static native long nrealloc(long var0, long var2);

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer realloc(@Nullable @NativeType(value="void *") ByteBuffer param0, @NativeType(value="size_t") long param1) {
        long v3 = LibCStdlib.nrealloc(MemoryUtil.memAddressSafe(param0), param1);
        return MemoryUtil.memByteBufferSafe(v3, (int)param1);
    }

    public static native void nfree(long var0);

    public static void free(@Nullable @NativeType(value="void *") ByteBuffer param0) {
        LibCStdlib.nfree(MemoryUtil.memAddressSafe(param0));
    }

    public static void free(@Nullable @NativeType(value="void *") ShortBuffer param0) {
        LibCStdlib.nfree(MemoryUtil.memAddressSafe(param0));
    }

    public static void free(@Nullable @NativeType(value="void *") IntBuffer param0) {
        LibCStdlib.nfree(MemoryUtil.memAddressSafe(param0));
    }

    public static void free(@Nullable @NativeType(value="void *") LongBuffer param0) {
        LibCStdlib.nfree(MemoryUtil.memAddressSafe(param0));
    }

    public static void free(@Nullable @NativeType(value="void *") FloatBuffer param0) {
        LibCStdlib.nfree(MemoryUtil.memAddressSafe(param0));
    }

    public static void free(@Nullable @NativeType(value="void *") DoubleBuffer param0) {
        LibCStdlib.nfree(MemoryUtil.memAddressSafe(param0));
    }

    public static void free(@Nullable @NativeType(value="void *") PointerBuffer param0) {
        LibCStdlib.nfree(MemoryUtil.memAddressSafe(param0));
    }

    public static native long naligned_alloc(long var0, long var2);

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer aligned_alloc(@NativeType(value="size_t") long param0, @NativeType(value="size_t") long param2) {
        long v4 = LibCStdlib.naligned_alloc(param0, param2);
        return MemoryUtil.memByteBufferSafe(v4, (int)param2);
    }

    public static native void naligned_free(long var0);

    public static void aligned_free(@Nullable @NativeType(value="void *") ByteBuffer param0) {
        LibCStdlib.naligned_free(MemoryUtil.memAddressSafe(param0));
    }

    public static void aligned_free(@Nullable @NativeType(value="void *") ShortBuffer param0) {
        LibCStdlib.naligned_free(MemoryUtil.memAddressSafe(param0));
    }

    public static void aligned_free(@Nullable @NativeType(value="void *") IntBuffer param0) {
        LibCStdlib.naligned_free(MemoryUtil.memAddressSafe(param0));
    }

    public static void aligned_free(@Nullable @NativeType(value="void *") LongBuffer param0) {
        LibCStdlib.naligned_free(MemoryUtil.memAddressSafe(param0));
    }

    public static void aligned_free(@Nullable @NativeType(value="void *") FloatBuffer param0) {
        LibCStdlib.naligned_free(MemoryUtil.memAddressSafe(param0));
    }

    public static void aligned_free(@Nullable @NativeType(value="void *") DoubleBuffer param0) {
        LibCStdlib.naligned_free(MemoryUtil.memAddressSafe(param0));
    }

    public static void aligned_free(@Nullable @NativeType(value="void *") PointerBuffer param0) {
        LibCStdlib.naligned_free(MemoryUtil.memAddressSafe(param0));
    }

    static {
        Library.initialize();
    }
}

