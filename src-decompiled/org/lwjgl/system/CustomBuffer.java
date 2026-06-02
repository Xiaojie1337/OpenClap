/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.InvalidMarkException;
import javax.annotation.Nullable;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.Pointer;

public abstract class CustomBuffer<SELF extends CustomBuffer<SELF>>
extends Pointer.Default {
    @Nullable
    protected ByteBuffer container;
    protected int mark;
    protected int position;
    protected int limit;
    protected int capacity;

    protected CustomBuffer(long param1, @Nullable ByteBuffer param3, int param4, int param5, int param6, int param7) {
        super(param1);
        this.container = param3;
        this.mark = param4;
        this.position = param5;
        this.limit = param6;
        this.capacity = param7;
    }

    public abstract int sizeof();

    public long address0() {
        return this.address;
    }

    @Override
    public long address() {
        return this.address + Integer.toUnsignedLong(this.position) * (long)this.sizeof();
    }

    public long address(int param1) {
        return this.address + Integer.toUnsignedLong(param1) * (long)this.sizeof();
    }

    public void free() {
        MemoryUtil.nmemFree(this.address);
    }

    public int capacity() {
        return this.capacity;
    }

    public int position() {
        return this.position;
    }

    public SELF position(int param1) {
        if (param1 < 0 || this.limit < param1) {
            throw new IllegalArgumentException();
        }
        this.position = param1;
        if (param1 < this.mark) {
            this.mark = -1;
        }
        return this.self();
    }

    public int limit() {
        return this.limit;
    }

    public SELF limit(int param1) {
        if (param1 < 0 || this.capacity < param1) {
            throw new IllegalArgumentException();
        }
        this.limit = param1;
        if (param1 < this.position) {
            this.position = param1;
        }
        if (param1 < this.mark) {
            this.mark = -1;
        }
        return this.self();
    }

    public SELF mark() {
        this.mark = this.position;
        return this.self();
    }

    public SELF reset() {
        int v1 = this.mark;
        if (v1 < 0) {
            throw new InvalidMarkException();
        }
        this.position = v1;
        return this.self();
    }

    public SELF clear() {
        this.position = 0;
        this.limit = this.capacity;
        this.mark = -1;
        return this.self();
    }

    public SELF flip() {
        this.limit = this.position;
        this.position = 0;
        this.mark = -1;
        return this.self();
    }

    public SELF rewind() {
        this.position = 0;
        this.mark = -1;
        return this.self();
    }

    public int remaining() {
        return this.limit - this.position;
    }

    public boolean hasRemaining() {
        return this.position < this.limit;
    }

    public SELF slice() {
        CustomBuffer v1;
        try {
            v1 = (CustomBuffer)UNSAFE.allocateInstance(this.getClass());
            UNSAFE.putLong(v1, ADDRESS, this.address + Integer.toUnsignedLong(this.position) * (long)this.sizeof());
            UNSAFE.putInt(v1, BUFFER_MARK, -1);
            UNSAFE.putInt(v1, BUFFER_LIMIT, this.remaining());
            UNSAFE.putInt(v1, BUFFER_CAPACITY, this.remaining());
            UNSAFE.putObject(v1, BUFFER_CONTAINER, this.container);
        }
        catch (InstantiationException v2) {
            throw new UnsupportedOperationException(v2);
        }
        return (SELF)v1;
    }

    public SELF slice(int param1, int param2) {
        CustomBuffer v4;
        int v3 = this.position + param1;
        if (param1 < 0 || this.limit < param1) {
            throw new IllegalArgumentException();
        }
        if (param2 < 0 || this.capacity - v3 < param2) {
            throw new IllegalArgumentException();
        }
        try {
            v4 = (CustomBuffer)UNSAFE.allocateInstance(this.getClass());
            UNSAFE.putLong(v4, ADDRESS, this.address + Integer.toUnsignedLong(v3) * (long)this.sizeof());
            UNSAFE.putInt(v4, BUFFER_MARK, -1);
            UNSAFE.putInt(v4, BUFFER_LIMIT, param2);
            UNSAFE.putInt(v4, BUFFER_CAPACITY, param2);
            UNSAFE.putObject(v4, BUFFER_CONTAINER, this.container);
        }
        catch (InstantiationException v5) {
            throw new UnsupportedOperationException(v5);
        }
        return (SELF)v4;
    }

    public SELF duplicate() {
        CustomBuffer v1;
        try {
            v1 = (CustomBuffer)UNSAFE.allocateInstance(this.getClass());
            UNSAFE.putLong(v1, ADDRESS, this.address);
            UNSAFE.putInt(v1, BUFFER_MARK, this.mark);
            UNSAFE.putInt(v1, BUFFER_POSITION, this.position);
            UNSAFE.putInt(v1, BUFFER_LIMIT, this.limit);
            UNSAFE.putInt(v1, BUFFER_CAPACITY, this.capacity);
            UNSAFE.putObject(v1, BUFFER_CONTAINER, this.container);
        }
        catch (InstantiationException v2) {
            throw new UnsupportedOperationException(v2);
        }
        return (SELF)v1;
    }

    public SELF put(SELF param1) {
        if (param1 == this) {
            throw new IllegalArgumentException();
        }
        int v2 = ((CustomBuffer)param1).remaining();
        if (this.remaining() < v2) {
            throw new BufferOverflowException();
        }
        MemoryUtil.memCopy(((CustomBuffer)param1).address(), this.address(), Integer.toUnsignedLong(v2) * (long)this.sizeof());
        this.position += v2;
        return this.self();
    }

    public SELF compact() {
        MemoryUtil.memCopy(this.address(), this.address, Integer.toUnsignedLong(this.remaining()) * (long)this.sizeof());
        this.position(this.remaining());
        this.limit(this.capacity());
        this.mark = -1;
        return this.self();
    }

    @Override
    public String toString() {
        return this.getClass().getName() + "[pos=" + this.position() + " lim=" + this.limit() + " cap=" + this.capacity() + "]";
    }

    protected abstract SELF self();

    protected final int nextGetIndex() {
        if (this.position < this.limit) {
            return this.position++;
        }
        throw new BufferUnderflowException();
    }

    protected final int nextPutIndex() {
        if (this.position < this.limit) {
            return this.position++;
        }
        throw new BufferOverflowException();
    }
}

