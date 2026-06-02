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

@NativeType(value="struct io_uring_rsrc_update2")
public class IOURingRSRCUpdate2
extends Struct<IOURingRSRCUpdate2>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int OFFSET;
    public static final int RESV;
    public static final int DATA;
    public static final int TAGS;
    public static final int NR;
    public static final int RESV2;

    protected IOURingRSRCUpdate2(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected IOURingRSRCUpdate2 create(long param1, @Nullable ByteBuffer param3) {
        return new IOURingRSRCUpdate2(param1, param3);
    }

    public IOURingRSRCUpdate2(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), IOURingRSRCUpdate2.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="__u32")
    public int offset() {
        return IOURingRSRCUpdate2.noffset(this.address());
    }

    @NativeType(value="__u32")
    public int resv() {
        return IOURingRSRCUpdate2.nresv(this.address());
    }

    @NativeType(value="__u64")
    public long data() {
        return IOURingRSRCUpdate2.ndata(this.address());
    }

    @NativeType(value="__u64")
    public long tags() {
        return IOURingRSRCUpdate2.ntags(this.address());
    }

    @NativeType(value="__u32")
    public int nr() {
        return IOURingRSRCUpdate2.nnr(this.address());
    }

    @NativeType(value="__u32")
    public int resv2() {
        return IOURingRSRCUpdate2.nresv2(this.address());
    }

    public IOURingRSRCUpdate2 offset(@NativeType(value="__u32") int param1) {
        IOURingRSRCUpdate2.noffset(this.address(), param1);
        return this;
    }

    public IOURingRSRCUpdate2 resv(@NativeType(value="__u32") int param1) {
        IOURingRSRCUpdate2.nresv(this.address(), param1);
        return this;
    }

    public IOURingRSRCUpdate2 data(@NativeType(value="__u64") long param1) {
        IOURingRSRCUpdate2.ndata(this.address(), param1);
        return this;
    }

    public IOURingRSRCUpdate2 tags(@NativeType(value="__u64") long param1) {
        IOURingRSRCUpdate2.ntags(this.address(), param1);
        return this;
    }

    public IOURingRSRCUpdate2 nr(@NativeType(value="__u32") int param1) {
        IOURingRSRCUpdate2.nnr(this.address(), param1);
        return this;
    }

    public IOURingRSRCUpdate2 resv2(@NativeType(value="__u32") int param1) {
        IOURingRSRCUpdate2.nresv2(this.address(), param1);
        return this;
    }

    public IOURingRSRCUpdate2 set(int param1, int param2, long param3, long param5, int param7, int param8) {
        this.offset(param1);
        this.resv(param2);
        this.data(param3);
        this.tags(param5);
        this.nr(param7);
        this.resv2(param8);
        return this;
    }

    public IOURingRSRCUpdate2 set(IOURingRSRCUpdate2 param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOURingRSRCUpdate2 malloc() {
        return new IOURingRSRCUpdate2(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static IOURingRSRCUpdate2 calloc() {
        return new IOURingRSRCUpdate2(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static IOURingRSRCUpdate2 create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new IOURingRSRCUpdate2(MemoryUtil.memAddress(v0), v0);
    }

    public static IOURingRSRCUpdate2 create(long param0) {
        return new IOURingRSRCUpdate2(param0, null);
    }

    @Nullable
    public static IOURingRSRCUpdate2 createSafe(long param0) {
        return param0 == 0L ? null : new IOURingRSRCUpdate2(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(IOURingRSRCUpdate2.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = IOURingRSRCUpdate2.__create(param0, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(v1), v1, -1, 0, param0, param0);
    }

    public static Buffer create(long param0, int param2) {
        return new Buffer(param0, param2);
    }

    @Nullable
    public static Buffer createSafe(long param0, int param2) {
        return param0 == 0L ? null : new Buffer(param0, param2);
    }

    public static IOURingRSRCUpdate2 malloc(MemoryStack param0) {
        return new IOURingRSRCUpdate2(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static IOURingRSRCUpdate2 calloc(MemoryStack param0) {
        return new IOURingRSRCUpdate2(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static int noffset(long param0) {
        return UNSAFE.getInt(null, param0 + (long)OFFSET);
    }

    public static int nresv(long param0) {
        return UNSAFE.getInt(null, param0 + (long)RESV);
    }

    public static long ndata(long param0) {
        return UNSAFE.getLong(null, param0 + (long)DATA);
    }

    public static long ntags(long param0) {
        return UNSAFE.getLong(null, param0 + (long)TAGS);
    }

    public static int nnr(long param0) {
        return UNSAFE.getInt(null, param0 + (long)NR);
    }

    public static int nresv2(long param0) {
        return UNSAFE.getInt(null, param0 + (long)RESV2);
    }

    public static void noffset(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)OFFSET, param2);
    }

    public static void nresv(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)RESV, param2);
    }

    public static void ndata(long param0, long param2) {
        UNSAFE.putLong(null, param0 + (long)DATA, param2);
    }

    public static void ntags(long param0, long param2) {
        UNSAFE.putLong(null, param0 + (long)TAGS, param2);
    }

    public static void nnr(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)NR, param2);
    }

    public static void nresv2(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)RESV2, param2);
    }

    static {
        Struct.Layout v0 = IOURingRSRCUpdate2.__struct(IOURingRSRCUpdate2.__member(4), IOURingRSRCUpdate2.__member(4), IOURingRSRCUpdate2.__member(8), IOURingRSRCUpdate2.__member(8), IOURingRSRCUpdate2.__member(4), IOURingRSRCUpdate2.__member(4));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        OFFSET = v0.offsetof(0);
        RESV = v0.offsetof(1);
        DATA = v0.offsetof(2);
        TAGS = v0.offsetof(3);
        NR = v0.offsetof(4);
        RESV2 = v0.offsetof(5);
    }

    public static class Buffer
    extends StructBuffer<IOURingRSRCUpdate2, Buffer>
    implements NativeResource {
        private static final IOURingRSRCUpdate2 ELEMENT_FACTORY = IOURingRSRCUpdate2.create(-1L);

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
        protected IOURingRSRCUpdate2 getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="__u32")
        public int offset() {
            return IOURingRSRCUpdate2.noffset(this.address());
        }

        @NativeType(value="__u32")
        public int resv() {
            return IOURingRSRCUpdate2.nresv(this.address());
        }

        @NativeType(value="__u64")
        public long data() {
            return IOURingRSRCUpdate2.ndata(this.address());
        }

        @NativeType(value="__u64")
        public long tags() {
            return IOURingRSRCUpdate2.ntags(this.address());
        }

        @NativeType(value="__u32")
        public int nr() {
            return IOURingRSRCUpdate2.nnr(this.address());
        }

        @NativeType(value="__u32")
        public int resv2() {
            return IOURingRSRCUpdate2.nresv2(this.address());
        }

        public Buffer offset(@NativeType(value="__u32") int param1) {
            IOURingRSRCUpdate2.noffset(this.address(), param1);
            return this;
        }

        public Buffer resv(@NativeType(value="__u32") int param1) {
            IOURingRSRCUpdate2.nresv(this.address(), param1);
            return this;
        }

        public Buffer data(@NativeType(value="__u64") long param1) {
            IOURingRSRCUpdate2.ndata(this.address(), param1);
            return this;
        }

        public Buffer tags(@NativeType(value="__u64") long param1) {
            IOURingRSRCUpdate2.ntags(this.address(), param1);
            return this;
        }

        public Buffer nr(@NativeType(value="__u32") int param1) {
            IOURingRSRCUpdate2.nnr(this.address(), param1);
            return this;
        }

        public Buffer resv2(@NativeType(value="__u32") int param1) {
            IOURingRSRCUpdate2.nresv2(this.address(), param1);
            return this;
        }
    }
}

