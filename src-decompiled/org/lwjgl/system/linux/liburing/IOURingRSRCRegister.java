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

@NativeType(value="struct io_uring_rsrc_register")
public class IOURingRSRCRegister
extends Struct<IOURingRSRCRegister>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int NR;
    public static final int FLAGS;
    public static final int RESV2;
    public static final int DATA;
    public static final int TAGS;

    protected IOURingRSRCRegister(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected IOURingRSRCRegister create(long param1, @Nullable ByteBuffer param3) {
        return new IOURingRSRCRegister(param1, param3);
    }

    public IOURingRSRCRegister(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), IOURingRSRCRegister.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="__u32")
    public int nr() {
        return IOURingRSRCRegister.nnr(this.address());
    }

    @NativeType(value="__u32")
    public int flags() {
        return IOURingRSRCRegister.nflags(this.address());
    }

    @NativeType(value="__u64")
    public long resv2() {
        return IOURingRSRCRegister.nresv2(this.address());
    }

    @NativeType(value="__u64")
    public long data() {
        return IOURingRSRCRegister.ndata(this.address());
    }

    @NativeType(value="__u64")
    public long tags() {
        return IOURingRSRCRegister.ntags(this.address());
    }

    public IOURingRSRCRegister nr(@NativeType(value="__u32") int param1) {
        IOURingRSRCRegister.nnr(this.address(), param1);
        return this;
    }

    public IOURingRSRCRegister flags(@NativeType(value="__u32") int param1) {
        IOURingRSRCRegister.nflags(this.address(), param1);
        return this;
    }

    public IOURingRSRCRegister resv2(@NativeType(value="__u64") long param1) {
        IOURingRSRCRegister.nresv2(this.address(), param1);
        return this;
    }

    public IOURingRSRCRegister data(@NativeType(value="__u64") long param1) {
        IOURingRSRCRegister.ndata(this.address(), param1);
        return this;
    }

    public IOURingRSRCRegister tags(@NativeType(value="__u64") long param1) {
        IOURingRSRCRegister.ntags(this.address(), param1);
        return this;
    }

    public IOURingRSRCRegister set(int param1, int param2, long param3, long param5, long param7) {
        this.nr(param1);
        this.flags(param2);
        this.resv2(param3);
        this.data(param5);
        this.tags(param7);
        return this;
    }

    public IOURingRSRCRegister set(IOURingRSRCRegister param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOURingRSRCRegister malloc() {
        return new IOURingRSRCRegister(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static IOURingRSRCRegister calloc() {
        return new IOURingRSRCRegister(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static IOURingRSRCRegister create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new IOURingRSRCRegister(MemoryUtil.memAddress(v0), v0);
    }

    public static IOURingRSRCRegister create(long param0) {
        return new IOURingRSRCRegister(param0, null);
    }

    @Nullable
    public static IOURingRSRCRegister createSafe(long param0) {
        return param0 == 0L ? null : new IOURingRSRCRegister(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(IOURingRSRCRegister.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = IOURingRSRCRegister.__create(param0, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(v1), v1, -1, 0, param0, param0);
    }

    public static Buffer create(long param0, int param2) {
        return new Buffer(param0, param2);
    }

    @Nullable
    public static Buffer createSafe(long param0, int param2) {
        return param0 == 0L ? null : new Buffer(param0, param2);
    }

    public static IOURingRSRCRegister malloc(MemoryStack param0) {
        return new IOURingRSRCRegister(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static IOURingRSRCRegister calloc(MemoryStack param0) {
        return new IOURingRSRCRegister(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static int nnr(long param0) {
        return UNSAFE.getInt(null, param0 + (long)NR);
    }

    public static int nflags(long param0) {
        return UNSAFE.getInt(null, param0 + (long)FLAGS);
    }

    public static long nresv2(long param0) {
        return UNSAFE.getLong(null, param0 + (long)RESV2);
    }

    public static long ndata(long param0) {
        return UNSAFE.getLong(null, param0 + (long)DATA);
    }

    public static long ntags(long param0) {
        return UNSAFE.getLong(null, param0 + (long)TAGS);
    }

    public static void nnr(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)NR, param2);
    }

    public static void nflags(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)FLAGS, param2);
    }

    public static void nresv2(long param0, long param2) {
        UNSAFE.putLong(null, param0 + (long)RESV2, param2);
    }

    public static void ndata(long param0, long param2) {
        UNSAFE.putLong(null, param0 + (long)DATA, param2);
    }

    public static void ntags(long param0, long param2) {
        UNSAFE.putLong(null, param0 + (long)TAGS, param2);
    }

    static {
        Struct.Layout v0 = IOURingRSRCRegister.__struct(IOURingRSRCRegister.__member(4), IOURingRSRCRegister.__member(4), IOURingRSRCRegister.__member(8), IOURingRSRCRegister.__member(8), IOURingRSRCRegister.__member(8));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        NR = v0.offsetof(0);
        FLAGS = v0.offsetof(1);
        RESV2 = v0.offsetof(2);
        DATA = v0.offsetof(3);
        TAGS = v0.offsetof(4);
    }

    public static class Buffer
    extends StructBuffer<IOURingRSRCRegister, Buffer>
    implements NativeResource {
        private static final IOURingRSRCRegister ELEMENT_FACTORY = IOURingRSRCRegister.create(-1L);

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
        protected IOURingRSRCRegister getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="__u32")
        public int nr() {
            return IOURingRSRCRegister.nnr(this.address());
        }

        @NativeType(value="__u32")
        public int flags() {
            return IOURingRSRCRegister.nflags(this.address());
        }

        @NativeType(value="__u64")
        public long resv2() {
            return IOURingRSRCRegister.nresv2(this.address());
        }

        @NativeType(value="__u64")
        public long data() {
            return IOURingRSRCRegister.ndata(this.address());
        }

        @NativeType(value="__u64")
        public long tags() {
            return IOURingRSRCRegister.ntags(this.address());
        }

        public Buffer nr(@NativeType(value="__u32") int param1) {
            IOURingRSRCRegister.nnr(this.address(), param1);
            return this;
        }

        public Buffer flags(@NativeType(value="__u32") int param1) {
            IOURingRSRCRegister.nflags(this.address(), param1);
            return this;
        }

        public Buffer resv2(@NativeType(value="__u64") long param1) {
            IOURingRSRCRegister.nresv2(this.address(), param1);
            return this;
        }

        public Buffer data(@NativeType(value="__u64") long param1) {
            IOURingRSRCRegister.ndata(this.address(), param1);
            return this;
        }

        public Buffer tags(@NativeType(value="__u64") long param1) {
            IOURingRSRCRegister.ntags(this.address(), param1);
            return this;
        }
    }
}

