/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.linux.liburing;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct io_uring_file_index_range")
public class IOURingFileIndexRange
extends Struct<IOURingFileIndexRange>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int OFF;
    public static final int LEN;
    public static final int RESV;

    protected IOURingFileIndexRange(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected IOURingFileIndexRange create(long param1, @Nullable ByteBuffer param3) {
        return new IOURingFileIndexRange(param1, param3);
    }

    public IOURingFileIndexRange(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), IOURingFileIndexRange.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="__u32")
    public int off() {
        return IOURingFileIndexRange.noff(this.address());
    }

    @NativeType(value="__u32")
    public int len() {
        return IOURingFileIndexRange.nlen(this.address());
    }

    @NativeType(value="__u64")
    public long resv() {
        return IOURingFileIndexRange.nresv(this.address());
    }

    public IOURingFileIndexRange off(@NativeType(value="__u32") int param1) {
        IOURingFileIndexRange.noff(this.address(), param1);
        return this;
    }

    public IOURingFileIndexRange len(@NativeType(value="__u32") int param1) {
        IOURingFileIndexRange.nlen(this.address(), param1);
        return this;
    }

    public IOURingFileIndexRange resv(@NativeType(value="__u64") long param1) {
        IOURingFileIndexRange.nresv(this.address(), param1);
        return this;
    }

    public IOURingFileIndexRange set(int param1, int param2, long param3) {
        this.off(param1);
        this.len(param2);
        this.resv(param3);
        return this;
    }

    public IOURingFileIndexRange set(IOURingFileIndexRange param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOURingFileIndexRange malloc() {
        return new IOURingFileIndexRange(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static IOURingFileIndexRange calloc() {
        return new IOURingFileIndexRange(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static IOURingFileIndexRange create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new IOURingFileIndexRange(MemoryUtil.memAddress(v0), v0);
    }

    public static IOURingFileIndexRange create(long param0) {
        return new IOURingFileIndexRange(param0, null);
    }

    @Nullable
    public static IOURingFileIndexRange createSafe(long param0) {
        return param0 == 0L ? null : new IOURingFileIndexRange(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(IOURingFileIndexRange.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = IOURingFileIndexRange.__create(param0, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(v1), v1, -1, 0, param0, param0);
    }

    public static Buffer create(long param0, int param2) {
        return new Buffer(param0, param2);
    }

    @Nullable
    public static Buffer createSafe(long param0, int param2) {
        return param0 == 0L ? null : new Buffer(param0, param2);
    }

    public static IOURingFileIndexRange malloc(MemoryStack param0) {
        return new IOURingFileIndexRange(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static IOURingFileIndexRange calloc(MemoryStack param0) {
        return new IOURingFileIndexRange(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static int noff(long param0) {
        return UNSAFE.getInt(null, param0 + (long)OFF);
    }

    public static int nlen(long param0) {
        return UNSAFE.getInt(null, param0 + (long)LEN);
    }

    public static long nresv(long param0) {
        return UNSAFE.getLong(null, param0 + (long)RESV);
    }

    public static void noff(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)OFF, param2);
    }

    public static void nlen(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)LEN, param2);
    }

    public static void nresv(long param0, long param2) {
        UNSAFE.putLong(null, param0 + (long)RESV, param2);
    }

    static {
        Struct.Layout v0 = IOURingFileIndexRange.__struct(IOURingFileIndexRange.__member(4), IOURingFileIndexRange.__member(4), IOURingFileIndexRange.__member(8));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        OFF = v0.offsetof(0);
        LEN = v0.offsetof(1);
        RESV = v0.offsetof(2);
    }

    public static class Buffer
    extends StructBuffer<IOURingFileIndexRange, Buffer>
    implements NativeResource {
        private static final IOURingFileIndexRange ELEMENT_FACTORY = IOURingFileIndexRange.create(-1L);

        public Buffer(ByteBuffer param1) {
            super(param1, param1.remaining() / SIZEOF);
        }

        public Buffer(long param1, int param3) {
            super(param1, null, -1, 0, param3, param3);
        }

        Buffer(long param1, @Nullable ByteBuffer param3, int param4, int param5, int param6, int param7) {
            super(param1, param3, param4, param5, param6, param7);
        }

        @Override
        protected Buffer self() {
            return this;
        }

        @Override
        protected IOURingFileIndexRange getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="__u32")
        public int off() {
            return IOURingFileIndexRange.noff(this.address());
        }

        @NativeType(value="__u32")
        public int len() {
            return IOURingFileIndexRange.nlen(this.address());
        }

        @NativeType(value="__u64")
        public long resv() {
            return IOURingFileIndexRange.nresv(this.address());
        }

        public Buffer off(@NativeType(value="__u32") int param1) {
            IOURingFileIndexRange.noff(this.address(), param1);
            return this;
        }

        public Buffer len(@NativeType(value="__u32") int param1) {
            IOURingFileIndexRange.nlen(this.address(), param1);
            return this;
        }

        public Buffer resv(@NativeType(value="__u64") long param1) {
            IOURingFileIndexRange.nresv(this.address(), param1);
            return this;
        }
    }
}

