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
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.CheckIntrinsics;
import org.lwjgl.system.Checks;
import org.lwjgl.system.CustomBuffer;
import org.lwjgl.system.MemoryUtil;

public class CLongBuffer
extends CustomBuffer<CLongBuffer>
implements Comparable<CLongBuffer> {
    protected CLongBuffer(long param1, @Nullable ByteBuffer param3, int param4, int param5, int param6, int param7) {
        super(param1, param3, param4, param5, param6, param7);
    }

    public static CLongBuffer allocateDirect(int param0) {
        ByteBuffer v1 = BufferUtils.createByteBuffer(BufferUtils.getAllocationSize(param0, CLONG_SHIFT));
        return new CLongBuffer(MemoryUtil.memAddress(v1), v1, -1, 0, param0, param0);
    }

    public static CLongBuffer create(long param0, int param2) {
        return new CLongBuffer(param0, null, -1, 0, param2, param2);
    }

    public static CLongBuffer create(ByteBuffer param0) {
        int v1 = param0.remaining() >> CLONG_SHIFT;
        return new CLongBuffer(MemoryUtil.memAddress(param0), param0, -1, 0, v1, v1);
    }

    @Override
    protected CLongBuffer self() {
        return this;
    }

    @Override
    public int sizeof() {
        return CLONG_SIZE;
    }

    public long get() {
        return MemoryUtil.memGetCLong(this.address + Integer.toUnsignedLong(this.nextGetIndex()) * (long)CLONG_SIZE);
    }

    public static long get(ByteBuffer param0) {
        if (param0.remaining() < CLONG_SIZE) {
            throw new BufferUnderflowException();
        }
        try {
            long v1 = MemoryUtil.memGetCLong(MemoryUtil.memAddress(param0));
            return v1;
        }
        finally {
            param0.position(param0.position() + CLONG_SIZE);
        }
    }

    @Override
    public CLongBuffer put(long param1) {
        MemoryUtil.memPutCLong(this.address + Integer.toUnsignedLong(this.nextPutIndex()) * (long)CLONG_SIZE, param1);
        return this;
    }

    public static void put(ByteBuffer param0, long param1) {
        if (param0.remaining() < CLONG_SIZE) {
            throw new BufferOverflowException();
        }
        try {
            MemoryUtil.memPutCLong(MemoryUtil.memAddress(param0), param1);
            return;
        }
        finally {
            param0.position(param0.position() + CLONG_SIZE);
        }
    }

    public long get(int param1) {
        return MemoryUtil.memGetCLong(this.address + Checks.check(param1, this.limit) * (long)CLONG_SIZE);
    }

    public static long get(ByteBuffer param0, int param1) {
        CheckIntrinsics.checkFromIndexSize(param1, CLONG_SIZE, param0.limit());
        return MemoryUtil.memGetCLong(MemoryUtil.memAddress0(param0) + (long)param1);
    }

    public CLongBuffer put(int param1, long param2) {
        MemoryUtil.memPutCLong(this.address + Checks.check(param1, this.limit) * (long)CLONG_SIZE, param2);
        return this;
    }

    public static void put(ByteBuffer param0, int param1, long param2) {
        CheckIntrinsics.checkFromIndexSize(param1, CLONG_SIZE, param0.limit());
        MemoryUtil.memPutCLong(MemoryUtil.memAddress0(param0) + (long)param1, param2);
    }

    public CLongBuffer get(long[] param1) {
        return this.get(param1, 0, param1.length);
    }

    public CLongBuffer get(long[] param1, int param2, int param3) {
        if (CLONG_SIZE == 8) {
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
    public CLongBuffer put(long[] param1) {
        return this.put(param1, 0, param1.length);
    }

    public CLongBuffer put(long[] param1, int param2, int param3) {
        if (CLONG_SIZE == 8) {
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
        if (!(param1 instanceof CLongBuffer)) {
            return false;
        }
        CLongBuffer v2 = (CLongBuffer)param1;
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
    public int compareTo(CLongBuffer param1) {
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

