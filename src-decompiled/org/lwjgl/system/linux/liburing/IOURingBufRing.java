/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.linux.liburing;

import java.nio.ByteBuffer;
import java.util.function.Consumer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;
import org.lwjgl.system.linux.liburing.IOURingBuf;

@NativeType(value="struct io_uring_buf_ring")
public class IOURingBufRing
extends Struct<IOURingBufRing>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int RESV1;
    public static final int RESV2;
    public static final int RESV3;
    public static final int TAIL;
    public static final int BUFS;

    protected IOURingBufRing(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected IOURingBufRing create(long param1, @Nullable ByteBuffer param3) {
        return new IOURingBufRing(param1, param3);
    }

    public IOURingBufRing(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), IOURingBufRing.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="__u64")
    public long resv1() {
        return IOURingBufRing.nresv1(this.address());
    }

    @NativeType(value="__u32")
    public int resv2() {
        return IOURingBufRing.nresv2(this.address());
    }

    @NativeType(value="__u16")
    public short resv3() {
        return IOURingBufRing.nresv3(this.address());
    }

    @NativeType(value="__u16")
    public short tail() {
        return IOURingBufRing.ntail(this.address());
    }

    @NativeType(value="struct io_uring_buf[0]")
    public IOURingBuf.Buffer bufs() {
        return IOURingBufRing.nbufs(this.address());
    }

    @NativeType(value="struct io_uring_buf")
    public IOURingBuf bufs(int param1) {
        return IOURingBufRing.nbufs(this.address(), param1);
    }

    public IOURingBufRing resv1(@NativeType(value="__u64") long param1) {
        IOURingBufRing.nresv1(this.address(), param1);
        return this;
    }

    public IOURingBufRing resv2(@NativeType(value="__u32") int param1) {
        IOURingBufRing.nresv2(this.address(), param1);
        return this;
    }

    public IOURingBufRing resv3(@NativeType(value="__u16") short param1) {
        IOURingBufRing.nresv3(this.address(), param1);
        return this;
    }

    public IOURingBufRing tail(@NativeType(value="__u16") short param1) {
        IOURingBufRing.ntail(this.address(), param1);
        return this;
    }

    public IOURingBufRing bufs(@NativeType(value="struct io_uring_buf[0]") IOURingBuf.Buffer param1) {
        IOURingBufRing.nbufs(this.address(), param1);
        return this;
    }

    public IOURingBufRing bufs(int param1, @NativeType(value="struct io_uring_buf") IOURingBuf param2) {
        IOURingBufRing.nbufs(this.address(), param1, param2);
        return this;
    }

    public IOURingBufRing bufs(Consumer<IOURingBuf.Buffer> param1) {
        param1.accept(this.bufs());
        return this;
    }

    public IOURingBufRing bufs(int param1, Consumer<IOURingBuf> param2) {
        param2.accept(this.bufs(param1));
        return this;
    }

    public IOURingBufRing set(IOURingBufRing param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOURingBufRing malloc() {
        return new IOURingBufRing(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static IOURingBufRing calloc() {
        return new IOURingBufRing(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static IOURingBufRing create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new IOURingBufRing(MemoryUtil.memAddress(v0), v0);
    }

    public static IOURingBufRing create(long param0) {
        return new IOURingBufRing(param0, null);
    }

    @Nullable
    public static IOURingBufRing createSafe(long param0) {
        return param0 == 0L ? null : new IOURingBufRing(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(IOURingBufRing.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = IOURingBufRing.__create(param0, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(v1), v1, -1, 0, param0, param0);
    }

    public static Buffer create(long param0, int param2) {
        return new Buffer(param0, param2);
    }

    @Nullable
    public static Buffer createSafe(long param0, int param2) {
        return param0 == 0L ? null : new Buffer(param0, param2);
    }

    public static IOURingBufRing malloc(MemoryStack param0) {
        return new IOURingBufRing(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static IOURingBufRing calloc(MemoryStack param0) {
        return new IOURingBufRing(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static long nresv1(long param0) {
        return UNSAFE.getLong(null, param0 + (long)RESV1);
    }

    public static int nresv2(long param0) {
        return UNSAFE.getInt(null, param0 + (long)RESV2);
    }

    public static short nresv3(long param0) {
        return UNSAFE.getShort(null, param0 + (long)RESV3);
    }

    public static short ntail(long param0) {
        return UNSAFE.getShort(null, param0 + (long)TAIL);
    }

    public static IOURingBuf.Buffer nbufs(long param0) {
        return IOURingBuf.create(param0 + (long)BUFS, 0);
    }

    public static IOURingBuf nbufs(long param0, int param2) {
        return IOURingBuf.create(param0 + (long)BUFS + Checks.check(param2, 0) * (long)IOURingBuf.SIZEOF);
    }

    public static void nresv1(long param0, long param2) {
        UNSAFE.putLong(null, param0 + (long)RESV1, param2);
    }

    public static void nresv2(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)RESV2, param2);
    }

    public static void nresv3(long param0, short param2) {
        UNSAFE.putShort(null, param0 + (long)RESV3, param2);
    }

    public static void ntail(long param0, short param2) {
        UNSAFE.putShort(null, param0 + (long)TAIL, param2);
    }

    public static void nbufs(long param0, IOURingBuf.Buffer param2) {
        if (Checks.CHECKS) {
            Checks.checkGT(param2, 0);
        }
        MemoryUtil.memCopy(param2.address(), param0 + (long)BUFS, param2.remaining() * IOURingBuf.SIZEOF);
    }

    public static void nbufs(long param0, int param2, IOURingBuf param3) {
        MemoryUtil.memCopy(param3.address(), param0 + (long)BUFS + Checks.check(param2, 0) * (long)IOURingBuf.SIZEOF, IOURingBuf.SIZEOF);
    }

    static {
        Struct.Layout v0 = IOURingBufRing.__struct(IOURingBufRing.__union(IOURingBufRing.__struct(IOURingBufRing.__member(8), IOURingBufRing.__member(4), IOURingBufRing.__member(2), IOURingBufRing.__member(2)), IOURingBufRing.__array(IOURingBuf.SIZEOF, IOURingBuf.ALIGNOF, 0)));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        RESV1 = v0.offsetof(2);
        RESV2 = v0.offsetof(3);
        RESV3 = v0.offsetof(4);
        TAIL = v0.offsetof(5);
        BUFS = v0.offsetof(6);
    }

    public static class Buffer
    extends StructBuffer<IOURingBufRing, Buffer>
    implements NativeResource {
        private static final IOURingBufRing ELEMENT_FACTORY = IOURingBufRing.create(-1L);

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
        protected IOURingBufRing getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="__u64")
        public long resv1() {
            return IOURingBufRing.nresv1(this.address());
        }

        @NativeType(value="__u32")
        public int resv2() {
            return IOURingBufRing.nresv2(this.address());
        }

        @NativeType(value="__u16")
        public short resv3() {
            return IOURingBufRing.nresv3(this.address());
        }

        @NativeType(value="__u16")
        public short tail() {
            return IOURingBufRing.ntail(this.address());
        }

        @NativeType(value="struct io_uring_buf[0]")
        public IOURingBuf.Buffer bufs() {
            return IOURingBufRing.nbufs(this.address());
        }

        @NativeType(value="struct io_uring_buf")
        public IOURingBuf bufs(int param1) {
            return IOURingBufRing.nbufs(this.address(), param1);
        }

        public Buffer resv1(@NativeType(value="__u64") long param1) {
            IOURingBufRing.nresv1(this.address(), param1);
            return this;
        }

        public Buffer resv2(@NativeType(value="__u32") int param1) {
            IOURingBufRing.nresv2(this.address(), param1);
            return this;
        }

        public Buffer resv3(@NativeType(value="__u16") short param1) {
            IOURingBufRing.nresv3(this.address(), param1);
            return this;
        }

        public Buffer tail(@NativeType(value="__u16") short param1) {
            IOURingBufRing.ntail(this.address(), param1);
            return this;
        }

        public Buffer bufs(@NativeType(value="struct io_uring_buf[0]") IOURingBuf.Buffer param1) {
            IOURingBufRing.nbufs(this.address(), param1);
            return this;
        }

        public Buffer bufs(int param1, @NativeType(value="struct io_uring_buf") IOURingBuf param2) {
            IOURingBufRing.nbufs(this.address(), param1, param2);
            return this;
        }

        public Buffer bufs(Consumer<IOURingBuf.Buffer> param1) {
            param1.accept(this.bufs());
            return this;
        }

        public Buffer bufs(int param1, Consumer<IOURingBuf> param2) {
            param2.accept(this.bufs(param1));
            return this;
        }
    }
}

