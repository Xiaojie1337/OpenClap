/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.linux.liburing;

import java.nio.ByteBuffer;
import java.nio.LongBuffer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct io_uring_buf_reg")
public class IOURingBufReg
extends Struct<IOURingBufReg>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int RING_ADDR;
    public static final int RING_ENTRIES;
    public static final int BGID;
    public static final int FLAGS;
    public static final int RESV;

    protected IOURingBufReg(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected IOURingBufReg create(long param1, @Nullable ByteBuffer param3) {
        return new IOURingBufReg(param1, param3);
    }

    public IOURingBufReg(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), IOURingBufReg.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="__u64")
    public long ring_addr() {
        return IOURingBufReg.nring_addr(this.address());
    }

    @NativeType(value="__u32")
    public int ring_entries() {
        return IOURingBufReg.nring_entries(this.address());
    }

    @NativeType(value="__u16")
    public short bgid() {
        return IOURingBufReg.nbgid(this.address());
    }

    @NativeType(value="__u16")
    public short flags() {
        return IOURingBufReg.nflags(this.address());
    }

    @NativeType(value="__u64[3]")
    public LongBuffer resv() {
        return IOURingBufReg.nresv(this.address());
    }

    @NativeType(value="__u64")
    public long resv(int param1) {
        return IOURingBufReg.nresv(this.address(), param1);
    }

    public IOURingBufReg ring_addr(@NativeType(value="__u64") long param1) {
        IOURingBufReg.nring_addr(this.address(), param1);
        return this;
    }

    public IOURingBufReg ring_entries(@NativeType(value="__u32") int param1) {
        IOURingBufReg.nring_entries(this.address(), param1);
        return this;
    }

    public IOURingBufReg bgid(@NativeType(value="__u16") short param1) {
        IOURingBufReg.nbgid(this.address(), param1);
        return this;
    }

    public IOURingBufReg flags(@NativeType(value="__u16") short param1) {
        IOURingBufReg.nflags(this.address(), param1);
        return this;
    }

    public IOURingBufReg resv(@NativeType(value="__u64[3]") LongBuffer param1) {
        IOURingBufReg.nresv(this.address(), param1);
        return this;
    }

    public IOURingBufReg resv(int param1, @NativeType(value="__u64") long param2) {
        IOURingBufReg.nresv(this.address(), param1, param2);
        return this;
    }

    public IOURingBufReg set(long param1, int param3, short param4, short param5, LongBuffer param6) {
        this.ring_addr(param1);
        this.ring_entries(param3);
        this.bgid(param4);
        this.flags(param5);
        this.resv(param6);
        return this;
    }

    public IOURingBufReg set(IOURingBufReg param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOURingBufReg malloc() {
        return new IOURingBufReg(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static IOURingBufReg calloc() {
        return new IOURingBufReg(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static IOURingBufReg create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new IOURingBufReg(MemoryUtil.memAddress(v0), v0);
    }

    public static IOURingBufReg create(long param0) {
        return new IOURingBufReg(param0, null);
    }

    @Nullable
    public static IOURingBufReg createSafe(long param0) {
        return param0 == 0L ? null : new IOURingBufReg(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(IOURingBufReg.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = IOURingBufReg.__create(param0, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(v1), v1, -1, 0, param0, param0);
    }

    public static Buffer create(long param0, int param2) {
        return new Buffer(param0, param2);
    }

    @Nullable
    public static Buffer createSafe(long param0, int param2) {
        return param0 == 0L ? null : new Buffer(param0, param2);
    }

    public static IOURingBufReg malloc(MemoryStack param0) {
        return new IOURingBufReg(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static IOURingBufReg calloc(MemoryStack param0) {
        return new IOURingBufReg(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static long nring_addr(long param0) {
        return UNSAFE.getLong(null, param0 + (long)RING_ADDR);
    }

    public static int nring_entries(long param0) {
        return UNSAFE.getInt(null, param0 + (long)RING_ENTRIES);
    }

    public static short nbgid(long param0) {
        return UNSAFE.getShort(null, param0 + (long)BGID);
    }

    public static short nflags(long param0) {
        return UNSAFE.getShort(null, param0 + (long)FLAGS);
    }

    public static LongBuffer nresv(long param0) {
        return MemoryUtil.memLongBuffer(param0 + (long)RESV, 3);
    }

    public static long nresv(long param0, int param2) {
        return UNSAFE.getLong(null, param0 + (long)RESV + Checks.check(param2, 3) * 8L);
    }

    public static void nring_addr(long param0, long param2) {
        UNSAFE.putLong(null, param0 + (long)RING_ADDR, param2);
    }

    public static void nring_entries(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)RING_ENTRIES, param2);
    }

    public static void nbgid(long param0, short param2) {
        UNSAFE.putShort(null, param0 + (long)BGID, param2);
    }

    public static void nflags(long param0, short param2) {
        UNSAFE.putShort(null, param0 + (long)FLAGS, param2);
    }

    public static void nresv(long param0, LongBuffer param2) {
        if (Checks.CHECKS) {
            Checks.checkGT(param2, 3);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(param2), param0 + (long)RESV, param2.remaining() * 8);
    }

    public static void nresv(long param0, int param2, long param3) {
        UNSAFE.putLong(null, param0 + (long)RESV + Checks.check(param2, 3) * 8L, param3);
    }

    static {
        Struct.Layout v0 = IOURingBufReg.__struct(IOURingBufReg.__member(8), IOURingBufReg.__member(4), IOURingBufReg.__member(2), IOURingBufReg.__member(2), IOURingBufReg.__array(8, 3));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        RING_ADDR = v0.offsetof(0);
        RING_ENTRIES = v0.offsetof(1);
        BGID = v0.offsetof(2);
        FLAGS = v0.offsetof(3);
        RESV = v0.offsetof(4);
    }

    public static class Buffer
    extends StructBuffer<IOURingBufReg, Buffer>
    implements NativeResource {
        private static final IOURingBufReg ELEMENT_FACTORY = IOURingBufReg.create(-1L);

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
        protected IOURingBufReg getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="__u64")
        public long ring_addr() {
            return IOURingBufReg.nring_addr(this.address());
        }

        @NativeType(value="__u32")
        public int ring_entries() {
            return IOURingBufReg.nring_entries(this.address());
        }

        @NativeType(value="__u16")
        public short bgid() {
            return IOURingBufReg.nbgid(this.address());
        }

        @NativeType(value="__u16")
        public short flags() {
            return IOURingBufReg.nflags(this.address());
        }

        @NativeType(value="__u64[3]")
        public LongBuffer resv() {
            return IOURingBufReg.nresv(this.address());
        }

        @NativeType(value="__u64")
        public long resv(int param1) {
            return IOURingBufReg.nresv(this.address(), param1);
        }

        public Buffer ring_addr(@NativeType(value="__u64") long param1) {
            IOURingBufReg.nring_addr(this.address(), param1);
            return this;
        }

        public Buffer ring_entries(@NativeType(value="__u32") int param1) {
            IOURingBufReg.nring_entries(this.address(), param1);
            return this;
        }

        public Buffer bgid(@NativeType(value="__u16") short param1) {
            IOURingBufReg.nbgid(this.address(), param1);
            return this;
        }

        public Buffer flags(@NativeType(value="__u16") short param1) {
            IOURingBufReg.nflags(this.address(), param1);
            return this;
        }

        public Buffer resv(@NativeType(value="__u64[3]") LongBuffer param1) {
            IOURingBufReg.nresv(this.address(), param1);
            return this;
        }

        public Buffer resv(int param1, @NativeType(value="__u64") long param2) {
            IOURingBufReg.nresv(this.address(), param1, param2);
            return this;
        }
    }
}

