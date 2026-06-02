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

@NativeType(value="struct io_uring_buf")
public class IOURingBuf
extends Struct<IOURingBuf>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int ADDR;
    public static final int LEN;
    public static final int BID;
    public static final int RESV;

    protected IOURingBuf(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected IOURingBuf create(long param1, @Nullable ByteBuffer param3) {
        return new IOURingBuf(param1, param3);
    }

    public IOURingBuf(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), IOURingBuf.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="__u64")
    public long addr() {
        return IOURingBuf.naddr(this.address());
    }

    @NativeType(value="__u32")
    public int len() {
        return IOURingBuf.nlen(this.address());
    }

    @NativeType(value="__u16")
    public short bid() {
        return IOURingBuf.nbid(this.address());
    }

    @NativeType(value="__u16")
    public short resv() {
        return IOURingBuf.nresv(this.address());
    }

    public IOURingBuf addr(@NativeType(value="__u64") long param1) {
        IOURingBuf.naddr(this.address(), param1);
        return this;
    }

    public IOURingBuf len(@NativeType(value="__u32") int param1) {
        IOURingBuf.nlen(this.address(), param1);
        return this;
    }

    public IOURingBuf bid(@NativeType(value="__u16") short param1) {
        IOURingBuf.nbid(this.address(), param1);
        return this;
    }

    public IOURingBuf resv(@NativeType(value="__u16") short param1) {
        IOURingBuf.nresv(this.address(), param1);
        return this;
    }

    public IOURingBuf set(long param1, int param3, short param4, short param5) {
        this.addr(param1);
        this.len(param3);
        this.bid(param4);
        this.resv(param5);
        return this;
    }

    public IOURingBuf set(IOURingBuf param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOURingBuf malloc() {
        return new IOURingBuf(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static IOURingBuf calloc() {
        return new IOURingBuf(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static IOURingBuf create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new IOURingBuf(MemoryUtil.memAddress(v0), v0);
    }

    public static IOURingBuf create(long param0) {
        return new IOURingBuf(param0, null);
    }

    @Nullable
    public static IOURingBuf createSafe(long param0) {
        return param0 == 0L ? null : new IOURingBuf(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(IOURingBuf.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = IOURingBuf.__create(param0, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(v1), v1, -1, 0, param0, param0);
    }

    public static Buffer create(long param0, int param2) {
        return new Buffer(param0, param2);
    }

    @Nullable
    public static Buffer createSafe(long param0, int param2) {
        return param0 == 0L ? null : new Buffer(param0, param2);
    }

    public static IOURingBuf malloc(MemoryStack param0) {
        return new IOURingBuf(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static IOURingBuf calloc(MemoryStack param0) {
        return new IOURingBuf(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static long naddr(long param0) {
        return UNSAFE.getLong(null, param0 + (long)ADDR);
    }

    public static int nlen(long param0) {
        return UNSAFE.getInt(null, param0 + (long)LEN);
    }

    public static short nbid(long param0) {
        return UNSAFE.getShort(null, param0 + (long)BID);
    }

    public static short nresv(long param0) {
        return UNSAFE.getShort(null, param0 + (long)RESV);
    }

    public static void naddr(long param0, long param2) {
        UNSAFE.putLong(null, param0 + (long)ADDR, param2);
    }

    public static void nlen(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)LEN, param2);
    }

    public static void nbid(long param0, short param2) {
        UNSAFE.putShort(null, param0 + (long)BID, param2);
    }

    public static void nresv(long param0, short param2) {
        UNSAFE.putShort(null, param0 + (long)RESV, param2);
    }

    static {
        Struct.Layout v0 = IOURingBuf.__struct(IOURingBuf.__member(8), IOURingBuf.__member(4), IOURingBuf.__member(2), IOURingBuf.__member(2));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        ADDR = v0.offsetof(0);
        LEN = v0.offsetof(1);
        BID = v0.offsetof(2);
        RESV = v0.offsetof(3);
    }

    public static class Buffer
    extends StructBuffer<IOURingBuf, Buffer>
    implements NativeResource {
        private static final IOURingBuf ELEMENT_FACTORY = IOURingBuf.create(-1L);

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
        protected IOURingBuf getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="__u64")
        public long addr() {
            return IOURingBuf.naddr(this.address());
        }

        @NativeType(value="__u32")
        public int len() {
            return IOURingBuf.nlen(this.address());
        }

        @NativeType(value="__u16")
        public short bid() {
            return IOURingBuf.nbid(this.address());
        }

        @NativeType(value="__u16")
        public short resv() {
            return IOURingBuf.nresv(this.address());
        }

        public Buffer addr(@NativeType(value="__u64") long param1) {
            IOURingBuf.naddr(this.address(), param1);
            return this;
        }

        public Buffer len(@NativeType(value="__u32") int param1) {
            IOURingBuf.nlen(this.address(), param1);
            return this;
        }

        public Buffer bid(@NativeType(value="__u16") short param1) {
            IOURingBuf.nbid(this.address(), param1);
            return this;
        }

        public Buffer resv(@NativeType(value="__u16") short param1) {
            IOURingBuf.nresv(this.address(), param1);
            return this;
        }
    }
}

