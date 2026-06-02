/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.CLongBuffer;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.CustomBuffer;
import org.lwjgl.system.MemoryUtil;

public final class BufferUtils {
    private BufferUtils() {
    }

    public static ByteBuffer createByteBuffer(int param0) {
        return ByteBuffer.allocateDirect(param0).order(ByteOrder.nativeOrder());
    }

    static int getAllocationSize(int param0, int param1) {
        APIUtil.apiCheckAllocation(param0, APIUtil.apiGetBytes(param0, param1), Integer.MAX_VALUE);
        return param0 << param1;
    }

    public static ShortBuffer createShortBuffer(int param0) {
        return BufferUtils.createByteBuffer(BufferUtils.getAllocationSize(param0, 1)).asShortBuffer();
    }

    public static CharBuffer createCharBuffer(int param0) {
        return BufferUtils.createByteBuffer(BufferUtils.getAllocationSize(param0, 1)).asCharBuffer();
    }

    public static IntBuffer createIntBuffer(int param0) {
        return BufferUtils.createByteBuffer(BufferUtils.getAllocationSize(param0, 2)).asIntBuffer();
    }

    public static LongBuffer createLongBuffer(int param0) {
        return BufferUtils.createByteBuffer(BufferUtils.getAllocationSize(param0, 3)).asLongBuffer();
    }

    public static CLongBuffer createCLongBuffer(int param0) {
        return CLongBuffer.allocateDirect(param0);
    }

    public static FloatBuffer createFloatBuffer(int param0) {
        return BufferUtils.createByteBuffer(BufferUtils.getAllocationSize(param0, 2)).asFloatBuffer();
    }

    public static DoubleBuffer createDoubleBuffer(int param0) {
        return BufferUtils.createByteBuffer(BufferUtils.getAllocationSize(param0, 3)).asDoubleBuffer();
    }

    public static PointerBuffer createPointerBuffer(int param0) {
        return PointerBuffer.allocateDirect(param0);
    }

    public static void zeroBuffer(ByteBuffer param0) {
        MemoryUtil.memSet(param0, 0);
    }

    public static void zeroBuffer(ShortBuffer param0) {
        MemoryUtil.memSet(param0, 0);
    }

    public static void zeroBuffer(CharBuffer param0) {
        MemoryUtil.memSet(param0, 0);
    }

    public static void zeroBuffer(IntBuffer param0) {
        MemoryUtil.memSet(param0, 0);
    }

    public static void zeroBuffer(FloatBuffer param0) {
        MemoryUtil.memSet(param0, 0);
    }

    public static void zeroBuffer(LongBuffer param0) {
        MemoryUtil.memSet(param0, 0);
    }

    public static void zeroBuffer(DoubleBuffer param0) {
        MemoryUtil.memSet(param0, 0);
    }

    public static <T extends CustomBuffer<T>> void zeroBuffer(T param0) {
        MemoryUtil.memSet(param0, 0);
    }
}

