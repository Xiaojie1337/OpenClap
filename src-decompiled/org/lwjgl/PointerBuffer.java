/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.CheckIntrinsics;
import org.lwjgl.system.Checks;
import org.lwjgl.system.CustomBuffer;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.Pointer;

public class PointerBuffer
extends CustomBuffer<PointerBuffer>
implements Comparable<PointerBuffer> {
    protected PointerBuffer(long param1, @Nullable ByteBuffer param3, int param4, int param5, int param6, int param7) {
        super(param1, param3, param4, param5, param6, param7);
    }

    public static PointerBuffer allocateDirect(int param0) {
        ByteBuffer v1 = BufferUtils.createByteBuffer(BufferUtils.getAllocationSize(param0, POINTER_SHIFT));
        return new PointerBuffer(MemoryUtil.memAddress(v1), v1, -1, 0, param0, param0);
    }

    public static PointerBuffer create(long param0, int param2) {
        return new PointerBuffer(param0, null, -1, 0, param2, param2);
    }

    public static PointerBuffer create(ByteBuffer param0) {
        int v1 = param0.remaining() >> POINTER_SHIFT;
        return new PointerBuffer(MemoryUtil.memAddress(param0), param0, -1, 0, v1, v1);
    }

    @Override
    protected PointerBuffer self() {
        return this;
    }

    @Override
    public int sizeof() {
        return POINTER_SIZE;
    }

    public long get() {
        return MemoryUtil.memGetAddress(this.address + Integer.toUnsignedLong(this.nextGetIndex()) * (long)POINTER_SIZE);
    }

    public static long get(ByteBuffer param0) {
        if (param0.remaining() < POINTER_SIZE) {
            throw new BufferUnderflowException();
        }
        try {
            long v1 = MemoryUtil.memGetAddress(MemoryUtil.memAddress(param0));
            return v1;
        }
        finally {
            param0.position(param0.position() + POINTER_SIZE);
        }
    }

    @Override
    public PointerBuffer put(long param1) {
        MemoryUtil.memPutAddress(this.address + Integer.toUnsignedLong(this.nextPutIndex()) * (long)POINTER_SIZE, param1);
        return this;
    }

    public static void put(ByteBuffer param0, long param1) {
        if (param0.remaining() < POINTER_SIZE) {
            throw new BufferOverflowException();
        }
        try {
            MemoryUtil.memPutAddress(MemoryUtil.memAddress(param0), param1);
            return;
        }
        finally {
            param0.position(param0.position() + POINTER_SIZE);
        }
    }

    public long get(int param1) {
        return MemoryUtil.memGetAddress(this.address + Checks.check(param1, this.limit) * (long)POINTER_SIZE);
    }

    public static long get(ByteBuffer param0, int param1) {
        CheckIntrinsics.checkFromIndexSize(param1, POINTER_SIZE, param0.limit());
        return MemoryUtil.memGetAddress(MemoryUtil.memAddress0(param0) + (long)param1);
    }

    public PointerBuffer put(int param1, long param2) {
        MemoryUtil.memPutAddress(this.address + Checks.check(param1, this.limit) * (long)POINTER_SIZE, param2);
        return this;
    }

    public static void put(ByteBuffer param0, int param1, long param2) {
        CheckIntrinsics.checkFromIndexSize(param1, POINTER_SIZE, param0.limit());
        MemoryUtil.memPutAddress(MemoryUtil.memAddress0(param0) + (long)param1, param2);
    }

    @Override
    public PointerBuffer put(Pointer param1) {
        this.put(param1.address());
        return this;
    }

    public PointerBuffer put(int param1, Pointer param2) {
        this.put(param1, param2.address());
        return this;
    }

    @Override
    public PointerBuffer put(ByteBuffer param1) {
        this.put(MemoryUtil.memAddress(param1));
        return this;
    }

    @Override
    public PointerBuffer put(ShortBuffer param1) {
        this.put(MemoryUtil.memAddress(param1));
        return this;
    }

    @Override
    public PointerBuffer put(IntBuffer param1) {
        this.put(MemoryUtil.memAddress(param1));
        return this;
    }

    @Override
    public PointerBuffer put(LongBuffer param1) {
        this.put(MemoryUtil.memAddress(param1));
        return this;
    }

    @Override
    public PointerBuffer put(FloatBuffer param1) {
        this.put(MemoryUtil.memAddress(param1));
        return this;
    }

    @Override
    public PointerBuffer put(DoubleBuffer param1) {
        this.put(MemoryUtil.memAddress(param1));
        return this;
    }

    public PointerBuffer putAddressOf(CustomBuffer<?> param1) {
        this.put(MemoryUtil.memAddress(param1));
        return this;
    }

    public PointerBuffer put(int param1, ByteBuffer param2) {
        this.put(param1, MemoryUtil.memAddress(param2));
        return this;
    }

    public PointerBuffer put(int param1, ShortBuffer param2) {
        this.put(param1, MemoryUtil.memAddress(param2));
        return this;
    }

    public PointerBuffer put(int param1, IntBuffer param2) {
        this.put(param1, MemoryUtil.memAddress(param2));
        return this;
    }

    public PointerBuffer put(int param1, LongBuffer param2) {
        this.put(param1, MemoryUtil.memAddress(param2));
        return this;
    }

    public PointerBuffer put(int param1, FloatBuffer param2) {
        this.put(param1, MemoryUtil.memAddress(param2));
        return this;
    }

    public PointerBuffer put(int param1, DoubleBuffer param2) {
        this.put(param1, MemoryUtil.memAddress(param2));
        return this;
    }

    public PointerBuffer putAddressOf(int param1, CustomBuffer<?> param2) {
        this.put(param1, MemoryUtil.memAddress(param2));
        return this;
    }

    public ByteBuffer getByteBuffer(int param1) {
        return MemoryUtil.memByteBuffer(this.get(), param1);
    }

    public ShortBuffer getShortBuffer(int param1) {
        return MemoryUtil.memShortBuffer(this.get(), param1);
    }

    public IntBuffer getIntBuffer(int param1) {
        return MemoryUtil.memIntBuffer(this.get(), param1);
    }

    public LongBuffer getLongBuffer(int param1) {
        return MemoryUtil.memLongBuffer(this.get(), param1);
    }

    public FloatBuffer getFloatBuffer(int param1) {
        return MemoryUtil.memFloatBuffer(this.get(), param1);
    }

    public DoubleBuffer getDoubleBuffer(int param1) {
        return MemoryUtil.memDoubleBuffer(this.get(), param1);
    }

    public PointerBuffer getPointerBuffer(int param1) {
        return MemoryUtil.memPointerBuffer(this.get(), param1);
    }

    public String getStringASCII() {
        return MemoryUtil.memASCII(this.get());
    }

    public String getStringUTF8() {
        return MemoryUtil.memUTF8(this.get());
    }

    public String getStringUTF16() {
        return MemoryUtil.memUTF16(this.get());
    }

    public ByteBuffer getByteBuffer(int param1, int param2) {
        return MemoryUtil.memByteBuffer(this.get(param1), param2);
    }

    public ShortBuffer getShortBuffer(int param1, int param2) {
        return MemoryUtil.memShortBuffer(this.get(param1), param2);
    }

    public IntBuffer getIntBuffer(int param1, int param2) {
        return MemoryUtil.memIntBuffer(this.get(param1), param2);
    }

    public LongBuffer getLongBuffer(int param1, int param2) {
        return MemoryUtil.memLongBuffer(this.get(param1), param2);
    }

    public FloatBuffer getFloatBuffer(int param1, int param2) {
        return MemoryUtil.memFloatBuffer(this.get(param1), param2);
    }

    public DoubleBuffer getDoubleBuffer(int param1, int param2) {
        return MemoryUtil.memDoubleBuffer(this.get(param1), param2);
    }

    public PointerBuffer getPointerBuffer(int param1, int param2) {
        return MemoryUtil.memPointerBuffer(this.get(param1), param2);
    }

    public String getStringASCII(int param1) {
        return MemoryUtil.memASCII(this.get(param1));
    }

    public String getStringUTF8(int param1) {
        return MemoryUtil.memUTF8(this.get(param1));
    }

    public String getStringUTF16(int param1) {
        return MemoryUtil.memUTF16(this.get(param1));
    }

    public PointerBuffer get(long[] param1) {
        return this.get(param1, 0, param1.length);
    }

    public PointerBuffer get(long[] param1, int param2, int param3) {
        if (BITS64) {
            MemoryUtil.memLongBuffer(this.address(), this.remaining()).get(param1, param2, param3);
            this.position(this.position() + param3);
        } else {
            this.get32(param1, param2, param3);
        }
        return this;
    }

    private void get32(long[] param1, int param2, int param3) {
        CheckIntrinsics.checkFromIndexSize(param2, param3, param1.length);
        if (this.remaining() < param3) {
            throw new BufferUnderflowException();
        }
        int v5 = param2 + param3;
        for (int v4 = param2; v4 < v5; ++v4) {
            param1[v4] = this.get();
        }
    }

    @Override
    public PointerBuffer put(long[] param1) {
        return this.put(param1, 0, param1.length);
    }

    public PointerBuffer put(long[] param1, int param2, int param3) {
        if (BITS64) {
            MemoryUtil.memLongBuffer(this.address(), this.remaining()).put(param1, param2, param3);
            this.position(this.position() + param3);
        } else {
            this.put32(param1, param2, param3);
        }
        return this;
    }

    private void put32(long[] param1, int param2, int param3) {
        CheckIntrinsics.checkFromIndexSize(param2, param3, param1.length);
        if (this.remaining() < param3) {
            throw new BufferOverflowException();
        }
        int v4 = param2 + param3;
        for (int v5 = param2; v5 < v4; ++v5) {
            this.put(param1[v5]);
        }
    }

    @Override
    public int hashCode() {
        int v1 = 1;
        int v2 = this.position();
        for (int v3 = this.limit() - 1; v3 >= v2; --v3) {
            v1 = 31 * v1 + (int)this.get(v3);
        }
        return v1;
    }

    @Override
    public boolean equals(Object param1) {
        if (!(param1 instanceof PointerBuffer)) {
            return false;
        }
        PointerBuffer v2 = (PointerBuffer)param1;
        if (this.remaining() != v2.remaining()) {
            return false;
        }
        int v3 = this.position();
        int v4 = this.limit() - 1;
        int v5 = v2.limit() - 1;
        while (v4 >= v3) {
            long v8;
            long v6 = this.get(v4);
            if (v6 != (v8 = v2.get(v5))) {
                return false;
            }
            --v4;
            --v5;
        }
        return true;
    }

    @Override
    public int compareTo(PointerBuffer param1) {
        int v2 = this.position() + Math.min(this.remaining(), param1.remaining());
        int v3 = this.position();
        int v4 = param1.position();
        while (v3 < v2) {
            long v7;
            long v5 = this.get(v3);
            if (v5 == (v7 = param1.get(v4))) {
                ++v3;
                ++v4;
                continue;
            }
            if (v5 < v7) {
                return -1;
            }
            return 1;
        }
        return this.remaining() - param1.remaining();
    }
}

