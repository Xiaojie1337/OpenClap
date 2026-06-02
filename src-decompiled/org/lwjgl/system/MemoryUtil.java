/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.Buffer;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.function.LongPredicate;
import javax.annotation.Nullable;
import org.lwjgl.CLongBuffer;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Configuration;
import org.lwjgl.system.CustomBuffer;
import org.lwjgl.system.Library;
import org.lwjgl.system.MathUtil;
import org.lwjgl.system.MemoryManage;
import org.lwjgl.system.MultiReleaseMemCopy;
import org.lwjgl.system.MultiReleaseTextDecoding;
import org.lwjgl.system.Pointer;
import org.lwjgl.system.Struct;
import org.lwjgl.system.jni.JNINativeInterface;
import org.lwjgl.system.libc.LibCString;
import sun.misc.Unsafe;

public final class MemoryUtil {
    public static final long NULL;
    public static final int PAGE_SIZE;
    public static final int CACHE_LINE_SIZE;
    static final int ARRAY_TLC_SIZE;
    static final ThreadLocal<byte[]> ARRAY_TLC_BYTE;
    static final ThreadLocal<char[]> ARRAY_TLC_CHAR;
    static final Unsafe UNSAFE;
    static final ByteOrder NATIVE_ORDER;
    private static final Charset UTF16;
    static final Class<? extends ByteBuffer> BUFFER_BYTE;
    static final Class<? extends ShortBuffer> BUFFER_SHORT;
    static final Class<? extends CharBuffer> BUFFER_CHAR;
    static final Class<? extends IntBuffer> BUFFER_INT;
    static final Class<? extends LongBuffer> BUFFER_LONG;
    static final Class<? extends FloatBuffer> BUFFER_FLOAT;
    static final Class<? extends DoubleBuffer> BUFFER_DOUBLE;
    private static final long MARK;
    private static final long POSITION;
    private static final long LIMIT;
    private static final long CAPACITY;
    private static final long ADDRESS;
    private static final long PARENT_BYTE;
    private static final long PARENT_SHORT;
    private static final long PARENT_CHAR;
    private static final long PARENT_INT;
    private static final long PARENT_LONG;
    private static final long PARENT_FLOAT;
    private static final long PARENT_DOUBLE;
    private static final int FILL_PATTERN_32;
    private static final long FILL_PATTERN_64;
    private static final int MAGIC_CAPACITY;
    private static final int MAGIC_POSITION;

    private MemoryUtil() {
    }

    public static MemoryAllocator getAllocator() {
        return MemoryUtil.getAllocator(false);
    }

    public static MemoryAllocator getAllocator(boolean param0) {
        return param0 ? LazyInit.ALLOCATOR : LazyInit.ALLOCATOR_IMPL;
    }

    public static long nmemAlloc(long param0) {
        return LazyInit.ALLOCATOR.malloc(param0);
    }

    public static long nmemAllocChecked(long param0) {
        long v2 = MemoryUtil.nmemAlloc(param0 != 0L ? param0 : 1L);
        if (Checks.CHECKS && v2 == 0L) {
            throw new OutOfMemoryError();
        }
        return v2;
    }

    private static long getAllocationSize(int param0, int param1) {
        return APIUtil.apiCheckAllocation(param0, Integer.toUnsignedLong(param0) << param1, Pointer.BITS64 ? Long.MAX_VALUE : 0xFFFFFFFFL);
    }

    public static ByteBuffer memAlloc(int param0) {
        return MemoryUtil.wrap(BUFFER_BYTE, MemoryUtil.nmemAllocChecked(param0), param0).order(NATIVE_ORDER);
    }

    public static ShortBuffer memAllocShort(int param0) {
        return MemoryUtil.wrap(BUFFER_SHORT, MemoryUtil.nmemAllocChecked(MemoryUtil.getAllocationSize(param0, 1)), param0);
    }

    public static IntBuffer memAllocInt(int param0) {
        return MemoryUtil.wrap(BUFFER_INT, MemoryUtil.nmemAllocChecked(MemoryUtil.getAllocationSize(param0, 2)), param0);
    }

    public static FloatBuffer memAllocFloat(int param0) {
        return MemoryUtil.wrap(BUFFER_FLOAT, MemoryUtil.nmemAllocChecked(MemoryUtil.getAllocationSize(param0, 2)), param0);
    }

    public static LongBuffer memAllocLong(int param0) {
        return MemoryUtil.wrap(BUFFER_LONG, MemoryUtil.nmemAllocChecked(MemoryUtil.getAllocationSize(param0, 3)), param0);
    }

    public static CLongBuffer memAllocCLong(int param0) {
        return CLongBuffer.create(MemoryUtil.nmemAllocChecked(MemoryUtil.getAllocationSize(param0, Pointer.CLONG_SHIFT)), param0);
    }

    public static DoubleBuffer memAllocDouble(int param0) {
        return MemoryUtil.wrap(BUFFER_DOUBLE, MemoryUtil.nmemAllocChecked(MemoryUtil.getAllocationSize(param0, 3)), param0);
    }

    public static PointerBuffer memAllocPointer(int param0) {
        return PointerBuffer.create(MemoryUtil.nmemAllocChecked(MemoryUtil.getAllocationSize(param0, Pointer.POINTER_SHIFT)), param0);
    }

    public static void nmemFree(long param0) {
        LazyInit.ALLOCATOR.free(param0);
    }

    public static void memFree(@Nullable Buffer param0) {
        if (param0 != null) {
            MemoryUtil.nmemFree(UNSAFE.getLong(param0, ADDRESS));
        }
    }

    public static void memFree(@Nullable CustomBuffer<?> param0) {
        if (param0 != null) {
            MemoryUtil.nmemFree(param0.address);
        }
    }

    public static long nmemCalloc(long param0, long param2) {
        return LazyInit.ALLOCATOR.calloc(param0, param2);
    }

    public static long nmemCallocChecked(long param0, long param2) {
        if (param0 == 0L || param2 == 0L) {
            param0 = 1L;
            param2 = 1L;
        }
        long v4 = MemoryUtil.nmemCalloc(param0, param2);
        if (Checks.CHECKS && v4 == 0L) {
            throw new OutOfMemoryError();
        }
        return v4;
    }

    public static ByteBuffer memCalloc(int param0, int param1) {
        return MemoryUtil.wrap(BUFFER_BYTE, MemoryUtil.nmemCallocChecked(param0, param1), param0 * param1).order(NATIVE_ORDER);
    }

    public static ByteBuffer memCalloc(int param0) {
        return MemoryUtil.wrap(BUFFER_BYTE, MemoryUtil.nmemCallocChecked(param0, 1L), param0).order(NATIVE_ORDER);
    }

    public static ShortBuffer memCallocShort(int param0) {
        return MemoryUtil.wrap(BUFFER_SHORT, MemoryUtil.nmemCallocChecked(param0, 2L), param0);
    }

    public static IntBuffer memCallocInt(int param0) {
        return MemoryUtil.wrap(BUFFER_INT, MemoryUtil.nmemCallocChecked(param0, 4L), param0);
    }

    public static FloatBuffer memCallocFloat(int param0) {
        return MemoryUtil.wrap(BUFFER_FLOAT, MemoryUtil.nmemCallocChecked(param0, 4L), param0);
    }

    public static LongBuffer memCallocLong(int param0) {
        return MemoryUtil.wrap(BUFFER_LONG, MemoryUtil.nmemCallocChecked(param0, 8L), param0);
    }

    public static CLongBuffer memCallocCLong(int param0) {
        return CLongBuffer.create(MemoryUtil.nmemCallocChecked(param0, Pointer.CLONG_SIZE), param0);
    }

    public static DoubleBuffer memCallocDouble(int param0) {
        return MemoryUtil.wrap(BUFFER_DOUBLE, MemoryUtil.nmemCallocChecked(param0, 8L), param0);
    }

    public static PointerBuffer memCallocPointer(int param0) {
        return PointerBuffer.create(MemoryUtil.nmemCallocChecked(param0, Pointer.POINTER_SIZE), param0);
    }

    public static long nmemRealloc(long param0, long param2) {
        return LazyInit.ALLOCATOR.realloc(param0, param2);
    }

    public static long nmemReallocChecked(long param0, long param2) {
        long v4 = MemoryUtil.nmemRealloc(param0, param2 != 0L ? param2 : 1L);
        if (Checks.CHECKS && v4 == 0L) {
            throw new OutOfMemoryError();
        }
        return v4;
    }

    private static <T extends Buffer> T realloc(@Nullable T param0, T param1, int param2) {
        if (param0 != null) {
            param1.position(Math.min(param0.position(), param2));
        }
        return param1;
    }

    public static ByteBuffer memRealloc(@Nullable ByteBuffer param0, int param1) {
        return MemoryUtil.realloc(param0, MemoryUtil.memByteBuffer(MemoryUtil.nmemReallocChecked(param0 == null ? 0L : UNSAFE.getLong(param0, ADDRESS), param1), param1), param1);
    }

    public static ShortBuffer memRealloc(@Nullable ShortBuffer param0, int param1) {
        return MemoryUtil.realloc(param0, MemoryUtil.memShortBuffer(MemoryUtil.nmemReallocChecked(param0 == null ? 0L : UNSAFE.getLong(param0, ADDRESS), MemoryUtil.getAllocationSize(param1, 1)), param1), param1);
    }

    public static IntBuffer memRealloc(@Nullable IntBuffer param0, int param1) {
        return MemoryUtil.realloc(param0, MemoryUtil.memIntBuffer(MemoryUtil.nmemReallocChecked(param0 == null ? 0L : UNSAFE.getLong(param0, ADDRESS), MemoryUtil.getAllocationSize(param1, 2)), param1), param1);
    }

    public static LongBuffer memRealloc(@Nullable LongBuffer param0, int param1) {
        return MemoryUtil.realloc(param0, MemoryUtil.memLongBuffer(MemoryUtil.nmemReallocChecked(param0 == null ? 0L : UNSAFE.getLong(param0, ADDRESS), MemoryUtil.getAllocationSize(param1, 3)), param1), param1);
    }

    public static CLongBuffer memRealloc(@Nullable CLongBuffer param0, int param1) {
        CLongBuffer v2 = MemoryUtil.memCLongBuffer(MemoryUtil.nmemReallocChecked(param0 == null ? 0L : param0.address, MemoryUtil.getAllocationSize(param1, Pointer.CLONG_SIZE)), param1);
        if (param0 != null) {
            v2.position(Math.min(param0.position(), param1));
        }
        return v2;
    }

    public static FloatBuffer memRealloc(@Nullable FloatBuffer param0, int param1) {
        return MemoryUtil.realloc(param0, MemoryUtil.memFloatBuffer(MemoryUtil.nmemReallocChecked(param0 == null ? 0L : UNSAFE.getLong(param0, ADDRESS), MemoryUtil.getAllocationSize(param1, 2)), param1), param1);
    }

    public static DoubleBuffer memRealloc(@Nullable DoubleBuffer param0, int param1) {
        return MemoryUtil.realloc(param0, MemoryUtil.memDoubleBuffer(MemoryUtil.nmemReallocChecked(param0 == null ? 0L : UNSAFE.getLong(param0, ADDRESS), MemoryUtil.getAllocationSize(param1, 3)), param1), param1);
    }

    public static PointerBuffer memRealloc(@Nullable PointerBuffer param0, int param1) {
        PointerBuffer v2 = MemoryUtil.memPointerBuffer(MemoryUtil.nmemReallocChecked(param0 == null ? 0L : param0.address, MemoryUtil.getAllocationSize(param1, Pointer.POINTER_SHIFT)), param1);
        if (param0 != null) {
            v2.position(Math.min(param0.position(), param1));
        }
        return v2;
    }

    public static long nmemAlignedAlloc(long param0, long param2) {
        return LazyInit.ALLOCATOR.aligned_alloc(param0, param2);
    }

    public static long nmemAlignedAllocChecked(long param0, long param2) {
        long v4 = MemoryUtil.nmemAlignedAlloc(param0, param2 != 0L ? param2 : 1L);
        if (Checks.CHECKS && v4 == 0L) {
            throw new OutOfMemoryError();
        }
        return v4;
    }

    public static ByteBuffer memAlignedAlloc(int param0, int param1) {
        return MemoryUtil.wrap(BUFFER_BYTE, MemoryUtil.nmemAlignedAllocChecked(param0, param1), param1).order(NATIVE_ORDER);
    }

    public static void nmemAlignedFree(long param0) {
        LazyInit.ALLOCATOR.aligned_free(param0);
    }

    public static void memAlignedFree(@Nullable ByteBuffer param0) {
        if (param0 != null) {
            MemoryUtil.nmemAlignedFree(UNSAFE.getLong(param0, ADDRESS));
        }
    }

    public static void memReport(MemoryAllocationReport param0) {
        MemoryManage.DebugAllocator.report(param0);
    }

    public static void memReport(MemoryAllocationReport param0, MemoryAllocationReport.Aggregate param1, boolean param2) {
        MemoryManage.DebugAllocator.report(param0, param1, param2);
    }

    public static long memAddress0(Buffer param0) {
        return UNSAFE.getLong(param0, ADDRESS);
    }

    public static long memAddress(ByteBuffer param0) {
        return (long)param0.position() + MemoryUtil.memAddress0(param0);
    }

    public static long memAddress(ByteBuffer param0, int param1) {
        Objects.requireNonNull(param0);
        return MemoryUtil.memAddress0(param0) + Integer.toUnsignedLong(param1);
    }

    private static long address(int param0, int param1, long param2) {
        return param2 + (((long)param0 & 0xFFFFFFFFL) << param1);
    }

    public static long memAddress(ShortBuffer param0) {
        return MemoryUtil.address(param0.position(), 1, MemoryUtil.memAddress0(param0));
    }

    public static long memAddress(ShortBuffer param0, int param1) {
        Objects.requireNonNull(param0);
        return MemoryUtil.address(param1, 1, MemoryUtil.memAddress0(param0));
    }

    public static long memAddress(CharBuffer param0) {
        return MemoryUtil.address(param0.position(), 1, MemoryUtil.memAddress0(param0));
    }

    public static long memAddress(CharBuffer param0, int param1) {
        Objects.requireNonNull(param0);
        return MemoryUtil.address(param1, 1, MemoryUtil.memAddress0(param0));
    }

    public static long memAddress(IntBuffer param0) {
        return MemoryUtil.address(param0.position(), 2, MemoryUtil.memAddress0(param0));
    }

    public static long memAddress(IntBuffer param0, int param1) {
        Objects.requireNonNull(param0);
        return MemoryUtil.address(param1, 2, MemoryUtil.memAddress0(param0));
    }

    public static long memAddress(FloatBuffer param0) {
        return MemoryUtil.address(param0.position(), 2, MemoryUtil.memAddress0(param0));
    }

    public static long memAddress(FloatBuffer param0, int param1) {
        Objects.requireNonNull(param0);
        return MemoryUtil.address(param1, 2, MemoryUtil.memAddress0(param0));
    }

    public static long memAddress(LongBuffer param0) {
        return MemoryUtil.address(param0.position(), 3, MemoryUtil.memAddress0(param0));
    }

    public static long memAddress(LongBuffer param0, int param1) {
        Objects.requireNonNull(param0);
        return MemoryUtil.address(param1, 3, MemoryUtil.memAddress0(param0));
    }

    public static long memAddress(DoubleBuffer param0) {
        return MemoryUtil.address(param0.position(), 3, MemoryUtil.memAddress0(param0));
    }

    public static long memAddress(DoubleBuffer param0, int param1) {
        Objects.requireNonNull(param0);
        return MemoryUtil.address(param1, 3, MemoryUtil.memAddress0(param0));
    }

    public static long memAddress(Buffer param0) {
        int v1 = param0 instanceof ByteBuffer ? 0 : (param0 instanceof ShortBuffer || param0 instanceof CharBuffer ? 1 : (param0 instanceof IntBuffer || param0 instanceof FloatBuffer ? 2 : 3));
        return MemoryUtil.address(param0.position(), v1, MemoryUtil.memAddress0(param0));
    }

    public static long memAddress(CustomBuffer<?> param0) {
        return param0.address();
    }

    public static long memAddress(CustomBuffer<?> param0, int param1) {
        return param0.address(param1);
    }

    public static long memAddressSafe(@Nullable ByteBuffer param0) {
        return param0 == null ? 0L : MemoryUtil.memAddress0(param0) + (long)param0.position();
    }

    public static long memAddressSafe(@Nullable ShortBuffer param0) {
        return param0 == null ? 0L : MemoryUtil.address(param0.position(), 1, MemoryUtil.memAddress0(param0));
    }

    public static long memAddressSafe(@Nullable CharBuffer param0) {
        return param0 == null ? 0L : MemoryUtil.address(param0.position(), 1, MemoryUtil.memAddress0(param0));
    }

    public static long memAddressSafe(@Nullable IntBuffer param0) {
        return param0 == null ? 0L : MemoryUtil.address(param0.position(), 2, MemoryUtil.memAddress0(param0));
    }

    public static long memAddressSafe(@Nullable FloatBuffer param0) {
        return param0 == null ? 0L : MemoryUtil.address(param0.position(), 2, MemoryUtil.memAddress0(param0));
    }

    public static long memAddressSafe(@Nullable LongBuffer param0) {
        return param0 == null ? 0L : MemoryUtil.address(param0.position(), 3, MemoryUtil.memAddress0(param0));
    }

    public static long memAddressSafe(@Nullable DoubleBuffer param0) {
        return param0 == null ? 0L : MemoryUtil.address(param0.position(), 3, MemoryUtil.memAddress0(param0));
    }

    public static long memAddressSafe(@Nullable Pointer param0) {
        return param0 == null ? 0L : param0.address();
    }

    public static ByteBuffer memByteBuffer(long param0, int param2) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return MemoryUtil.wrap(BUFFER_BYTE, param0, param2).order(NATIVE_ORDER);
    }

    @Nullable
    public static ByteBuffer memByteBufferSafe(long param0, int param2) {
        return param0 == 0L ? null : MemoryUtil.wrap(BUFFER_BYTE, param0, param2).order(NATIVE_ORDER);
    }

    public static ByteBuffer memByteBuffer(ShortBuffer param0) {
        if (Checks.CHECKS && 0x3FFFFFFF < param0.remaining()) {
            throw new IllegalArgumentException("The source buffer range is too wide");
        }
        return MemoryUtil.wrap(BUFFER_BYTE, MemoryUtil.memAddress(param0), param0.remaining() << 1).order(NATIVE_ORDER);
    }

    public static ByteBuffer memByteBuffer(CharBuffer param0) {
        if (Checks.CHECKS && 0x3FFFFFFF < param0.remaining()) {
            throw new IllegalArgumentException("The source buffer range is too wide");
        }
        return MemoryUtil.wrap(BUFFER_BYTE, MemoryUtil.memAddress(param0), param0.remaining() << 1).order(NATIVE_ORDER);
    }

    public static ByteBuffer memByteBuffer(IntBuffer param0) {
        if (Checks.CHECKS && 0x1FFFFFFF < param0.remaining()) {
            throw new IllegalArgumentException("The source buffer range is too wide");
        }
        return MemoryUtil.wrap(BUFFER_BYTE, MemoryUtil.memAddress(param0), param0.remaining() << 2).order(NATIVE_ORDER);
    }

    public static ByteBuffer memByteBuffer(LongBuffer param0) {
        if (Checks.CHECKS && 0xFFFFFFF < param0.remaining()) {
            throw new IllegalArgumentException("The source buffer range is too wide");
        }
        return MemoryUtil.wrap(BUFFER_BYTE, MemoryUtil.memAddress(param0), param0.remaining() << 3).order(NATIVE_ORDER);
    }

    public static ByteBuffer memByteBuffer(FloatBuffer param0) {
        if (Checks.CHECKS && 0x1FFFFFFF < param0.remaining()) {
            throw new IllegalArgumentException("The source buffer range is too wide");
        }
        return MemoryUtil.wrap(BUFFER_BYTE, MemoryUtil.memAddress(param0), param0.remaining() << 2).order(NATIVE_ORDER);
    }

    public static ByteBuffer memByteBuffer(DoubleBuffer param0) {
        if (Checks.CHECKS && 0xFFFFFFF < param0.remaining()) {
            throw new IllegalArgumentException("The source buffer range is too wide");
        }
        return MemoryUtil.wrap(BUFFER_BYTE, MemoryUtil.memAddress(param0), param0.remaining() << 3).order(NATIVE_ORDER);
    }

    public static ByteBuffer memByteBuffer(CustomBuffer<?> param0) {
        if (Checks.CHECKS && Integer.MAX_VALUE / param0.sizeof() < param0.remaining()) {
            throw new IllegalArgumentException("The source buffer range is too wide");
        }
        return MemoryUtil.wrap(BUFFER_BYTE, MemoryUtil.memAddress(param0), param0.remaining() * param0.sizeof()).order(NATIVE_ORDER);
    }

    public static <T extends Struct<T>> ByteBuffer memByteBuffer(T param0) {
        return MemoryUtil.wrap(BUFFER_BYTE, param0.address, param0.sizeof()).order(NATIVE_ORDER);
    }

    public static ShortBuffer memShortBuffer(long param0, int param2) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return MemoryUtil.wrap(BUFFER_SHORT, param0, param2);
    }

    @Nullable
    public static ShortBuffer memShortBufferSafe(long param0, int param2) {
        return param0 == 0L ? null : MemoryUtil.wrap(BUFFER_SHORT, param0, param2);
    }

    public static CharBuffer memCharBuffer(long param0, int param2) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return MemoryUtil.wrap(BUFFER_CHAR, param0, param2);
    }

    @Nullable
    public static CharBuffer memCharBufferSafe(long param0, int param2) {
        return param0 == 0L ? null : MemoryUtil.wrap(BUFFER_CHAR, param0, param2);
    }

    public static IntBuffer memIntBuffer(long param0, int param2) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return MemoryUtil.wrap(BUFFER_INT, param0, param2);
    }

    @Nullable
    public static IntBuffer memIntBufferSafe(long param0, int param2) {
        return param0 == 0L ? null : MemoryUtil.wrap(BUFFER_INT, param0, param2);
    }

    public static LongBuffer memLongBuffer(long param0, int param2) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return MemoryUtil.wrap(BUFFER_LONG, param0, param2);
    }

    @Nullable
    public static LongBuffer memLongBufferSafe(long param0, int param2) {
        return param0 == 0L ? null : MemoryUtil.wrap(BUFFER_LONG, param0, param2);
    }

    public static CLongBuffer memCLongBuffer(long param0, int param2) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return CLongBuffer.create(param0, param2);
    }

    @Nullable
    public static CLongBuffer memCLongBufferSafe(long param0, int param2) {
        return param0 == 0L ? null : CLongBuffer.create(param0, param2);
    }

    public static FloatBuffer memFloatBuffer(long param0, int param2) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return MemoryUtil.wrap(BUFFER_FLOAT, param0, param2);
    }

    @Nullable
    public static FloatBuffer memFloatBufferSafe(long param0, int param2) {
        return param0 == 0L ? null : MemoryUtil.wrap(BUFFER_FLOAT, param0, param2);
    }

    public static DoubleBuffer memDoubleBuffer(long param0, int param2) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return MemoryUtil.wrap(BUFFER_DOUBLE, param0, param2);
    }

    @Nullable
    public static DoubleBuffer memDoubleBufferSafe(long param0, int param2) {
        return param0 == 0L ? null : MemoryUtil.wrap(BUFFER_DOUBLE, param0, param2);
    }

    public static PointerBuffer memPointerBuffer(long param0, int param2) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return PointerBuffer.create(param0, param2);
    }

    @Nullable
    public static PointerBuffer memPointerBufferSafe(long param0, int param2) {
        return param0 == 0L ? null : PointerBuffer.create(param0, param2);
    }

    public static ByteBuffer memDuplicate(ByteBuffer param0) {
        Object object;
        ByteBuffer v1;
        try {
            v1 = (ByteBuffer)UNSAFE.allocateInstance(BUFFER_BYTE);
            UNSAFE.putLong(v1, ADDRESS, UNSAFE.getLong(param0, ADDRESS));
            UNSAFE.putInt(v1, MARK, UNSAFE.getInt(param0, MARK));
            UNSAFE.putInt(v1, POSITION, UNSAFE.getInt(param0, POSITION));
            UNSAFE.putInt(v1, LIMIT, UNSAFE.getInt(param0, LIMIT));
            UNSAFE.putInt(v1, CAPACITY, UNSAFE.getInt(param0, CAPACITY));
            Object v2 = UNSAFE.getObject(param0, PARENT_BYTE);
            object = v2 == null ? param0 : v2;
        }
        catch (InstantiationException v2) {
            throw new UnsupportedOperationException(v2);
        }
        UNSAFE.putObject(v1, PARENT_BYTE, object);
        return v1.order(param0.order());
    }

    public static ShortBuffer memDuplicate(ShortBuffer param0) {
        return MemoryUtil.duplicate(BUFFER_SHORT, param0, PARENT_SHORT);
    }

    public static CharBuffer memDuplicate(CharBuffer param0) {
        return MemoryUtil.duplicate(BUFFER_CHAR, param0, PARENT_CHAR);
    }

    public static IntBuffer memDuplicate(IntBuffer param0) {
        return MemoryUtil.duplicate(BUFFER_INT, param0, PARENT_INT);
    }

    public static LongBuffer memDuplicate(LongBuffer param0) {
        return MemoryUtil.duplicate(BUFFER_LONG, param0, PARENT_LONG);
    }

    public static FloatBuffer memDuplicate(FloatBuffer param0) {
        return MemoryUtil.duplicate(BUFFER_FLOAT, param0, PARENT_FLOAT);
    }

    public static DoubleBuffer memDuplicate(DoubleBuffer param0) {
        return MemoryUtil.duplicate(BUFFER_DOUBLE, param0, PARENT_DOUBLE);
    }

    public static ByteBuffer memSlice(ByteBuffer param0) {
        return MemoryUtil.slice(param0, MemoryUtil.memAddress0(param0) + (long)param0.position(), param0.remaining());
    }

    public static ShortBuffer memSlice(ShortBuffer param0) {
        return MemoryUtil.slice(BUFFER_SHORT, param0, MemoryUtil.address(param0.position(), 1, MemoryUtil.memAddress0(param0)), param0.remaining(), PARENT_SHORT);
    }

    public static CharBuffer memSlice(CharBuffer param0) {
        return MemoryUtil.slice(BUFFER_CHAR, param0, MemoryUtil.address(param0.position(), 1, MemoryUtil.memAddress0(param0)), param0.remaining(), PARENT_CHAR);
    }

    public static IntBuffer memSlice(IntBuffer param0) {
        return MemoryUtil.slice(BUFFER_INT, param0, MemoryUtil.address(param0.position(), 2, MemoryUtil.memAddress0(param0)), param0.remaining(), PARENT_INT);
    }

    public static LongBuffer memSlice(LongBuffer param0) {
        return MemoryUtil.slice(BUFFER_LONG, param0, MemoryUtil.address(param0.position(), 3, MemoryUtil.memAddress0(param0)), param0.remaining(), PARENT_LONG);
    }

    public static FloatBuffer memSlice(FloatBuffer param0) {
        return MemoryUtil.slice(BUFFER_FLOAT, param0, MemoryUtil.address(param0.position(), 2, MemoryUtil.memAddress0(param0)), param0.remaining(), PARENT_FLOAT);
    }

    public static DoubleBuffer memSlice(DoubleBuffer param0) {
        return MemoryUtil.slice(BUFFER_DOUBLE, param0, MemoryUtil.address(param0.position(), 3, MemoryUtil.memAddress0(param0)), param0.remaining(), PARENT_DOUBLE);
    }

    public static ByteBuffer memSlice(ByteBuffer param0, int param1, int param2) {
        int v3 = param0.position() + param1;
        if (param1 < 0 || param0.limit() < v3) {
            throw new IllegalArgumentException();
        }
        if (param2 < 0 || param0.capacity() - v3 < param2) {
            throw new IllegalArgumentException();
        }
        return MemoryUtil.slice(param0, MemoryUtil.memAddress0(param0) + (long)v3, param2);
    }

    public static ShortBuffer memSlice(ShortBuffer param0, int param1, int param2) {
        int v3 = param0.position() + param1;
        if (param1 < 0 || param0.limit() < v3) {
            throw new IllegalArgumentException();
        }
        if (param2 < 0 || param0.capacity() - v3 < param2) {
            throw new IllegalArgumentException();
        }
        return MemoryUtil.slice(BUFFER_SHORT, param0, MemoryUtil.address(v3, 1, MemoryUtil.memAddress0(param0)), param2, PARENT_SHORT);
    }

    public static CharBuffer memSlice(CharBuffer param0, int param1, int param2) {
        int v3 = param0.position() + param1;
        if (param1 < 0 || param0.limit() < v3) {
            throw new IllegalArgumentException();
        }
        if (param2 < 0 || param0.capacity() - v3 < param2) {
            throw new IllegalArgumentException();
        }
        return MemoryUtil.slice(BUFFER_CHAR, param0, MemoryUtil.address(v3, 1, MemoryUtil.memAddress0(param0)), param2, PARENT_CHAR);
    }

    public static IntBuffer memSlice(IntBuffer param0, int param1, int param2) {
        int v3 = param0.position() + param1;
        if (param1 < 0 || param0.limit() < v3) {
            throw new IllegalArgumentException();
        }
        if (param2 < 0 || param0.capacity() - v3 < param2) {
            throw new IllegalArgumentException();
        }
        return MemoryUtil.slice(BUFFER_INT, param0, MemoryUtil.address(v3, 2, MemoryUtil.memAddress0(param0)), param2, PARENT_INT);
    }

    public static LongBuffer memSlice(LongBuffer param0, int param1, int param2) {
        int v3 = param0.position() + param1;
        if (param1 < 0 || param0.limit() < v3) {
            throw new IllegalArgumentException();
        }
        if (param2 < 0 || param0.capacity() - v3 < param2) {
            throw new IllegalArgumentException();
        }
        return MemoryUtil.slice(BUFFER_LONG, param0, MemoryUtil.address(v3, 3, MemoryUtil.memAddress0(param0)), param2, PARENT_LONG);
    }

    public static FloatBuffer memSlice(FloatBuffer param0, int param1, int param2) {
        int v3 = param0.position() + param1;
        if (param1 < 0 || param0.limit() < v3) {
            throw new IllegalArgumentException();
        }
        if (param2 < 0 || param0.capacity() - v3 < param2) {
            throw new IllegalArgumentException();
        }
        return MemoryUtil.slice(BUFFER_FLOAT, param0, MemoryUtil.address(v3, 2, MemoryUtil.memAddress0(param0)), param2, PARENT_FLOAT);
    }

    public static DoubleBuffer memSlice(DoubleBuffer param0, int param1, int param2) {
        int v3 = param0.position() + param1;
        if (param1 < 0 || param0.limit() < v3) {
            throw new IllegalArgumentException();
        }
        if (param2 < 0 || param0.capacity() - v3 < param2) {
            throw new IllegalArgumentException();
        }
        return MemoryUtil.slice(BUFFER_DOUBLE, param0, MemoryUtil.address(v3, 3, MemoryUtil.memAddress0(param0)), param2, PARENT_DOUBLE);
    }

    public static <T extends CustomBuffer<T>> T memSlice(T param0, int param1, int param2) {
        return param0.slice(param1, param2);
    }

    public static void memSet(ByteBuffer param0, int param1) {
        MemoryUtil.memSet(MemoryUtil.memAddress(param0), param1, param0.remaining());
    }

    public static void memSet(ShortBuffer param0, int param1) {
        MemoryUtil.memSet(MemoryUtil.memAddress(param0), param1, APIUtil.apiGetBytes(param0.remaining(), 1));
    }

    public static void memSet(CharBuffer param0, int param1) {
        MemoryUtil.memSet(MemoryUtil.memAddress(param0), param1, APIUtil.apiGetBytes(param0.remaining(), 1));
    }

    public static void memSet(IntBuffer param0, int param1) {
        MemoryUtil.memSet(MemoryUtil.memAddress(param0), param1, APIUtil.apiGetBytes(param0.remaining(), 2));
    }

    public static void memSet(LongBuffer param0, int param1) {
        MemoryUtil.memSet(MemoryUtil.memAddress(param0), param1, APIUtil.apiGetBytes(param0.remaining(), 3));
    }

    public static void memSet(FloatBuffer param0, int param1) {
        MemoryUtil.memSet(MemoryUtil.memAddress(param0), param1, APIUtil.apiGetBytes(param0.remaining(), 2));
    }

    public static void memSet(DoubleBuffer param0, int param1) {
        MemoryUtil.memSet(MemoryUtil.memAddress(param0), param1, APIUtil.apiGetBytes(param0.remaining(), 3));
    }

    public static <T extends CustomBuffer<T>> void memSet(T param0, int param1) {
        MemoryUtil.memSet(MemoryUtil.memAddress(param0), param1, Integer.toUnsignedLong(param0.remaining()) * (long)param0.sizeof());
    }

    public static <T extends Struct<T>> void memSet(T param0, int param1) {
        MemoryUtil.memSet(param0.address, param1, param0.sizeof());
    }

    public static void memCopy(ByteBuffer param0, ByteBuffer param1) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)param1, param0.remaining());
        }
        MultiReleaseMemCopy.copy(MemoryUtil.memAddress(param0), MemoryUtil.memAddress(param1), param0.remaining());
    }

    public static void memCopy(ShortBuffer param0, ShortBuffer param1) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)param1, param0.remaining());
        }
        MultiReleaseMemCopy.copy(MemoryUtil.memAddress(param0), MemoryUtil.memAddress(param1), APIUtil.apiGetBytes(param0.remaining(), 1));
    }

    public static void memCopy(CharBuffer param0, CharBuffer param1) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)param1, param0.remaining());
        }
        MultiReleaseMemCopy.copy(MemoryUtil.memAddress(param0), MemoryUtil.memAddress(param1), APIUtil.apiGetBytes(param0.remaining(), 1));
    }

    public static void memCopy(IntBuffer param0, IntBuffer param1) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)param1, param0.remaining());
        }
        MultiReleaseMemCopy.copy(MemoryUtil.memAddress(param0), MemoryUtil.memAddress(param1), APIUtil.apiGetBytes(param0.remaining(), 2));
    }

    public static void memCopy(LongBuffer param0, LongBuffer param1) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)param1, param0.remaining());
        }
        MultiReleaseMemCopy.copy(MemoryUtil.memAddress(param0), MemoryUtil.memAddress(param1), APIUtil.apiGetBytes(param0.remaining(), 3));
    }

    public static void memCopy(FloatBuffer param0, FloatBuffer param1) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)param1, param0.remaining());
        }
        MultiReleaseMemCopy.copy(MemoryUtil.memAddress(param0), MemoryUtil.memAddress(param1), APIUtil.apiGetBytes(param0.remaining(), 2));
    }

    public static void memCopy(DoubleBuffer param0, DoubleBuffer param1) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)param1, param0.remaining());
        }
        MultiReleaseMemCopy.copy(MemoryUtil.memAddress(param0), MemoryUtil.memAddress(param1), APIUtil.apiGetBytes(param0.remaining(), 3));
    }

    public static <T extends CustomBuffer<T>> void memCopy(T param0, T param1) {
        if (Checks.CHECKS) {
            Checks.check(param1, param0.remaining());
        }
        MultiReleaseMemCopy.copy(MemoryUtil.memAddress(param0), MemoryUtil.memAddress(param1), Integer.toUnsignedLong(param0.remaining()) * (long)param0.sizeof());
    }

    public static <T extends Struct<T>> void memCopy(T param0, T param1) {
        MultiReleaseMemCopy.copy(param0.address, param1.address, param0.sizeof());
    }

    public static void memSet(long param0, int param2, long param3) {
        if (Checks.DEBUG && (param0 == 0L || param3 < 0L)) {
            throw new IllegalArgumentException();
        }
        if (param3 < 256L) {
            int v5 = (int)param0;
            if (Pointer.BITS64) {
                if ((v5 & 7) == 0) {
                    MemoryUtil.memSet64(param0, param2, (int)param3 & 0xFF);
                    return;
                }
            } else if ((v5 & 3) == 0) {
                MemoryUtil.memSet32(v5, param2, (int)param3 & 0xFF);
                return;
            }
        }
        LibCString.nmemset(param0, param2, param3);
    }

    private static void memSet64(long param0, int param2, int param3) {
        int v7;
        int v4 = param3 & 0xFFFFFFF8;
        long v5 = (long)(param2 & 0xFF) * 0x101010101010101L;
        for (v7 = 0; v7 < v4; v7 += 8) {
            UNSAFE.putLong(null, param0 + (long)v7, v5);
        }
        v7 = (byte)(param2 & 0xFF);
        for (int v8 = v4; v8 < param3; ++v8) {
            UNSAFE.putByte(null, param0 + (long)v8, (byte)v7);
        }
    }

    private static void memSet32(int param0, int param1, int param2) {
        int v5;
        int v3 = param2 & 0xFFFFFFFC;
        int v4 = (param1 & 0xFF) * 0x1010101;
        for (v5 = 0; v5 < v3; v5 += 4) {
            UNSAFE.putInt(null, (long)(param0 + v5) & 0xFFFFFFFFL, v4);
        }
        v5 = (byte)(param1 & 0xFF);
        for (int v6 = v3; v6 < param2; ++v6) {
            UNSAFE.putByte(null, (long)(param0 + v6) & 0xFFFFFFFFL, (byte)v5);
        }
    }

    public static void memCopy(long param0, long param2, long param4) {
        if (Checks.DEBUG && (param0 == 0L || param2 == 0L || param4 < 0L)) {
            throw new IllegalArgumentException();
        }
        MultiReleaseMemCopy.copy(param0, param2, param4);
    }

    static void memCopyAligned64(long param0, long param2, int param4) {
        int v6;
        int v5 = param4 & 0xFFFFFFF8;
        for (v6 = 0; v6 < v5; v6 += 8) {
            UNSAFE.putLong(null, param2 + (long)v6, UNSAFE.getLong(null, param0 + (long)v6));
        }
        for (v6 = v5; v6 < param4; ++v6) {
            UNSAFE.putByte(null, param2 + (long)v6, UNSAFE.getByte(null, param0 + (long)v6));
        }
    }

    static void memCopyAligned32(int param0, int param1, int param2) {
        int v4;
        int v3 = param2 & 0xFFFFFFFC;
        for (v4 = 0; v4 < v3; v4 += 4) {
            UNSAFE.putInt(null, (long)(param1 + v4) & 0xFFFFFFFFL, UNSAFE.getInt(null, (long)(param0 + v4) & 0xFFFFFFFFL));
        }
        for (v4 = v3; v4 < param2; ++v4) {
            UNSAFE.putByte(null, (long)(param1 + v4) & 0xFFFFFFFFL, UNSAFE.getByte(null, (long)(param0 + v4) & 0xFFFFFFFFL));
        }
    }

    public static boolean memGetBoolean(long param0) {
        return UNSAFE.getByte(null, param0) != 0;
    }

    public static byte memGetByte(long param0) {
        return UNSAFE.getByte(null, param0);
    }

    public static short memGetShort(long param0) {
        return UNSAFE.getShort(null, param0);
    }

    public static int memGetInt(long param0) {
        return UNSAFE.getInt(null, param0);
    }

    public static long memGetLong(long param0) {
        return UNSAFE.getLong(null, param0);
    }

    public static float memGetFloat(long param0) {
        return UNSAFE.getFloat(null, param0);
    }

    public static double memGetDouble(long param0) {
        return UNSAFE.getDouble(null, param0);
    }

    public static long memGetCLong(long param0) {
        return Pointer.CLONG_SIZE == 8 ? UNSAFE.getLong(null, param0) : (long)UNSAFE.getInt(null, param0);
    }

    public static long memGetAddress(long param0) {
        return Pointer.BITS64 ? UNSAFE.getLong(null, param0) : (long)UNSAFE.getInt(null, param0) & 0xFFFFFFFFL;
    }

    public static void memPutByte(long param0, byte param2) {
        UNSAFE.putByte(null, param0, param2);
    }

    public static void memPutShort(long param0, short param2) {
        UNSAFE.putShort(null, param0, param2);
    }

    public static void memPutInt(long param0, int param2) {
        UNSAFE.putInt(null, param0, param2);
    }

    public static void memPutLong(long param0, long param2) {
        UNSAFE.putLong(null, param0, param2);
    }

    public static void memPutFloat(long param0, float param2) {
        UNSAFE.putFloat(null, param0, param2);
    }

    public static void memPutDouble(long param0, double param2) {
        UNSAFE.putDouble(null, param0, param2);
    }

    public static void memPutCLong(long param0, long param2) {
        if (Pointer.CLONG_SIZE == 8) {
            UNSAFE.putLong(null, param0, param2);
        } else {
            UNSAFE.putInt(null, param0, (int)param2);
        }
    }

    public static void memPutAddress(long param0, long param2) {
        if (Pointer.BITS64) {
            UNSAFE.putLong(null, param0, param2);
        } else {
            UNSAFE.putInt(null, param0, (int)param2);
        }
    }

    public static native <T> T memGlobalRefToObject(long var0);

    private static int write8(long param0, int param2, int param3) {
        UNSAFE.putByte(null, param0 + Integer.toUnsignedLong(param2), (byte)param3);
        return param2 + 1;
    }

    private static int write8Safe(long param0, int param2, int param3, int param4) {
        if (param2 == param3) {
            throw new BufferOverflowException();
        }
        UNSAFE.putByte(null, param0 + Integer.toUnsignedLong(param2), (byte)param4);
        return param2 + 1;
    }

    private static int write16(long param0, int param2, char param3) {
        UNSAFE.putShort(null, param0 + Integer.toUnsignedLong(param2), (short)param3);
        return param2 + 2;
    }

    public static ByteBuffer memASCII(CharSequence param0) {
        return MemoryUtil.memASCII(param0, true);
    }

    @Nullable
    public static ByteBuffer memASCIISafe(@Nullable CharSequence param0) {
        return param0 == null ? null : MemoryUtil.memASCII(param0, true);
    }

    public static ByteBuffer memASCII(CharSequence param0, boolean param1) {
        int v2 = MemoryUtil.memLengthASCII(param0, param1);
        long v3 = MemoryUtil.nmemAlloc(v2);
        if (Checks.CHECKS && v3 == 0L) {
            throw new OutOfMemoryError();
        }
        MemoryUtil.encodeASCIIUnsafe(param0, param1, v3);
        return MemoryUtil.wrap(BUFFER_BYTE, v3, v2).order(NATIVE_ORDER);
    }

    @Nullable
    public static ByteBuffer memASCIISafe(@Nullable CharSequence param0, boolean param1) {
        return param0 == null ? null : MemoryUtil.memASCII(param0, param1);
    }

    public static int memASCII(CharSequence param0, boolean param1, ByteBuffer param2) {
        if (param2.remaining() < MemoryUtil.memLengthASCII(param0, param1)) {
            throw new BufferOverflowException();
        }
        long v3 = MemoryUtil.memAddress(param2);
        return MemoryUtil.encodeASCIIUnsafe(param0, param1, v3);
    }

    public static int memASCII(CharSequence param0, boolean param1, ByteBuffer param2, int param3) {
        if (param2.capacity() - param3 < MemoryUtil.memLengthASCII(param0, param1)) {
            throw new BufferOverflowException();
        }
        return MemoryUtil.encodeASCIIUnsafe(param0, param1, MemoryUtil.memAddress(param2, param3));
    }

    static int encodeASCIIUnsafe(CharSequence param0, boolean param1, long param2) {
        int v4 = 0;
        int v5 = param0.length();
        while (v4 < v5) {
            v4 = MemoryUtil.write8(param2, v4, param0.charAt(v4));
        }
        if (param1) {
            v4 = MemoryUtil.write8(param2, v4, 0);
        }
        return v4;
    }

    public static int memLengthASCII(CharSequence param0, boolean param1) {
        int v2 = param0.length() + (param1 ? 1 : 0);
        if (v2 < 0) {
            throw new BufferOverflowException();
        }
        return v2;
    }

    public static ByteBuffer memUTF8(CharSequence param0) {
        return MemoryUtil.memUTF8(param0, true);
    }

    @Nullable
    public static ByteBuffer memUTF8Safe(@Nullable CharSequence param0) {
        return param0 == null ? null : MemoryUtil.memUTF8(param0, true);
    }

    public static ByteBuffer memUTF8(CharSequence param0, boolean param1) {
        int v2 = MemoryUtil.memLengthUTF8(param0, param1);
        long v3 = MemoryUtil.nmemAlloc(v2);
        if (Checks.CHECKS && v3 == 0L) {
            throw new OutOfMemoryError();
        }
        MemoryUtil.encodeUTF8Unsafe(param0, param1, v3);
        return MemoryUtil.wrap(BUFFER_BYTE, v3, v2).order(NATIVE_ORDER);
    }

    @Nullable
    public static ByteBuffer memUTF8Safe(@Nullable CharSequence param0, boolean param1) {
        return param0 == null ? null : MemoryUtil.memUTF8(param0, param1);
    }

    public static int memUTF8(CharSequence param0, boolean param1, ByteBuffer param2) {
        if (param2.remaining() < MemoryUtil.memLengthASCII(param0, param1)) {
            throw new BufferOverflowException();
        }
        return MemoryUtil.encodeUTF8Safe(param0, param1, MemoryUtil.memAddress(param2), param2.remaining());
    }

    public static int memUTF8(CharSequence param0, boolean param1, ByteBuffer param2, int param3) {
        if (param2.capacity() - param3 < MemoryUtil.memLengthASCII(param0, param1)) {
            throw new BufferOverflowException();
        }
        return MemoryUtil.encodeUTF8Safe(param0, param1, MemoryUtil.memAddress(param2, param3), param2.capacity() - param3);
    }

    static int encodeUTF8Unsafe(CharSequence param0, boolean param1, long param2) {
        int v4 = 0;
        int v5 = 0;
        int v6 = param0.length();
        while (v5 < v6) {
            int v7;
            if ((v7 = param0.charAt(v5++)) < 128) {
                v4 = MemoryUtil.write8(param2, v4, v7);
                continue;
            }
            int v8 = v7;
            if (v7 < 2048) {
                v4 = MemoryUtil.write8(param2, v4, 0xC0 | v8 >> 6);
            } else {
                if (!Character.isHighSurrogate((char)v7)) {
                    v4 = MemoryUtil.write8(param2, v4, 0xE0 | v8 >> 12);
                } else {
                    v8 = Character.toCodePoint((char)v7, param0.charAt(v5++));
                    v4 = MemoryUtil.write8(param2, v4, 0xF0 | v8 >> 18);
                    v4 = MemoryUtil.write8(param2, v4, 0x80 | v8 >> 12 & 0x3F);
                }
                v4 = MemoryUtil.write8(param2, v4, 0x80 | v8 >> 6 & 0x3F);
            }
            v4 = MemoryUtil.write8(param2, v4, 0x80 | v8 & 0x3F);
        }
        if (param1) {
            v4 = MemoryUtil.write8(param2, v4, 0);
        }
        return v4;
    }

    static int encodeUTF8Safe(CharSequence param0, boolean param1, long param2, int param4) {
        int v8;
        int v6;
        int v5 = 0;
        int v7 = param0.length();
        for (v6 = 0; v6 < v7 && 128 > (v8 = param0.charAt(v6)); ++v6) {
            v5 = MemoryUtil.write8(param2, v5, v8);
        }
        while (v6 < v7) {
            if ((v8 = param0.charAt(v6++)) < 128) {
                v5 = MemoryUtil.write8Safe(param2, v5, param4, v8);
                continue;
            }
            int v9 = v8;
            if (v8 < 2048) {
                v5 = MemoryUtil.write8Safe(param2, v5, param4, 0xC0 | v9 >> 6);
            } else {
                if (!Character.isHighSurrogate((char)v8)) {
                    v5 = MemoryUtil.write8Safe(param2, v5, param4, 0xE0 | v9 >> 12);
                } else {
                    v9 = Character.toCodePoint((char)v8, param0.charAt(v6++));
                    v5 = MemoryUtil.write8Safe(param2, v5, param4, 0xF0 | v9 >> 18);
                    v5 = MemoryUtil.write8Safe(param2, v5, param4, 0x80 | v9 >> 12 & 0x3F);
                }
                v5 = MemoryUtil.write8Safe(param2, v5, param4, 0x80 | v9 >> 6 & 0x3F);
            }
            v5 = MemoryUtil.write8Safe(param2, v5, param4, 0x80 | v9 & 0x3F);
        }
        if (param1) {
            v5 = MemoryUtil.write8Safe(param2, v5, param4, 0);
        }
        return v5;
    }

    public static int memLengthUTF8(CharSequence param0, boolean param1) {
        int v2 = param0.length();
        int v3 = v2 + (param1 ? 1 : 0);
        for (int v4 = 0; v4 < v2; ++v4) {
            char v5 = param0.charAt(v4);
            if (v5 < '\u0080') continue;
            if (v5 < '\u0800') {
                v3 += 127 - v5 >>> 31;
            } else {
                v3 += 2;
                if (Character.isHighSurrogate(v5)) {
                    ++v4;
                }
            }
            if (v3 >= 0) continue;
            throw new BufferOverflowException();
        }
        if (v3 < 0) {
            throw new BufferOverflowException();
        }
        return v3;
    }

    public static ByteBuffer memUTF16(CharSequence param0) {
        return MemoryUtil.memUTF16(param0, true);
    }

    @Nullable
    public static ByteBuffer memUTF16Safe(@Nullable CharSequence param0) {
        return param0 == null ? null : MemoryUtil.memUTF16(param0, true);
    }

    public static ByteBuffer memUTF16(CharSequence param0, boolean param1) {
        int v2 = MemoryUtil.memLengthUTF16(param0, param1);
        long v3 = MemoryUtil.nmemAlloc(v2);
        if (Checks.CHECKS && v3 == 0L) {
            throw new OutOfMemoryError();
        }
        MemoryUtil.encodeUTF16Unsafe(param0, param1, v3);
        return MemoryUtil.wrap(BUFFER_BYTE, v3, v2).order(NATIVE_ORDER);
    }

    @Nullable
    public static ByteBuffer memUTF16Safe(@Nullable CharSequence param0, boolean param1) {
        return param0 == null ? null : MemoryUtil.memUTF16(param0, param1);
    }

    public static int memUTF16(CharSequence param0, boolean param1, ByteBuffer param2) {
        if (param2.remaining() < MemoryUtil.memLengthUTF16(param0, param1)) {
            throw new BufferOverflowException();
        }
        long v3 = MemoryUtil.memAddress(param2);
        return MemoryUtil.encodeUTF16Unsafe(param0, param1, v3);
    }

    public static int memUTF16(CharSequence param0, boolean param1, ByteBuffer param2, int param3) {
        if (param2.capacity() - param3 < MemoryUtil.memLengthUTF16(param0, param1)) {
            throw new BufferOverflowException();
        }
        long v4 = MemoryUtil.memAddress(param2, param3);
        return MemoryUtil.encodeUTF16Unsafe(param0, param1, v4);
    }

    static int encodeUTF16Unsafe(CharSequence param0, boolean param1, long param2) {
        int v4 = 0;
        int v5 = 0;
        int v6 = param0.length();
        while (v5 < v6) {
            v4 = MemoryUtil.write16(param2, v4, param0.charAt(v5++));
        }
        if (param1) {
            v4 = MemoryUtil.write16(param2, v4, '\u0000');
        }
        return v4;
    }

    public static int memLengthUTF16(CharSequence param0, boolean param1) {
        int v2 = param0.length() + (param1 ? 1 : 0);
        if (v2 < 0 || 0x3FFFFFFF < v2) {
            throw new BufferOverflowException();
        }
        return v2 << 1;
    }

    private static int memLengthNT1(long param0, int param2) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return Pointer.BITS64 ? MemoryUtil.strlen64NT1(param0, param2) : MemoryUtil.strlen32NT1(param0, param2);
    }

    private static int strlen64NT1(long param0, int param2) {
        int v3;
        if (8 <= param2) {
            int v4 = (int)param0 & 7;
            if (v4 != 0) {
                int v5 = 8 - v4;
                for (v3 = 0; v3 < v5; ++v3) {
                    if (UNSAFE.getByte(null, param0 + (long)v3) != 0) continue;
                    return v3;
                }
            }
            while (v3 <= param2 - 8 && !MathUtil.mathHasZeroByte(UNSAFE.getLong(null, param0 + (long)v3))) {
                v3 += 8;
            }
        }
        while (v3 < param2 && UNSAFE.getByte(null, param0 + (long)v3) != 0) {
            ++v3;
        }
        return v3;
    }

    private static int strlen32NT1(long param0, int param2) {
        int v3;
        if (4 <= param2) {
            int v4 = (int)param0 & 3;
            if (v4 != 0) {
                int v5 = 4 - v4;
                for (v3 = 0; v3 < v5; ++v3) {
                    if (UNSAFE.getByte(null, param0 + (long)v3) != 0) continue;
                    return v3;
                }
            }
            while (v3 <= param2 - 4 && !MathUtil.mathHasZeroByte(UNSAFE.getInt(null, param0 + (long)v3))) {
                v3 += 4;
            }
        }
        while (v3 < param2 && UNSAFE.getByte(null, param0 + (long)v3) != 0) {
            ++v3;
        }
        return v3;
    }

    public static int memLengthNT1(ByteBuffer param0) {
        return MemoryUtil.memLengthNT1(MemoryUtil.memAddress(param0), param0.remaining());
    }

    private static int memLengthNT2(long param0, int param2) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return Pointer.BITS64 ? MemoryUtil.strlen64NT2(param0, param2) : MemoryUtil.strlen32NT2((int)param0, param2);
    }

    private static int strlen64NT2(long param0, int param2) {
        int v3;
        if (8 <= param2) {
            int v4 = (int)param0 & 7;
            if (v4 != 0) {
                int v5 = 8 - v4;
                for (v3 = 0; v3 < v5; v3 += 2) {
                    if (UNSAFE.getShort(null, param0 + (long)v3) != 0) continue;
                    return v3;
                }
            }
            while (v3 <= param2 - 8 && !MathUtil.mathHasZeroShort(UNSAFE.getLong(null, param0 + (long)v3))) {
                v3 += 8;
            }
        }
        while (v3 < param2 && UNSAFE.getShort(null, param0 + (long)v3) != 0) {
            v3 += 2;
        }
        return v3;
    }

    private static int strlen32NT2(long param0, int param2) {
        int v3;
        if (4 <= param2) {
            int v4 = (int)param0 & 3;
            if (v4 != 0) {
                int v5 = 4 - v4;
                for (v3 = 0; v3 < v5; v3 += 2) {
                    if (UNSAFE.getShort(null, param0 + (long)v3) != 0) continue;
                    return v3;
                }
            }
            while (v3 <= param2 - 4 && !MathUtil.mathHasZeroShort(UNSAFE.getInt(null, param0 + (long)v3))) {
                v3 += 4;
            }
        }
        while (v3 < param2 && UNSAFE.getShort(null, param0 + (long)v3) != 0) {
            v3 += 2;
        }
        return v3;
    }

    public static int memLengthNT2(ByteBuffer param0) {
        return MemoryUtil.memLengthNT2(MemoryUtil.memAddress(param0), param0.remaining());
    }

    public static ByteBuffer memByteBufferNT1(long param0) {
        return MemoryUtil.memByteBuffer(param0, MemoryUtil.memLengthNT1(param0, Integer.MAX_VALUE));
    }

    public static ByteBuffer memByteBufferNT1(long param0, int param2) {
        return MemoryUtil.memByteBuffer(param0, MemoryUtil.memLengthNT1(param0, param2));
    }

    @Nullable
    public static ByteBuffer memByteBufferNT1Safe(long param0) {
        return param0 == 0L ? null : MemoryUtil.memByteBuffer(param0, MemoryUtil.memLengthNT1(param0, Integer.MAX_VALUE));
    }

    @Nullable
    public static ByteBuffer memByteBufferNT1Safe(long param0, int param2) {
        return param0 == 0L ? null : MemoryUtil.memByteBuffer(param0, MemoryUtil.memLengthNT1(param0, param2));
    }

    public static ByteBuffer memByteBufferNT2(long param0) {
        return MemoryUtil.memByteBufferNT2(param0, 0x7FFFFFFE);
    }

    public static ByteBuffer memByteBufferNT2(long param0, int param2) {
        if (Checks.DEBUG && (param2 & 1) != 0) {
            throw new IllegalArgumentException("The maximum length must be an even number.");
        }
        return MemoryUtil.memByteBuffer(param0, MemoryUtil.memLengthNT2(param0, param2));
    }

    @Nullable
    public static ByteBuffer memByteBufferNT2Safe(long param0) {
        return param0 == 0L ? null : MemoryUtil.memByteBufferNT2(param0, 0x7FFFFFFE);
    }

    @Nullable
    public static ByteBuffer memByteBufferNT2Safe(long param0, int param2) {
        return param0 == 0L ? null : MemoryUtil.memByteBufferNT2(param0, param2);
    }

    public static String memASCII(long param0) {
        return MemoryUtil.memASCII(param0, MemoryUtil.memLengthNT1(param0, Integer.MAX_VALUE));
    }

    public static String memASCII(long param0, int param2) {
        if (param2 <= 0) {
            return "";
        }
        byte[] v3 = param2 <= ARRAY_TLC_SIZE ? ARRAY_TLC_BYTE.get() : new byte[param2];
        MemoryUtil.memByteBuffer(param0, param2).get(v3, 0, param2);
        return new String(v3, 0, 0, param2);
    }

    public static String memASCII(ByteBuffer param0) {
        return MemoryUtil.memASCII(MemoryUtil.memAddress(param0), param0.remaining());
    }

    @Nullable
    public static String memASCIISafe(long param0) {
        return param0 == 0L ? null : MemoryUtil.memASCII(param0, MemoryUtil.memLengthNT1(param0, Integer.MAX_VALUE));
    }

    @Nullable
    public static String memASCIISafe(long param0, int param2) {
        return param0 == 0L ? null : MemoryUtil.memASCII(param0, param2);
    }

    @Nullable
    public static String memASCIISafe(@Nullable ByteBuffer param0) {
        return param0 == null ? null : MemoryUtil.memASCII(MemoryUtil.memAddress(param0), param0.remaining());
    }

    public static String memASCII(ByteBuffer param0, int param1) {
        return MemoryUtil.memASCII(MemoryUtil.memAddress(param0), param1);
    }

    public static String memASCII(ByteBuffer param0, int param1, int param2) {
        return MemoryUtil.memASCII(MemoryUtil.memAddress(param0, param2), param1);
    }

    public static String memUTF8(long param0) {
        return MultiReleaseTextDecoding.decodeUTF8(param0, MemoryUtil.memLengthNT1(param0, Integer.MAX_VALUE));
    }

    public static String memUTF8(long param0, int param2) {
        return MultiReleaseTextDecoding.decodeUTF8(param0, param2);
    }

    public static String memUTF8(ByteBuffer param0) {
        return MultiReleaseTextDecoding.decodeUTF8(MemoryUtil.memAddress(param0), param0.remaining());
    }

    @Nullable
    public static String memUTF8Safe(long param0) {
        return param0 == 0L ? null : MultiReleaseTextDecoding.decodeUTF8(param0, MemoryUtil.memLengthNT1(param0, Integer.MAX_VALUE));
    }

    @Nullable
    public static String memUTF8Safe(long param0, int param2) {
        return param0 == 0L ? null : MultiReleaseTextDecoding.decodeUTF8(param0, param2);
    }

    @Nullable
    public static String memUTF8Safe(@Nullable ByteBuffer param0) {
        return param0 == null ? null : MultiReleaseTextDecoding.decodeUTF8(MemoryUtil.memAddress(param0), param0.remaining());
    }

    public static String memUTF8(ByteBuffer param0, int param1) {
        return MultiReleaseTextDecoding.decodeUTF8(MemoryUtil.memAddress(param0), param1);
    }

    public static String memUTF8(ByteBuffer param0, int param1, int param2) {
        return MultiReleaseTextDecoding.decodeUTF8(MemoryUtil.memAddress(param0, param2), param1);
    }

    public static String memUTF16(long param0) {
        return MemoryUtil.memUTF16(param0, MemoryUtil.memLengthNT2(param0, 0x7FFFFFFE) >> 1);
    }

    public static String memUTF16(long param0, int param2) {
        if (param2 <= 0) {
            return "";
        }
        if (Checks.DEBUG) {
            int v3 = param2 << 1;
            byte[] v4 = v3 <= ARRAY_TLC_SIZE ? ARRAY_TLC_BYTE.get() : new byte[v3];
            MemoryUtil.memByteBuffer(param0, v3).get(v4, 0, v3);
            return new String(v4, 0, v3, UTF16);
        }
        char[] v3 = param2 <= ARRAY_TLC_SIZE ? ARRAY_TLC_CHAR.get() : new char[param2];
        MemoryUtil.memCharBuffer(param0, param2).get(v3, 0, param2);
        return new String(v3, 0, param2);
    }

    public static String memUTF16(ByteBuffer param0) {
        return MemoryUtil.memUTF16(MemoryUtil.memAddress(param0), param0.remaining() >> 1);
    }

    @Nullable
    public static String memUTF16Safe(long param0) {
        return param0 == 0L ? null : MemoryUtil.memUTF16(param0, MemoryUtil.memLengthNT2(param0, 0x7FFFFFFE) >> 1);
    }

    @Nullable
    public static String memUTF16Safe(long param0, int param2) {
        return param0 == 0L ? null : MemoryUtil.memUTF16(param0, param2);
    }

    @Nullable
    public static String memUTF16Safe(@Nullable ByteBuffer param0) {
        return param0 == null ? null : MemoryUtil.memUTF16(MemoryUtil.memAddress(param0), param0.remaining() >> 1);
    }

    public static String memUTF16(ByteBuffer param0, int param1) {
        return MemoryUtil.memUTF16(MemoryUtil.memAddress(param0), param1);
    }

    public static String memUTF16(ByteBuffer param0, int param1, int param2) {
        return MemoryUtil.memUTF16(MemoryUtil.memAddress(param0, param2), param1);
    }

    private static Unsafe getUnsafeInstance() {
        for (Field v4 : Unsafe.class.getDeclaredFields()) {
            int v5;
            if (!v4.getType().equals(Unsafe.class) || !Modifier.isStatic(v5 = v4.getModifiers()) || !Modifier.isFinal(v5)) continue;
            try {
                v4.setAccessible(true);
                return (Unsafe)v4.get(null);
            }
            catch (Exception exception) {
                break;
            }
        }
        throw new UnsupportedOperationException("LWJGL requires sun.misc.Unsafe to be available.");
    }

    private static long getFieldOffset(Class<?> param0, Class<?> param1, LongPredicate param2) {
        for (Class<?> v3 = param0; v3 != Object.class; v3 = v3.getSuperclass()) {
            Field[] v4;
            for (Field v8 : v4 = v3.getDeclaredFields()) {
                long v9;
                if (!v8.getType().isAssignableFrom(param1) || Modifier.isStatic(v8.getModifiers()) || v8.isSynthetic() || !param2.test(v9 = UNSAFE.objectFieldOffset(v8))) continue;
                return v9;
            }
        }
        throw new UnsupportedOperationException("Failed to find field offset in class.");
    }

    private static long getFieldOffsetInt(Object param0, int param1) {
        return MemoryUtil.getFieldOffset(param0.getClass(), Integer.TYPE, param2 -> UNSAFE.getInt(param0, param2) == param1);
    }

    private static long getFieldOffsetObject(Object param0, Object param1) {
        return MemoryUtil.getFieldOffset(param0.getClass(), param1.getClass(), param2 -> UNSAFE.getObject(param0, param2) == param1);
    }

    private static long getAddressOffset() {
        long v0 = 0xDEADBEEF8BADF00DL & (Pointer.BITS32 ? 0xFFFFFFFFL : -1L);
        ByteBuffer v2 = Objects.requireNonNull(JNINativeInterface.NewDirectByteBuffer(v0, 0L));
        return MemoryUtil.getFieldOffset(v2.getClass(), Long.TYPE, param3 -> UNSAFE.getLong(v2, param3) == v0);
    }

    private static long getMarkOffset() {
        ByteBuffer v0 = Objects.requireNonNull(JNINativeInterface.NewDirectByteBuffer(1L, 0L));
        return MemoryUtil.getFieldOffsetInt(v0, -1);
    }

    private static long getPositionOffset() {
        ByteBuffer v0 = Objects.requireNonNull(JNINativeInterface.NewDirectByteBuffer(-1L, 219540062L));
        v0.position(16435934);
        return MemoryUtil.getFieldOffsetInt(v0, 16435934);
    }

    private static long getLimitOffset() {
        ByteBuffer v0 = Objects.requireNonNull(JNINativeInterface.NewDirectByteBuffer(-1L, 219540062L));
        v0.limit(16435934);
        return MemoryUtil.getFieldOffsetInt(v0, 16435934);
    }

    private static long getCapacityOffset() {
        ByteBuffer v0 = Objects.requireNonNull(JNINativeInterface.NewDirectByteBuffer(-1L, 219540062L));
        v0.limit(0);
        return MemoryUtil.getFieldOffsetInt(v0, 219540062);
    }

    static <T extends Buffer> T wrap(Class<? extends T> param0, long param1, int param3) {
        Buffer v4;
        try {
            v4 = (Buffer)UNSAFE.allocateInstance(param0);
            UNSAFE.putLong(v4, ADDRESS, param1);
            UNSAFE.putInt(v4, MARK, -1);
            UNSAFE.putInt(v4, LIMIT, param3);
            UNSAFE.putInt(v4, CAPACITY, param3);
        }
        catch (InstantiationException v5) {
            throw new UnsupportedOperationException(v5);
        }
        return (T)v4;
    }

    static ByteBuffer slice(ByteBuffer param0, long param1, int param3) {
        Object object;
        ByteBuffer v4;
        try {
            v4 = (ByteBuffer)UNSAFE.allocateInstance(BUFFER_BYTE);
            UNSAFE.putLong(v4, ADDRESS, param1);
            UNSAFE.putInt(v4, MARK, -1);
            UNSAFE.putInt(v4, LIMIT, param3);
            UNSAFE.putInt(v4, CAPACITY, param3);
            Object v5 = UNSAFE.getObject(param0, PARENT_BYTE);
            object = v5 == null ? param0 : v5;
        }
        catch (InstantiationException v5) {
            throw new UnsupportedOperationException(v5);
        }
        UNSAFE.putObject(v4, PARENT_BYTE, object);
        return v4.order(param0.order());
    }

    static <T extends Buffer> T slice(Class<? extends T> param0, T param1, long param2, int param4, long param5) {
        Buffer v7;
        try {
            v7 = (Buffer)UNSAFE.allocateInstance(param0);
            UNSAFE.putLong(v7, ADDRESS, param2);
            UNSAFE.putInt(v7, MARK, -1);
            UNSAFE.putInt(v7, LIMIT, param4);
            UNSAFE.putInt(v7, CAPACITY, param4);
            UNSAFE.putObject(v7, param5, UNSAFE.getObject(param1, param5));
        }
        catch (InstantiationException v8) {
            throw new UnsupportedOperationException(v8);
        }
        return (T)v7;
    }

    static <T extends Buffer> T duplicate(Class<? extends T> param0, T param1, long param2) {
        Buffer v4;
        try {
            v4 = (Buffer)UNSAFE.allocateInstance(param0);
            UNSAFE.putLong(v4, ADDRESS, UNSAFE.getLong(param1, ADDRESS));
            UNSAFE.putInt(v4, MARK, UNSAFE.getInt(param1, MARK));
            UNSAFE.putInt(v4, POSITION, UNSAFE.getInt(param1, POSITION));
            UNSAFE.putInt(v4, LIMIT, UNSAFE.getInt(param1, LIMIT));
            UNSAFE.putInt(v4, CAPACITY, UNSAFE.getInt(param1, CAPACITY));
            UNSAFE.putObject(v4, param2, UNSAFE.getObject(param1, param2));
        }
        catch (InstantiationException v5) {
            throw new UnsupportedOperationException(v5);
        }
        return (T)v4;
    }

    static {
        MAGIC_POSITION = 16435934;
        MAGIC_CAPACITY = 219540062;
        NULL = 0L;
        ARRAY_TLC_SIZE = Configuration.ARRAY_TLC_SIZE.get(8192);
        ARRAY_TLC_BYTE = ThreadLocal.withInitial(() -> new byte[ARRAY_TLC_SIZE]);
        ARRAY_TLC_CHAR = ThreadLocal.withInitial(() -> new char[ARRAY_TLC_SIZE]);
        NATIVE_ORDER = ByteOrder.nativeOrder();
        UTF16 = NATIVE_ORDER == ByteOrder.LITTLE_ENDIAN ? StandardCharsets.UTF_16LE : StandardCharsets.UTF_16BE;
        Library.initialize();
        ByteBuffer v0 = ByteBuffer.allocateDirect(0).order(NATIVE_ORDER);
        BUFFER_BYTE = v0.getClass();
        BUFFER_SHORT = v0.asShortBuffer().getClass();
        BUFFER_CHAR = v0.asCharBuffer().getClass();
        BUFFER_INT = v0.asIntBuffer().getClass();
        BUFFER_LONG = v0.asLongBuffer().getClass();
        BUFFER_FLOAT = v0.asFloatBuffer().getClass();
        BUFFER_DOUBLE = v0.asDoubleBuffer().getClass();
        UNSAFE = MemoryUtil.getUnsafeInstance();
        try {
            MARK = MemoryUtil.getMarkOffset();
            POSITION = MemoryUtil.getPositionOffset();
            LIMIT = MemoryUtil.getLimitOffset();
            CAPACITY = MemoryUtil.getCapacityOffset();
            ADDRESS = MemoryUtil.getAddressOffset();
            PARENT_BYTE = MemoryUtil.getFieldOffsetObject(v0.duplicate().order(v0.order()), v0);
            PARENT_SHORT = MemoryUtil.getFieldOffsetObject(v0.asShortBuffer(), v0);
            PARENT_CHAR = MemoryUtil.getFieldOffsetObject(v0.asCharBuffer(), v0);
            PARENT_INT = MemoryUtil.getFieldOffsetObject(v0.asIntBuffer(), v0);
            PARENT_LONG = MemoryUtil.getFieldOffsetObject(v0.asLongBuffer(), v0);
            PARENT_FLOAT = MemoryUtil.getFieldOffsetObject(v0.asFloatBuffer(), v0);
            PARENT_DOUBLE = MemoryUtil.getFieldOffsetObject(v0.asDoubleBuffer(), v0);
            PAGE_SIZE = UNSAFE.pageSize();
            CACHE_LINE_SIZE = 64;
            FILL_PATTERN_32 = 0x1010101;
            FILL_PATTERN_64 = 0x101010101010101L;
            return;
        }
        catch (Throwable v1) {
            throw new UnsupportedOperationException(v1);
        }
    }

    public static interface MemoryAllocationReport {
        public void invoke(long var1, long var3, long var5, @Nullable String var7, StackTraceElement ... var8);

        public static enum Aggregate {
            ALL,
            GROUP_BY_METHOD,
            GROUP_BY_STACKTRACE;

        }
    }

    public static interface MemoryAllocator {
        public long getMalloc();

        public long getCalloc();

        public long getRealloc();

        public long getFree();

        public long getAlignedAlloc();

        public long getAlignedFree();

        public long malloc(long var1);

        public long calloc(long var1, long var3);

        public long realloc(long var1, long var3);

        public void free(long var1);

        public long aligned_alloc(long var1, long var3);

        public void aligned_free(long var1);
    }

    static final class LazyInit {
        static final MemoryAllocator ALLOCATOR_IMPL;
        static final MemoryAllocator ALLOCATOR;

        private LazyInit() {
        }

        static {
            boolean v0 = Configuration.DEBUG_MEMORY_ALLOCATOR.get(false);
            ALLOCATOR_IMPL = MemoryManage.getInstance();
            ALLOCATOR = v0 ? new MemoryManage.DebugAllocator(ALLOCATOR_IMPL) : ALLOCATOR_IMPL;
            APIUtil.apiLog("MemoryUtil allocator: " + ALLOCATOR.getClass().getSimpleName());
            if (v0 && !Configuration.DEBUG_MEMORY_ALLOCATOR_FAST.get(false).booleanValue()) {
                APIUtil.apiLogMore("Reminder: enable Configuration.DEBUG_MEMORY_ALLOCATOR_FAST for low overhead allocation tracking.");
            }
        }
    }
}

