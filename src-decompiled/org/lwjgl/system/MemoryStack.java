/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.Arrays;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.CLongBuffer;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Configuration;
import org.lwjgl.system.CustomBuffer;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.Pointer;
import org.lwjgl.system.StackWalkUtil;

public class MemoryStack
extends Pointer.Default
implements AutoCloseable {
    private static final int DEFAULT_STACK_SIZE;
    private static final int DEFAULT_STACK_FRAMES;
    private static final ThreadLocal<MemoryStack> TLS;
    @Nullable
    private final ByteBuffer container;
    private final int size;
    private int pointer;
    private int[] frames;
    protected int frameIndex;

    protected MemoryStack(@Nullable ByteBuffer param1, long param2, int param4) {
        super(param2);
        this.container = param1;
        this.size = param4;
        this.pointer = param4;
        this.frames = new int[8];
    }

    public static MemoryStack create() {
        return MemoryStack.create(DEFAULT_STACK_SIZE);
    }

    public static MemoryStack create(int param0) {
        return MemoryStack.create(BufferUtils.createByteBuffer(param0));
    }

    public static MemoryStack create(ByteBuffer param0) {
        long v1 = MemoryUtil.memAddress(param0);
        int v3 = param0.remaining();
        return Configuration.DEBUG_STACK.get(false) != false ? new DebugMemoryStack(param0, v1, v3) : new MemoryStack(param0, v1, v3);
    }

    public static MemoryStack ncreate(long param0, int param2) {
        return Configuration.DEBUG_STACK.get(false) != false ? new DebugMemoryStack(null, param0, param2) : new MemoryStack(null, param0, param2);
    }

    public MemoryStack push() {
        if (this.frameIndex == this.frames.length) {
            this.frameOverflow();
        }
        this.frames[this.frameIndex++] = this.pointer;
        return this;
    }

    private void frameOverflow() {
        if (Checks.DEBUG) {
            APIUtil.apiLog("[WARNING] Out of frame stack space (" + this.frames.length + ") in thread: " + Thread.currentThread());
        }
        this.frames = Arrays.copyOf(this.frames, this.frames.length * 3 / 2);
    }

    public MemoryStack pop() {
        this.pointer = this.frames[--this.frameIndex];
        return this;
    }

    @Override
    public void close() {
        this.pop();
    }

    public long getAddress() {
        return this.address;
    }

    public int getSize() {
        return this.size;
    }

    public int getFrameIndex() {
        return this.frameIndex;
    }

    public long getPointerAddress() {
        return this.address + ((long)this.pointer & 0xFFFFFFFFL);
    }

    public int getPointer() {
        return this.pointer;
    }

    public void setPointer(int param1) {
        if (Checks.CHECKS) {
            this.checkPointer(param1);
        }
        this.pointer = param1;
    }

    private void checkPointer(int param1) {
        if (param1 < 0 || this.size < param1) {
            throw new IndexOutOfBoundsException("Invalid stack pointer");
        }
    }

    private static void checkAlignment(int param0) {
        if (Integer.bitCount(param0) != 1) {
            throw new IllegalArgumentException("Alignment must be a power-of-two value.");
        }
    }

    public long nmalloc(int param1) {
        return this.nmalloc(POINTER_SIZE, param1);
    }

    public long nmalloc(int param1, int param2) {
        long v3 = this.address + (long)this.pointer - (long)param2 & (Integer.toUnsignedLong(param1 - 1) ^ 0xFFFFFFFFFFFFFFFFL);
        this.pointer = (int)(v3 - this.address);
        if (Checks.CHECKS && this.pointer < 0) {
            throw new OutOfMemoryError("Out of stack space.");
        }
        return v3;
    }

    public long ncalloc(int param1, int param2, int param3) {
        int v4 = param2 * param3;
        long v5 = this.nmalloc(param1, v4);
        MemoryUtil.memSet(v5, 0, v4);
        return v5;
    }

    public ByteBuffer malloc(int param1, int param2) {
        if (Checks.DEBUG) {
            MemoryStack.checkAlignment(param1);
        }
        return MemoryUtil.wrap(MemoryUtil.BUFFER_BYTE, this.nmalloc(param1, param2), param2).order(MemoryUtil.NATIVE_ORDER);
    }

    public ByteBuffer calloc(int param1, int param2) {
        if (Checks.DEBUG) {
            MemoryStack.checkAlignment(param1);
        }
        return MemoryUtil.wrap(MemoryUtil.BUFFER_BYTE, this.ncalloc(param1, param2, 1), param2).order(MemoryUtil.NATIVE_ORDER);
    }

    public ByteBuffer malloc(int param1) {
        return MemoryUtil.wrap(MemoryUtil.BUFFER_BYTE, this.nmalloc(POINTER_SIZE, param1), param1).order(MemoryUtil.NATIVE_ORDER);
    }

    public ByteBuffer calloc(int param1) {
        return MemoryUtil.wrap(MemoryUtil.BUFFER_BYTE, this.ncalloc(POINTER_SIZE, param1, 1), param1).order(MemoryUtil.NATIVE_ORDER);
    }

    public long nbyte(byte param1) {
        long v2 = this.nmalloc(1, 1);
        MemoryUtil.memPutByte(v2, param1);
        return v2;
    }

    public ByteBuffer bytes(byte param1) {
        return this.malloc(1, 1).put(0, param1);
    }

    public ByteBuffer bytes(byte param1, byte param2) {
        return this.malloc(1, 2).put(0, param1).put(1, param2);
    }

    public ByteBuffer bytes(byte param1, byte param2, byte param3) {
        return this.malloc(1, 3).put(0, param1).put(1, param2).put(2, param3);
    }

    public ByteBuffer bytes(byte param1, byte param2, byte param3, byte param4) {
        return this.malloc(1, 4).put(0, param1).put(1, param2).put(2, param3).put(3, param4);
    }

    public ByteBuffer bytes(byte ... param1) {
        ByteBuffer v2 = this.malloc(1, param1.length).put(param1);
        v2.flip();
        return v2;
    }

    public ShortBuffer mallocShort(int param1) {
        return MemoryUtil.wrap(MemoryUtil.BUFFER_SHORT, this.nmalloc(2, param1 << 1), param1);
    }

    public ShortBuffer callocShort(int param1) {
        int v2 = param1 * 2;
        long v3 = this.nmalloc(2, v2);
        MemoryUtil.memSet(v3, 0, v2);
        return MemoryUtil.wrap(MemoryUtil.BUFFER_SHORT, v3, param1);
    }

    public long nshort(short param1) {
        long v2 = this.nmalloc(2, 2);
        MemoryUtil.memPutShort(v2, param1);
        return v2;
    }

    public ShortBuffer shorts(short param1) {
        return this.mallocShort(1).put(0, param1);
    }

    public ShortBuffer shorts(short param1, short param2) {
        return this.mallocShort(2).put(0, param1).put(1, param2);
    }

    public ShortBuffer shorts(short param1, short param2, short param3) {
        return this.mallocShort(3).put(0, param1).put(1, param2).put(2, param3);
    }

    public ShortBuffer shorts(short param1, short param2, short param3, short param4) {
        return this.mallocShort(4).put(0, param1).put(1, param2).put(2, param3).put(3, param4);
    }

    public ShortBuffer shorts(short ... param1) {
        ShortBuffer v2 = this.mallocShort(param1.length).put(param1);
        v2.flip();
        return v2;
    }

    public IntBuffer mallocInt(int param1) {
        return MemoryUtil.wrap(MemoryUtil.BUFFER_INT, this.nmalloc(4, param1 << 2), param1);
    }

    public IntBuffer callocInt(int param1) {
        int v2 = param1 * 4;
        long v3 = this.nmalloc(4, v2);
        MemoryUtil.memSet(v3, 0, v2);
        return MemoryUtil.wrap(MemoryUtil.BUFFER_INT, v3, param1);
    }

    public long nint(int param1) {
        long v2 = this.nmalloc(4, 4);
        MemoryUtil.memPutInt(v2, param1);
        return v2;
    }

    public IntBuffer ints(int param1) {
        return this.mallocInt(1).put(0, param1);
    }

    public IntBuffer ints(int param1, int param2) {
        return this.mallocInt(2).put(0, param1).put(1, param2);
    }

    public IntBuffer ints(int param1, int param2, int param3) {
        return this.mallocInt(3).put(0, param1).put(1, param2).put(2, param3);
    }

    public IntBuffer ints(int param1, int param2, int param3, int param4) {
        return this.mallocInt(4).put(0, param1).put(1, param2).put(2, param3).put(3, param4);
    }

    public IntBuffer ints(int ... param1) {
        IntBuffer v2 = this.mallocInt(param1.length).put(param1);
        v2.flip();
        return v2;
    }

    public LongBuffer mallocLong(int param1) {
        return MemoryUtil.wrap(MemoryUtil.BUFFER_LONG, this.nmalloc(8, param1 << 3), param1);
    }

    public LongBuffer callocLong(int param1) {
        int v2 = param1 * 8;
        long v3 = this.nmalloc(8, v2);
        MemoryUtil.memSet(v3, 0, v2);
        return MemoryUtil.wrap(MemoryUtil.BUFFER_LONG, v3, param1);
    }

    public long nlong(long param1) {
        long v3 = this.nmalloc(8, 8);
        MemoryUtil.memPutLong(v3, param1);
        return v3;
    }

    public LongBuffer longs(long param1) {
        return this.mallocLong(1).put(0, param1);
    }

    public LongBuffer longs(long param1, long param3) {
        return this.mallocLong(2).put(0, param1).put(1, param3);
    }

    public LongBuffer longs(long param1, long param3, long param5) {
        return this.mallocLong(3).put(0, param1).put(1, param3).put(2, param5);
    }

    public LongBuffer longs(long param1, long param3, long param5, long param7) {
        return this.mallocLong(4).put(0, param1).put(1, param3).put(2, param5).put(3, param7);
    }

    public LongBuffer longs(long ... param1) {
        LongBuffer v2 = this.mallocLong(param1.length).put(param1);
        v2.flip();
        return v2;
    }

    public CLongBuffer mallocCLong(int param1) {
        return CLongBuffer.create(this.nmalloc(CLONG_SIZE, param1 << CLONG_SHIFT), param1);
    }

    public CLongBuffer callocCLong(int param1) {
        int v2 = param1 * CLONG_SIZE;
        long v3 = this.nmalloc(CLONG_SIZE, v2);
        MemoryUtil.memSet(v3, 0, v2);
        return CLongBuffer.create(v3, param1);
    }

    public long nclong(long param1) {
        long v3 = this.nmalloc(CLONG_SIZE, CLONG_SIZE);
        MemoryUtil.memPutCLong(v3, param1);
        return v3;
    }

    public CLongBuffer clongs(long param1) {
        return this.mallocCLong(1).put(0, param1);
    }

    public CLongBuffer clongs(long param1, long param3) {
        return this.mallocCLong(2).put(0, param1).put(1, param3);
    }

    public CLongBuffer clongs(long param1, long param3, long param5) {
        return this.mallocCLong(3).put(0, param1).put(1, param3).put(2, param5);
    }

    public CLongBuffer clongs(long param1, long param3, long param5, long param7) {
        return this.mallocCLong(4).put(0, param1).put(1, param3).put(2, param5).put(3, param7);
    }

    public CLongBuffer clongs(long ... param1) {
        CLongBuffer v2 = this.mallocCLong(param1.length).put(param1);
        v2.flip();
        return v2;
    }

    public FloatBuffer mallocFloat(int param1) {
        return MemoryUtil.wrap(MemoryUtil.BUFFER_FLOAT, this.nmalloc(4, param1 << 2), param1);
    }

    public FloatBuffer callocFloat(int param1) {
        int v2 = param1 * 4;
        long v3 = this.nmalloc(4, v2);
        MemoryUtil.memSet(v3, 0, v2);
        return MemoryUtil.wrap(MemoryUtil.BUFFER_FLOAT, v3, param1);
    }

    public long nfloat(float param1) {
        long v2 = this.nmalloc(4, 4);
        MemoryUtil.memPutFloat(v2, param1);
        return v2;
    }

    public FloatBuffer floats(float param1) {
        return this.mallocFloat(1).put(0, param1);
    }

    public FloatBuffer floats(float param1, float param2) {
        return this.mallocFloat(2).put(0, param1).put(1, param2);
    }

    public FloatBuffer floats(float param1, float param2, float param3) {
        return this.mallocFloat(3).put(0, param1).put(1, param2).put(2, param3);
    }

    public FloatBuffer floats(float param1, float param2, float param3, float param4) {
        return this.mallocFloat(4).put(0, param1).put(1, param2).put(2, param3).put(3, param4);
    }

    public FloatBuffer floats(float ... param1) {
        FloatBuffer v2 = this.mallocFloat(param1.length).put(param1);
        v2.flip();
        return v2;
    }

    public DoubleBuffer mallocDouble(int param1) {
        return MemoryUtil.wrap(MemoryUtil.BUFFER_DOUBLE, this.nmalloc(8, param1 << 3), param1);
    }

    public DoubleBuffer callocDouble(int param1) {
        int v2 = param1 * 8;
        long v3 = this.nmalloc(8, v2);
        MemoryUtil.memSet(v3, 0, v2);
        return MemoryUtil.wrap(MemoryUtil.BUFFER_DOUBLE, v3, param1);
    }

    public long ndouble(double param1) {
        long v3 = this.nmalloc(8, 8);
        MemoryUtil.memPutDouble(v3, param1);
        return v3;
    }

    public DoubleBuffer doubles(double param1) {
        return this.mallocDouble(1).put(0, param1);
    }

    public DoubleBuffer doubles(double param1, double param3) {
        return this.mallocDouble(2).put(0, param1).put(1, param3);
    }

    public DoubleBuffer doubles(double param1, double param3, double param5) {
        return this.mallocDouble(3).put(0, param1).put(1, param3).put(2, param5);
    }

    public DoubleBuffer doubles(double param1, double param3, double param5, double param7) {
        return this.mallocDouble(4).put(0, param1).put(1, param3).put(2, param5).put(3, param7);
    }

    public DoubleBuffer doubles(double ... param1) {
        DoubleBuffer v2 = this.mallocDouble(param1.length).put(param1);
        v2.flip();
        return v2;
    }

    public PointerBuffer mallocPointer(int param1) {
        return PointerBuffer.create(this.nmalloc(POINTER_SIZE, param1 << POINTER_SHIFT), param1);
    }

    public PointerBuffer callocPointer(int param1) {
        int v2 = param1 * POINTER_SIZE;
        long v3 = this.nmalloc(POINTER_SIZE, v2);
        MemoryUtil.memSet(v3, 0, v2);
        return PointerBuffer.create(v3, param1);
    }

    public long npointer(long param1) {
        long v3 = this.nmalloc(POINTER_SIZE, POINTER_SIZE);
        MemoryUtil.memPutAddress(v3, param1);
        return v3;
    }

    public PointerBuffer pointers(long param1) {
        return this.mallocPointer(1).put(0, param1);
    }

    public PointerBuffer pointers(long param1, long param3) {
        return this.mallocPointer(2).put(0, param1).put(1, param3);
    }

    public PointerBuffer pointers(long param1, long param3, long param5) {
        return this.mallocPointer(3).put(0, param1).put(1, param3).put(2, param5);
    }

    public PointerBuffer pointers(long param1, long param3, long param5, long param7) {
        return this.mallocPointer(4).put(0, param1).put(1, param3).put(2, param5).put(3, param7);
    }

    public PointerBuffer pointers(long ... param1) {
        PointerBuffer v2 = this.mallocPointer(param1.length).put(param1);
        v2.flip();
        return v2;
    }

    public long npointer(Pointer param1) {
        long v2 = this.nmalloc(POINTER_SIZE, POINTER_SIZE);
        MemoryUtil.memPutAddress(v2, param1.address());
        return v2;
    }

    public PointerBuffer pointers(Pointer param1) {
        return this.mallocPointer(1).put(0, param1);
    }

    public PointerBuffer pointers(Pointer param1, Pointer param2) {
        return this.mallocPointer(2).put(0, param1).put(1, param2);
    }

    public PointerBuffer pointers(Pointer param1, Pointer param2, Pointer param3) {
        return this.mallocPointer(3).put(0, param1).put(1, param2).put(2, param3);
    }

    public PointerBuffer pointers(Pointer param1, Pointer param2, Pointer param3, Pointer param4) {
        return this.mallocPointer(4).put(0, param1).put(1, param2).put(2, param3).put(3, param4);
    }

    public PointerBuffer pointers(Pointer ... param1) {
        PointerBuffer v2 = this.mallocPointer(param1.length);
        for (int v3 = 0; v3 < param1.length; ++v3) {
            v2.put(v3, param1[v3]);
        }
        return v2;
    }

    public long npointer(Buffer param1) {
        long v2 = this.nmalloc(POINTER_SIZE, POINTER_SIZE);
        MemoryUtil.memPutAddress(v2, MemoryUtil.memAddress(param1));
        return v2;
    }

    public PointerBuffer pointers(Buffer param1) {
        return this.mallocPointer(1).put(0, MemoryUtil.memAddress(param1));
    }

    public PointerBuffer pointers(Buffer param1, Buffer param2) {
        return this.mallocPointer(2).put(0, MemoryUtil.memAddress(param1)).put(1, MemoryUtil.memAddress(param2));
    }

    public PointerBuffer pointers(Buffer param1, Buffer param2, Buffer param3) {
        return this.mallocPointer(3).put(0, MemoryUtil.memAddress(param1)).put(1, MemoryUtil.memAddress(param2)).put(2, MemoryUtil.memAddress(param3));
    }

    public PointerBuffer pointers(Buffer param1, Buffer param2, Buffer param3, Buffer param4) {
        return this.mallocPointer(4).put(0, MemoryUtil.memAddress(param1)).put(1, MemoryUtil.memAddress(param2)).put(2, MemoryUtil.memAddress(param3)).put(3, MemoryUtil.memAddress(param4));
    }

    public PointerBuffer pointers(Buffer ... param1) {
        PointerBuffer v2 = this.mallocPointer(param1.length);
        for (int v3 = 0; v3 < param1.length; ++v3) {
            v2.put(v3, MemoryUtil.memAddress(param1[v3]));
        }
        return v2;
    }

    public PointerBuffer pointersOfElements(CustomBuffer<?> param1) {
        int v2 = param1.remaining();
        long v3 = param1.address();
        long v5 = param1.sizeof();
        PointerBuffer v7 = this.mallocPointer(v2);
        for (int v8 = 0; v8 < v2; ++v8) {
            v7.put(v8, v3 + v5 * (long)v8);
        }
        return v7;
    }

    public ByteBuffer ASCII(CharSequence param1) {
        return this.ASCII(param1, true);
    }

    public ByteBuffer ASCII(CharSequence param1, boolean param2) {
        int v3 = MemoryUtil.memLengthASCII(param1, param2);
        long v4 = this.nmalloc(POINTER_SIZE, v3);
        MemoryUtil.encodeASCIIUnsafe(param1, param2, v4);
        return MemoryUtil.wrap(MemoryUtil.BUFFER_BYTE, v4, v3).order(MemoryUtil.NATIVE_ORDER);
    }

    public int nASCII(CharSequence param1, boolean param2) {
        long v3 = this.nmalloc(POINTER_SIZE, MemoryUtil.memLengthASCII(param1, param2));
        return MemoryUtil.encodeASCIIUnsafe(param1, param2, v3);
    }

    @Nullable
    public ByteBuffer ASCIISafe(@Nullable CharSequence param1) {
        return this.ASCIISafe(param1, true);
    }

    @Nullable
    public ByteBuffer ASCIISafe(@Nullable CharSequence param1, boolean param2) {
        return param1 == null ? null : this.ASCII(param1, param2);
    }

    public int nASCIISafe(@Nullable CharSequence param1, boolean param2) {
        return param1 == null ? 0 : this.nASCII(param1, param2);
    }

    public ByteBuffer UTF8(CharSequence param1) {
        return this.UTF8(param1, true);
    }

    public ByteBuffer UTF8(CharSequence param1, boolean param2) {
        int v3 = MemoryUtil.memLengthUTF8(param1, param2);
        long v4 = this.nmalloc(POINTER_SIZE, v3);
        MemoryUtil.encodeUTF8Unsafe(param1, param2, v4);
        return MemoryUtil.wrap(MemoryUtil.BUFFER_BYTE, v4, v3).order(MemoryUtil.NATIVE_ORDER);
    }

    public int nUTF8(CharSequence param1, boolean param2) {
        long v3 = this.nmalloc(POINTER_SIZE, MemoryUtil.memLengthUTF8(param1, param2));
        return MemoryUtil.encodeUTF8Unsafe(param1, param2, v3);
    }

    @Nullable
    public ByteBuffer UTF8Safe(@Nullable CharSequence param1) {
        return this.UTF8Safe(param1, true);
    }

    @Nullable
    public ByteBuffer UTF8Safe(@Nullable CharSequence param1, boolean param2) {
        return param1 == null ? null : this.UTF8(param1, param2);
    }

    public int nUTF8Safe(@Nullable CharSequence param1, boolean param2) {
        return param1 == null ? 0 : this.nUTF8(param1, param2);
    }

    public ByteBuffer UTF16(CharSequence param1) {
        return this.UTF16(param1, true);
    }

    public ByteBuffer UTF16(CharSequence param1, boolean param2) {
        int v3 = MemoryUtil.memLengthUTF16(param1, param2);
        long v4 = this.nmalloc(POINTER_SIZE, v3);
        MemoryUtil.encodeUTF16Unsafe(param1, param2, v4);
        return MemoryUtil.wrap(MemoryUtil.BUFFER_BYTE, v4, v3).order(MemoryUtil.NATIVE_ORDER);
    }

    public int nUTF16(CharSequence param1, boolean param2) {
        long v3 = this.nmalloc(POINTER_SIZE, MemoryUtil.memLengthUTF16(param1, param2));
        return MemoryUtil.encodeUTF16Unsafe(param1, param2, v3);
    }

    @Nullable
    public ByteBuffer UTF16Safe(@Nullable CharSequence param1) {
        return this.UTF16Safe(param1, true);
    }

    @Nullable
    public ByteBuffer UTF16Safe(@Nullable CharSequence param1, boolean param2) {
        return param1 == null ? null : this.UTF16(param1, param2);
    }

    public int nUTF16Safe(@Nullable CharSequence param1, boolean param2) {
        return param1 == null ? 0 : this.nUTF16(param1, param2);
    }

    public static MemoryStack stackGet() {
        return TLS.get();
    }

    public static MemoryStack stackPush() {
        return MemoryStack.stackGet().push();
    }

    public static MemoryStack stackPop() {
        return MemoryStack.stackGet().pop();
    }

    public static long nstackMalloc(int param0) {
        return MemoryStack.stackGet().nmalloc(param0);
    }

    public static long nstackMalloc(int param0, int param1) {
        return MemoryStack.stackGet().nmalloc(param0, param1);
    }

    public static long nstackCalloc(int param0, int param1, int param2) {
        return MemoryStack.stackGet().ncalloc(param0, param1, param2);
    }

    public static ByteBuffer stackMalloc(int param0) {
        return MemoryStack.stackGet().malloc(param0);
    }

    public static ByteBuffer stackCalloc(int param0) {
        return MemoryStack.stackGet().calloc(param0);
    }

    public static ByteBuffer stackBytes(byte param0) {
        return MemoryStack.stackGet().bytes(param0);
    }

    public static ByteBuffer stackBytes(byte param0, byte param1) {
        return MemoryStack.stackGet().bytes(param0, param1);
    }

    public static ByteBuffer stackBytes(byte param0, byte param1, byte param2) {
        return MemoryStack.stackGet().bytes(param0, param1, param2);
    }

    public static ByteBuffer stackBytes(byte param0, byte param1, byte param2, byte param3) {
        return MemoryStack.stackGet().bytes(param0, param1, param2, param3);
    }

    public static ByteBuffer stackBytes(byte ... param0) {
        return MemoryStack.stackGet().bytes(param0);
    }

    public static ShortBuffer stackMallocShort(int param0) {
        return MemoryStack.stackGet().mallocShort(param0);
    }

    public static ShortBuffer stackCallocShort(int param0) {
        return MemoryStack.stackGet().callocShort(param0);
    }

    public static ShortBuffer stackShorts(short param0) {
        return MemoryStack.stackGet().shorts(param0);
    }

    public static ShortBuffer stackShorts(short param0, short param1) {
        return MemoryStack.stackGet().shorts(param0, param1);
    }

    public static ShortBuffer stackShorts(short param0, short param1, short param2) {
        return MemoryStack.stackGet().shorts(param0, param1, param2);
    }

    public static ShortBuffer stackShorts(short param0, short param1, short param2, short param3) {
        return MemoryStack.stackGet().shorts(param0, param1, param2, param3);
    }

    public static ShortBuffer stackShorts(short ... param0) {
        return MemoryStack.stackGet().shorts(param0);
    }

    public static IntBuffer stackMallocInt(int param0) {
        return MemoryStack.stackGet().mallocInt(param0);
    }

    public static IntBuffer stackCallocInt(int param0) {
        return MemoryStack.stackGet().callocInt(param0);
    }

    public static IntBuffer stackInts(int param0) {
        return MemoryStack.stackGet().ints(param0);
    }

    public static IntBuffer stackInts(int param0, int param1) {
        return MemoryStack.stackGet().ints(param0, param1);
    }

    public static IntBuffer stackInts(int param0, int param1, int param2) {
        return MemoryStack.stackGet().ints(param0, param1, param2);
    }

    public static IntBuffer stackInts(int param0, int param1, int param2, int param3) {
        return MemoryStack.stackGet().ints(param0, param1, param2, param3);
    }

    public static IntBuffer stackInts(int ... param0) {
        return MemoryStack.stackGet().ints(param0);
    }

    public static LongBuffer stackMallocLong(int param0) {
        return MemoryStack.stackGet().mallocLong(param0);
    }

    public static LongBuffer stackCallocLong(int param0) {
        return MemoryStack.stackGet().callocLong(param0);
    }

    public static LongBuffer stackLongs(long param0) {
        return MemoryStack.stackGet().longs(param0);
    }

    public static LongBuffer stackLongs(long param0, long param2) {
        return MemoryStack.stackGet().longs(param0, param2);
    }

    public static LongBuffer stackLongs(long param0, long param2, long param4) {
        return MemoryStack.stackGet().longs(param0, param2, param4);
    }

    public static LongBuffer stackLongs(long param0, long param2, long param4, long param6) {
        return MemoryStack.stackGet().longs(param0, param2, param4, param6);
    }

    public static LongBuffer stackLongs(long ... param0) {
        return MemoryStack.stackGet().longs(param0);
    }

    public static CLongBuffer stackMallocCLong(int param0) {
        return MemoryStack.stackGet().mallocCLong(param0);
    }

    public static CLongBuffer stackCallocCLong(int param0) {
        return MemoryStack.stackGet().callocCLong(param0);
    }

    public static CLongBuffer stackCLongs(long param0) {
        return MemoryStack.stackGet().clongs(param0);
    }

    public static CLongBuffer stackCLongs(long param0, long param2) {
        return MemoryStack.stackGet().clongs(param0, param2);
    }

    public static CLongBuffer stackCLongs(long param0, long param2, long param4) {
        return MemoryStack.stackGet().clongs(param0, param2, param4);
    }

    public static CLongBuffer stackCLongs(long param0, long param2, long param4, long param6) {
        return MemoryStack.stackGet().clongs(param0, param2, param4, param6);
    }

    public static CLongBuffer stackCLongs(long ... param0) {
        return MemoryStack.stackGet().clongs(param0);
    }

    public static FloatBuffer stackMallocFloat(int param0) {
        return MemoryStack.stackGet().mallocFloat(param0);
    }

    public static FloatBuffer stackCallocFloat(int param0) {
        return MemoryStack.stackGet().callocFloat(param0);
    }

    public static FloatBuffer stackFloats(float param0) {
        return MemoryStack.stackGet().floats(param0);
    }

    public static FloatBuffer stackFloats(float param0, float param1) {
        return MemoryStack.stackGet().floats(param0, param1);
    }

    public static FloatBuffer stackFloats(float param0, float param1, float param2) {
        return MemoryStack.stackGet().floats(param0, param1, param2);
    }

    public static FloatBuffer stackFloats(float param0, float param1, float param2, float param3) {
        return MemoryStack.stackGet().floats(param0, param1, param2, param3);
    }

    public static FloatBuffer stackFloats(float ... param0) {
        return MemoryStack.stackGet().floats(param0);
    }

    public static DoubleBuffer stackMallocDouble(int param0) {
        return MemoryStack.stackGet().mallocDouble(param0);
    }

    public static DoubleBuffer stackCallocDouble(int param0) {
        return MemoryStack.stackGet().callocDouble(param0);
    }

    public static DoubleBuffer stackDoubles(double param0) {
        return MemoryStack.stackGet().doubles(param0);
    }

    public static DoubleBuffer stackDoubles(double param0, double param2) {
        return MemoryStack.stackGet().doubles(param0, param2);
    }

    public static DoubleBuffer stackDoubles(double param0, double param2, double param4) {
        return MemoryStack.stackGet().doubles(param0, param2, param4);
    }

    public static DoubleBuffer stackDoubles(double param0, double param2, double param4, double param6) {
        return MemoryStack.stackGet().doubles(param0, param2, param4, param6);
    }

    public static DoubleBuffer stackDoubles(double ... param0) {
        return MemoryStack.stackGet().doubles(param0);
    }

    public static PointerBuffer stackMallocPointer(int param0) {
        return MemoryStack.stackGet().mallocPointer(param0);
    }

    public static PointerBuffer stackCallocPointer(int param0) {
        return MemoryStack.stackGet().callocPointer(param0);
    }

    public static PointerBuffer stackPointers(long param0) {
        return MemoryStack.stackGet().pointers(param0);
    }

    public static PointerBuffer stackPointers(long param0, long param2) {
        return MemoryStack.stackGet().pointers(param0, param2);
    }

    public static PointerBuffer stackPointers(long param0, long param2, long param4) {
        return MemoryStack.stackGet().pointers(param0, param2, param4);
    }

    public static PointerBuffer stackPointers(long param0, long param2, long param4, long param6) {
        return MemoryStack.stackGet().pointers(param0, param2, param4, param6);
    }

    public static PointerBuffer stackPointers(long ... param0) {
        return MemoryStack.stackGet().pointers(param0);
    }

    public static PointerBuffer stackPointers(Pointer param0) {
        return MemoryStack.stackGet().pointers(param0);
    }

    public static PointerBuffer stackPointers(Pointer param0, Pointer param1) {
        return MemoryStack.stackGet().pointers(param0, param1);
    }

    public static PointerBuffer stackPointers(Pointer param0, Pointer param1, Pointer param2) {
        return MemoryStack.stackGet().pointers(param0, param1, param2);
    }

    public static PointerBuffer stackPointers(Pointer param0, Pointer param1, Pointer param2, Pointer param3) {
        return MemoryStack.stackGet().pointers(param0, param1, param2, param3);
    }

    public static PointerBuffer stackPointers(Pointer ... param0) {
        return MemoryStack.stackGet().pointers(param0);
    }

    public static ByteBuffer stackASCII(CharSequence param0) {
        return MemoryStack.stackGet().ASCII(param0);
    }

    public static ByteBuffer stackASCII(CharSequence param0, boolean param1) {
        return MemoryStack.stackGet().ASCII(param0, param1);
    }

    public static ByteBuffer stackUTF8(CharSequence param0) {
        return MemoryStack.stackGet().UTF8(param0);
    }

    public static ByteBuffer stackUTF8(CharSequence param0, boolean param1) {
        return MemoryStack.stackGet().UTF8(param0, param1);
    }

    public static ByteBuffer stackUTF16(CharSequence param0) {
        return MemoryStack.stackGet().UTF16(param0);
    }

    public static ByteBuffer stackUTF16(CharSequence param0, boolean param1) {
        return MemoryStack.stackGet().UTF16(param0, param1);
    }

    @Nullable
    public static ByteBuffer stackASCIISafe(@Nullable CharSequence param0) {
        return MemoryStack.stackGet().ASCIISafe(param0);
    }

    @Nullable
    public static ByteBuffer stackASCIISafe(@Nullable CharSequence param0, boolean param1) {
        return MemoryStack.stackGet().ASCIISafe(param0, param1);
    }

    @Nullable
    public static ByteBuffer stackUTF8Safe(@Nullable CharSequence param0) {
        return MemoryStack.stackGet().UTF8Safe(param0);
    }

    @Nullable
    public static ByteBuffer stackUTF8Safe(@Nullable CharSequence param0, boolean param1) {
        return MemoryStack.stackGet().UTF8Safe(param0, param1);
    }

    @Nullable
    public static ByteBuffer stackUTF16Safe(@Nullable CharSequence param0) {
        return MemoryStack.stackGet().UTF16Safe(param0);
    }

    @Nullable
    public static ByteBuffer stackUTF16Safe(@Nullable CharSequence param0, boolean param1) {
        return MemoryStack.stackGet().UTF16Safe(param0, param1);
    }

    static {
        DEFAULT_STACK_FRAMES = 8;
        DEFAULT_STACK_SIZE = Configuration.STACK_SIZE.get(64) * 1024;
        TLS = ThreadLocal.withInitial(MemoryStack::create);
        if (DEFAULT_STACK_SIZE < 0) {
            throw new IllegalStateException("Invalid stack size.");
        }
    }

    private static class DebugMemoryStack
    extends MemoryStack {
        private Object[] debugFrames = new Object[8];

        DebugMemoryStack(@Nullable ByteBuffer param1, long param2, int param4) {
            super(param1, param2, param4);
        }

        @Override
        public MemoryStack push() {
            if (this.frameIndex == this.debugFrames.length) {
                this.frameOverflow();
            }
            this.debugFrames[this.frameIndex] = StackWalkUtil.stackWalkGetMethod(MemoryStack.class);
            return super.push();
        }

        @Override
        private void frameOverflow() {
            this.debugFrames = Arrays.copyOf(this.debugFrames, this.debugFrames.length * 3 / 2);
        }

        @Override
        public MemoryStack pop() {
            Object v1 = this.debugFrames[this.frameIndex - 1];
            Object v2 = StackWalkUtil.stackWalkCheckPop(MemoryStack.class, v1);
            if (v2 != null) {
                DebugMemoryStack.reportAsymmetricPop(v1, v2);
            }
            this.debugFrames[this.frameIndex - 1] = null;
            return super.pop();
        }

        @Override
        public void close() {
            this.debugFrames[this.frameIndex - 1] = null;
            super.pop();
        }

        private static void reportAsymmetricPop(Object param0, Object param1) {
            APIUtil.DEBUG_STREAM.format("[LWJGL] Asymmetric pop detected:\n\tPUSHED: %s\n\tPOPPED: %s\n\tTHREAD: %s\n", param0, param1, Thread.currentThread());
        }
    }
}

